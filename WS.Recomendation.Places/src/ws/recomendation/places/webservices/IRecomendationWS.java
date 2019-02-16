package ws.recomendation.places.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import ws.recomendation.places.webservices.model.Recomendation;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IRecomendationWS {

    @WebMethod
    Recomendation[] find(Request request);
    
}
