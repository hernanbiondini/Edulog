package ControllerXML;

import Controller.*;
import Model.Predicado;
import Model.Regla;
import Model.Repre;
import Model.Sujeto;
import Model.Suva;
import Model.Variablep;
import java.util.ArrayList;
import java.util.List;

public class SuvaControllerXML extends EntityControllerXML {
    
    private static SuvaControllerXML suvaControler;
    private static SujetoControllerXML sujetoController;
    private static VariablepControllerXML variablepController;
    
    private static final String QUERY_GET_ALL_SUJETO = "sujeto.all";
    private static final String QUERY_GET_ALL_VARIABLEP = "variablep.all";
    
    private List<Sujeto> sujetos;
    private List<Variablep> variablesp;

    public SuvaControllerXML() {
        this.sujetos = new ArrayList<Sujeto>();
        this.variablesp = new ArrayList<Variablep>();
    }

    public static SuvaControllerXML getInstance() {
        if (suvaControler == null) {
            suvaControler = new SuvaControllerXML();
        }
        if (sujetoController == null) {
            sujetoController = new SujetoControllerXML();
        }
         if(variablepController ==null){
            variablepController = new VariablepControllerXML();
        }
        return suvaControler;
    }

    public List<Sujeto> getAllSujeto() {
        return this.executeNamedQuery(QUERY_GET_ALL_SUJETO);
    }

    public List<Variablep> getAllVariable() {
        return this.executeNamedQuery(QUERY_GET_ALL_VARIABLEP);
    }

    // Predicados tipo 1 y reglas 1,2,3,4
    public List<Suva> getAllSuba() {
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

    
}
