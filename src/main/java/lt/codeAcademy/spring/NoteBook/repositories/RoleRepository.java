package lt.codeAcademy.spring.NoteBook.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeAcademy.spring.NoteBook.entities.ERole;
import lt.codeAcademy.spring.NoteBook.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
