package gdsc.apisec.controllers;

import gdsc.apisec.model.Movie;
import gdsc.apisec.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping({"/movies", "/movies/"})
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;

    @PostMapping
    public Movie create(@RequestParam("title") String title, @RequestParam("length") Double length) {
        return movieRepository.save(
                Movie.builder()
//                        .owner()
                        .length(length)
                        .title(title)
                        .build());
    }

    @GetMapping
    public List<Movie> movies() {
        return movieRepository.findAll();
    }

    @GetMapping({"/{id}", "/{id}/"})
    public Movie movieById(@PathVariable("id") String id) {
        return movieRepository.findById(UUID.fromString(id)).orElseThrow();
    }


}
