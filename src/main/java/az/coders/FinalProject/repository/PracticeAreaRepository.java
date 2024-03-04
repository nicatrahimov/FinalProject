package az.coders.FinalProject.repository;

import az.coders.FinalProject.model.PracticeArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeAreaRepository extends JpaRepository<PracticeArea, String> {
}
