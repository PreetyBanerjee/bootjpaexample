package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		
		UserRepository userRepository=context.getBean(UserRepository.class);
		
//		User user=new User();
//		user.setId(1);
//		user.setName("Preety Banerjee");
//		user.setCity("West Bengal");
//		user.setStatus("I am Java Programmer");
//		
//		User user1=userRepository.save(user);
//		System.out.println(user1);
		
//		*********Create********************
//		Create Object of user
		User user1=new User();
		user1.setName("Deepika");
		user1.setCity("Hyderabad");
		user1.setStatus("I am Python Programmer");
		
		User user2=new User();
		user2.setName("Rahul");
		user2.setCity("Bihar");
		user2.setStatus("I am C Programmer");

//		Saving single user
//		User resultUser=userRepository.save(user2);
		List<User> users=List.of(user1,user2);
//		Save multiple objects
		Iterable<User> result=userRepository.saveAll(users);
		result.forEach(user->{
			System.out.println(user);
		});
		
//		System.out.println("Saved user"+ resultUser);
		System.out.println("done");
		
////		************Update**************
////		update the user of id 52
//		Optional<User> optional= userRepository.findById(52);
//		User user=optional.get();
////		System.out.println(user);
//		
//		user.setName("Pooja Naaz");
//		userRepository.save(user);
//		System.out.println(user);
//		
//		*******Read**********
//		How to get data
//		findById(id) - return Optional Containing your data
		Iterable<User> itr=userRepository.findAll();
//		Iterator<User> iterator=itr.iterator();
//		
//		while(iterator.hasNext()) {
//			User user=iterator.next();
//			System.out.println(user);
//		}
		
////	******anonymous function**********
//		itr.forEach(new Consumer<User>() {
//			@Override
//			public void accept(User t) {
//				// TODO Auto-generated method stub
//				System.out.println(t);
//			}
//			
//		});
//		
////*********Lambda function***********8
//		itr.forEach(user->{System.out.println(user);});
//		
		
//		***********Delete**********
//////		Delete the user element
////		userRepository.deleteById(2);
////		System.out.println("deleted");
//		
//		Iterable<User> allusers= userRepository.findAll();
//		allusers.forEach(user->System.out.println(user));
//		userRepository.deleteAll(allusers);
		
//		List<User> users1=userRepository.findByName("Deepika");
//		users1.forEach(e->System.out.println(e));

		List<User> allUser=userRepository.getAllUser();
		allUser.forEach(e->{
			System.out.println(e);
		});
		System.out.println("__________");
		
		List<User> userByName=userRepository.getUserByName("Rahul");
		userByName.forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("__________");
		
		
		userRepository.getUsers().forEach(e->System.out.println(e));
	}
}

