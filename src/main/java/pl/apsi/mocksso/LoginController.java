package pl.apsi.mocksso;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
@Controller
public class LoginController {

    private final SessionsRepository sessionsRepository;
    private final UsersRepository usersRepository;
    private final AccessTokenGenerator accessTokenGenerator;
    private final WebhookHandler webhookHandler;

    @GetMapping("/session/{id}")
    public String showAuthenticationPage(final Model model, @PathVariable final UUID id) {
        model.addAttribute("sessionId", id);
        return "index";
    }

    @PostMapping("/session/{sessionId}/authenticate")
    public RedirectView authenticate(final Model model,
                                     @PathVariable final UUID sessionId,
                                     final String email,
                                     final String password) {
        Optional<User> optionalUser = usersRepository.findByEmailAndPassword(email, password);
        return optionalUser.map(user -> {
            final Urls urls = sessionsRepository.get(sessionId);
            final String accessToken = accessTokenGenerator.generate();
            webhookHandler.confirmAuthentity(urls.getWebhookUrl(), user, accessToken);
            return new RedirectView(urls.getRedirectUrl() + "?access_token=" + accessToken);
        }).orElseGet(() -> {
            model.addAttribute("error", "User not found.");
            return new RedirectView("/session/" + sessionId + "/authenticate");
        });
    }
}
