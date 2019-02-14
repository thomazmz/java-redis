package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurant")
public class RestaurantMongo {

    // Properties

    @Id
    private String id;

    private GeoJsonPoint point;

    private String name;

    // Constructors

    public RestaurantMongo(GeoJsonPoint point, String name) {
        this.point = point;
        this.name = name;
    }

    // Methods

    public String getId() {
        return id;
    }

    public GeoJsonPoint getPoint() {
        return point;
    }

    public void setPoint(GeoJsonPoint point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
