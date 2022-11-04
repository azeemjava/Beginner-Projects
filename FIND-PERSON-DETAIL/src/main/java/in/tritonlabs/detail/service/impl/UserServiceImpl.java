package in.tritonlabs.detail.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.tritonlabs.detail.entity.Adhar;
import in.tritonlabs.detail.entity.User;
import in.tritonlabs.detail.entity.Vote;
import in.tritonlabs.detail.repository.IUserRepository;
import in.tritonlabs.detail.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepo;

	public List<User> readAll() {
		return userRepo.findAll();
	}

	public Optional<User> readOne(long id) {
		return userRepo.findById(id);
	}

	public User create(User user) {

		User userObj = new User();
		userObj.setName(user.getName());

		List<Adhar> adharList = user.getAdhar();
		Adhar adharObj = adharList.get(0);
		adharObj.setUser(userObj);
		adharObj.setName(adharObj.getName());
		adharObj.setIdentity(adharObj.getIdentity());
		adharList.add(adharObj);

		List<Vote> voteList = user.getVote();
		Vote voteObj = voteList.get(0);
		voteObj.setUser(userObj);
		voteObj.setName(voteObj.getName());
		voteObj.setIdentity(voteObj.getIdentity());
		voteList.add(voteObj);

		userObj.setVote(voteList);
		userObj.setAdhar(adharList);

		return userRepo.save(userObj);

	}

	public User update(User user, long id) {

		Optional<User> userFind = userRepo.findById((long) id);
		User UserGet = userFind.get();

		List<Adhar> adharList = UserGet.getAdhar();
		Adhar adharGetPosition = adharList.get(0);
		long adharId = adharGetPosition.getId();

		List<Vote> voteListTemp = UserGet.getVote();
		Vote voteGetPosition = voteListTemp.get(0);
		long voteId = voteGetPosition.getId();

		User userSet = new User();
		userSet.setId(id);
		userSet.setName(user.getName());

		List<Adhar> adharListAdd = user.getAdhar();
		Adhar adhar = adharListAdd.get(0);
		adhar.setUser(userSet);
		adhar.setId(adharId);
		adhar.setName(adhar.getName());
		adhar.setIdentity(adhar.getIdentity());
		adharListAdd.add(adhar);

		List<Vote> voteList = user.getVote();
		Vote vote = voteList.get(0);
		vote.setUser(userSet);
		vote.setId(voteId);
		vote.setName(vote.getName());
		vote.setIdentity(vote.getIdentity());
		voteList.add(vote);

		userSet.setAdhar(adharListAdd);
		userSet.setVote(voteList);

		return userRepo.save(userSet);

	}

	public String delete(long id) {
		userRepo.deleteById(id);
		return null;
	}

	public String deleteAll() {
		userRepo.deleteAll();
		return null;
	}
}
