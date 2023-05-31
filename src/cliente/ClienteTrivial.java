package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteTrivial {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ClienteTrivial() {
        try {
            socket = new Socket("localhost", 12345);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Conexión establecida con el servidor.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void jugarTrivial() {
        try {
            int puntuacionTotal = 0;

            for (int i = 0; i < 5; i++) {
                String pregunta = recibirMensaje();
                System.out.println("Pregunta: " + pregunta);
                String respuesta = leerRespuesta();
                enviarRespuesta(respuesta);
                boolean acertado = recibirResultado();
                int puntuacion = recibirPuntuacion();
                System.out.println("¿Acertado? " + (acertado ? "Sí" : "No"));
                System.out.println("Puntuación: " + puntuacion);
                puntuacionTotal += puntuacion;
            }

            String mensajeDespedida = recibirMensaje();
            System.out.println(mensajeDespedida);
            System.out.println("Puntuación total: " + puntuacionTotal);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String recibirMensaje() throws IOException {
        return input.readLine();
    }

    private String leerRespuesta() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private void enviarRespuesta(String respuesta) {
        output.println(respuesta);
    }

    private boolean recibirResultado() throws IOException {
        String resultado = recibirMensaje();
        return resultado.equals("ACERTADO");
    }

    private int recibirPuntuacion() throws IOException {
        String puntuacion = recibirMensaje();
        return Integer.parseInt(puntuacion);
    }

    public static void main(String[] args) {
        ClienteTrivial cliente = new ClienteTrivial();
        cliente.jugarTrivial();
    }
}

