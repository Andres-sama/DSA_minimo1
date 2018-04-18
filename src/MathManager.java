import java.util.List;

public interface MathManager {
    //llamamos a las funciones
    Alumno login(Alumno a); //

    //Listado de institutos ordenados
    List<Operacion>  getListaDeInstitutosPorOperaciones();

    //Realizar una operacion
    boolean  realizarOperacion(int alumnoId,List<Operacion> operacion);

    //Procesar una operacion
    int  procesarOperaciones (int alumnoId);

    //Listado de operaciones de alumno
    List<Operaciones> getOperacionesAlumno(int alumnoId);

    //Listado de operaciones de instituto
    List<Operaciones> getOperacionesInstituto(int institutoId);

    }
}
