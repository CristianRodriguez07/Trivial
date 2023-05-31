package users;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Clase que representa a un admin del juego
 * @author Cristian Rodriguez
 */
@Entity
public class Admin extends User implements Serializable {

    /**
     * Constructor de la clase Admin
     * @param nombre String con el nombre del admin
     * @param pass String con la pass del admin
     */
    public Admin(String nombre, String pass) {
        super(nombre, pass);
    }

    public Admin() {

    }

    /**
     * Devuelve true si el usuario es admin
     * @return true si el usuario es admin
     */
    @Override
    public boolean permisosAdmin() {
        return true;
    }

    /**
     * Devuelve el nombre y la pass del admin
     * @return String con el nombre y la pass del admin
     */
    public String toString(){
        return "Nombre: " + this.nombre + " Pass: " + this.pass;
    }

    /**
     * Compara dos admins y devuelve true
     * si son iguales y false si no lo son
     * @param o Object con el admin a comparar
     * @return true si son iguales y false si no lo son
     */
    public boolean equals(Object o){
        if(o instanceof Admin){
            Admin a = (Admin) o;
            if(this.nombre.equals(a.getNombre()) && this.pass.equals(a.getPass())){
                return true;
            }
        }
        return false;
    }

    public String getPass() {
        return pass;
    }
}
