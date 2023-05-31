package preguntas;

/**
 * Clase Opcion
 * Contiene el enunciado de la opcion y si es correcta o no
 * @author Cristian Rodriguez
 */
public class Opcion {
    private final String enunciado;
    private final boolean correcta;

    /**
     * Constructor de la clase Opcion
     * @param enunciado
     * @param correcta
     */
    public Opcion(String enunciado, boolean correcta){
        this.enunciado = enunciado;
        this.correcta = correcta;
    }

    /**
     * Devuelve el enunciado de la opcion
     * @return String con el enunciado de la opcion
     */
    public String getEnunciado(){
        return this.enunciado;
    }

    /**
     * Devuelve si la opcion es correcta o no
     * @return true si es correcta, false si no lo es
     */
    public boolean getCorrecta(){
        return this.correcta;
    }

    /**
     * Modifica el enunciado de la opcion
     */
    @Override
    public String toString() {
        return enunciado;
    }

    /**
     * Compara dos opciones y devuelve true
     * si son iguales y false si no lo son
     * @param o Object con la opcion a comparar
     * @return true si son iguales y false si no lo son
     */
    public boolean equals(Object o){
        if(o instanceof Opcion op){
            return this.enunciado.equals(op.getEnunciado()) && this.correcta == op.getCorrecta();
        }
        return false;
    }

}

