package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document(collection = "neighborhood")
public class NeighborhoodMongo {

    // Properties

    @Id
    private String id;

    private String name;

    private GeoJsonPolygon polygon;

    // Constructor

    public NeighborhoodMongo(String name, GeoJsonPolygon polygon) {
        this.name = name;
        this.polygon = polygon;
    }

    // Methods

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GeoJsonPolygon getPolygon() {
        return polygon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPolygon(GeoJsonPolygon polygon) {
        this.polygon = polygon;
    }
}
