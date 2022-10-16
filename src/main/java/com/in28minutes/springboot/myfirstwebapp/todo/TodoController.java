package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String listalltodo(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("in28min");
		model.put("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String name = (String) model.get("name");
		Todo todo = new Todo(0, name, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);

		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, Todo todo) {

		String name = (String) model.get("name");

		todoService.addTodo(name, todo.getDescription(), LocalDate.now().plusYears(1), false);

		return "redirect:list-todo";
	}

}
