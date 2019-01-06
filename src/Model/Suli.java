/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hernan
 */
public class Suli {

    private Sujeto sujeto;
    private Lista lista;
    private String tipo = "";

    public Suli() {}
    
    public Suli(Sujeto sujeto, Lista lista) {
        this.sujeto = sujeto;
        this.lista = lista;
    }

    public Sujeto getSujeto() {
        return sujeto;
    }

    public void setSujeto(Sujeto sujeto) {
        this.sujeto = sujeto;
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
        if (this.tipo.equals("sujeto")) {
            return this.getSujeto().getNat();
        } else {
            return this.lista.getNombre();
        }

    }
}
