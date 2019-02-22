
package ws.recomendation.webservices.services.places;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para recomendationType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="recomendationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MUSEUM"/&gt;
 *     &lt;enumeration value="CASINO"/&gt;
 *     &lt;enumeration value="AQUARIUM"/&gt;
 *     &lt;enumeration value="PARK"/&gt;
 *     &lt;enumeration value="SPA"/&gt;
 *     &lt;enumeration value="NIGHT_CLUB"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "recomendationType")
@XmlEnum
public enum RecomendationType {

    MUSEUM,
    CASINO,
    AQUARIUM,
    PARK,
    SPA,
    NIGHT_CLUB;

    public String value() {
        return name();
    }

    public static RecomendationType fromValue(String v) {
        return valueOf(v);
    }

}
