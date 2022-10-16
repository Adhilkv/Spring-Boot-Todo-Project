package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.constraints.Size;

public class Todo {

	private int id;
	private String username;
	@Size(min = 10, message = "Enter Atleast 10 Char")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
		logger.debug("inside constructor Todo " + id + " :: " + username + " :: " + description + " :: " + targetDate
				+ " :: " + done);
	}

	public int getId() {
		logger.debug("getId ");
		return id;
	}

	public void setId(int id) {
		logger.debug("setId : " + id);
		this.id = id;
	}

	public String getUsername() {
		logger.debug("getUsername");
		return username;
	}

	public void setUsername(String username) {
		logger.debug("setUsername : " + username);
		this.username = username;
	}

	public String getDescription() {
		logger.debug("getDescription");
		return description;
	}

	public void setDescription(String description) {
		logger.debug("setDescription : " + description);
		this.description = description;
	}

	public LocalDate getTargetDate() {
		logger.debug("getTargetDate");
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		logger.debug("setTargetDate : " + targetDate);
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		logger.debug("isDone");
		return done;
	}

	public void setDone(boolean done) {
		logger.debug("setDone : " + done);
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

}
