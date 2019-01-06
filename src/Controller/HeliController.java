/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Hecho;
import Model.Heli;
import Model.Lista;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hernan
 */
public class HeliController extends EntityController {

    private static HeliController hereController;
    private static final String QUERY_GET_ALL_LISTA = "lista.all";
    private static final String QUERY_GET_ALL_HECHO = "hecho.all";

    private List<Lista> listas;
    private List<Hecho> hechos;

    public HeliController() {
        this.listas = new ArrayList<Lista>();
        this.hechos = new ArrayList<Hecho>();
    }

    public static HeliController getInstance() {
        if (hereController == null) {
            hereController = new HeliController();
        }
        return hereController;
    }

    public List<Lista> getAllLista() {
        return this.executeNamedQuery(QUERY_GET_ALL_LISTA);
    }

    public List<Hecho> getAllHecho() {
        return this.executeNamedQuery(QUERY_GET_ALL_HECHO);
    }

    public List<Heli> getAllHeLi() {

        this.hechos = this.getAllHecho();
        this.listas = this.getAllLista();
        ArrayList<Heli> helis = new ArrayList<Heli>();

        for (Hecho p : hechos) {
            Heli r = new Heli();
            r.setHecho(p);
            r.setTipo("hecho");
            helis.add(r);
        }

        for (Lista l : listas) {
            Heli r = new Heli();
            r.setLista(l);
            r.setTipo("lista");
            helis.add(r);
        }

        return helis;
    }

}
