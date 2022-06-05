package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Usuario implements Serializable {
    protected String nombre;
    protected String correo;
    protected Proyecto prActual;
    private ArrayList<Actividad> actividades;

    @Override
    public boolean equals(Object usuario2) {
        if (this.getEmail().equals(((Usuario) usuario2).getEmail())) {
            return true;
        }
        return false;
    }

    public void setProyecto(Proyecto proyectoEntrada) {
        prActual = proyectoEntrada;
    }

    public Usuario(String nombre, String correo, Proyecto prActual) {
        this.nombre = nombre;
        this.correo = correo;
        this.prActual = prActual;
        actividades = new ArrayList<>();
       
    }

    public String generarReporte() {
    	System.out.println(actividades);
        String reporteTxt ="--- Inicio del reporte ---\r\n";
        int tiempoTotalTrabajo,tiempo,tiempoTipo;
        HashMap<LocalDate, Integer> tiempoPorDia;
        HashMap<String,Integer> tiempoPorTipo;
        int numActividades;
    	Reporte reporte = new Reporte(actividades); 
    	
    	
    	tiempoTotalTrabajo = reporte.tiempoTrabajo();
    	tiempoPorDia = reporte.tiempoTrabajoDia();
    	tiempoPorTipo = reporte.tiempoTrabajoTipo();
    	numActividades = reporte.cantActividades();
    	
    	reporteTxt += "Tiempo total trabajado" + " : "+ tiempoTotalTrabajo +"\r\n";
    	reporteTxt += "Numero total de actividades trabajadas es: " + numActividades+"\r\n";
    	reporteTxt+="Tiempo trabajado diariamente: \r\n";

    	
    	for (LocalDate fecha : tiempoPorDia.keySet()) {
			tiempo = tiempoPorDia.get(fecha);
			reporteTxt+="\t-"+fecha+": "+tiempo+"\r\n";
		
			
		}
    	
    	reporteTxt += "El tiempo de trabajo por tipo de actividad es: v";
    	for (String tipo : tiempoPorTipo.keySet()) {
    		tiempoTipo = tiempoPorTipo.get(tipo);
    		reporteTxt += "\t-"+ tipo + ": "+ tiempoTipo +"\r\n";
    		
    		 
		}
    	reporteTxt += "--- Fin del reporte ---";
    	return reporteTxt;
    	
    	
    }

    public void inciarActividad(String nombreActividad, String tipoActividad, String descripcion) {
        Actividad actividad = new Actividad(correo, nombreActividad, nombre, descripcion, tipoActividad, prActual.getActividadesSize());
        prActual.addActividad(actividad);
        actividades.add(actividad);

    }

    public void iniciarActividadExt(String correo, String nombreActividad, String tipoActividad, String descripcion) {
        Actividad actividad = new Actividad(correo, nombreActividad, nombre, descripcion, tipoActividad, prActual.getActividadesSize());
        prActual.addActividad(actividad);
        actividades.add(actividad);
    }
    public void setPrActual(Proyecto prActual) {
    	this.prActual = prActual;
    }
    
    public String consultarInformacion() {
        return ("Nombre: " + nombre
                + "\nCorreo: " + correo + "\n");
    }

    public void finalizarActividad(String correo, String nombreActividad) {

    }

    public Proyecto getPrActual() {
        return prActual;
    }

    public void addActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public String getName() {
        return nombre;
    }

    public String getEmail() {
        return correo;
    }
}
