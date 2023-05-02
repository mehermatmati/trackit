package lu.trackit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lu.trackit.entity.user.User;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "allergens")
@Data
public class Allergen {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allergen_generator")
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "is_allergen")
    private boolean isAllergen;

    @Column(name = "is_suspect")
    private boolean isSuspect;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "allergens")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

}
