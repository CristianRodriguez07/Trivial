package users;

import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa una partida
 * de un jugador
 * @author  Cristian Rodriguez
 */
public class Partida {
    private Date date;
    private int puntuacion;
    private Player player;

    /**
     * Constructor de la clase Partida que
     * recibe un jugador y crea una partida
     * con la fecha actual y la puntuación a
     * 0 para ese jugador
     * @param player Jugador de la partida
     */
    public Partida(Player player){
        this.date = new Date();
        this.puntuacion = 0;
        this.player = player;
    }

    /**
     * Método que suma un punto a la puntuación
     * de la partida
     */
    public void sumarPunto(){
        this.puntuacion++;
    }

    /**
     * Método que resta un punto a la puntuación
     * de la partida
     */
    public int getPuntuacion(){
        return this.puntuacion;
    }

    /**
     * Método que devuelve la fecha de la partida
     * @return date Fecha de la partida
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * Método que devuelve el jugador de la partida
     * @return player Jugador de la partida
     */
    public Player getPlayer(){
        return this.player;
    }

    /**
     * Método que devuelve la fecha, la puntuación
     * y el jugador de la partida
     * @return String con la fecha, la puntuación
     */
    public String toString(){
        return "Fecha: " + this.date + " Puntuación: " + this.puntuacion + " Jugador: " + this.player.getNombre();
    }

    /**
     * Método que compara dos partidas y devuelve
     * true si son iguales y false si no lo son
     * @param o Object con la partida a comparar
     * @return true si son iguales y false si no lo son
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Partida partida = (Partida) o;
        return puntuacion == partida.puntuacion && Objects.equals(date, partida.date) && Objects.equals(player, partida.player);
    }

}

