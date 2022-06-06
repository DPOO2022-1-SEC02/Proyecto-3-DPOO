package modelo;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Actividad implements Serializable {
    private String titulo;
    private String descripcion;
    private final String nombre;
    private final String correo;
    private String tipoActividad;
    private Date fechaInicio;
    private Date fechaFinal;
    private int tiempoTrabajo;
    private int trabajoTotal;
    private Instant starts, ends;
    private HashMap<LocalDate, Integer> trabajoDiario;
    private ArrayList<Date[]> fechas;
    private boolean terminado;
    private int id; 
    private boolean esFinal;

    private String tarea;

    public Actividad(String correo, String titulo,String nombre, String descripcion, String tipoActividad, int id,boolean esFinTarea,String tarea) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.correo = correo;
        fechaInicio = new Date();
        this.id = id;
        tiempoTrabajo = 0;
        trabajoDiario = new HashMap<>();
        trabajoTotal = 0;
        fechas = new ArrayList<>();
        terminado = false;
        this.esFinal = esFinTarea;
        //se aÃ±ade con el comboBox de tareas
        this.tarea = tarea;
    }

    public void nuevoRegistro(Date fechaInicio, Date fechaFinal) {
        Date[] registro = {fechaInicio, fechaFinal};
        trabajoTotal += (Duration.between(fechaInicio.toInstant(), fechaFinal.toInstant()).getSeconds()) / 60;
        fechas.add(registro);
    }


    public Date getFecha() {
        
    	return fechaInicio;
    }
    public void initCronometro() {
        starts = Instant.now();
    }

    public String getTitulo() {
        return titulo;
    }
    public int getId() {
    	return id;
    }
    public int getTrabTotal() {
    	return trabajoTotal;
    }
    public String getTipo() {
    	return tipoActividad;
    }

    public void stopCronometro() {
        ends = Instant.now();
        LocalDate hoy = LocalDate.now();
        tiempoTrabajo += (Duration.between(starts, ends).getSeconds()) / 60;
        int trabajado = trabajoDiario.getOrDefault(hoy, 0);
        trabajado += tiempoTrabajo;
        trabajoDiario.put(hoy, trabajado);
        trabajoTotal += trabajado;
    }
    
    public void sumarTiempo(HashMap<LocalDate, Integer> tiempoTotal){
        int tiempo ,tiempoSuma;
        for(LocalDate fecha:trabajoDiario.keySet()){
            tiempo = trabajoDiario.get(fecha);
            tiempoSuma = tiempoTotal.getOrDefault(fecha, 0);
            tiempoSuma += tiempo;
            tiempoTotal.put(fecha,tiempoSuma);
        }
    }

    public int getTiempoTrabajo() {
        return tiempoTrabajo;
    }

    public void setFechaInicio(Date fecha) {
        fechaInicio = fecha;
    }

    public void setFechaFin(Date fecha) {
        fechaFinal = fecha;
        terminado = true;
    }

    public void terminar() {
        fechaFinal = new Date();
        terminado = true;
    }

    public String consultarInformacion() {
        String ended = "En progreso";
        if (terminado) {
            ended = "Terminado";
        }
        if (fechaFinal == null) {
        	String fechaFinal = "Actividad todavia en curso";
        }
        String retorno = "TÃ­tulo: " + titulo +
        		"\nCreador: " + nombre +
                "\nDescripciÃ³n: " + descripcion +
                "\nEstado: " + ended +
                "\nTipo: " + tipoActividad +
                "\nFecha de Inicio: " + fechaInicio +
                "\nFecha de Finalizacion: "+ fechaFinal +
                "\n----------Tiempos de trabajo-----------------\n" +
                infoDias() +
                "\n------------Registros externos de actividad-------------\n" +
                infoExtra();
        return (retorno);
    }

    private String infoExtra() {
        String info = "";
        int contador = 1;
        for (Date[] array : fechas) {
            info += "\nRegistro " + contador;
            info += "\nDesde: " + array[0].toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            info += "\nHasta: " + array[1].toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            contador++;
        }
        if (info.equals("")) {
            info = "No se encuentran registros";
        }
        return info;
    }

    private String infoDias() {
        int tiempo;
        String info = "";
        for (LocalDate dia : trabajoDiario.keySet()) {
            info += dia + ": ";
            info += trabajoDiario.get(dia) + " minutos";
        }

        if (info.equals("")) {
            info = "No se han encontrado sesiones de trabajo";
        }
        return info;
    }
    
    public String getEncargado() {
    	return nombre;
    }
    public String getDescripcion() {
    	return descripcion;
    }

	public void setNombre(String nuevoNombre) {
		this.titulo = nuevoNombre;
		
	}

	public void setDescripcion(String nuevaDescripcion) {
		this.descripcion = nuevaDescripcion;
		
	}
}



