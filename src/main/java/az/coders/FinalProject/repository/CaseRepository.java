package az.coders.FinalProject.repository;

import az.coders.FinalProject.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<Case,String> {
}
