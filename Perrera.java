/**
 * Clase Perrera
 * Encargada de organizar a todas las familias y perros dentro del sistema, contiene las razas de perro peligrosas,
 * permite agregar nuevas familias y perros, y manejar los datos de estos.
 * 
 * @version 1.0, 22/08/2021
 * @author Diego E. Lemus L. - 21469
 */

 public class Perrera {
    //-----PROPIEDADES-----
    Familia[] familias = new Familia[15];
    Perro[] perros = new Perro[30];
    private int nf;
    private int np;
    //Array con razas peligrosas
    String[] razasPeligrosas = {"Pitbull terrier", "American Staffordshire terrier", "Tosa Inu", "Dogo argentino", "Dogo Guatemalteco", "Fila brasileño","Presa canario", "Doberman", "Gran perro japones", "Mastin napolitano", "Presa Mallorqui", "Dogo de burdeos", "Bullmastiff", "Bull terrier ingles","Bulldog americano", "Rhodesiano", "Rottweiler"};

    /** 
     * Constructor para Perrera
     */
    public Perrera(){
        nf = 0;
        np = 0;
    }

    /** 
     * Método para agregar familia de ejemplo al sistema.
     */
    public void agregarFamilia(){
        familias[nf++] = new Familia();
    }

    /** 
     * Método para agregar familia al sistema.
     * @param apellido
     * @param miembrosFam
     * @param ninos
     * @param adolescentes
     * @param adultos
     * @param mascotas
     */
    public void agregarFamilia(String apellido, int miembrosFam, int ninos, int adolescentes, int adultos, int mascotas){
        familias[nf++] = new Familia(apellido, miembrosFam, ninos, adolescentes, adultos, mascotas);
    }

    /** 
     * Método para agregar perro al sistema.
     * @param nombreP
     * @param razaP
     * @param tamanoP
     * @param edadP
     * @param saludP
     * @param estadoP
     */
    public void agregarPerro(String nombreP, String razaP, int tamanoP, int edadP, int saludP, boolean estadoP){
        perros[np++] = new Perro(nombreP, razaP, tamanoP, edadP, saludP, estadoP);
    }

    /** 
     * Método que devuelve la cantidad de familias registradas.
     * @return int nf (numero de familias)
     */
    public int getNumFam(){
        return (nf);
    }

    /** 
     * Método que devuelve la cantidad de perros registrados.
     * @return int np (número de perros)
     */
    public int getNumPerros(){
        return (np);
    }

    /** 
     * Método que devuelve la cantidad de niños en una familia.
     * @param t id
     * @return int cantidadNinos
     */
    public int getNinosT(int t){
        int cantidadNinos = familias[t].getNinos();
        return cantidadNinos;
    }

    /** 
     * Método que devuelve la cantidad de adolescentes en una familia.
     * @param t id
     * @return int cantidadAdol
     */
    public int getAdolescentesT(int t){
        int cantidadAdol = familias[t].getAdolescentes();
        return cantidadAdol;
    }

    /** 
     * Método que devuelve la cantidad de adultos en una familia.
     * @param t id
     * @return int cantidadAdul
     */
    public int getAdultosT(int t){
        int cantidadAdul = familias[t].getAdultos();
        return cantidadAdul;
    }

    /** 
     * Método que devuelve la cantidad de mascotas en una familia.
     * @param t id
     * @return int mascotas
     */
    public int getMascotas(int t){
        int mascotas = familias[t].getMascotas();
        return mascotas;
    }
    
    /** 
     * Método que devuelve la raza de un perro.
     * @param p id
     * @return String raza
     */
    public String getRazaP(int p){
        String raza = perros[p].getRaza();
        return raza;
    }

    /** 
     * Método que devuelve el tamaño de un perro.
     * @param p id
     * @return int tamaño
     */
    public int getTamanoP(int p){
        int tamano = perros[p].getTamano();
        return tamano;
    }

    /** 
     * Método que devuelve el estado de un perro.
     * @param p id
     * @return boolean est (true=asignado, false=no asignado)
     */
    public boolean getEstadoP(int p){
        boolean est = perros[p].getEstado();
        return est;
    }
 
    /** 
     * Método que indica si un perro pertenece a una raza peligrosa.
     * @param p id
     * @return boolean peligrosidad (true=si, false=no)
     */
    public boolean peligrosidadP(int p){
        //Por defecto se supone que no
        boolean peligrosidad = false;
        //Ciclo que verifica raza por raza dentro del array
        for(int i=0; i<razasPeligrosas.length; i++){
            String raza = perros[p].getRaza();
            String razaPeligrosa = razasPeligrosas[i];
            //Se verifica si hay coincidencia
            if(raza.equals(razaPeligrosa)){
                peligrosidad = true;
                break;
            }else{
                peligrosidad = false;
            }
        }
        return peligrosidad;
    }

    /** 
     * Método que actualiza el estado de un perro (asignado o no).
     * @param p id
     */
    public void ActualizarEstado(int p){
        perros[p].actualizarEstado();
    }

    /** 
     * Método que actualiza la cantidad de mascotas en una familia.
     * @param t id
     */
    public void actualizarMascotas(int t){
        familias[t].actualizarMascotas();
    }

    /** 
     * Método que muestra a todas las familias dentro del sistema.
     * (Se eligió hacerlo acá y no en vista para evitar problema de compatibilidad y el ciclo)  
     */
    public void mostrarFamilias(){
        for(int i=0; i<nf; i++){
            System.out.println("\n+++++ Familia No."+(i+1)+" +++++");
            System.out.println("- Apellido: "+familias[i].getApellido());
            System.out.println("- Numero de miembros: "+familias[i].getMiembrosFam());
            System.out.println("- Adultos: "+familias[i].getAdultos());
            System.out.println("- Niños: "+familias[i].getNinos());
            System.out.println("- Adolescentes: "+familias[i].getAdolescentes());
            System.out.println("- Numero de mascotas: "+familias[i].getMascotas());
        }
    }

    /** 
     * Método que muestra a todos los perros dentro del sistema.
     * (Se eligió hacerlo acá y no en vista para evitar problema de compatibilidad y el ciclo)  
     */
    public void mostrarPerros(){
        for(int i=0; i<np; i++){
            System.out.println("\n+++++ Perro No."+(i+1)+" +++++");
            System.out.println("- Nombre: "+perros[i].getNombre());
            System.out.println("- Raza: "+perros[i].getRaza());
            System.out.println("- Tamaño: "+perros[i].getTamano());
            System.out.println("- Edad: "+perros[i].getEdad());
            System.out.println("- Salud: "+perros[i].getSaludP());
            System.out.println("- Estado: "+perros[i].getEstado());
        }
    }

    /** 
     * Método que muestra un listado de todas las razas peligrosas.
     * (Se eligió hacerlo acá y no en vista para evitar problema de compatibilidad y el ciclo)  
     */
    public void mostrarRazasPeligrosas(){
        System.out.println("\nLas razas consideradas como peligrosas son:");
        for(int r=0; r<17; r++){
            System.out.println((r+1)+". "+razasPeligrosas[r]);
        }
        System.out.println();
    }

}