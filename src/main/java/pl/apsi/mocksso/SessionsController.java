package pl.apsi.mocksso;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class SessionsController {

    private final SessionsRepository sessionsRepository;

    @PostMapping(value = "/session/create", consumes = "application/json")
    public SessionId create(@RequestBody CreateSessionDto createSessionDto) {
        final UUID id = UUID.randomUUID();
        sessionsRepository.put(id, new Urls(createSessionDto.getWebhookUrl(), createSessionDto.getRedirectUrl()));
        return new SessionId(id);
    }

}
