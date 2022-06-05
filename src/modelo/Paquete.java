package modelo;

import java.util.ArrayList;

public class Paquete {
    ArrayList<Tarea> tareas;
    ArrayList<Paquete> paquetes;
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
}
