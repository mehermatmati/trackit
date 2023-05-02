package lu.trackit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lu.trackit.entity.user.User;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "aliments")
@Data
public class Aliment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aliment_generator")
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "nbr_calories")
    private Long nbrCalories;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "aliments")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

}
