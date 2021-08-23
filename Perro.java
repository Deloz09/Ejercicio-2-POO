/**
 * Clase Perro
 * Representa a un perro, contiene y maneja sus caracteristicas.
 * 
 * @version 1.0, 22/08/2021
 * @author Diego E. Lemus L. - 21469
 */

public class Perro {
    //-----PROPIEDADES-----
    private String nombreP;
    private String razaP;
    private int tamanoP;
    private int edadP;
    private int saludP;
    private boolean estadoP;

    /** 
     * Constructor para Perro
     */
    public Perro(String n, String r, int t, int e, int s, boolean es){
        nombreP = n;
        razaP = r;
        tamanoP = t;
        edadP = e;
        saludP = s;
        estadoP = es;
    }
    
    /** 
     * Método que devuelve el nombre del perro.
     * @return String nombreP
     */
    public String getNombre(){
        return nombreP;
    }
    
    /** 
     * Método que devuelve la raza del perro.
     * @return String razaP
     */
    public String getRaza(){
        return razaP;
    }

    /** 
     * Método que devuelve el tamaño del perro (pequeño, mediano, grande).
     * @return int tamanoP
     */
    public int getTamano(){
        return tamanoP;
    }

    /** 
     * Método que devuelve la edad del perro.
     * @return int edadP
     */
    public int getEdad(){
        return edadP;
    }
    
    /** 
     * Método que devuelve la salud del perro (1-100).
     * @return int saludP
     */
    public int getSaludP(){
        return saludP;
    }
    
    /** 
     * Método que devuelve el estado del perro (asignado o no).
     * @return boolean estadoP
     */
    public boolean getEstado(){
        return estadoP;
    }

    /** 
     * Método que realiza la actualización de estado.
     * @return boolean estadoP (actualizado)
     */
    public void actualizarEstado(){
        estadoP = true;    
    }
}
