package ws.recomendation.webservices.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "place")
public class Place {

    private String name;
    private String address;
    private double rating;

    public Place(String name, String address, double rating) {
	super();
	this.name = name;
	this.address = address;
	this.rating = rating;
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

}
