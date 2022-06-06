package modelo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Tarea {
    private String nombre;
    private String descripcion;
    private String tipoTarea;
    private int tiempo;
    private Date finFecha;
    private Actividad actFinal;
    private ArrayList<Usuario> responsables;
    private ArrayList<Actividad> actividades;
    private Proyecto proyecto;
    private Paquete padre;

    private boolean isFinished;
    
    public Tarea(String nombre, String descripcion, String tipoTarea, Usuario participante, Proyecto proyecto ){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoTarea = tipoTarea;
		tiempo = 0;
		this.responsables.add(participante);
		
    }
    
    

    
    public String getNombre() {
		return this.nombre;
	}
	
	public Date getFinFecha() {
		return  finFecha; 
	}
	
	public int getTiempo() {
		for (Actividad actividad : actividades) {
			tiempo+=actividad.getTiempoTrabajo();
		}
		return tiempo;
	}
	
	public boolean isFinished() {
		return this.isFinished;
	}
    
    
    
    
    public void addParticipant(Usuario user) {
		if (!this.responsables.contains(user)) {
			this.responsables.add(user);
			user.addTarea(this);
		}
	}
}
