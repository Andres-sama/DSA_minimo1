
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Test {//inicializo valores y invoco a los metodos para comprovar su forma de actuar
    MathManagerImpl pm = MathManagerImpl.getInstance();
//Inicilizo las variables
    private final static Logger logger = Logger.getLogger(String.valueOf(Test.class));
    //Creo ususarios
    private Alumno a1;
    private Alumno a2;
    private  Instituto i1;
    private  Instituto i2;
    //Creo productos y la lista de los productos
    private Operacion p1;
    private Operacion p2;
    private Operacion p3;
    private Operacion p4;
    private List<Operacion> op1;
    private List<Operacion> op2;

    //Creo los metodos para probar las funciones que he creado

    @Before //Lo que se hace antes de empezar la demostracion
    //Primero inicilizo las estructuras de datos
    public void setUp() throws Exception {
        //Creo dos usuarios
        a1 = new Alumno(1,"Andres");
        a2 = new Alumno(2,"Fernando");
        //lista de productos
        op1 = new ArrayList<>();
        op2 = new ArrayList<>();
        //Añado a cada lista un producto
        op1.add(p1);
        op1.add(p2);
    }

    @After //Lo que hago al acabar la demostracion
    //pongo los parametros a null para evitar problemas si vuelvo a arrancar el Test
    public void tearDown(){
        a1 = null;
        a2 = null;
        p1 = null;
        p2 = null;
        op1 = null;
        op2 = null;
       pm.getOperaciones().clear();
       pm.getProcesarOperaciones().clear();
    }
    //test para realizar un pedido
    @org.junit.Test
    public void hacerPedido(){
        logger.info("Test: Realizar Operaciones de " + a1.getAlumno() );
        Assert.assertTrue(pm.getInstance().realizarOperacion(a1.getAlumnoId(), op1));//si el boolean de respuesta es true
        }
    //test para sevir el pedido
    @org.junit.Test
    public void servirPedido(){
        logger.info("Test: Servir Operaciones de " + a2.getAlumnoId());
        pm.getInstance().realizarOperacion((a2.getAlumnoId()), op2);
        pm.getInstance().procesarOperaciones(a2.getAlumnoId());
        Assert.assertEquals(0,pm.getInstance().getOperaciones().size());//Me aseguro de que el pedido sea eliminado
                                                                            // de la cola de pedidos servidos
    }

}
