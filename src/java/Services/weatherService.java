/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author rakesh
 */
public class weatherService {

    public weatherService(){
        
    }
    
    public String getWeather(java.lang.String cityName, java.lang.String stateName) {
        org.tempuri.Service service = new org.tempuri.Service();
        org.tempuri.IService port = service.getBasicHttpBindingIService();
        
        return port.getWeather(cityName, stateName);
    }

    public String getWeatherHourly(java.lang.String cityName, 
            java.lang.String stateName, java.lang.Boolean hourly) {
        org.tempuri.Service service = new org.tempuri.Service();
        org.tempuri.IService port = service.getBasicHttpBindingIService();
        
        return port.getWeatherHourly(cityName, stateName, hourly);
    }

    public String getWeatherTenDays(java.lang.String cityName, 
            java.lang.String stateName, java.lang.Boolean tenday) {
        org.tempuri.Service service = new org.tempuri.Service();
        org.tempuri.IService port = service.getBasicHttpBindingIService();
        
        return port.getWeatherTenDays(cityName, stateName, tenday);
    }
    
}
