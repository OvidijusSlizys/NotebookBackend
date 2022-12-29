package lt.codeAcademy.spring.NoteBook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lt.codeAcademy.spring.NoteBook.entities.TodoListItem;
import lt.codeAcademy.spring.NoteBook.services.TodoListItemService;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class TodoListItemsController {
	@Autowired
	private TodoListItemService todoListItemService;

	@GetMapping("/toDoListItems")
	public List<TodoListItem> getAllToDoListItem() {
		return todoListItemService.getTodoListItemList();
	}

	@PostMapping("/toDoListItems")
	public TodoListItem saveToDoListItemDetails(@RequestBody TodoListItem todoListItem) {
		return todoListItemService.addTodoListItem(todoListItem);
	}

	@PostMapping("/toDoListItems/{id}")
	public TodoListItem updateToDoListItem(@RequestBody TodoListItem toDoListItem, @PathVariable Long id) {
		return todoListItemService.updateTodoListItemById(id, toDoListItem);
	}

	@GetMapping("/toDoListItems/{id}")
	public TodoListItem getToDoListItemById(@PathVariable Long id) {
		return todoListItemService.getTodoListItemById(id);
	}

	@DeleteMapping("/toDoListItems/{id}")
	public ResponseEntity<HttpStatus> deleteToDoListItemById(@PathVariable Long id) {
		todoListItemService.deleteTodoListItemById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//    @GetMapping("/users/{userId}/todoLists/{todoListId}/todolistItems")
//    public List<TodoListItem> getAllTodoListItems(@PathVariable Long userId, @PathVariable Long todoListId) {
//        return todoListItemService.getTodoListItems(userId, todoListId);
//    }
//
//    @PostMapping("/users/{userId}/todoLists/{todoListId}/todoListItems")
//    public TodoListItem saveTodoListItem
//        (
//            @RequestBody TodoListItem todoListItem,
//            @PathVariable Long userId,
//            @PathVariable Long todoListId
//        )
//    {
//        return todoListItemService.saveTodoListItem(userId, todoListId, todoListItem);
//    }
//
//    @PostMapping("/users/{userId}/todoLists/{todoListId}/todoListItems/{id}")
//    public TodoListItem updateTodoListItem
//        (
//            @RequestBody TodoListItem todoListItem,
//            @PathVariable Long userId,
//            @PathVariable Long todoListId,
//            @PathVariable Long id
//        )
//    {
//        return todoListItemService.updateTodoListItemById(
//            userId,
//            todoListId,
//            todoListItem
//        );
//    }
//
//    @DeleteMapping("/users/{userId}/todoLists/{todoListId}/todolistItems/{id}")
//    public ResponseEntity<HttpStatus> deleteTodoListItem
//        (
//            @PathVariable Long userId,
//            @PathVariable Long todoListId,
//            @PathVariable Long id
//        )
//    {
//        todoListItemService.deleteTodoListItemById(userId, todoListId, id);
//        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
//    }
}
