package ficheros;

import preguntas.Opcion;
import preguntas.Pregunta;
import users.Partida;
import users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona los ficheros de preguntas, usuarios y partidas de la aplicación
 * @author Cristian Rodriguez
 */
public class GestionaFicheros {
    private static final File filePreguntas = new File("files/preguntas.txt");
    private static final File fileUser = new File("files/user.dat");
    private static final File filePartidas = new File("files/partidas.txt");

    /**
     * Guarda los usuarios en un fichero binario con ObjectOutputStream y un ArrayList de usuarios
     * @param users ArrayList de usuarios a guardar
     */
    public static void guardaUsers(ArrayList<User> users) {
            ObjectOutputStream oos = null;
            File fileUser = new File("files/user.dat");
            try {
                oos = new ObjectOutputStream(new FileOutputStream(fileUser));
                oos.writeObject(users);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (oos != null) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

    /**
     * Carga los usuarios de un fichero binario gracias a ObjectInputStream y devuelve un ArrayList de usuarios
     * @return ArrayList de usuarios cargados
     */
    public static ArrayList<User> cargaUsers() {
        List<User> users = new ArrayList<>();
        File fileUser = new File("files/user.dat");
        if (fileUser.exists()) {
            try (FileInputStream fis = new FileInputStream(fileUser);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                users = (List<User>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return (ArrayList<User>) users;
    }

    /**
     * Guarda las preguntas en un fichero de texto con BufferedWriter
     */
    public static List<Pregunta> cargaPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>();
        File filePreguntas = new File("files/preguntas.txt");
        if (filePreguntas.exists()) {
            try (FileReader fr = new FileReader(filePreguntas);
                 BufferedReader br = new BufferedReader(fr)) {
                String pregunta = br.readLine();
                while (pregunta != null) {
                    Opcion[] respuestas = new Opcion[4];
                    respuestas[0] = new Opcion(br.readLine(), true);
                    for (int i = 1; i < 4; i++) {
                        respuestas[i] = new Opcion(br.readLine(), false);
                    }
                    preguntas.add(new Pregunta(pregunta, respuestas));
                    pregunta = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return preguntas;
    }


    /**
     * Guarda las partidas en un fichero de texto con BufferedWriter
     * @param partida Partida a guardar
     */
    public static void guardaPartida(Partida partida) throws IOException {
        File filePartidas = new File("files/partidas.txt");
        if (!filePartidas.exists()) {
            filePartidas.createNewFile();
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(filePartidas, true))) {
            out.println(partida.toString());
        }
    }

    /**
     * Carga las partidas de un fichero de texto con BufferedReader
     * @return ArrayList de partidas cargadas
     */
    public static List<String> leePartidas() throws IOException {
        List<String> partidas = new ArrayList<>();
        File filePartidas = new File("files/partidas.txt");
        if (!filePartidas.exists()) {
            filePartidas.createNewFile();
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePartidas)))) {
            String partida = br.readLine();
            while (partida != null) {
                partidas.add(partida);
                partida = br.readLine();
            }
        }
        return partidas;
    }

}

