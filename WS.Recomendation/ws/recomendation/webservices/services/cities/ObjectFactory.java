
package ws.recomendation.webservices.services.cities;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.recomendation.webservices.services.cities package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.recomendation.webservices.services.cities
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetClosestCities }
     * 
     */
    public GetClosestCities createGetClosestCities() {
        return new GetClosestCities();
    }

    /**
     * Create an instance of {@link GetClosestCitiesResponse }
     * 
     */
    public GetClosestCitiesResponse createGetClosestCitiesResponse() {
        return new GetClosestCitiesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCity }
     * 
     */
    public ArrayOfCity createArrayOfCity() {
        return new ArrayOfCity();
    }

    /**
     * Create an instance of {@link GetClosestCitiesWithWeatcher }
     * 
     */
    public GetClosestCitiesWithWeatcher createGetClosestCitiesWithWeatcher() {
        return new GetClosestCitiesWithWeatcher();
    }

    /**
     * Create an instance of {@link GetClosestCitiesWithWeatcherResponse }
     * 
     */
    public GetClosestCitiesWithWeatcherResponse createGetClosestCitiesWithWeatcherResponse() {
        return new GetClosestCitiesWithWeatcherResponse();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

    /**
     * Create an instance of {@link ExtensionDataObject }
     * 
     */
    public ExtensionDataObject createExtensionDataObject() {
        return new ExtensionDataObject();
    }

    /**
     * Create an instance of {@link ArrayOfCityWeather }
     * 
     */
    public ArrayOfCityWeather createArrayOfCityWeather() {
        return new ArrayOfCityWeather();
    }

    /**
     * Create an instance of {@link CityWeather }
     * 
     */
    public CityWeather createCityWeather() {
        return new CityWeather();
    }

}
