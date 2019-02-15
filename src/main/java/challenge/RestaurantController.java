package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantServiceImpl service;

	@GetMapping("/restaurants/findInNeighborhood")
	public NeighborhoodRedis findInNeighborhood(
			@RequestParam("latitude") Double x,
			@RequestParam("longitude") Double y) {

		return service.findInNeighborhood(x, y);
	}

	// Testes

	@GetMapping("/mongo/neighborhood")
	public NeighborhoodMongo findNeighborhood(
			@RequestParam("latitude") Double x,
			@RequestParam("longitude") Double y) {

		return service.findNeighborhood(x, y);

	}

	@GetMapping("/mongo/neighborhood/restaurants")
	public List<RestaurantMongo> findNeighborhoodRestaurants(
			@RequestParam("latitude") Double x,
			@RequestParam("longitude") Double y) {

		return service.findNeighborhoodRestaurants(service.findNeighborhood(x, y));

	}

}
