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

/**
 *
 * @author Hernan
 */
@Entity
@Table(name = "hecho")
@NamedQueries({
    @NamedQuery(name = "hecho.all", query = "SELECT m FROM Hecho m WHERE m.nat NOT LIKE 'M' ORDER BY m.nat"),
    @NamedQuery(name = "hecho3.all", query = "SELECT m FROM Hecho m WHERE m.nat NOT LIKE 'M' ORDER BY m.pro")

})
@NamedQuery(name = "hecho2.all", query = "DELETE FROM Hecho")

public class Hecho implements Cloneable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDHECHO", nullable = false)
    private int id;
    private String nat;
    private String pro;

    public Hecho() {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hecho other = (Hecho) obj;
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
        hash = 61 * hash + this.id;
        hash = 61 * hash + (this.nat != null ? this.nat.hashCode() : 0);
        hash = 61 * hash + (this.pro != null ? this.pro.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Hecho{" + "nat=" + nat + '}';
    }
}
