package ws.recomendation.places.webservices;

import java.util.ArrayList;
import java.util.List;

import ws.recomendation.places.webservices.model.RecomendationType;

public class Request {

    private double lat;
    private double lon;

    private List<RecomendationType> types;

    public double getLat() {
	return lat;
    }

    public void setLat(double lat) {
	this.lat = lat;
    }

    public double getLon() {
	return lon;
    }

    public void setLon(double lon) {
	this.lon = lon;
    }

    public List<RecomendationType> getTypes() {
	if (types == null) {
	    types = new ArrayList<RecomendationType>();
	}
	return types;
    }

    public void setTypes(List<RecomendationType> types) {
	this.types = types;
    }

}
