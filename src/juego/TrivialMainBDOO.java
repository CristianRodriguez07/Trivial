package juego;


import Dao.UserDAO;
import ficheros.GestionaFicheros;
import users.Admin;
import users.Player;
import users.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrivialMainBDOO {
    private static ArrayList<User> users = new ArrayList<>();

    /**
     * Método principal que muestra el menú principal
     *
     * @param args Argumentos de la línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            ArrayList<User> users = (ArrayList<User>) UserDAO.readAll();
            System.out.println("1.Registro player");
            System.out.println("2.Registro admin");
            System.out.println("3.Inicio de sesión");
            System.out.println("4.Salir");
            try {
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> registroPlayer();
                    case 2 -> registroAdmin();
                    case 3 -> inicioSesion();
                    case 4 -> System.exit(0);
                    default -> System.out.println("Opción incorrecta");
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Método que registra un nuevo jugador en el sistema
     * y lo guarda en el fichero de usuarios registrados
     */
    private static void registroPlayer() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        users = GestionaFicheros.cargaUsers();
        System.out.println("Introduce nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce contraseña");
        String pass = sc.nextLine();
        System.out.println("Repite contraseña");
        String pass2 = sc.nextLine();
        if (pass.equals(pass2)) {
            if (pass.length() >= 8) {
                User user = new Player(nombre, pass);
                if (!users.contains(user)) {
                    users.add(user);
                    GestionaFicheros.guardaUsers(users);
                } else {
                    System.out.println("El usuario ya existe");
                }
            } else {
                System.out.println("La contraseña debe tener al menos 8 caracteres");
            }
        } else {
            System.out.println("Las contraseñas no coinciden");
        }
    }

    /**
     * Método que registra un nuevo administrador en el sistema y lo guarda
     * en el fichero de usuarios registrados si la contraseña tiene al menos
     * 8 caracteres, si no existe ya un usuario con ese nombre de usuario y si es la misma salta un error
     * * @throws IOException
     */
    private static void registroAdmin() throws IOException {
        Scanner sc = new Scanner(System.in);
        users = GestionaFicheros.cargaUsers();
        System.out.println("Introduce nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce contraseña");
        String pass = sc.nextLine();
        System.out.println("Repite contraseña");
        String pass2 = sc.nextLine();
        if (!pass.equals(pass2)) {
            System.out.println("Las contraseñas no coinciden");
            return;
        }
        if (pass.length() < 8) {
            System.out.println("La contraseña debe tener al menos 8 caracteres");
            return;
        }
        User user = new Admin(nombre, pass);
        if (users.contains(user)) {
            System.out.println("El usuario ya existe");
            return;
        }
        users.add(user);
        GestionaFicheros.guardaUsers(users);
    }

    /**
     * Método que inicia sesión en el sistema y muestra el menú de juego
     * o de administración según el tipo de usuario que sea
     * el que inicie sesión en el sistema
     */
    private static void inicioSesion() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        users = GestionaFicheros.cargaUsers();
        Player player = null;
        Admin admin = null;

        System.out.println("Introduce nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce contraseña");
        String pass = sc.nextLine();

        for (User user : users) {
            if (user instanceof Player currentPlayer) {
                if (currentPlayer.getNombre().equals(nombre) && currentPlayer.getPass().equals(pass)) {
                    player = currentPlayer;
                    break;
                }
            } else if (user instanceof Admin currentAdmin) {
                if (currentAdmin.getNombre().equals(nombre) && currentAdmin.getPass().equals(pass)) {
                    admin = currentAdmin;
                    break;
                }
            }
        }

        if (player != null) {
            TrivialJuego trivialJuego = new TrivialJuego(player);
            trivialJuego.jugar();
        } else if (admin != null) {
            TrivialAdmin trivialAdmin = new TrivialAdmin();
            trivialAdmin.administrar();
        } else {
            System.out.println("El usuario no existe");
        }
    }

}