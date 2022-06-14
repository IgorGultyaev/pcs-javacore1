package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TodoServer {
    int port;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {

        String act = "Start";
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Starting server at " + port + "...");

            while (!act.equals("#end")) {

                Socket clientSocket = serverSocket.accept(); // ждем подключения
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                Gson gson = new Gson();
                Json json = gson.fromJson(in.readLine(), Json.class);
                act = json.type;
                if (act.equals("ADD")) {

                    todos.addTask(json.task);
                } else if(act.equals("REMOVE")){
                    todos.removeTask(json.task);
                }
                System.out.println("Список задач: " + todos.getAllTasks());
                out.println("Задача добавлена, список всех задач: " + todos.getAllTasks());
            }

        } catch (IOException e){
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }

    }
}
