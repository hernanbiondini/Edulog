/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hernan
 */
public class Heli {

    private Hecho hecho;
    private Lista lista;
    private String tipo = "";

    public Heli() {}
    
    public Heli(Hecho hecho, Lista lista) {
        this.hecho = hecho;
        this.lista = lista;
    }

    public Hecho getHecho() {
        return hecho;
    }

    public void setHecho(Hecho hecho) {
        this.hecho = hecho;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        if (this.tipo.equals("hecho")) {
            return this.getHecho().getNat();
        } else {
            return this.lista.getNombre();
        }

    }
}
