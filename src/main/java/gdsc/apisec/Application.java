package gdsc.apisec;

import gdsc.apisec.model.AppUser;
import gdsc.apisec.model.Movie;
import gdsc.apisec.model.Role;
import gdsc.apisec.repositories.AppUserRepository;
import gdsc.apisec.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			AppUserRepository appUserRepository,
			MovieRepository movieRepository,
			PasswordEncoder passwordEncoder
	) {
		return args -> {
			AppUser bob = AppUser.builder()
					.email("bob@mail.com")
					.password(passwordEncoder.encode("password123"))
					.roles(Set.of(Role.ADMIN))
					.build();
			AppUser john = AppUser.builder()
					.email("john@mail.com")
					.password(passwordEncoder.encode("password321"))
					.roles(Set.of(Role.MEMBER))
					.build();

			appUserRepository.saveAll(List.of(bob, john));


			Movie darkKnight = Movie.builder()
					.title("The Dark Knight")
					.length(152)
					.owner(john)
					.build();

			Movie shawshankRedemption = Movie.builder()
					.title("Shawshank Redemption")
					.length(142)
					.owner(john)
					.build();

			Movie myCousinVinny = Movie.builder()
					.title("My Cousin Vinny")
					.length(119)
					.owner(bob)
					.build();

			movieRepository.saveAll(List.of(darkKnight, shawshankRedemption, myCousinVinny));

		};
	}

}
