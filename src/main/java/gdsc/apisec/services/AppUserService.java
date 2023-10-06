package gdsc.apisec.services;

import gdsc.apisec.model.AppUser;
import gdsc.apisec.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Transactional
    public AppUser create(String email, String password) {
        AppUser user = AppUser.builder()
                .email(email)
                .password(password)
                .build();
        return appUserRepository.save(user);
    }
}
