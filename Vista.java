import java.util.Scanner;

/**
 * Clase Vista
 * Encargada de recibir y mostrarle la información al usuario.
 * 
 * @version 1.0, 22/08/2021
 * @author Diego E. Lemus L. - 21469
 */

public class Vista {
    //-----PROPIEDADES-----
    Scanner scan = new Scanner(System.in);

    /** 
     * Método que muestra el menú, además lee y devuelve la opción del usuario.
     * @return int op, seleccionada por el usuario (1-7)
     */
    public int mostrarMenu(){
        System.out.println("\n\n\n--------------------Menú--------------------");
        System.out.println("Opción 1: Crear nueva familia");
        System.out.println("Opción 2: Mostrar familias en el sistema");
        System.out.println("Opción 3: Recibir perro");
        System.out.println("Opción 4: Mostrar perros en el sistema");
        System.out.println("OPción 5: Mostrar razas 'peligrosas'");
        System.out.println("Opción 6: Asignar perro");
        System.out.println("Opción 7: Salir\n");
        int op = Integer.parseInt(scan.nextLine());
        return op;
    }

    /** 
     * Método que imprime la bienvenida.
     */
    public void bienvenida(){
        System.out.println("\n\nBienvenido al Sistema de Hogares Temporales para Canes");
    }

    /** 
     * Método que imprime la despedida.
     */
    public void despedida(){
        System.out.println("\n\nHa salido del sistema, que tenga un feliz día.\n");
    }

    /** 
     * Método que le pide al usuario el número de miembros de una familia, lee y devuelve.
     * @return int miembros (máximo 12 por familia)
     */
    public int numeroFam(){
        System.out.println("\nIngrese el número de miembros de la familia:");
        int miembros = Integer.parseInt(scan.nextLine());
        return miembros;
    }

    /** 
     * Método que le pide al usuario el apellido de la familia, lee y devuelve.
     * @return String apellido
     */
    public String pedirApellido(){
        System.out.println("\nIngrese el apellido de la familia");
        String apellido = scan.nextLine();
        return apellido;
    }

    /** 
     * Método que le pide al usuario la edad de un miembro "m" de la familia, lee y devuelve.
     * @param m usado para llevar el conteo de miembros
     * @return int edad del miembro de la familia
     */
    public int pedirEdad(int m){
        System.out.println("\nIngrese la edad del miembro "+m+": ");
        int edad = Integer.parseInt(scan.nextLine());
        return edad;
    }

    /** 
     * Método que le pide al usuario el nombre del perro, lee y devuelve.
     * @return String nombreP
     */
    public String pedirNombreP(){
        System.out.println("\nIngrese el nombre del perro:");
        String nombreP = scan.nextLine();
        return nombreP;
    }

    /** 
     * Método que le pide al usuario la raza del perro, lee y devuelve.
     * @return String razaP
     */
    public String pedirRazaP(){
        System.out.println("\nIngrese la raza del perro (Si no se conoce coloque *Mestizo*):");
        String razaP = scan.nextLine();
        return razaP;
    }
    
    /** 
     * Método que le pide al usuario el tamaño del perro, lee y devuelve.
     * @return int tamanoP (1=Pequeño, 2=Mediano, 3=Grande)
     */
    public int pedirTamanoP(){
        System.out.println("\nIngrese el numero correspondiente al tamaño del perro:");
        System.out.println("1. Pequeño\n2. Mediano\n3. Grande");;
        int tamanoP = Integer.parseInt(scan.nextLine());
        return tamanoP;
    }

    /** 
     * Método que le pide al usuario la edad del perro, lee y devuelve.
     * @return int edadP
     */
    public int pedirEdadP(){
        System.out.println("\nIngrese la edad del perro:");
        int edadP = Integer.parseInt(scan.nextLine());
        return edadP;
    }

    /** 
     * Método que le pide al usuario la salud del perro, lee y devuelve.
     * @return int saludP (1-100)
     */
    public int pedirSaludP(){
        System.out.println("\nIngrese la salud del perro (1-100):");
        int saludP = Integer.parseInt(scan.nextLine());
        return saludP;
    }
    
    /** 
     * Método que muestra el número de familias en el sistema.
     * @param i (cantidad de familias)
     */
    public void mostrarNumFamilias(int i){
        System.out.println("El numero de familias en el sistema es: "+i+"\n");
    }

    /** 
     * Método que muestra el número de perros en el sistema.
     * @param i (cantidad de perros)
     */
    public void mostrarNumPerros(int i){
        System.out.println("El numero de perros en el sistema es: "+i+"\n");
    }

    /** 
     * Método que le pide al usuario el id del perro que quiere asignar, lee y devuelve.
     * @return int ap (perro asignado)
     */
    public int asignacion1(){
        System.out.println("\nIngrese el id del perro que desea asignar:");
        int ap = Integer.parseInt(scan.nextLine());
        return ap;
    }

