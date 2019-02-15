package challenge;

import org.springframework.data.annotation.Id;

public class RestaurantRedis {

    // Properties

    @Id
    private String id;

    private String name;

    private Double x;

    private Double y;

    // Constructors

    public RestaurantRedis() {
    }

    public RestaurantRedis(String name, Double x, Double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    // Methods

    public String getId() {
        return id;
    }

    public void setId( String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

}