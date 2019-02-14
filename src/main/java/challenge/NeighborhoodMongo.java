package challenge;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;

/**
 * Classe para mapear o bairro no MongoDB
 *
 */

public class NeighborhoodMongo {

    @Id
    private String id;

    private String name;

    private GeoJsonPolygon polygon;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GeoJsonPolygon getPolygon() {
        return polygon;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPolygon(GeoJsonPolygon polygon) {
        this.polygon = polygon;
    }
}
