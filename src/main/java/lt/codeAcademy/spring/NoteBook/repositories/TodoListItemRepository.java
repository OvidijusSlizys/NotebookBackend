package lt.codeAcademy.spring.NoteBook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeAcademy.spring.NoteBook.entities.TodoListItem;
@Repository
public interface TodoListItemRepository extends JpaRepository<TodoListItem, Long>{

}
