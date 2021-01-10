package pl.apsi.mocksso;

import java.util.Optional;

public interface UsersRepository {
    Optional<User> findByEmailAndPassword(String email, String password);
}
