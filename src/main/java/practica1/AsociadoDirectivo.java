
package practica1;

import java.time.LocalDate;

public class AsociadoDirectivo extends Asociado{
        private String cargo;
        private LocalDate tomaPosecion;

    public AsociadoDirectivo(String cargo, LocalDate tomaPosecion, int noSocio, String nombre, LocalDate fechaIngreso, long noTelefonico) {
        super(noSocio, nombre, fechaIngreso, noTelefonico);
        this.cargo = cargo;
        this.tomaPosecion = tomaPosecion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getTomaPosecion() {
        return tomaPosecion;
    }

    public void setTomaPosecion(LocalDate tomaPosecion) {
        this.tomaPosecion = tomaPosecion;
    }

    @Override
    public String toString() {
        return "Asociado Directivo: " + super.toString() + ", Cargo: " + this.cargo;
    }
  
}
