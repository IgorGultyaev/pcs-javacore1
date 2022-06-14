package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class TodosTests {

    @org.junit.jupiter.api.Test
    public void testTodosGetAllTasks(){
        // given:
        String expected = "task #A task #B task #C";
        Todos todos = new Todos();
        todos.addTask("task #A");
        todos.addTask("task #C");
        todos.addTask("task #B");
        // when:
        String result = todos.getAllTasks();
        // then:
        Assertions.assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    public void testTodosRemoveTask(){
        // given:
        String expected = "task #A task #B";
        Todos todos = new Todos();
        todos.addTask("task #A");
        todos.addTask("task #C");
        todos.addTask("task #B");
        // when:
        todos.removeTask("task #C");
        String result = todos.getAllTasks();
        // then:
        Assertions.assertEquals(expected, result);
    }

//    @org.junit.jupiter.api.Test
//    public void testTodosGetAllTasks(){
//        // given:
//        String expected = "task #A task #B task #C";
//        Todos todos = new Todos();
//        todos.addTask("task #A");
//        todos.addTask("task #C");
//        todos.addTask("task #B");
//        // when:
//        String result = todos.getAllTasks();
//        // then:
//        Assertions.assertEquals(expected, result);
//    }


}
