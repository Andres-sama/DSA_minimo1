
public class Alumno {
    private int alumnoId;
    private String alumno;

    public Alumno(int alumnoId, String alumno){
        this.alumnoId = alumnoId;
        this.alumno = alumno;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
}
