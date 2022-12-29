package lt.codeAcademy.spring.NoteBook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeAcademy.spring.NoteBook.entities.TodoListItem;
import lt.codeAcademy.spring.NoteBook.repositories.TodoListItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListItemService {
	@Autowired
	TodoListItemRepository todoListItemRepository;

	public List<TodoListItem> getTodoListItemList() {
		return todoListItemRepository.findAll();
	}

	public TodoListItem addTodoListItem(TodoListItem toDoListItem) {
		return todoListItemRepository.save(toDoListItem);
	}

	public TodoListItem getTodoListItemById(Long id) {
		Optional<TodoListItem> toDoListItem = todoListItemRepository.findById(id);

		if (toDoListItem.isEmpty()) {
			return null;
		}

		return toDoListItem.get();
	}

	public TodoListItem updateTodoListItemById(Long id, TodoListItem toDoListItem) {
		return todoListItemRepository.save(toDoListItem);
	}

	public String deleteTodoListItemById(Long id) {
		boolean exists = todoListItemRepository.existsById(id);

		if (exists) {
			todoListItemRepository.deleteById(id);
			return "ToDoListItem was deleted with id: " + id;
		}
		return "ToDoListItem does not exist";
	}
}


