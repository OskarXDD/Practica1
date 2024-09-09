
package practica1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Interfaz {
    static Scanner input = new Scanner(System.in);
    
    static Asociado datosGenerales(){
        System.out.println("Proporciona el numero de socio");
        int noSocio=input.nextInt();
        input.nextLine();
        System.out.println("Proporciona el nombre completo");
        String nombre=input.nextLine();
        System.out.println("Proporciona tu numero telefonico");
        long noTelefonico=input.nextLong();
        input.nextLine();
        
        return new Asociado(noSocio, nombre, LocalDate.now(), noTelefonico);
    }
    
    static AsociadoDirectivo datosDirectivos(){
        Asociado a = datosGenerales();
        System.out.println("Proporciona el cargo");
        String cargo=input.nextLine();
        
         return new AsociadoDirectivo(cargo, LocalDate.now(), a.getNoSocio(), a.getNombre(), 
                                     a.getFechaIngreso(), a.getNoTelefonico());
    }
    
    static AsociadoNatural datosNaturales(){
        Asociado a = datosGenerales();
        System.out.println("Proporciona aportacion inicial (Opcional)");
        float aportacion=input.nextFloat();
        aportacion = aportacion + 2500;
        input.nextLine();
        List<Float> aportaciones = new ArrayList<>();
        if (aportacion > 0) {
            aportaciones.add(aportacion);
        }
        
        return new AsociadoNatural(aportaciones, LocalDate.now(), a.getNoSocio(), a.getNombre(), 
                                   a.getFechaIngreso(), a.getNoTelefonico());
    }
 
    static void agregaAsociado(int tipo) throws Exception{
       try {
            Asociado asociado;
            if (tipo == 1) {
                asociado = datosDirectivos();
            } else {
                asociado = datosNaturales();
            }
            Almacenamiento.agregarAsociado(asociado);
            System.out.println("Asociado agregado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    static void eliminarAsociados() {
		System.out.println("Proporciona numero de socio");
                int noSocio = input.nextInt();
                input.nextLine();
                if(Almacenamiento.eliminarAsociado(noSocio))
                    System.out.println("Se elimino correctamente");
                else System.out.println("No se encontro ese Asociado");
    }
    
     static void aportar() {
		System.out.println("Proporciona numero de socio");
                int noSocio = input.nextInt();
                input.nextLine();
                System.out.println("Proporciona tu aportacion extra");
                float aportacion = input.nextFloat();
                if(Almacenamiento.aportar(noSocio,aportacion))
                    System.out.println("Se aporto correctamente");
                else System.out.println("No se encontro ese Asociado");
	}
    
    static String getMenu() {
		String m="\nMenu Principal";
		m+="\n"+"1.- Agregar Asociado Directivo";
		m+="\n"+"2.- Agregar Asociado Natural";
		m+="\n"+"3.- Aportar";
		m+="\n"+"4.- Eliminar Asociado";
		m+="\n"+"5.- Listar Asociados";
		m+="\n"+"6.- Terminar";
		m+="\n"+"Dar opcion[1..6]: \n";
		return m;		
	}
    
    static int opcion() {
		System.out.print(getMenu());
		return input.nextInt();
	}
    
    static void listarAsociados() {
		Almacenamiento.listarAsociado();
	}
    
    static void run() throws Exception {
		int opc;
		do {
			opc=opcion();
			input.nextLine();
			switch(opc){
			    case 1:agregaAsociado(1);break;
			    case 2:agregaAsociado(2);break;
			    case 3:aportar();break;
			    case 4:eliminarAsociados();
			    case 5:listarAsociados();
			}
		}while(opc!=6);
	}
    
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        run();
	}
	 
}


