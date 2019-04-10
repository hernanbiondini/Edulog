package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
@NamedQueries({
@NamedQuery(name = "categoria.all", query = "SELECT m FROM Categoria m ORDER BY m.nombre")
})

public class Categoria implements Cloneable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CATEGORIA", nullable = false)
    private int id;
    private String nombre;
    private String descripcion;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private Collection<Sujeto> sujetos;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private Collection<Predicado> predicados;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private Collection<Variablep> variables;
    
    public Categoria() {
    }

    public Categoria(int id, String nombre, String descripcion, Collection<Sujeto> sujetos, Collection<Predicado> predicados, Collection<Variablep> variables) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sujetos = sujetos;
        this.predicados = predicados;
        this.variables = variables;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Sujeto> getSujetos() {
        return sujetos;
    }

    public void setSujetos(Collection<Sujeto> sujetos) {
        this.sujetos = sujetos;
    }

    public Collection<Predicado> getPredicados() {
        return predicados;
    }

    public void setPredicados(Collection<Predicado> predicados) {
        this.predicados = predicados;
    }

    public Collection<Variablep> getVariables() {
        return variables;
    }

    public void setVariables(Collection<Variablep> variables) {
        this.variables = variables;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.nombre);
        hash = 19 * hash + Objects.hashCode(this.descripcion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }
   
}
