package ma.fsr.jpaap.repositories;

import ma.fsr.jpaap.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient ,Long> {
}
