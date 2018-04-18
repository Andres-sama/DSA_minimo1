
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


//DIFERENCIA ENTRE POST Y GET
//POST, cuando haces algo (modifico algo del programa) y GET cuando solo das algo (pides)

@Path("pedidos") //Como llamar path == URL
//@Singleton
public class MathManagerService {
    MathManagerImpl pm = MathManagerImpl.getInstance();
        /**
        * Method handling HTTP GET requests. The returned object will be sent
        * to the client as "text/plain" media type.
        * @return String that will be returned as a text/plain response.
        */
//Test de los productos
    //Comprovacion de funcionamiento
    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    //Realizar Operaciones
    @POST
    @Path("RealizarPedido/{ID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean realizarPedido(@PathParam("ID") int userID, List<Operacion> operaciones){//como recoge los operaciones
        return pm.getInstance().realizarOperacion(userID, operaciones);
    }
    //Servir Operaciones
    @Path("/ProcesarOperacion")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public boolean procesarOperacion(){
        return pm.procesarOperacion();
    }
    //Listado de pedidos de un usuarios
    @Path("listaPedidosAlumno/{ID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operaciones> listaPedidosUsuario(@PathParam("ID") int userID){
        return pm.getOperacionesAlumno(userID);
    }
}