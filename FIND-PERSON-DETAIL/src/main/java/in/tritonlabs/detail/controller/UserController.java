package in.tritonlabs.detail.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.tritonlabs.detail.entity.User;
import in.tritonlabs.detail.service.impl.UserServiceImpl;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/")
	public List<User> readAll() {
		return userService.readAll();
	}

	@GetMapping("/{id}")
	public User readOne(@PathVariable("id") long id) {
		Optional<User> op = userService.readOne(id);
		return op.get();
	}

	@PostMapping("/")
	public User craete(@RequestBody User user) {
		userService.create(user);
		return user;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id) {
		userService.delete(id);
		return "Deleted";
	}

	@DeleteMapping("/")
	public String deleteAl() {
		userService.deleteAll();
		return "Deleted All";
	}

	@PutMapping("/{id}")
	public String update(@RequestBody User user, @PathVariable("id") long id) {
		user = userService.update(user, id);
		return "Updated";

	}
}
