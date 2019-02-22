
package ws.recomendation.webservices.services.cities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfCityWeather complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCityWeather"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CityWeather" type="{http://WS.Recomendation.Cities/}CityWeather" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCityWeather", propOrder = {
    "cityWeather"
})
public class ArrayOfCityWeather {

    @XmlElement(name = "CityWeather", nillable = true)
    protected List<CityWeather> cityWeather;

    /**
     * Gets the value of the cityWeather property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cityWeather property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCityWeather().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CityWeather }
     * 
     * 
     */
    public List<CityWeather> getCityWeather() {
        if (cityWeather == null) {
            cityWeather = new ArrayList<CityWeather>();
        }
        return this.cityWeather;
    }

}
