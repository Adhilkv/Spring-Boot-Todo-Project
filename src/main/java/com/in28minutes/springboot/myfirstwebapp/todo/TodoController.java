package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
		String name = GetLoginedInUsername(model);
		List<Todo> todos = todoService.findByUsername(name);
		model.put("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {

		String name = GetLoginedInUsername(model);
		Todo todo = new Todo(0, name, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		String name = GetLoginedInUsername(model);

		todoService.addTodo(name, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todo";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}

		String username = GetLoginedInUsername(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todo";
	}

	private String GetLoginedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
