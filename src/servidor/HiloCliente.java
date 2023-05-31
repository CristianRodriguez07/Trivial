package servidor;

import users.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloCliente extends Thread {
    private Socket clientSocket;

    public HiloCliente(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            output.println("Bienvenido al Trivial. Por favor, introduce tu nombre:");
            String nombre = input.readLine();
            Player player = new Player(nombre, "");

            for (int i = 1; i <= 5; i++) {
                String pregunta = obtenerPregunta(i); // Método para obtener la pregunta correspondiente
                output.println("Pregunta " + i + ": " + pregunta);
                String respuesta = input.readLine();
                // Realizar la lógica para verificar la respuesta y enviar la respuesta al cliente
                output.println("Respuesta recibida para pregunta " + i);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String obtenerPregunta(int numeroPregunta) {
        // Lógica para obtener la pregunta correspondiente al número proporcionado
        return "¿Pregunta " + numeroPregunta + "?";
    }
}

