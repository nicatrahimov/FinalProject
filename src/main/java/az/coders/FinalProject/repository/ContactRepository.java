package az.coders.FinalProject.repository;

import az.coders.FinalProject.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,String> {
}
