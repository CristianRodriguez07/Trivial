package preguntas;

/**
 * Clase Pregunta
 * Contiene la pregunta y las opciones de la pregunta
 * @author Cristian Rodriguez
 */
public class Pregunta {
    private String pregunta;
    private Opcion[] opciones;

    /**
     * Constructor de la clase Pregunta
     * @param pregunta String con la pregunta de la clase
     * @param opciones Opcion[] con las opciones de la pregunta
     */
    public Pregunta(String pregunta, Opcion[] opciones){
        this.pregunta = pregunta;
        this.opciones = opciones;
    }

    /**
     * Devuelve la pregunta
     * @return String con la pregunta
     */
    public String getPregunta(){
        return this.pregunta;
    }

    /**
     * Devuelve las opciones de la pregunta
     * @return Opcion[] con las opciones de la pregunta
     */
    public Opcion[] getOpciones(){
        return this.opciones;
    }

    /**
     * Devuelve la opcion correcta
     * @return String con la opcion correcta
     */
    public String getOpcionCorrecta(){
        for (Opcion opcion : opciones) {
            if (opcion.getCorrecta()){
                return opcion.getEnunciado();
            }
        }
        return null;
    }

    /**
     * Devuelve la opcion incorrecta
     * @return String con la opcion incorrecta
     */
    public boolean esCorrecta(int indice){
        return opciones[indice].getCorrecta();
    }

    /**
     * Devuelve la pregunta y sus opciones en forma de String
     * @return String con la pregunta y sus opciones
     */
    public String toString() {
        String texto = "Pregunta: " + this.pregunta + " Opciones: ";
        for (Opcion opcion : opciones) {
            texto += opcion.toString();
        }
        return texto;
    }

    /**
     * Compara dos preguntas y devuelve true
     * si son iguales y false si no lo son
     * @param o Pregunta a comparar con la actual
     * @return boolean
     */
    public boolean equals(Object o){
        if(o instanceof Pregunta){
            Pregunta p = (Pregunta) o;
            if(this.pregunta.equals(p.getPregunta())){
                return true;
            }
        }
        return false;
    }

}

