package pl.apsi.mocksso;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
@JsonIgnoreProperties("password")
public class User {
    @NonNull
    UUID id;

    @NonNull
    String email;

    @NonNull
    @JsonProperty("password")
    String password;

    @NonNull
    @JsonProperty("first_name")
    String firstName;

    @NonNull
    @JsonProperty("last_name")
    String lastName;

    @JsonProperty("is_lecturer")
    boolean isLecturer;
}
