/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerXML;

import Controller.*;
import Model.Hecho;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Hernan
 */
public class HechoControllerXML extends EntityControllerXML{
    private static HechoControllerXML hechoController;
    private static final String QUERY_GET_ALL_HECHO = "hecho.all";
    private static final String QUERY_DELETE_ALL_HECHO = "hecho2.all";

    HechoControllerXML(){}

    public static HechoControllerXML getInstance(){
        if(hechoController ==null){
            hechoController = new HechoControllerXML();
        }
        return hechoController;
    }

    public void guardar(Hecho m) throws Exception{
           this.persist(m);
           System.out.println(m.getNat());
    }

   public void borrar(Hecho m) throws Exception{
        this.removeHecho(m);
    }

  
 public List<Hecho> getAllHecho(){
        return this.executeNamedQuery(QUERY_GET_ALL_HECHO);
    }


   public void deletetAllHecho(){
        this.borrarAllHecho();
    }
    
   public List<Hecho> getHechosManuales(){
        EntityManager em = this.getEntityManager();
        Query q = (Query) em.createQuery("SELECT c FROM Hecho c WHERE c.nat = 'M'");
        List <Hecho> al= q.getResultList();
        return al;
    }
}
