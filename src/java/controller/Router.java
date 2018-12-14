/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Services.weatherService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.weather;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author rakesh
 */
@WebServlet(name = "Router", urlPatterns = "/weather")
public class Router extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatch;
        dispatch = request.getRequestDispatcher("index.jsp");
        dispatch.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String jsonResponse = null;
        JSONObject jsonObj = null;
        RequestDispatcher dispatch;
        weatherService service = new weatherService();
        
        if (city == null || city.isEmpty())
        {
            request.setAttribute("error", "The city cannot be null");
            
            dispatch = request.getRequestDispatcher("error.jsp");
            dispatch.forward(request, response);
            return;
        }
        
        if (request.getParameter("option") != null){
            if(request.getParameter("option").equals("hourly")){
                
                List<weather> currentWeather = new ArrayList();
                jsonResponse = service.getWeatherHourly(city, state, 
                        Boolean.TRUE);
            
                try {
                    jsonObj = new JSONObject(jsonResponse);
                    
                    if (jsonObj.getJSONObject("response").has("error")){
                        String errorDescription = jsonObj.getJSONObject("response")
                                .getJSONObject("error").getString("description");

                        request.setAttribute("error", errorDescription);

                        dispatch = request.getRequestDispatcher("error.jsp");
                        dispatch.forward(request, response);
                    }
                    
                    if (jsonObj.getJSONObject("response").has("results")){
                        
                        request.setAttribute("error", "Give the right City & State combination ");

                        dispatch = request.getRequestDispatcher("error.jsp");
                        dispatch.forward(request, response);
                        
                    }

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    JsonParser jp = new JsonParser();
                    JsonElement je = jp.parse(jsonResponse);
                    String prettyJsonString = gson.toJson(je);
                    System.out.println(prettyJsonString);

                    currentWeather = setHourlyWeather(jsonObj, city, state);
                    setMultipleDisplayAttributes(currentWeather, request);

                } catch (JSONException ex) {
                    ex.printStackTrace();
                    response.sendError(500, "Internal Error on the Server side");
                }
                
                dispatch = request.getRequestDispatcher("result_hourly.jsp");
                dispatch.forward(request, response);
                return;
            }
            else{
                List<weather> currentWeather = new ArrayList();
                jsonResponse = service.getWeatherTenDays(city, state, 
                        Boolean.TRUE);
                try {
                    jsonObj = new JSONObject(jsonResponse);
                    
                    if (jsonObj.getJSONObject("response").has("error")){
                        String errorDescription = jsonObj.getJSONObject("response")
                                .getJSONObject("error").getString("description");

                        System.out.println("The Error Description "+ errorDescription);
                        request.setAttribute("error", errorDescription);

                        dispatch = request.getRequestDispatcher("error.jsp");
                        dispatch.forward(request, response);
                    }
                    
                    if (jsonObj.getJSONObject("response").has("results")){
                        
                        request.setAttribute("error", "Give the right City & State combination ");

                        dispatch = request.getRequestDispatcher("error.jsp");
                        dispatch.forward(request, response);
                        
                    }

                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    JsonParser jp = new JsonParser();
                    JsonElement je = jp.parse(jsonResponse);
                    String prettyJsonString = gson.toJson(je);
                    System.out.println(prettyJsonString);

                    currentWeather = setTenDayWeather(jsonObj, city, state);
                    setMultipleDisplayAttributes(currentWeather, request);

                } catch (JSONException ex) {
                    ex.printStackTrace();
                    response.sendError(500, "Internal Error on the Server side");
                }
                
                dispatch = request.getRequestDispatcher("result_tenday.jsp");
                dispatch.forward(request, response);
                return;
            }
            
        }else{
            
            weather currentWeather = null;
            jsonResponse = service.getWeather(city, state);
        
            try {
                jsonObj = new JSONObject(jsonResponse);
               
                if (jsonObj.getJSONObject("response").has("error")){
                    String errorDescription = jsonObj.getJSONObject("response")
                            .getJSONObject("error").getString("description");
                    
                    System.out.println("The Error Description "+ errorDescription);
                    request.setAttribute("error", errorDescription);
                    
                    dispatch = request.getRequestDispatcher("error.jsp");
                    dispatch.forward(request, response);
                }
                
                if (jsonObj.getJSONObject("response").has("results")){
                        
                        request.setAttribute("error", "Give the right City & State combination ");

                        dispatch = request.getRequestDispatcher("error.jsp");
                        dispatch.forward(request, response);
                        
                    }

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonParser jp = new JsonParser();
                JsonElement je = jp.parse(jsonResponse);
                String prettyJsonString = gson.toJson(je);
                System.out.println(prettyJsonString);

                currentWeather = setWeather(jsonObj);
                setDisplayAttributes(currentWeather, request);

            } catch (JSONException ex) {
                ex.printStackTrace();
                response.sendError(500, "Internal Error on the Server side");
            }
            
            System.out.println(request.getAttribute("temperature"));
            System.out.println(request.getAttribute("city"));

            dispatch = request.getRequestDispatcher("result.jsp");
            dispatch.forward(request, response);
        }
        
    }
    
    private weather setWeather(JSONObject jsonObj){
        weather  weatherModel = new weather();
        try {
                weatherModel.setCity(jsonObj.getJSONObject("current_observation")
                    .getJSONObject("display_location").getString("city"));
                weatherModel.setState(jsonObj.getJSONObject("current_observation")
                    .getJSONObject("display_location").getString("state_name"));
                weatherModel.setTime(jsonObj.getJSONObject("current_observation")
                    .getString("observation_time"));
                weatherModel.setTemperature(jsonObj.getJSONObject("current_observation")
                    .getString("temperature_string"));
                weatherModel.setFeelsLike(jsonObj.getJSONObject("current_observation")
                    .getString("feelslike_string"));
                weatherModel.setHumidity(jsonObj.getJSONObject("current_observation")
                    .getString("relative_humidity"));
        }catch (JSONException ex) {
                ex.printStackTrace();
            }
        return weatherModel;
    }
    
    private List<weather> setHourlyWeather(JSONObject jsonObj, String city,
            String state) throws JSONException{
        
        List<weather> weatherModel = new ArrayList();
        JSONArray weatherArray = jsonObj.getJSONArray("hourly_forecast");
        
        for(int i=0; i < weatherArray.length(); i++){
            JSONObject perHour = new JSONObject(weatherArray.get(i).toString());
            weather weatherMdl = new weather();
            String temperature = perHour.getJSONObject("temp")
                    .getString("english") + " F(" + 
                    perHour.getJSONObject("temp").getString("metric") + " C)";
            
            System.out.println("The temperature "+ temperature);
            
            String feelsLike = perHour.getJSONObject("feelslike")
                    .getString("english") + " F(" + 
                    perHour.getJSONObject("feelslike").getString("metric") 
                    + " C)";
                    
            System.out.println("The feels like "+ feelsLike);
            
            weatherMdl.setCity(city);
            weatherMdl.setState(state);
            weatherMdl.setTime(perHour.getJSONObject("FCTTIME")
                    .getString("pretty"));
            weatherMdl.setTemperature(temperature);
            weatherMdl.setFeelsLike(feelsLike);
            weatherMdl.setHumidity(perHour.getString("humidity"));
            
            weatherModel.add(weatherMdl);
        }
        
        return weatherModel;
        
    }
    
    private List<weather> setTenDayWeather(JSONObject jsonObj, String city,
            String state) throws JSONException{
        
        List<weather> weatherModel = new ArrayList();
        JSONArray weatherArray = jsonObj.getJSONObject("forecast")
                .getJSONObject("simpleforecast").getJSONArray("forecastday");
        
        for(int i=0; i < weatherArray.length(); i++){
            JSONObject perHour = new JSONObject(weatherArray.get(i).toString());
            weather weatherMdl = new weather();
            String temperature = perHour.getJSONObject("high")
                    .getString("fahrenheit") + " F(" + 
                    perHour.getJSONObject("high").getString("celsius") + " C)";
            
            System.out.println("The High temperature "+ temperature);
            
            String feelsLike = perHour.getJSONObject("low")
                    .getString("fahrenheit") + " F(" + 
                    perHour.getJSONObject("low").getString("celsius") + " C)";
                    
            System.out.println("The Low temperature "+ feelsLike);
            
            weatherMdl.setCity(city);
            weatherMdl.setState(state);
            weatherMdl.setTime(perHour.getJSONObject("date")
                    .getString("pretty"));
            weatherMdl.setTemperature(temperature);
            weatherMdl.setFeelsLike(feelsLike);
            weatherMdl.setHumidity(perHour.getString("conditions"));
            
            weatherModel.add(weatherMdl);
        }
        
        return weatherModel;
        
    }
    
    private void setDisplayAttributes( weather currentWeather, HttpServletRequest 
            request){
        
        request.setAttribute("city", currentWeather.getCity());
        request.setAttribute("state", currentWeather.getState());
        request.setAttribute("time", currentWeather.getTime());
        request.setAttribute("temperature", currentWeather.getTemperature());
        request.setAttribute("feelsLike", currentWeather.getFeelsLike());
        request.setAttribute("humidity", currentWeather.getHumidity());
        request.setAttribute("attributeSet", "True");
       
    }
    
    private void setMultipleDisplayAttributes (List<weather> currentWeather, 
            HttpServletRequest request){
        
        int i = 0;
        
        request.setAttribute("city", request.getParameter("city"));
        request.setAttribute("state", request.getParameter("state"));
        request.setAttribute("attributeSet", "True");
        
        for (weather singleWeather : currentWeather){
            
            String attributeTime = "time_"+ i;
            String attributeTemperature = "temperature_"+ i;
            String attributFeelsLike = "feelsLike_"+ i;
            String attributeHumidity = "humidity_"+ i;
            
            System.out.println("The generated String " + attributeTime);
            System.out.println("The Time " + singleWeather.getTime());
            
            request.setAttribute(attributeTime, singleWeather.getTime());
            request.setAttribute(attributeTemperature, singleWeather.getTemperature());
            request.setAttribute(attributFeelsLike, singleWeather.getFeelsLike());
            request.setAttribute(attributeHumidity, singleWeather.getHumidity());
            
            System.out.println("The time of update " + request.getAttribute(attributeTime));
            
            i++;
        }
        request.setAttribute("length", i);
        System.out.println("The Length is " + request.getAttribute("length"));
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Main control servlet for Weather Check Web Application";
    }// </editor-fold>

}
