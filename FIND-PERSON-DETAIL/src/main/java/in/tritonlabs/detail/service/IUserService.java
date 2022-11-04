package in.tritonlabs.detail.service;

import java.util.List;
import java.util.Optional;
import in.tritonlabs.detail.entity.User;

public interface IUserService {

	public List<User> readAll();

	public Optional<User> readOne(long id);

	public User create(User user);

	public User update(User user, long id);

	public String delete(long id);

	public String deleteAll();

}
