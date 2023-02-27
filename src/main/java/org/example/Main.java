package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Main {
    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) throws IOException {
        System.out.println("Client is started");
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        Socket socket = new Socket("localhost", 8081);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter output = new PrintWriter(outputStream, true);

        System.out.println("please enter the command");
        String message = scanner.next();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while (!message.equals("exit")) {
            message = scanner.next();
            output.println(message);
            String serverWord = bufferedReader.readLine(); // ждём, что скажет сервер
            System.out.println(serverWord);
        }



    }

}