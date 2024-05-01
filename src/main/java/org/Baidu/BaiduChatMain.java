package org.Baidu;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class BaiduChatMain {

    public  String getAccessToken() throws IOException, InterruptedException {
        String clientId = "RMHLYl6GdLo9TUmvjeri8pl4";
        String clientSecret = "MDOeHTtMxEOsOIw2qH3bb9rBC48HtjKE";

        String url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonResponse = new JSONObject(response.body());
        return jsonResponse.getString("access_token");
    }

    public  String  BoChat(String userMessage) throws IOException, InterruptedException {
        String accessToken = getAccessToken();

        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/eb-instant?access_token=" + accessToken;

        JSONObject payload = new JSONObject();
        payload.put("messages", new JSONObject[]{
                new JSONObject().put("role", "user").put("content", userMessage)
        });

        HttpRequest chatRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
                .build();

        HttpResponse<String> chatResponse = HttpClient.newHttpClient().send(chatRequest, HttpResponse.BodyHandlers.ofString());

        // 解析返回的JSON
        JSONObject resultJson = new JSONObject(chatResponse.body());
        String resultContent = resultJson.getString("result");
        System.out.println(resultContent);
        return resultContent;
    }
}
