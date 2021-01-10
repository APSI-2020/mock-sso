package pl.apsi.mocksso;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class WebhookHandler {

    private final RestTemplate restTemplate;

    public void confirmAuthentity(@NonNull String webhookUrl, User user, String accessToken) {
        restTemplate.postForEntity(webhookUrl, new UserWithAccessToken(user, accessToken), Void.class);
    }
}
