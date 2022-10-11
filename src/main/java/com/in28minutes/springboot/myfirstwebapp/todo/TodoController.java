package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") 
public class TodoController {
	
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todo")
	public String listalltodo(ModelMap model)
	{
		List<Todo> todos = todoService.findByUsername("in28min");
		model.put("todos", todos);		
		return "listTodos";
	}

}
