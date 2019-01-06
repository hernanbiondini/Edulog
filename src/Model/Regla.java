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
@Table(name = "regla")
@NamedQueries({
    @NamedQuery(name = "regla.all", query = "SELECT m FROM Regla m WHERE m.nat NOT LIKE 'M' ORDER BY m.nombre"),
    @NamedQuery(name = "regla2.all", query = "SELECT m FROM Regla m WHERE m.nat NOT LIKE 'M' ORDER BY m.pro")
})
public class Regla implements Cloneable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDREGLA", nullable = false)
    private int id;
    private String nat;
    private String pro;
    private String nombre;
    private String nombrePro;


    public Regla(){};

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
    
    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
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
        return this.getNombre()+" -> "+this.getNat();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
