package com.example.dropbox;

import okhttp3.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    private static final String ACCESS_TOKEN = "YOUR_ACCESS_TOKEN"; // Replace with your Dropbox OAuth token

    public static void main(String[] args) {
        try {
            fetchUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fetchUsers() throws Exception {
        OkHttpClient client = new OkHttpClient();

        String url = "https://api.dropboxapi.com/2/team/members/list";
        String jsonBody = "{ \"limit\": 5 }";

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(jsonBody, MediaType.parse("application/json")))
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Unexpected response: " + response);
            }

            String responseBody = response.body().string();
            System.out.println("API Response:\n" + responseBody);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(responseBody);
            if (rootNode.has("members")) {
                for (JsonNode member : rootNode.get("members")) {
                    String email = member.path("profile").path("email").asText();
                    String status = member.path("profile").path("status").path(".tag").asText();
                    System.out.println("User: " + email + " | Status: " + status);
                }
            }
        }
    }
}
