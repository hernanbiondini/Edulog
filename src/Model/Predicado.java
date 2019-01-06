/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "predicado")
@NamedQueries({
    @NamedQuery(name = "predicado.all", query = "SELECT m FROM Predicado m ORDER BY m.nat"),
    @NamedQuery(name = "predicadoAfectado.all", query = "SELECT m FROM Predicado m WHERE m.afectado = 1 ORDER BY m.nat")
})
public class Predicado implements Cloneable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPREDICADO", nullable = false)
    private int id;
    private String nat;
    private String pro;
    private int tipo;
    private String opuestoNat;
    private String opuestoPro;
    private int afectado;

    public Predicado(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }


    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }  

    public String getOpuestoNat() {
        return opuestoNat;
    }

    public void setOpuestoNat(String opuestoNat) {
        this.opuestoNat = opuestoNat;
    }

    public String getOpuestoPro() {
        return opuestoPro;
    }

    public void setOpuestoPro(String opuestoPro) {
        this.opuestoPro = opuestoPro;
    }

    public int getAfectado() {
        return afectado;
    }

    public void setAfectado(int afectado) {
        this.afectado = afectado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Predicado other = (Predicado) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.nat == null) ? (other.nat != null) : !this.nat.equals(other.nat)) {
            return false;
        }
        if ((this.pro == null) ? (other.pro != null) : !this.pro.equals(other.pro)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + (this.nat != null ? this.nat.hashCode() : 0);
        hash = 17 * hash + (this.pro != null ? this.pro.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return this.getNat();
    }


    

    



}
