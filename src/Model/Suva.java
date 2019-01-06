/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hernan
 */
public class Suva {

    private Sujeto sujeto;
    private Variablep variablep;
    private String tipo = "";

    public Suva(Sujeto sujeto, Variablep variablep) {
        this.sujeto = sujeto;
        this.variablep = variablep;
    }

    public Suva() {
    }

    public Sujeto getSujeto() {
        return sujeto;
    }

    public void setSujeto(Sujeto sujeto) {
        this.sujeto = sujeto;
    }

    public Variablep getVariablep() {
        return variablep;
    }

    public void setVariablep(Variablep variablep) {
        this.variablep = variablep;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        if (this.tipo.equals("sujeto")) {
            return this.sujeto.getNat();
        } else {
            return this.variablep.getNat();
        }

    }
}
