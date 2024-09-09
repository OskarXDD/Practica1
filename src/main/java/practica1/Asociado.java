
package practica1;

import java.time.LocalDate;


public class Asociado {
        private int noSocio;
        private String nombre;
        private LocalDate fechaIngreso;
        private long noTelefonico;

        public Asociado(int noSocio, String nombre, LocalDate fechaIngreso, long noTelefonico) {
            super();
            this.noSocio = noSocio;
            this.nombre = nombre;
            this.fechaIngreso = fechaIngreso;
            this.noTelefonico = noTelefonico;
        }

        public int getNoSocio() {
            return noSocio;
        }

        public void setNoSocio(int noSocio) {
            this.noSocio = noSocio;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public LocalDate getFechaIngreso() {
            return fechaIngreso;
        }

        public void setFechaIngreso(LocalDate fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
        }

        public long getNoTelefonico() {
            return noTelefonico;
        }

        public void setNoTelefonico(long noTelefonico) {
            this.noTelefonico = noTelefonico;
        }

        @Override
        public String toString() {
           return "NoSocio: " + this.noSocio + ", Nombre: " + this.nombre + ", Fecha de Ingreso: " + 
                   this.fechaIngreso + ", NoTelefonico: " + this.noTelefonico;
        }
        
}
