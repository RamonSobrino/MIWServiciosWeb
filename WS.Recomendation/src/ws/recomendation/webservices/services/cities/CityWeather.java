
package ws.recomendation.webservices.services.cities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CityWeather complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CityWeather"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExtensionData" type="{http://WS.Recomendation.Cities/}ExtensionDataObject" minOccurs="0"/&gt;
 *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Humidity" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CityWeather", propOrder = {
    "extensionData",
    "temperature",
    "humidity",
    "description"
})
public class CityWeather {

    @XmlElement(name = "ExtensionData")
    protected ExtensionDataObject extensionData;
    @XmlElement(name = "Temperature")
    protected double temperature;
    @XmlElement(name = "Humidity")
    protected double humidity;
    @XmlElement(name = "Description")
    protected String description;

    /**
     * Obtiene el valor de la propiedad extensionData.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionDataObject }
     *     
     */
    public ExtensionDataObject getExtensionData() {
        return extensionData;
    }

    /**
     * Define el valor de la propiedad extensionData.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionDataObject }
     *     
     */
    public void setExtensionData(ExtensionDataObject value) {
        this.extensionData = value;
    }

    /**
     * Obtiene el valor de la propiedad temperature.
     * 
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Define el valor de la propiedad temperature.
     * 
     */
    public void setTemperature(double value) {
        this.temperature = value;
    }

    /**
     * Obtiene el valor de la propiedad humidity.
     * 
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * Define el valor de la propiedad humidity.
     * 
     */
    public void setHumidity(double value) {
        this.humidity = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
