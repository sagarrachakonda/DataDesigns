package com.datadesign.datadesign.restApi;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class RestClient {

    public String POST(String url) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        // Define the JSON payload
        String json = "{\n" +
                "    \"email\": \"sagar\",\n" +
                "    \"password\": \"kumar\"\n" +
                "}";

        // Build the POST request with a JSON payload
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Content-Type", "application/json")  // Specify JSON content type
                .POST(HttpRequest.BodyPublishers.ofString(json))  // Attach JSON payload
                .build();

        // Send the request and handle the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Print the response status code and body
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
        return response.body();
    }

    public HttpResponse<String> Get(String url,String token) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        // Build a GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Authorization","Bearer "+token)
                .timeout(Duration.ofSeconds(10))  // Optional: Set request timeout
                .GET()  // Explicitly set the method as GET (default is GET)
                .build();

        // Send the request and handle the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
        return response;
    }

}