package lu.trackit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
import lu.trackit.entity.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "allergies")
@Data
public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allergy_generator")
    private Long id;

    @Column
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime startDate;

    @Column
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;


}
