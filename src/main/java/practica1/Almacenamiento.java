
package practica1;

import java.util.HashSet;
import java.util.Set;


public class Almacenamiento {
    static final int LIMITE = 100;
    static Asociado asociados[] = new Asociado[LIMITE]; 
    static int cA = 0;
    static Set<String> cargosDirectivos = new HashSet<>(); 
    

    static void agregarAsociado(Asociado asociado) throws Exception {
        if (cA < asociados.length - 1) {
            if (asociado instanceof AsociadoDirectivo) {
                AsociadoDirectivo directivo = (AsociadoDirectivo) asociado;
                if (cargosDirectivos.contains(directivo.getCargo())) {
                    throw new Exception("El cargo ya existe");
                } else {
                    cargosDirectivos.add(directivo.getCargo());
                }
            }
            asociados[cA] = asociado;
            cA++;
        } else throw new Exception("Lista Llena");
    }
    
    static int buscarAsociado(int noSocio){
        for(int i=0;i<cA;i++)
                if(asociados[i].getNoSocio()== noSocio){
                    return i;
                }
        return -1;
    }
    
    static void listarAsociado(){
        for(int i=0;i<cA;i++)
            System.out.println(asociados[i]);
        
        float sumaTotal = sumaTotalAportaciones();
        System.out.println("Suma Total de las Aportaciones: " + sumaTotal);
    }
    

    static boolean eliminarAsociado(int noSocio) {
       int a = buscarAsociado(noSocio);
       boolean encontrado = false;
       
       if(a>=0){
           for(int i=a;i<cA-1;i++)
               asociados[i] = asociados[i+1];
           asociados[cA - 1] = null;
           cA--;
           encontrado = true;
       }
       
       return encontrado;
    }
    
    static boolean aportar(int noSocio, float nuevaAportacion){
        int a = buscarAsociado(noSocio);
        boolean encontrado = false;
        
        if (a>= 0 && asociados[a] instanceof AsociadoNatural) {
                AsociadoNatural asociado = (AsociadoNatural) asociados[a];
                encontrado = asociado.agregarAportacion(nuevaAportacion);
            }

        return encontrado;
    }
    
    static float sumaTotalAportaciones() {
        float suma = 0;

        for (int i = 0; i < cA; i++) {
            if (asociados[i] instanceof AsociadoNatural) {
                AsociadoNatural asociado = (AsociadoNatural) asociados[i];
                for (float aportacion : asociado.getAportaciones()) {
                    suma += aportacion;
                }
            }
        }

        return suma;
    }

    void muestra() {
        for (int i = 0; i < cA; i++) {
            if (asociados[i] != null) {
                asociados[i].toString();
            }
        }
    }
}
