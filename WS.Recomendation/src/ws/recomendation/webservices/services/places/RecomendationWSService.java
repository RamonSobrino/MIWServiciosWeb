
package ws.recomendation.webservices.services.places;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "RecomendationWSService", targetNamespace = "http://webservices.places.recomendation.ws/", wsdlLocation = "http://156.35.95.51:8080/WS.Recomendation.Places/soapws/v1?wsdl")
public class RecomendationWSService
    extends Service
{

    private final static URL RECOMENDATIONWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException RECOMENDATIONWSSERVICE_EXCEPTION;
    private final static QName RECOMENDATIONWSSERVICE_QNAME = new QName("http://webservices.places.recomendation.ws/", "RecomendationWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://156.35.95.51:8080/WS.Recomendation.Places/soapws/v1?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RECOMENDATIONWSSERVICE_WSDL_LOCATION = url;
        RECOMENDATIONWSSERVICE_EXCEPTION = e;
    }

    public RecomendationWSService() {
        super(__getWsdlLocation(), RECOMENDATIONWSSERVICE_QNAME);
    }

    public RecomendationWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RECOMENDATIONWSSERVICE_QNAME, features);
    }

    public RecomendationWSService(URL wsdlLocation) {
        super(wsdlLocation, RECOMENDATIONWSSERVICE_QNAME);
    }

    public RecomendationWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RECOMENDATIONWSSERVICE_QNAME, features);
    }

    public RecomendationWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RecomendationWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IRecomendationWS
     */
    @WebEndpoint(name = "RecomendationWSPort")
    public IRecomendationWS getRecomendationWSPort() {
        return super.getPort(new QName("http://webservices.places.recomendation.ws/", "RecomendationWSPort"), IRecomendationWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IRecomendationWS
     */
    @WebEndpoint(name = "RecomendationWSPort")
    public IRecomendationWS getRecomendationWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.places.recomendation.ws/", "RecomendationWSPort"), IRecomendationWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RECOMENDATIONWSSERVICE_EXCEPTION!= null) {
            throw RECOMENDATIONWSSERVICE_EXCEPTION;
        }
        return RECOMENDATIONWSSERVICE_WSDL_LOCATION;
    }

}
