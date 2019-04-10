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

@Entity
@Table(name = "sujeto")
@NamedQueries({
    @NamedQuery(name = "sujeto.all", query = "SELECT m FROM Sujeto m ORDER BY m.nat")
})
public class Sujeto implements Cloneable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDSUJETO", nullable = false)
    private int id;
    private String nat;
    private String pro;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne
    private Categoria categoria;

    public Sujeto(){};

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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sujeto other = (Sujeto) obj;
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
        hash = 73 * hash + this.id;
        hash = 73 * hash + (this.nat != null ? this.nat.hashCode() : 0);
        hash = 73 * hash + (this.pro != null ? this.pro.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return this.getNat();
    }

}
