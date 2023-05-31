package juego;

import ficheros.GestionaFicheros;
import users.User;

import java.io.IOException;
import java.util.List;

/**
 * Clase que administra el juego trivial
 * @author Cristian Rodriguez
 */
public class TrivialAdmin implements Comparable<User> {
    public TrivialAdmin() {
    }

    /**
     * Método que muestra las partidas jugadas y los usuarios registrados
     */
    public void administrar() throws IOException, ClassNotFoundException {
        System.out.println("Bienvenido administrador");
        System.out.println("Partidas jugadas: ");
        List<String> partidas = GestionaFicheros.leePartidas();
        if (partidas.isEmpty()) {
            System.out.println("No hay partidas registradas.");
        } else {
            for (String partida : partidas) {
                System.out.println(partida);
            }
        }
        System.out.println("Usuarios registrados: ");
        List<User> usuarios = GestionaFicheros.cargaUsers();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (User user : usuarios) {
                System.out.println("- " + user.getNombre());
            }
        }
    }


    /**
     * Método que muestra las estadísticas de un usuario
     */
    @Override
    public int compareTo(User o) {
        return 0;
    }
}

