
package ws.recomendation.webservices.services.cities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="originCityId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numberOfCitiesToReturn" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "originCityId",
    "numberOfCitiesToReturn"
})
@XmlRootElement(name = "GetClosestCities")
public class GetClosestCities {

    protected int originCityId;
    protected int numberOfCitiesToReturn;

    /**
     * Obtiene el valor de la propiedad originCityId.
     * 
     */
    public int getOriginCityId() {
        return originCityId;
    }

    /**
     * Define el valor de la propiedad originCityId.
     * 
     */
    public void setOriginCityId(int value) {
        this.originCityId = value;
    }

    /**
     * Obtiene el valor de la propiedad numberOfCitiesToReturn.
     * 
     */
    public int getNumberOfCitiesToReturn() {
        return numberOfCitiesToReturn;
    }

    /**
     * Define el valor de la propiedad numberOfCitiesToReturn.
     * 
     */
    public void setNumberOfCitiesToReturn(int value) {
        this.numberOfCitiesToReturn = value;
    }

}
