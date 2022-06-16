package ru.netology.javacore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Todos {
    private List<String> tasks = new ArrayList<>();

    protected void addTask(String task) {
        tasks.add(task);
    }

    protected void removeTask(String task) {
        tasks.remove(task);
    }

    protected String getAllTasks() {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(tasks);
        tasks.forEach((value) -> stringBuilder.append(value).append(" "));
        return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();
    }

    public List<String> getTasks() {
        return new ArrayList<>(tasks);
    }
}
