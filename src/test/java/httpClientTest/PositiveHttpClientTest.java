package httpClientTest;

import com.google.gson.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;


/**
 * Created by home on 27.05.2017.
 */
public class PositiveHttpClientTest {

    private StringBuffer stringConverter(CloseableHttpResponse httpResponse) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(
                    httpResponse.getEntity().getContent()));
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return response;
    }

    @Test
    public void getCurrentWeatherFromCity() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://api.apixu.com/v1/current.json?key=239cb3791fbb4487a3c152609172405&q=Kharkiv");
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            String response = stringConverter(httpResponse).toString();
            JsonElement jElement = new JsonParser().parse(response);
            JsonObject jObject = jElement.getAsJsonObject();
            JsonObject location = jObject.get("location").getAsJsonObject();
            String name = location.get("name").toString();
            assertEquals(name, "\"Kharkiv\"");
            httpClient.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }


    @Test
    public void getForecastWeatherByCityForSomeDays() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://api.apixu.com/v1/forecast.json?key=239cb3791fbb4487a3c152609172405&q=Kharkiv&days=5");
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            String response = stringConverter(httpResponse).toString();
            JsonElement jElement = new JsonParser().parse(response);
            JsonObject jObject = jElement.getAsJsonObject();
            jObject = jObject.getAsJsonObject("forecast");
            JsonArray jsonArray = jObject.getAsJsonArray("forecastday");
            int arraySize = jsonArray.size();
            assertEquals(arraySize, 5);
            httpClient.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Test
    public void getMaxTemperature() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://api.apixu.com/v1/forecast.json?key=239cb3791fbb4487a3c152609172405&q=Kharkiv");
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            String response = stringConverter(httpResponse).toString();
            JsonElement jElement = new JsonParser().parse(response);
            JsonObject jObject = jElement.getAsJsonObject();
            jObject = jObject.getAsJsonObject("forecast");
            JsonArray jsonArray = jObject.getAsJsonArray("forecastday");
            JsonObject jsonObjectForecastDay = jsonArray.get(0).getAsJsonObject();
            JsonObject jsonObjectDay = jsonObjectForecastDay.getAsJsonObject("day");
            JsonPrimitive maxTemperature = jsonObjectDay.getAsJsonPrimitive("maxtemp_c");
            String temperature = maxTemperature.toString();
            assertEquals(temperature, "18.2");
            httpClient.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Test
    public void getMinTemperature() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://api.apixu.com/v1/forecast.json?key=239cb3791fbb4487a3c152609172405&q=Kharkiv");
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            String response = stringConverter(httpResponse).toString();
            JsonElement jElement = new JsonParser().parse(response);
            JsonObject jObject = jElement.getAsJsonObject();
            jObject = jObject.getAsJsonObject("forecast");
            JsonArray jsonArray = jObject.getAsJsonArray("forecastday");
            JsonObject jsonObjectForecastDay = jsonArray.get(0).getAsJsonObject();
            JsonObject jsonObjectDay = jsonObjectForecastDay.getAsJsonObject("day");
            JsonPrimitive maxTemperature = jsonObjectDay.getAsJsonPrimitive("mintemp_c");
            String temperature = maxTemperature.toString();
            assertEquals(temperature, "8.2");
            httpClient.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Test
    public void getForecastWeatherByCityWithDateTime() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://api.apixu.com/v1/forecast.json?key=239cb3791fbb4487a3c152609172405&dt=2017-05-27&q=Kharkiv&hour=5");
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            String response = stringConverter(httpResponse).toString();
            JsonElement jElement = new JsonParser().parse(response);
            JsonObject jObject = jElement.getAsJsonObject();
            jObject = jObject.getAsJsonObject("location");
            String name = jObject.get("name").toString();
            JsonObject jObjectF = jElement.getAsJsonObject();
            jObjectF = jObjectF.getAsJsonObject("forecast");
            JsonArray jsonArray = jObjectF.getAsJsonArray("forecastday");
            JsonObject jObjectB = jsonArray.get(0).getAsJsonObject();
            String date = jObjectB.get("date").toString();
            assertEquals(date, "\"2017-05-27\"");
            assertEquals(name, "\"Kharkiv\"");
            httpClient.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}