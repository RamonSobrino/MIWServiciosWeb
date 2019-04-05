package ws.recomendation.webservices.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "place")
public class Place {

    private String name;
    private String address;
    private double rating;
    private double lat;
    private double lng;
 
    public Place(String name, String address, double rating, double lat,
	    double lng) {
	super();
	this.name = name;
	this.address = address;
	this.rating = rating;
	this.lat = lat;
	this.lng = lng;
    }

    @XmlElement
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @XmlElement
    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    @XmlElement
    public double getRating() {
	return rating;
    }

    public void setRating(double rating) {
	this.rating = rating;
    }

    @XmlElement
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @XmlElement
    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
    
    

}
