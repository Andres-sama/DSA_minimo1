
import java.util.*;
import java.util.logging.Logger;

public class MathManagerImpl implements MathManager {
    //Implemetnacion de las 5 funciones como Singletone
    //Declaraciones
    private static MathManagerImpl instance = null;
    final static Logger logger = Logger.getLogger(String.valueOf(MathManagerImpl.class));

    private Queue<Operaciones> procesarOperaciones; //lista de operaciones iniciales
    private List<Operaciones> operaciones;

    //Singleton Pattern
    public static MathManagerImpl getInstance() {
        if (instance == null) instance = new MathManagerImpl();
        return instance;
    }
    //Constructores
    private MathManagerImpl(){
        this.procesarOperaciones = new ArrayDeque<>();
        this.operaciones = new ArrayList<>();
    }
    //Getters and Setters
    public Queue<Operaciones> getProcesarOperaciones() {
        return procesarOperaciones;
    }
    public List<Operaciones> getOperaciones() {
        return operaciones;
    }

    //Funciones pricipales (publicas, se accede a ellas desde el Test)
   //Realizar una operacion
    public boolean realizarOperacion (int alumnoId, List<Operacion> operacion) {
        logger.info("Hacer Operaciones del alumno "+ alumnoId);
        this.operaciones.add(new Operaciones(operacion, alumnoId));
        logger.info("Operaciones del alumno" + alumnoId +" hecho");
        return true;
    }
    //Procesar una operacion
    public int procesarOperaciones(int alumnoId) {
        logger.info("Procesar Operaciones");
        int resultado = 0;
        if(!operaciones.isEmpty()) { //si hay operaciones en la cola
            this.procesarOperaciones.add(this.procesarOperaciones.element()); //guardar en la lista de operaciones hechos
            this.procesarOperaciones.remove(); //eliminar de la lista

            logger.info("Operaciones Procesadas");
            return resultado;
        }
        else {
            logger.warning("No hay Operaciones para procesar");
            return resultado;
        }
    }
    //Lista de operaciones realizadas por Alumnos
    public List<Operaciones> getOperacionesAlumno(int alumnoId) {
        List<Operaciones> operaciones = new ArrayList<>();
        if (colaAlumnos(alumnoId)) {//si hay operaciones del usuario en cola
            logger.info("Operaciones hechas por el alumno" +alumnoId);
            for(Operaciones o : this.operaciones) {
                if (o.getAlumnoID() == alumnoId)
                    operaciones.add(o);
            }
            logger.info("Los operaciones hechas al alumno" +alumnoId+" son:");
            return operaciones;
        }
        else {
            logger.warning("El alumno " +alumnoId+ " no ha hecho operaciones");
            return operaciones;
        }
    }
    //Lista de Operaciones realizadas por un instituto
    public List<Operaciones>  getOperacionesInstituto(int institutoId) {
        List<Operaciones> operaciones = new ArrayList();

        if (!operaciones.isEmpty()) {//si hay operaciones realizadas
            logger.info("Las operaciones de los institutos son:");
            //realizar conteo de las operaciones del instituto
            return operaciones;
        }
        else {
            logger.warning("No se han realizado operaciones");
            return operaciones;
        }

    }

    //Funciones secundarias (Privadas)
    //me dice si mi Alumno ha hecho operaciones o no
    private boolean colaAlumnos (int alumnoId) {
        for(Operaciones p : procesarOperaciones) {
            if(p.getAlumnoID() == alumnoId)
                return true;
        }
        return false;
    }
    //me dice si mi Instituto ha hecho operaciones o no
    /*private boolean colaInstitutos (int institutoId) {
        for(Operaciones p : procesarOperaciones) {
            if(p.getInstitutoID() == InstitutoId)
                return true;
        }
        return false;
    }
    */
    //me ordena los institutos por operaciones realizadas

    //Lista con los operaciones servidos
    private List<Operacion> getOperacionesProcesadas() {
        List<Operacion> operacion = new ArrayList<>();
        if (!procesarOperaciones.isEmpty()) { //si hay operaciones servidos
            for(Operaciones p : this.procesarOperaciones) {
                operacion.addAll(p.getOperaciones());

            }
            return operacion;
        }
        else {
            return operacion;
        }

    }
    public Alumno login(Alumno u) {
        return u;
    }
}