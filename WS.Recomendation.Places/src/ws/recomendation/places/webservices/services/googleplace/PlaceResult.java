package ws.recomendation.places.webservices.services.googleplace;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
public class PlaceResult {

    private String name;
    private String vicinity;
    private double rating;
	private Geometry geometry;
	
	@XmlElement
	public Geometry getGeometry(){
		return geometry;
	}

	
	
    public void setGeometry(Geometry geometry) {
	    this.geometry = geometry;
	}



    @XmlElement
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @XmlElement
    public String getVicinity() {
	return vicinity;
    }

    public void setVicinity(String vicinity) {
	this.vicinity = vicinity;
    }

    @XmlElement
    public double getRating() {
	return rating;
    }

    public void setRating(double rating) {
	this.rating = rating;
    }

    @Override
    public String toString() {
	return "\nPlaceResult ["
		+ "\n\tname=" + name 
		+ "\n\t,vicinity=" + vicinity
		+ "\n\t,rating=" + rating 
		+ "\n\t,geometry=" + geometry 
		+ "]";
    }
    
    

}
