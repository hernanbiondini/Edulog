/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerXML;

import Controller.*;
import Model.HeRe;
import Model.Hecho;
import Model.Regla;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hernan
 */
public class HereControllerXML extends EntityControllerXML {

    private static HereControllerXML hereController;
    private static ReglaControllerXML reglaController;
    private static HechoControllerXML hechoController;

    private static final String QUERY_GET_ALL_REGLA = "regla.all";
    private static final String QUERY_GET_ALL_HECHO = "hecho.all";

    private List<Regla> reglas;
    private List<Hecho> hechos;

    public HereControllerXML() {
        this.reglas = new ArrayList<Regla>();
        this.hechos = new ArrayList<Hecho>();
    }

    public static HereControllerXML getInstance() {
        if (hereController == null) {
            hereController = new HereControllerXML();
        }
        if (reglaController == null) {
            reglaController = new ReglaControllerXML();
        }
        if (hechoController == null) {
            hechoController = new HechoControllerXML();
        }
        return hereController;
    }

    public List<Regla> getAllRegla() {
        return this.executeNamedQuery(QUERY_GET_ALL_REGLA);
    }

    public List<Hecho> getAllHecho() {
        return this.executeNamedQuery(QUERY_GET_ALL_HECHO);
    }

    // Hechos y Reglas no manuales
    public List<HeRe> getAllHeRe() {

        this.hechos = hechoController.getAllHecho();
        this.reglas = reglaController.getAllRegla();
        ArrayList<HeRe> heres = new ArrayList<HeRe>();
        HeRe r = new HeRe();

        r = new HeRe("Hechos:", "");
        heres.add(r);
        r = new HeRe("", "");
        heres.add(r);

        for (Hecho p : hechos) {
            if (p.getNat().trim().equals("M") == false) {
                r = new HeRe();
                r.setNombre(p.getNat());
                heres.add(r);
            }
        }

        r = new HeRe("", "");
        heres.add(r);
        r = new HeRe("", "");
        heres.add(r);
        r = new HeRe("Reglas:", "");
        heres.add(r);
        r = new HeRe("", "");
        heres.add(r);

        for (Regla re : reglas) {
            if (re.getNat().trim().equals("M") == false) {
                r = new HeRe();
                r.setNombre(re.getNat());
                heres.add(r);
            }
        }

        return heres;
    }
    
    // Hechos y Reglas  manuales
    public List<HeRe> getAllHeReManuales() {

        this.hechos = hechoController.getAllHecho();
        this.reglas = reglaController.getAllRegla();
        ArrayList<HeRe> heres = new ArrayList<HeRe>();
        HeRe r = new HeRe();

        r = new HeRe("Hechos:", "");
        heres.add(r);
        r = new HeRe("", "");
        heres.add(r);

        for (Hecho p : hechos) {
            if (p.getNat().trim().equals("M")) {
                r = new HeRe();
                r.setNombre(p.getNat());
                r.setId(p.getId());
                r.setTipo("H");
                heres.add(r);
            }
        }

        r = new HeRe("", "");
        heres.add(r);
        r = new HeRe("", "");
        heres.add(r);
        r = new HeRe("Reglas:", "");
        heres.add(r);
        r = new HeRe("", "");
        heres.add(r);

        for (Regla re : reglas) {
            if (re.getNat().trim().equals("M")) {
                r = new HeRe();
                r.setNombre(re.getNat());
                r.setId(re.getId());
                r.setTipo("R");
                heres.add(r);
            }
        }

        return heres;
    }

}
