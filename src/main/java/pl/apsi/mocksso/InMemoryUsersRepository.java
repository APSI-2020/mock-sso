package pl.apsi.mocksso;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InMemoryUsersRepository implements UsersRepository {

    private final String firstUserId = "2141b02a-2f69-41ae-b278-d37d848fc271";

    private final ImmutableMap<UUID, User> users = ImmutableMap.<UUID, User>builder()
            .put(UUID.fromString(firstUserId),
                    User.builder()
                            .id(UUID.fromString(firstUserId))
                            .email("test@test.com")
                            .password("haslomaslo")
                            .firstName("James")
                            .lastName("Bond")
                            .build()
                    )
            .build();

    @Override
    public Optional<User> findByEmailAndPassword(final String email, final String password) {
        return users.values()
                .stream()
                .filter(user ->  user.getEmail().equals(email))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }
}
