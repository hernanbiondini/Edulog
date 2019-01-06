/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Lista;
import Model.Sujeto;
import Model.Suli;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hernan
 */
public class SuliController extends EntityController {

    private static SuliController suliController;


    private static final String QUERY_GET_ALL_LISTA = "lista.all";
    private static final String QUERY_GET_ALL_SUJETO = "sujeto.all";

    private List<Lista> listas;
    private List<Sujeto> sujetos;

    public SuliController() {
        this.listas = new ArrayList<Lista>();
        this.sujetos = new ArrayList<Sujeto>();
    }

    public static SuliController getInstance() {
        if (suliController == null) {
            suliController = new SuliController();
        }
        return suliController;
    }

    public List<Lista> getAllLista() {
        return this.executeNamedQuery(QUERY_GET_ALL_LISTA);
    }

    public List<Sujeto> getAllSujeto() {
        return this.executeNamedQuery(QUERY_GET_ALL_SUJETO);
    }

    public List<Suli> getAllSuli() {

        this.sujetos = this.getAllSujeto();
        this.listas = this.getAllLista();
        ArrayList<Suli> sulis = new ArrayList<Suli>();

        for (Sujeto p : sujetos) {
            Suli r = new Suli();
            r.setSujeto(p);
            r.setTipo("sujeto");
            sulis.add(r);
        }

        for (Lista l : listas) {
            Suli r = new Suli();
            r.setLista(l);
            r.setTipo("lista");
            sulis.add(r);
        }

        return sulis;
    }

}
