package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 0;
	
	static {
		todos.add(new Todo(++todoCount, "in28min", "learn Aws", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "in28min", "learn Spring", LocalDate.now().plusYears(3), false));
		todos.add(new Todo(++todoCount, "in28min", "learn React", LocalDate.now().plusYears(6), false));
	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}
	
	public void addTodo(String Username,String Description,LocalDate localDate,boolean hasDone)
	{
		Todo todo = new Todo(++todoCount,Username,Description,localDate,hasDone);
		todos.add(todo);
		
	}
	
	public void deleteById(int id)
	{

		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
		
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	
	}

}
