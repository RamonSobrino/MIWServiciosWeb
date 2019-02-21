package ws.recomendation.webservices.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "recomendation")
public class Recomendation {

    private String city;
    private List<Place> places;

    @XmlElement
    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    @XmlElement(name = "places")
    public List<Place> getPlaces() {
	if (places == null) {
	    places = new ArrayList<Place>();
	}
	return places;
    }

}
