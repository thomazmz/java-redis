package challenge;

import org.springframework.data.annotation.Id;

import java.util.List;

public class NeighborhoodRedis {

    // Properties

    @Id
    private String id;

    private String name;

    private List<RestaurantRedis> restaurants;

    // Constructors
    public NeighborhoodRedis() {

    }

    public NeighborhoodRedis(String name) {
        this.name = name;
    }


    // Methods

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RestaurantRedis> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantRedis> restaurants) {
        this.restaurants = restaurants;
    }

}
