package org.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Scanner;

public class WeatherAPIExample {
    public static void main(String[] args) {
        // Create a scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the name of the city
        System.out.print("Enter the name of the city: ");
        String city = scanner.nextLine();

        // Define the API key and build the URL
        String apiKey = "a80907b4c4c047d4a09160316240508&q";
        String url = "https://api.weatherapi.com/v1/forecast.json?key=a80907b4c4c047d4a09160316240508&q=" +city+ "&days=3&aqi=no&alerts=no";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(request);

            try {
                if (response.getStatusLine().getStatusCode() == 200) {
                    String json = EntityUtils.toString(response.getEntity());
                    JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

                    // Example: Print out the current temperature
                    JsonObject current = jsonObject.getAsJsonObject("current");
                    System.out.println("Current Temperature in " + city + ": " + current.get("temp_c").getAsString() + "°C");

                    // You can also parse and print other details as needed
                } else {
                    System.out.println("Error: " + response.getStatusLine().getStatusCode());
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
