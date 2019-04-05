package ws.recomendation.places.webservices.services.googleplace;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "geometry")
public class Geometry {
	
	private Location location;
	
	@XmlElement
	public Location getLocation(){
		return location;
	}
	
	public void setLocation(Location location){
		this.location=location;
	}
	
	@Override
    public String toString() {
	return "\nGeometry ["
		+ "\n\tlocation=" + location 
		+ "]";
    }

}