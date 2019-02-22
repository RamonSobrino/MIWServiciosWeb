
package ws.recomendation.webservices.services.cities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetClosestCitiesWithWeatcherResult" type="{http://WS.Recomendation.Cities/}ArrayOfCity" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getClosestCitiesWithWeatcherResult"
})
@XmlRootElement(name = "GetClosestCitiesWithWeatcherResponse")
public class GetClosestCitiesWithWeatcherResponse {

    @XmlElement(name = "GetClosestCitiesWithWeatcherResult")
    protected ArrayOfCity getClosestCitiesWithWeatcherResult;

    /**
     * Obtiene el valor de la propiedad getClosestCitiesWithWeatcherResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCity }
     *     
     */
    public ArrayOfCity getGetClosestCitiesWithWeatcherResult() {
        return getClosestCitiesWithWeatcherResult;
    }

    /**
     * Define el valor de la propiedad getClosestCitiesWithWeatcherResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCity }
     *     
     */
    public void setGetClosestCitiesWithWeatcherResult(ArrayOfCity value) {
        this.getClosestCitiesWithWeatcherResult = value;
    }

}
