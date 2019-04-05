package ws.recomendation.places.webservices.services.googleplace;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "location")
public class Location {
	
	private double lat;
	private double lng;
	
	@XmlElement
	public double getLat(){
		return lat;
	}
	
	public void setLat(double lat){
		this.lat=lat;
	}
	
	@XmlElement
	public double getLng(){
		return lng;
	}
	
	public void setLng(double lng){
		this.lng=lng;
	}
	
	@Override
    public String toString() {
	return "\nLocation ["
		+ "\n\tlat=" + lat 
		+ "\n\t, lng=" + lng
		+ "]";
    }
	

}