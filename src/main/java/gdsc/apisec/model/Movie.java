package gdsc.apisec.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private AppUser owner;

    private String title;

    private double length;

}
