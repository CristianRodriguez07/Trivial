package users;

import javax.jdo.annotations.Query;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Clase que representa a un usuario del juego
 * @author Cristian Rodriguez
 */
@Entity
public abstract class User implements Comparable<User>, Serializable {
    @Id
    protected String nombre;
    protected String pass;

    /**
     * Constructor de la clase User que recibe el nombre y la pass del usuario
     * @param nombre
     * @param pass
     */
    public User(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }

    public User() {

    }

    /**
     * Devuelve el nombre del usuario
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve la pass del usuario
     * @return
     */
    public String getPass() {
        return this.pass;
    }

    /**
     * Cambia la pass del usuario si la longitud es mayor o igual a 8
     * @param pass
     * @return
     */
    public boolean cambiarPass(String pass) {
        if (pass.length() >= 8) {
            this.pass = pass;
            return true;
        }
        return false;
    }

    /**
     * Comprueba si la pass del usuario es correcta
     * @param pass
     * @return
     */
    public boolean compruebaPass(String pass) {
        if (this.pass.equals(pass)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve true si el usuario es admin
     * @return
     */
    public abstract boolean permisosAdmin();

    /**
     * Devuelve el nombre y la pass del usuario
     * @return
     */
    public String toString() {
        return "Nombre: " + this.nombre + " Pass: " + this.pass + "\n";
    }

    /**
     * Compara dos usuarios y devuelve true
     * si son iguales y false si no lo son
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if (o instanceof User) {
            User u = (User) o;
            if (this.nombre.equals(u.getNombre()) && this.pass.equals(u.getPass())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compara dos usuarios y devuelve un entero
     * @param u
     * @return
     */
    public int compareTo(User u) {
        return this.nombre.compareTo(u.getNombre());
    }


    public Object getPassword() {
        return pass;
    }

}
