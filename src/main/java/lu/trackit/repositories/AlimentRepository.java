package lu.trackit.repositories;
import lu.trackit.entity.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentRepository extends JpaRepository<Aliment, Long>  {
}
