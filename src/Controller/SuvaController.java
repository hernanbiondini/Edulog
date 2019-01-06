package Controller;

import Model.Sujeto;
import Model.Suva;
import Model.Variablep;
import java.util.ArrayList;
import java.util.List;

public class SuvaController extends EntityController {
    
    private static SuvaController suvaControler;
    
    private static final String QUERY_GET_ALL_SUJETO = "sujeto.all";
    private static final String QUERY_GET_ALL_VARIABLEP = "variablep.all";
    
    private List<Sujeto> sujetos;
    private List<Variablep> variablesp;

    public SuvaController() {
        this.sujetos = new ArrayList<Sujeto>();
        this.variablesp = new ArrayList<Variablep>();
    }

    public static SuvaController getInstance() {
        if (suvaControler == null) {
            suvaControler = new SuvaController();
        }
        return suvaControler;
    }

    public List<Sujeto> getAllSujeto() {
        return this.executeNamedQuery(QUERY_GET_ALL_SUJETO);
    }

    public List<Variablep> getAllVariable() {
        return this.executeNamedQuery(QUERY_GET_ALL_VARIABLEP);
    }


    public List<Suva> getAllSuva() {
        this.sujetos = getAllSujeto();
        this.variablesp = getAllVariable();
        ArrayList<Suva> suva = new ArrayList<Suva>();

        for (Sujeto s : sujetos) {
            Suva su = new Suva();
            su.setSujeto(s);
            su.setTipo("sujeto");
            suva.add(su);
        }

        for (Variablep v : variablesp) {
            Suva su = new Suva();
            su.setVariablep(v);
            su.setTipo("variablep");
            suva.add(su);
        }

        return suva;
    }

    public List<Suva> getAllSuva2() {
        this.sujetos = getAllSujeto();
        this.variablesp = getAllVariable();
        ArrayList<Suva> suva = new ArrayList<Suva>();

        for (Variablep v : variablesp) {
            Suva su = new Suva();
            su.setVariablep(v);
            su.setTipo("variablep");
            suva.add(su);
        }
        
        for (Sujeto s : sujetos) {
            Suva su = new Suva();
            su.setSujeto(s);
            su.setTipo("sujeto");
            suva.add(su);
        }

        return suva;
    }
    
}
