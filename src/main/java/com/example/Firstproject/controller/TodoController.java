package com.example.Firstproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.Firstproject.model.Todo;
import com.example.Firstproject.service.LoginService;
import com.example.Firstproject.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET) 
	public String showTodos(ModelMap model) {
		String name = getLoggedinUserName(model);
		model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}

	// refactor alt+shift+M
	private String getLoggedinUserName(ModelMap model) {
		return (String) model.get("name");
	}

	
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap model) {
		model.put("todo", new Todo(0, getLoggedinUserName(model), "", new Date(), false));
		return "add-todo";
	}
	/* Using Command Bean */
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodoPost(ModelMap model,@Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "add-todo";
		}
		service.addTodo(getLoggedinUserName(model), todo.getDesc(),todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}

	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET) 
	public String deleteTodo(@RequestParam int id) {
		if(id==1) throw new RuntimeException("somwthing gadbadd");// whitelabel error with above mssg
		
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "add-todo";
	}
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "add-todo";
		}
		
		todo.setUser(getLoggedinUserName(model));
		service.updateTodo(todo);	
		
		return "redirect:/list-todos";
	}

}

