package lt.codeAcademy.spring.NoteBook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeAcademy.spring.NoteBook.entities.User;
import lt.codeAcademy.spring.NoteBook.services.UserService;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin("*")
public class UserController {
	@Autowired
    private UserService userService;
    
    @GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getUserList();
	}

	@PostMapping("/users")
	public User saveUserDetails(@RequestBody User user) {
		System.out.println(user);
		return userService.addUser( user );
	}

	@PostMapping("/users/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		return userService.updateUserById( id, user );
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById( id );
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) {
		userService.deleteUserById( id );
		return new ResponseEntity<>( HttpStatus.NO_CONTENT );
	}
}
