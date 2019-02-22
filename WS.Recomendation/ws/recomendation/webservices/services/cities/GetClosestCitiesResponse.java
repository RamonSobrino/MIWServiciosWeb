
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
 *         &lt;element name="GetClosestCitiesResult" type="{http://WS.Recomendation.Cities/}ArrayOfCity" minOccurs="0"/&gt;
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
    "getClosestCitiesResult"
})
@XmlRootElement(name = "GetClosestCitiesResponse")
public class GetClosestCitiesResponse {

    @XmlElement(name = "GetClosestCitiesResult")
    protected ArrayOfCity getClosestCitiesResult;

    /**
     * Obtiene el valor de la propiedad getClosestCitiesResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCity }
     *     
     */
    public ArrayOfCity getGetClosestCitiesResult() {
        return getClosestCitiesResult;
    }

    /**
     * Define el valor de la propiedad getClosestCitiesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCity }
     *     
     */
    public void setGetClosestCitiesResult(ArrayOfCity value) {
        this.getClosestCitiesResult = value;
    }

}
