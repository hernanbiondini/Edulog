package ControllerXML;

import Controller.*;
import Model.Predicado;
import Model.Regla;
import Model.Repre;
import java.util.ArrayList;
import java.util.List;

public class RepreControllerXML extends EntityControllerXML {
    
    private static RepreControllerXML repreControler;
    private static ReglaControllerXML reglaController;
    private static PredicadoControllerXML predicadoController;
    
    private static final String QUERY_GET_ALL_REGLA = "regla.all";
    private static final String QUERY_GET_ALL_PREDICADO = "predicado.all";
    
    private List<Regla> reglas;
    private List<Predicado> predicados;

    public RepreControllerXML() {
        this.reglas = new ArrayList<Regla>();
        this.predicados = new ArrayList<Predicado>();
    }

    public static RepreControllerXML getInstance() {
        if (repreControler == null) {
            repreControler = new RepreControllerXML();
        }
        if (reglaController == null) {
            reglaController = new ReglaControllerXML();
        }
         if(predicadoController ==null){
            predicadoController = new PredicadoControllerXML();
        }
        return repreControler;
    }

    public List<Regla> getAllRegla() {
        return this.executeNamedQuery(QUERY_GET_ALL_REGLA);
    }

    public List<Predicado> getAllPredicado() {
        return this.executeNamedQuery(QUERY_GET_ALL_PREDICADO);
    }

    
    // Predicados tipo 1,2 y reglas 
    public List<Repre> getAllRepre() {
        this.predicados = predicadoController.getAllPredicado();
        this.reglas = reglaController.getAllRegla();
        ArrayList<Repre> repre = new ArrayList<Repre>();

        for (Predicado p : predicados) {          
                Repre r = new Repre();
                r.setPredicado(p);
                r.setTipo("predicado");
                repre.add(r);    
        }

        Predicado p1 = new Predicado();
        p1.setNat("es igual que");
        p1.setPro("=");
        p1.setTipo(3);
        Repre r = new Repre();
        r.setPredicado(p1);
        r.setTipo("predicado");
        repre.add(r);

        Predicado p3 = new Predicado();
        p3.setNat("no es igual que");
        p3.setPro("\\=");
        p3.setTipo(3);
        r = new Repre();
        r.setPredicado(p3);
        r.setTipo("predicado");
        repre.add(r);

        Predicado p5 = new Predicado();
        p5.setNat("es menor que");
        p5.setPro("<");
        p5.setTipo(3);
        r = new Repre();
        r.setPredicado(p5);
        r.setTipo("predicado");
        repre.add(r);

        Predicado p6 = new Predicado();
        p6.setNat("es mayor que");
        p6.setPro(">");
        p6.setTipo(3);
        r = new Repre();
        r.setPredicado(p6);
        r.setTipo("predicado");
        repre.add(r);

        Predicado p2 = new Predicado();
        p2.setNat("es igual o menor que");
        p2.setPro("=<");
        p2.setTipo(3);
        r = new Repre();
        r.setPredicado(p2);
        r.setTipo("predicado");
        repre.add(r);

        Predicado p4 = new Predicado();
        p4.setNat("es igual o mayor que");
        p4.setPro("=>");
        p4.setTipo(3);
        r = new Repre();
        r.setPredicado(p4);
        r.setTipo("predicado");
        repre.add(r);
        
        for (Regla re : reglas) {
            r = new Repre();
            r.setRegla(re);
            r.setTipo("regla");
            repre.add(r);
        }

        return repre;
    }
}
