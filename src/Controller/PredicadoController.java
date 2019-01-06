package Controller;

import Model.Predicado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PredicadoController extends EntityController {

    private static final String QUERY_GET_ALL_PREDICADO = "predicado.all";
    private static final String QUERY_GET_ALL_PREDICADO_AFECTADO = "predicadoAfectado.all";
    private static PredicadoController predicadoController;
    private List<Predicado> predicados;

    PredicadoController() {
    }

    public static PredicadoController getInstance() {
        if (predicadoController == null) {
            predicadoController = new PredicadoController();
        }
        return predicadoController;
    }

    public void guardar(Predicado p) throws Exception {
        this.persist(p);
    }

    public void borrar(Predicado p) throws Exception {
        this.removePredicado(p);
    }

    public List<Predicado> getAllPredicado() {
        return this.executeNamedQuery(QUERY_GET_ALL_PREDICADO);
    }
    
    public List<Predicado> getAllPredicadoAfectado() {
            return this.executeNamedQuery(QUERY_GET_ALL_PREDICADO_AFECTADO);
    }

    public List<Predicado> getAllPredicado2() {
        this.predicados = predicadoController.getAllPredicado();

        // Se cargan las primitivas de prolog
        Predicado p1 = new Predicado();
        p1.setNat("es igual que");
        p1.setPro("=");
        p1.setTipo(2);
        predicados.add(p1);

        Predicado p3 = new Predicado();
        p3.setNat("no es igual que");
        p3.setPro("\\=");
        p1.setTipo(2);
        predicados.add(p3);

        Predicado p5 = new Predicado();
        p5.setNat("es menor que");
        p5.setPro("<");
        p1.setTipo(2);
        predicados.add(p5);

        Predicado p6 = new Predicado();
        p6.setNat("es mayor que");
        p6.setPro(">");
        p1.setTipo(2);
        predicados.add(p6);

        Predicado p2 = new Predicado();
        p2.setNat("es igual o menor que");
        p2.setPro("=<");
        p1.setTipo(2);
        predicados.add(p2);

        Predicado p4 = new Predicado();
        p4.setNat("es igual o mayor que");
        p4.setPro("=>");
        p1.setTipo(2);
        predicados.add(p4);

        return predicados;
    }

    public List<Predicado> getAllPredicado3() {
        this.predicados = predicadoController.getAllPredicadoAfectado();
        // Se cargan las primitivas de prolog
        Predicado p1 = new Predicado();
        p1.setNat("es igual que");
        p1.setPro("=");
        p1.setTipo(2);
        predicados.add(p1);

        Predicado p3 = new Predicado();
        p3.setNat("no es igual que");
        p3.setPro("\\=");
        p1.setTipo(2);
        predicados.add(p3);

        Predicado p5 = new Predicado();
        p5.setNat("es menor que");
        p5.setPro("<");
        p1.setTipo(2);
        predicados.add(p5);

        Predicado p6 = new Predicado();
        p6.setNat("es mayor que");
        p6.setPro(">");
        p1.setTipo(2);
        predicados.add(p6);

        Predicado p2 = new Predicado();
        p2.setNat("es igual o menor que");
        p2.setPro("=<");
        p1.setTipo(2);
        predicados.add(p2);

        Predicado p4 = new Predicado();
        p4.setNat("es igual o mayor que");
        p4.setPro("=>");
        p1.setTipo(2);
        predicados.add(p4);

        return predicados;
    }

    public void afectarPredicadoC(int idPredicado) throws Exception {
        this.afectarPredicado(idPredicado);
    }

    public void desafectarPredicadoC(int idPredicado) throws Exception {
        this.desafectarPredicado(idPredicado);
    }

    public void desafectarPredicadoC(String predicadoPro) throws Exception {
        this.desafectarPredicado(predicadoPro);
    }

}
