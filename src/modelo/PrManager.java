package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class PrManager implements Serializable {

    private ArrayList<Proyecto> proyectos;

    public PrManager() {
        proyectos = new ArrayList<>();
    }


    public void crearProyecto(String nombre, String descripcion, Usuario duenio, Date fechaFin, ArrayList<String> tipos) {
        Proyecto retorno = new Proyecto(nombre, descripcion, duenio, proyectos.size(), fechaFin, tipos);
        proyectos.add(retorno);
    }

    public Proyecto getProyecto(int id) {
        return proyectos.get(id);
    }
        
    public int getId()
        {
            return proyectos.size() - 1;
        }

    public int sizeOfList(){
        if (proyectos.isEmpty()){
            return 1;
        }
        return proyectos.size();
    }
    public ArrayList<Proyecto> getProyectos(){
        return proyectos;
    }

}
