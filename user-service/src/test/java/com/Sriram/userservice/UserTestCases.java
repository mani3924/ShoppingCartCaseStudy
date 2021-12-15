package com.Sriram.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.Sriram.userservice.model.User;
import com.Sriram.userservice.controller.UserController;
import com.Sriram.userservice.repository.UserRepository;

@SpringBootTest(classes= {UserTestCases.class})
public class UserTestCases {
	
@Mock	
UserRepository userRepo;

@InjectMocks
UserController userController;

@Test
public void getUserById()
{
	List<User> myuser=new ArrayList<User>();
	myuser.add(new User(123,"manikanta","sriram","Sriram@gmail.com","password",98765,"M","Address","house","street","area","city","state","country","user"));
	myuser.add(new User(999,"Bujji","bujji","bujji@gmail.com","password",87654,"f","Address","house","street","area","city","state","country","user"));
	
	int userId=999;
	
	when(userRepo.getUser(userId)).thenReturn(myuser);
	assertEquals(userId,userController.findById());
			
	
}
}
