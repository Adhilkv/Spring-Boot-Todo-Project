package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	
	static {
		todos.add(new Todo(1, "in28min", "learn Aws", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(2, "in28min", "learn Spring", LocalDate.now().plusYears(3), false));
		todos.add(new Todo(3, "in28min", "learn React", LocalDate.now().plusYears(6), false));
	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}

}
