package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sd.a2.domain.entity.Class;

public interface ClassRepository extends JpaRepository<Class, String> {
}
