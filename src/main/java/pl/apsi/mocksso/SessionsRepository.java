package pl.apsi.mocksso;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class SessionsRepository {

    private final Map<UUID, Urls> idsMappedToWebHookUrls = new HashMap<>();

    public void put(UUID id, Urls urls) {
        idsMappedToWebHookUrls.put(id, urls);
    }

    public Urls get(UUID id) {
        return idsMappedToWebHookUrls.get(id);
    }
}
