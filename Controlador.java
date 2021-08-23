/**
 * Clase Controlador
 * Encargada de ejecutar el programa, llevar a cabo la seleccion de opciones, comunicarse con las
 * demás clases y sus respectivos procesos.
 * 
 * @version 1.0, 22/08/2021
 * @author Diego E. Lemus L. - 21469
 */

 public class Controlador{
	/** 
     * @param args
     */
	public static void main(String[] args){

		//-----PROPIEDADES-----
        int op = 0;
		int miembros = 0;
		Vista v = new Vista();
		Perrera perrera = new Perrera();
		
		//Se generan las 3 familias de ejemplo (datos aleatorios)
		perrera.agregarFamilia();
		perrera.agregarFamilia();
		perrera.agregarFamilia();

		//Mensaje de bienvenida
		v.bienvenida();

		//Ciclo en base a opcion
		while (op != 7){
			//Menu
            op = v.mostrarMenu();
			switch (op){
				case 1://Nueva Familia
					//Se pide apellido
					String apellido = v.pedirApellido();
					//Se pide cantidad de miembros
					miembros = v.numeroFam();
					
					//Limite de 12 miembros por familia
					if(miembros<12){
						int m = miembros;
						//Variables contadoras de rangos de edad
						int ninos = 0;
						int adolescentes = 0;
						int adultos = 0;
						int mascotas = 0;
						//Se piden edades en base a la cantidad de miembros
						for (int i=0; i<miembros; i++){
							int edad = v.pedirEdad(m);
							//Clasificacion por edades
							if (edad <=10){
								ninos++;
							}else if(edad >10 && edad<18){
								adolescentes++;
							}else if(edad >= 18){
								adultos++;
							}
							m--;
						}
						//Se agrega familia al sistema y se muestran sus datos
						perrera.agregarFamilia(apellido, miembros, ninos, adolescentes, adultos, mascotas);
						v.mostrarFam(apellido, miembros, ninos, adolescentes, adultos, mascotas);
						//Se muestra la cantidad de familias registradas
						int numf = perrera.getNumFam();
						v.mostrarNumFamilias(numf);
					}else{
						//En caso de exceder el limite de miembros
						v.limiteFamilia();
					}
				break;

				case 2://Mostrar Familias
					perrera.mostrarFamilias();
				break;

				case 3://Nuevo Perro
					//Se piden todas las caracteristicas
					String nombreP = v.pedirNombreP();
					String razaP = v.pedirRazaP();
					int tamanoP = v.pedirTamanoP();
					int edadP = v.pedirEdadP();
					int saludP = v.pedirSaludP();
					//Se asigna el estado a false=no asignado
					boolean estadoP = false;

					//Se agrega perro al sistema y se muestran sus datos
					perrera.agregarPerro(nombreP, razaP, tamanoP, edadP, saludP, estadoP);
					v.mostrarPerro(nombreP, razaP, tamanoP, edadP, saludP);
					//Se muestra la cantidad de perros registrados
					int nump = perrera.getNumPerros();
					v.mostrarNumPerros(nump);
				break;

				case 4://Mostrar Perros
					perrera.mostrarPerros();
				break;

				case 5://Mostrar Razas Peligrosas
					perrera.mostrarRazasPeligrosas();
				break;

				case 6://Asignar Perro
					try {
						//Se muestran indicaciones y requerimientos
						v.requerimientos();
						v.avisoAsignacion();

						//Se piden ambos id (perro y familia)
						int ap = v.asignacion1();
						int af = v.asignacion2();

						//Se obtienen los datos de la familia seleccionada
						int cninos = perrera.getNinosT((af-1));
						int cadol = perrera.getAdolescentesT((af-1));
						int cmasc = perrera.getMascotas((af-1));

						//Se obtienen los datos del perro seleccionado
						String raza = perrera.getRazaP((ap-1));
						int tamano = perrera.getTamanoP((ap-1));
						boolean estado = perrera.getEstadoP((ap-1));
						boolean peligrosidad = perrera.peligrosidadP((ap-1));

						//Se comprueba que el perro no haya sido asignado anteriormente
						if (estado==false){
							//Se comprueba el limite de mascotas por familia
							if(cmasc<4){
								//Si el perro no pertenece a una raza peligrosa
								if(peligrosidad==false){
									//Perro pequeño y/o labrador
									if(tamano == 1 || raza.equals("Labrador")){
										v.perroAsignado();
										//Actualizacion de estado de asignacion del perro
										estado = true;
										perrera.ActualizarEstado((ap-1));
										//Actualizacion de la cantidad de mascotas de la familia
										cmasc++;
										perrera.actualizarMascotas((af-1));
									}else if(tamano==2){
										//Familia con niños
										if(cninos>0){
											v.familiaNoDisponible();
										}else{
											//Familia solo con adolescentes y adultos
											v.perroAsignado();
											//Actualizacion de estado de asignacion del perro
											estado = true;
											perrera.ActualizarEstado((ap-1));
											//Actualizacion de la cantidad de mascotas de la familia
											cmasc++;
											perrera.actualizarMascotas((af-1));
										}
									//Perro grande
									}else if(tamano==3){
										//Familia con niños y adolescentes
										if(cninos>0 || cadol>0){
											v.familiaNoDisponible();
										}else{
											//Familia solo con adultos
											v.perroAsignado();
											//Actualizacion de estado de asignacion del perro
											estado = true;
											perrera.ActualizarEstado((ap-1));
											//Actualizacion de la cantidad de mascotas de la familia
											cmasc++;
											perrera.actualizarMascotas((af-1));
										}
									}
								//Si el perro pertenece a una raza peligrosa
								}else if(peligrosidad==true){
									//Familia con niños y adolescentes
									if(cninos>0 || cadol>0){
										v.familiaNoDisponible();
									}else{
										//Familia solo con adultos
										v.perroAsignado();
										//Actualizacion de estado de asignacion del perro
										estado = true;
										perrera.ActualizarEstado((ap-1));
										//Actualizacion de la cantidad de mascotas de la familia
										cmasc++;
										perrera.actualizarMascotas((af-1));
									}
								}
							}else{
								//En caso de exceder el limite de mascotas
								v.limiteMascotas();
							}
						}else{
							//En caso de que el perro seleccionado ya este asignado
							v.perroNoDisponible();
						}
					//En caso de que se introduzcan datos incorrectos
					} catch (Exception e) {
						v.errorAsignacion();
					}
				break;

				case 7://Salir
					op = 7;
				break;

				default://En caso de valor de opcion invalido
					v.ingresoIncorrecto();
			}
		}
		//Mensaje de despedida
		v.despedida();
	}
}
 
/*
CAMBIOS GENERALES:
- Se agregaron las opciones de mostrar Familias, mostrar Perros y mostrar razas peligrosas para facilitar la interaccion 
  y para que el usuario sepa que datos contiene el programa.
- La clasificacion de los miembros por edades es inmediata y se hace con el fin de simplificar los procesos de 
  verificacion de edades.
- Se agregó la funcion de la generacion de las 3 familias de ejemplo, con datos randomizados y un apellido que se escoge
  de manera aleatorioentre una lista de apellidos pre establecidos.
- Perrera posee más métodos enfocados a mejorar el manejo de la familia seleccionada entre todas las que están registradas.
*/