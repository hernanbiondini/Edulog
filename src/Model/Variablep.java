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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Hernan
 */

@Entity
@Table(name = "variablep")
@NamedQueries({
@NamedQuery(name = "variablep.all", query = "SELECT m FROM Variablep m ORDER BY m.categoria, m.nat")
})

public class Variablep implements Cloneable, Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDVARIABLEP", nullable = false)
    private int id;
    private String nat;
    private String pro;
    @JoinColumn(name = "IDCATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne
    private Categoria categoria;

    public Variablep() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return this.getNat();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Variablep other = (Variablep) obj;
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
        int hash = 3;
        hash = 59 * hash + this.id;
        hash = 59 * hash + (this.nat != null ? this.nat.hashCode() : 0);
        hash = 59 * hash + (this.pro != null ? this.pro.hashCode() : 0);
        return hash;
    }

}
