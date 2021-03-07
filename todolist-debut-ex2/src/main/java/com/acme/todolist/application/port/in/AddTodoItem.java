package com.acme.todolist.application.port.in;
import com.acme.todolist.domain.TodoItem;
public interface AddTodoItem {
	//Représente le contrat servant à ajouter un item
	void addTodoItem(TodoItem item);
	
}
