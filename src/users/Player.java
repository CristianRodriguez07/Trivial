package users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa a un jugador del juego
 * @author Cristian Rodriguez
 */
@Entity
public class Player extends User implements Serializable {

    /**
     * Constructor de la clase Player que recibe el nombre y la pass del jugador
     * @param nombre String con el nombre del jugador
     * @param pass String con la pass del jugador
     */
    public Player(String nombre, String pass) {
        super(nombre, pass);
    }

    /**
     * Devuelve false si el usuario no es admin
     * @return false si el usuario no es admin
     */
    @Override
    public boolean permisosAdmin() {
        return false;
    }

    /**
     * Devuelve el nombre y la pass del jugador
     * @return String con el nombre y la pass del jugador
     */
    public String toString(){
        return "Nombre: " + this.nombre + " Pass: " + this.pass;
    }

    /**
     * Compara dos jugadores y devuelve true
     * si son iguales y false si no lo son
     * @param o Object con el jugador a comparar
     * @return true si son iguales y false si no lo son
     */
    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player p = (Player) o;
            return Objects.equals(this.nombre, p.getNombre()) && Objects.equals(this.pass, p.getPass());
        }
        return false;
    }


}

