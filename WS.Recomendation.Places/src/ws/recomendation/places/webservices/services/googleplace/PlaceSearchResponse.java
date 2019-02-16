package ws.recomendation.places.webservices.services.googleplace;
import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PlaceSearchResponse")
public class PlaceSearchResponse {
    
    private String status;
    private String nextPageToken;
    private PlaceResult[] results;

    @XmlElement
    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    @XmlElement(name = "next_page_token")
    public String getNextPageToken() {
	return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
	this.nextPageToken = nextPageToken;
    }

    @XmlElement
    public PlaceResult[] getResults() {
	return results;
    }

    public void setResults(PlaceResult[] results) {
	this.results = results;
    }

    @Override
    public String toString() {
	return "PlaceSearchResponse " + "\n["
		+ "\ntstatus=" + status 
		+ "\n,nextPageToken=" + nextPageToken 
		+ "\n,results=" + Arrays.toString(results) 
		+ "\n]";
    }
}
