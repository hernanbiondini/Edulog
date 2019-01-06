/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hernan
 */
public class Repre {

    private Regla regla;
    private Predicado predicado;
    private String tipo = "";

    public Repre(Regla regla, Predicado predicado) {
        this.regla = regla;
        this.predicado = predicado;
    }

    public Repre() {
    }

    public Predicado getPredicado() {
        return predicado;
    }

    public void setPredicado(Predicado predicado) {
        this.predicado = predicado;
    }

    public Regla getRegla() {
        return regla;
    }

    public void setRegla(Regla regla) {
        this.regla = regla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        if (this.tipo.equals("regla")) {
            return this.regla.getNombre();
        } else {
            return this.predicado.getNat();
        }

    }
}
