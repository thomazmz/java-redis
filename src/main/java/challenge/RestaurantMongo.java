package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurant")
public class RestaurantMongo {

    // Properties

    @Id
    private String id;

    private GeoJsonPoint location;

    private String name;

    // Constructors

    public RestaurantMongo(GeoJsonPoint location, String name) {
        this.location = location;
        this.name = name;
    }

    // Methods

    public String getId() {
        return id;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
