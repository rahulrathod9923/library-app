package com.library.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.app.entity.Users;
import com.library.app.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository usersRepository;

	public Users createUser(Users user) {
		return usersRepository.save(user);
	}

	public Optional<Users> getUserById(Long id) {
		return usersRepository.findById(id);
	}

	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}
	
	public Users updateUserById(Users user , Long id) {
		Users existingBook = usersRepository.findById(id).get();
		
		existingBook.setBookName(user.getBookName());
		existingBook.setAuthor(user.getAuthor());
		existingBook.setDateOfIssue(user.getDateOfIssue());
		existingBook.setNameOfUser(user.getNameOfUser());
		
		return usersRepository.save(existingBook);
	}

	public String deleteById(Long id) {
		usersRepository.deleteById(id);
		return "Record deleted successfully";
	}
}
