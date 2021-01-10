package pl.apsi.mocksso;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.Value;

@Value
public class UserWithAccessToken {
    @NonNull
    User user;

    @NonNull
    @JsonProperty("access_token")
    String accessToken;
}
