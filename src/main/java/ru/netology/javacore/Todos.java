package ru.netology.javacore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Todos {
    List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(tasks);
        tasks.forEach((value) -> stringBuilder.append(value).append(" "));
        return stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length()).toString();
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }
}
