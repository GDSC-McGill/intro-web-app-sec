package gdsc.apisec.controllers;

import gdsc.apisec.model.Movie;
import gdsc.apisec.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping({"/movies", "/movies/"})
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;


    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<Movie> movies() {
        return movieRepository.findAll();
    }

    @GetMapping({"/{id}", "/{id}/"})
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_MEMBER')")
    public Movie movieById(@PathVariable("id") String id) {
        return movieRepository.findById(UUID.fromString(id)).orElseThrow();
    }


}
