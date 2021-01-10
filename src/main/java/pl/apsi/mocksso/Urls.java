package pl.apsi.mocksso;

import lombok.NonNull;
import lombok.Value;

@Value
public class Urls {
    @NonNull
    String webhookUrl;
    @NonNull
    String redirectUrl;
}
