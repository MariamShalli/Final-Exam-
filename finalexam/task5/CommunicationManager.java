package finalexam.task5;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommunicationManager {

    private String endpoint;

    public CommunicationManager(String endpoint) {
        this.endpoint = endpoint;
    }

    public String sendUserMessage(String message) {
        try {
            // Create the URL object
            URL url = new URL(endpoint);
            // Open a connection to the URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // Set the request method to POST
            conn.setRequestMethod("POST");
            // Set the request headers
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Create the JSON payload
            String jsonInputString = "{\"message\": \"" + message + "\"}";

            // Write the JSON payload to the output stream
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Check the response code and read the response
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // The request was successful
                return "Message sent successfully.";
            } else {
                // There was an error with the request
                return "Failed to send message. Response code: " + responseCode;
            }

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return "An error occurred: " + e.getMessage();
        }
    }
}
