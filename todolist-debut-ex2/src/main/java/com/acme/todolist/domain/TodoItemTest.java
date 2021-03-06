package com.acme.todolist.domain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test correspondant à la règle de gestion 1
 * 
 */
class TodoItemTest {
	
	/////////////////////////////////////////////////////////
	/////////On vérifie si islate() fonctionne bien//////////
	/////////////////////////////////////////////////////////

	@Test
	void isNotLate_itemCreationDate20Minutes_afterCurrentTime_returnsFalse() {
	     TodoItem item = new TodoItem("1", Instant.now().minus(20,ChronoUnit.MINUTES), "mycontent"); // 20 minutes de retard
	     assertFalse(item.isLate());
	}
	
	@Test
	void isNotLate_itemCreationDate20Minutes_beforeCurrentTime_returnsFalse() {
	     TodoItem item = new TodoItem("1", Instant.now().plus(20,ChronoUnit.MINUTES), "mycontent");  // 20 minutes d'avance
	     assertFalse(item.isLate());
	}
	
	@Test
	void isLate_itemCreationDate1Day_afterCurrentTime_returnsTrue() {
	     TodoItem item = new TodoItem("1", Instant.now().minus(25,ChronoUnit.HOURS), "mycontent");   // 25 heures de retard
	     assertTrue(item.isLate());
	}
	
	///////////////////////////////////////////////////////////
	//On vérifie si le texte correspond au statut de islate()//
	///////////////////////////////////////////////////////////
	
	@Test
	void containsLate_itemCreationDate20Minutes_afterCurrenTime_returnsFalse() {
	     TodoItem item = new TodoItem("1", Instant.now().minus(20,ChronoUnit.MINUTES), "mycontent"); // 20 minutes de retard
	     assertFalse(item.finalContent().contains("LATE" ));
	}
	
	@Test
	void containsLate_itemCreationDate20Minutes_beforeCurrenTime_returnsFalse() {
	     TodoItem item = new TodoItem("1", Instant.now().plus(20,ChronoUnit.MINUTES), "mycontent");  // 20 minutes d'avance
	     assertFalse(item.finalContent().contains("LATE" ));
	}
	
	@Test
	void containsLate_itemCreationDate1Day_afterCurrrentTime_returnsTrue() {
	     TodoItem item = new TodoItem("1", Instant.now().minus(25,ChronoUnit.HOURS), "mycontent");   // 25 heures de retard
	     assertTrue(item.finalContent().contains("LATE" ));
	}

}
