
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _GetWeatherTenDaysCityName_QNAME = new QName("http://tempuri.org/", "city_name");
    private final static QName _GetWeatherTenDaysStateName_QNAME = new QName("http://tempuri.org/", "state_name");
    private final static QName _GetWeatherHourlyResponseGetWeatherHourlyResult_QNAME = new QName("http://tempuri.org/", "getWeather_hourlyResult");
    private final static QName _GetWeatherTenDaysResponseGetWeatherTenDaysResult_QNAME = new QName("http://tempuri.org/", "getWeather_tenDaysResult");
    private final static QName _GetWeatherResponseGetWeatherResult_QNAME = new QName("http://tempuri.org/", "getWeatherResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWeather }
     * 
     */
    public GetWeather createGetWeather() {
        return new GetWeather();
    }

    /**
     * Create an instance of {@link GetWeatherTenDays }
     * 
     */
    public GetWeatherTenDays createGetWeatherTenDays() {
        return new GetWeatherTenDays();
    }

    /**
     * Create an instance of {@link GetWeatherTenDaysResponse }
     * 
     */
    public GetWeatherTenDaysResponse createGetWeatherTenDaysResponse() {
        return new GetWeatherTenDaysResponse();
    }

    /**
     * Create an instance of {@link GetWeatherHourly }
     * 
     */
    public GetWeatherHourly createGetWeatherHourly() {
        return new GetWeatherHourly();
    }

    /**
     * Create an instance of {@link GetWeatherHourlyResponse }
     * 
     */
    public GetWeatherHourlyResponse createGetWeatherHourlyResponse() {
        return new GetWeatherHourlyResponse();
    }

    /**
     * Create an instance of {@link GetWeatherResponse }
     * 
     */
    public GetWeatherResponse createGetWeatherResponse() {
        return new GetWeatherResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "city_name", scope = GetWeatherTenDays.class)
    public JAXBElement<String> createGetWeatherTenDaysCityName(String value) {
        return new JAXBElement<String>(_GetWeatherTenDaysCityName_QNAME, String.class, GetWeatherTenDays.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "state_name", scope = GetWeatherTenDays.class)
    public JAXBElement<String> createGetWeatherTenDaysStateName(String value) {
        return new JAXBElement<String>(_GetWeatherTenDaysStateName_QNAME, String.class, GetWeatherTenDays.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "getWeather_hourlyResult", scope = GetWeatherHourlyResponse.class)
    public JAXBElement<String> createGetWeatherHourlyResponseGetWeatherHourlyResult(String value) {
        return new JAXBElement<String>(_GetWeatherHourlyResponseGetWeatherHourlyResult_QNAME, String.class, GetWeatherHourlyResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "getWeather_tenDaysResult", scope = GetWeatherTenDaysResponse.class)
    public JAXBElement<String> createGetWeatherTenDaysResponseGetWeatherTenDaysResult(String value) {
        return new JAXBElement<String>(_GetWeatherTenDaysResponseGetWeatherTenDaysResult_QNAME, String.class, GetWeatherTenDaysResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "city_name", scope = GetWeather.class)
    public JAXBElement<String> createGetWeatherCityName(String value) {
        return new JAXBElement<String>(_GetWeatherTenDaysCityName_QNAME, String.class, GetWeather.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "state_name", scope = GetWeather.class)
    public JAXBElement<String> createGetWeatherStateName(String value) {
        return new JAXBElement<String>(_GetWeatherTenDaysStateName_QNAME, String.class, GetWeather.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "city_name", scope = GetWeatherHourly.class)
    public JAXBElement<String> createGetWeatherHourlyCityName(String value) {
        return new JAXBElement<String>(_GetWeatherTenDaysCityName_QNAME, String.class, GetWeatherHourly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "state_name", scope = GetWeatherHourly.class)
    public JAXBElement<String> createGetWeatherHourlyStateName(String value) {
        return new JAXBElement<String>(_GetWeatherTenDaysStateName_QNAME, String.class, GetWeatherHourly.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "getWeatherResult", scope = GetWeatherResponse.class)
    public JAXBElement<String> createGetWeatherResponseGetWeatherResult(String value) {
        return new JAXBElement<String>(_GetWeatherResponseGetWeatherResult_QNAME, String.class, GetWeatherResponse.class, value);
    }

}
