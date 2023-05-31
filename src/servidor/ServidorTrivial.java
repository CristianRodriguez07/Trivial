package servidor;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTrivial {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor iniciado. Esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress().getHostAddress());

                HiloCliente hiloCliente = new HiloCliente(clientSocket);
                hiloCliente.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}