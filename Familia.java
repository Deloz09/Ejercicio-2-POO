import java.util.Random;
/**
 * Clase Familia
 * Representa a una familia, contiene y maneja sus caracteristicas.
 * 
 * @version 1.0, 22/08/2021
 * @author Diego E. Lemus L. - 21469
 */

public class Familia {
    //-----PROPIEDADES-----
    private String apellido;
    private int miembrosFam;
    private int ninos;
    private int adolescentes;
    private int adultos;
    private int mascotasFam;
    Random rand = new Random();
    private String[] apellidosDefault = {"Martinez", "Villalta", "Morales", "Orozco", "Montenegro", "Arredondo"};

    /** 
     * Constructor para Familia de ejemplo
     */
    public Familia(){
        apellido = apellidosDefault[rand.nextInt(6)];
        adultos = 2;
        ninos = rand.nextInt(2);
        adolescentes = rand.nextInt(2);
        miembrosFam = adultos+ninos+adolescentes;
    }

    /** 
     * Constructor para Familia
     * @param ape (apellido)
     * @param miemFam (miembros)
     * @param nin (niños)
     * @param ado (adolescentes)
     * @param adu (adultos)
     * @param masFam (mascotas)
     */
    public Familia(String ape, int miemFam, int nin, int ado, int adu, int masFam){
        apellido = ape;
        miembrosFam = miemFam;
        ninos = nin;
        adolescentes = ado;
        adultos = adu;
        mascotasFam = masFam;
    }
    
    
    /** 
     * Método que devuelve el apellido de la familia.
     * @return String
     */
    public String getApellido(){
        return apellido;
    }

    
    /** 
     * Método que devuelve la cantidad de miembros de la familia.
     * @return int
     */
    public int getMiembrosFam(){
        return miembrosFam;
    }

    
    /** 
     * Método que devuelve la cantidad de niños en la familia.
     * @return int
     */
    public int getNinos(){
        return ninos;
    }

    
    /** 
     * Método que devuelve la cantidad de adolescentes en la familia.
     * @return int
     */
    public int getAdolescentes(){
        return adolescentes;
    }

    
    /** 
     * Método que devuelve la cantidad de adultos en la familia.
     * @return int
     */
    public int getAdultos(){
        return adultos;
    }

    
    /** 
     * Método que devuelve la cantidad de mascotas en la familia.
     * @return int
     */
    public int getMascotas(){
        return mascotasFam;
    }

    /** 
     * Método que realiza la actualización de cantidad de mascotas.
     */
    public void actualizarMascotas(){
        mascotasFam = mascotasFam + 1;
    }
}
