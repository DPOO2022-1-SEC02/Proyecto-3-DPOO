package modelo;

import java.util.ArrayList;

public class Paquete {
    ArrayList<Tarea> tareas;
    ArrayList<Paquete> paquetes;

    Paquete paquetePadre;
    String nombre;
    String descripcion;

    public Paquete(){
        tareas = new ArrayList<Tarea>();
        paquetes = new ArrayList<Paquete>();
    }
    public void addTarea(Tarea tarea){
        tareas.add(tarea);
    }
    public void addPaquete(Paquete paquete){
        paquetes.add(paquete);
    }

    public Paquete darPadre(){
        return paquetePadre;
    }
    public ArrayList<Paquete> darHijos(){
        return paquetes;
    }
}
