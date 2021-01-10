package pl.apsi.mocksso;

import lombok.Value;

@Value
public class CreateSessionDto {
    String webhookUrl;
    String redirectUrl;
}
