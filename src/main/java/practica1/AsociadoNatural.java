
package practica1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AsociadoNatural extends Asociado{
    private List<Float> aportaciones;
    private LocalDate fechaAportacion;
    private int i = 0;

    public AsociadoNatural(List<Float> aportaciones, LocalDate fechaAportacion, int noSocio, String nombre, LocalDate fechaIngreso, long noTelefonico) {
        super(noSocio, nombre, fechaIngreso, noTelefonico);
        this.aportaciones = aportaciones;
        this.fechaAportacion = fechaAportacion;
    }
  
    public boolean agregarAportacion(float nuevaAportacion) {
    if (nuevaAportacion > 0) {
            aportaciones.add(nuevaAportacion);
            fechaAportacion = LocalDate.now(); 
            return true;
        }
        return false;
    }

    public List<Float> getAportaciones() {
        return aportaciones;
    }

    public void setAportaciones(List<Float> aportaciones) {
        this.aportaciones = aportaciones;
    }

    public LocalDate getFechaAportacion() {
        return fechaAportacion;
    }

    public void setFechaAportacion(LocalDate fechaAportacion) {
        this.fechaAportacion = fechaAportacion;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
       return "Asociado Natural: " + super.toString() + ", Aportaciones: " + aportaciones;
    }
    
}