    /** 
     * Método que le pide al usuario el id de la familia a la que quiere asignarle el perro, lee y devuelve.
     * @return int af (familia asignada)
     */
    public int asignacion2(){
        System.out.println("\nIngrese el id de la familia a la que se lo desea asignar:");
        int af = Integer.parseInt(scan.nextLine());
        return af;
    }

    /** 
     * Método que indica que el ingreso de opcion no es válido.
     */
    public void ingresoIncorrecto(){
        System.out.println("\nOpcion invalida, intentelo otra vez.");
    }

    /** 
     * Método que indica que el perro no está disponible para asignación.
     */
    public void perroNoDisponible(){
        System.out.println("\n=> El perro ya ha sido acogido por una familia.");
    }

    /** 
     * Método que indica que el perro ha sido asignado correctamente.
     */
    public void perroAsignado(){
        System.out.println("\n=> El perro ha sido asigando a la familia correctamente. :D");
    }

    /** 
     * Método que indica que la familia no cumple con los requerimientos.
     */
    public void familiaNoDisponible(){
        System.out.println("\n=> La familia no cumple con el requerimiento de acogida temporal. :(");
    }

    /** 
     * Método que indica que la familia ya llegó al máximo de perros asignados.
     */
    public void limiteMascotas(){
        System.out.println("\n=> La familia excede el numero de perros asignados permitidos.");
    }

    /** 
     * Método que indica que la familia excedió el límite de miembros (12).
     */
    public void limiteFamilia(){
        System.out.println("\nEl numero de miembros de la familia excede el limite.");
    }

    /** 
     * Método que muestra un aviso con indicaciones para la asignación.
     */
    public void avisoAsignacion(){
        System.out.println("\n*Aviso*\nTenga en cuenta que para la asiganacion el id es el numero que la familia y perro tiene asignado en este sistema.");
        System.out.println("Si desconoce estos valores, le recomendamos visualizar las familias y perros registrados (opciones 3 y 4)");
    }

    /** 
     * Método que indica que sucedió un error en la asiganción.
     */
    public void errorAsignacion(){
        System.out.println("\nHa ocurrido un error en la asiganacion, verifique que los id son correctos y/o existen en el sistema.");
    }

    /** 
     * Método que muestra los requerimiento a cumplir para la asignación.
     */
    public void requerimientos(){
        System.out.println("\n------------Requerimientos de Asignacion------------");
        System.out.println("1. Familias con niños (menores a 10 años) solo pueden acoger de forma temporal perros de tamaño pequeño y/o labradores (No razas peligrosas).");
        System.out.println("2. Familias con adolescentes (mayores a 10 años y menones a 18 años) tienen permitido acoger a perros de tamaño pequeño y mediano (No razas peligrosas).");
        System.out.println("3. Familias sin niños ni adolescentes pueden acoger a cualquier perro de cualquier raza o tamaño.");
    }

    /** 
     * Método que muestra que una familia ha sido registrada en el sistema, junto a los datos ingresados.
     * @param apellido
     * @param miembrosFam
     * @param ninos
     * @param adolescentes
     * @param adultos
     * @param mascotas
     */
    public void mostrarFam(String apellido, int miembrosFam, int ninos, int adolescentes, int adultos, int mascotas){
        System.out.println("\nLa familia ha sido resgistrada exitosamente.");
        System.out.println("\n--------------------------------------------");
        System.out.println("El apellido de la familia es: "+apellido);
        System.out.println("La cantidad de miembros en la familia es: "+miembrosFam);
        System.out.println("Cantidad de adultos en la familia: "+adultos);
        System.out.println("Cantidad de niños en la familia: "+ninos);
        System.out.println("Cantidad de adolescentes en la familia: "+adolescentes);
        System.out.println("La cantidad de mascotas de la familia es: "+mascotas);
        System.out.println("--------------------------------------------\n");
    }

    /** 
     * Método que muestra que un perro ha sido registrado en el sistema, junto a los datos ingresados.
     * @param nombreP
     * @param razaP
     * @param tamanoP
     * @param edadP
     * @param saludP
     */
    public void mostrarPerro(String nombreP, String razaP, int tamanoP, int edadP, int saludP){
        System.out.println("\nEl perro ha sido resgistrado exitosamente.");
        System.out.println("\n--------------------------------------------");
        System.out.println("El nombre del perro es: "+nombreP);
        System.out.println("La raza del perro es: "+razaP);
        System.out.println("El tamano del perro es: "+tamanoP);
        System.out.println("La edad del perro es: "+edadP);
        System.out.println("La salud actual del perro es: "+saludP);
        System.out.println("--------------------------------------------\n");
    }
}
