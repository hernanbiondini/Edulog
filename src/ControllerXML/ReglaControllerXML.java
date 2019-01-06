package ControllerXML;

import Controller.*;
import Model.Regla;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ReglaControllerXML extends EntityControllerXML {
    private static final String QUERY_GET_ALL_REGLA = "regla.all";
    private static ReglaControllerXML reglaController;

    ReglaControllerXML(){}

    public static ReglaControllerXML getInstance(){
        if(reglaController ==null){
            reglaController = new ReglaControllerXML();
        }
        return reglaController;
    }

    public void guardar(Regla p) throws Exception{
           this.persist(p);
    }

   public void borrar(Regla p) throws Exception{
        this.removerRegla(p);
    }


   public List<Regla> getAllRegla(){
        return this.executeNamedQuery(QUERY_GET_ALL_REGLA);
    }
 
 public List<Regla> getReglasManuales(){
        EntityManager em = this.getEntityManager();
        Query q = (Query) em.createQuery("SELECT c FROM Regla c WHERE c.nat = 'M'");
        List <Regla> al= q.getResultList();
        return al;
    }
  public void deletetAllRegla(){
        this.borrarAllRegla();
    }
}

