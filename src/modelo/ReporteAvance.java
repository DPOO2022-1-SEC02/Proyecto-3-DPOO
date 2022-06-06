package modelo;

import java.util.ArrayList;

public class ReporteAvance {
    private int tareasFin;
    private int tareasSinFin;
    private int porcentajeTarea;
    private int tiempoCompletado;
    private int tiempoFalta;
    private int porcentajeTiempo;
    ArrayList<Tarea> tareas;
    ArrayList<Paquete> paquetes;


    //constructor
    public ReporteAvance(ArrayList<Tarea> tareas, ArrayList<Paquete> paquetes){
        this.tareas = tareas;
        this.paquetes = paquetes;
        tareasFin = 0;
        tareasSinFin = 0;
}

    public int calcularPorcTareaComplet(){
        return 0;
    }
    public int calcularTiempoFalta(){
        return 0;
    }

    public void genGraficaAvance(){

    }

}
