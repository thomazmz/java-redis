package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	MongoOperations mongoOperations;

	@Autowired
	RedisOperations<String, NeighborhoodRedis> redisRedisOperations;

	// REDIS

	@Override
	public NeighborhoodRedis findInNeighborhood(double x, double y) {

		NeighborhoodMongo neighborhoodMongo = this.findNeighborhood(x, y);

		String redisKey = "neighborhood:" + neighborhoodMongo.getId();

		NeighborhoodRedis neighborhoodRedis = redisRedisOperations.opsForValue().get(redisKey);

		if (neighborhoodRedis == null) {

			neighborhoodRedis = new NeighborhoodRedis(neighborhoodMongo.getName());
			neighborhoodRedis.setId(neighborhoodMongo.getId());
			neighborhoodRedis.setName(neighborhoodMongo.getName());
			neighborhoodRedis.setRestaurants(mongoToRedis(this.findNeighborhoodRestaurants(neighborhoodMongo)));

			redisRedisOperations.opsForValue().set(redisKey, neighborhoodRedis);

		}

		return neighborhoodRedis;

	}

	public NeighborhoodMongo findNeighborhood(double x, double y) {
		return mongoOperations.findOne(
				query(where("geometry").intersects(new GeoJsonPoint(new Point(x, y)))),
				NeighborhoodMongo.class);
	}

	public List<RestaurantMongo> findNeighborhoodRestaurants(NeighborhoodMongo neighborhoodMongo) {
		return mongoOperations.find(
				query(where("location").within(neighborhoodMongo.getGeometry())).with(Sort.by("name").ascending()),
				RestaurantMongo.class);
	}

	private List<RestaurantRedis> mongoToRedis(List<RestaurantMongo> restaurantsMongo) {
		return restaurantsMongo
				.stream()
				.map(this::mongoToRedis)
				.collect(Collectors.toList());
	}

	private RestaurantRedis mongoToRedis(RestaurantMongo restaurantMongo) {
		final RestaurantRedis restaurantRedis = new RestaurantRedis();
		restaurantRedis.setId(restaurantMongo.getId());
		restaurantRedis.setName(restaurantMongo.getName());
		restaurantRedis.setX(restaurantMongo.getLocation().getX());
		restaurantRedis.setY(restaurantMongo.getLocation().getY());
		return restaurantRedis;
	}

}
