
import java.util.ArrayList;
import java.util.List;

public class Operaciones {

    //El id que me relaciona la operacion con el alumno
    private int alumnoId;
    //lista de operacioes
    private List<Operacion> operacion;
    private  int institutoId;


    //contructor
    public Operaciones(List<Operacion> operacion, int alumnoId){
        this.operacion = operacion;
        this.alumnoId = alumnoId;
    }


    //una lista con las operaciones
    public Operaciones(){
        this.operacion = new ArrayList<>();
    }
    //Getters y setters

    public int getAlumnoID() {
        return alumnoId;
    }

    public List<Operacion> getOperaciones() {
        return operacion;
    }

    public void setOperaciones(List<Operacion> operacion) {
        this.operacion = operacion;
    }

    public void setAlumnoID(int alumnoID) {
        this.alumnoId = alumnoID;
    }

   }
