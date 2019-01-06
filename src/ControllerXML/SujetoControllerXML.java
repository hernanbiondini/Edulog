package ControllerXML;



import Controller.*;
import Model.Sujeto;
import java.util.List;


public class SujetoControllerXML extends EntityControllerXML {



private static SujetoControllerXML sujetoController;
    private static final String QUERY_GET_ALL_SUJETO = "sujeto.all";

    SujetoControllerXML(){}

    public static SujetoControllerXML getInstance(){
        if(sujetoController ==null){
            sujetoController = new SujetoControllerXML();
        }
        return sujetoController;
    }

    public void guardar(Sujeto m) throws Exception{
           this.persist(m);
    }

   public void borrar(Sujeto m) throws Exception{
        this.removeSujeto(m);
    }

  
 public List<Sujeto> getAllSujeto(){
        return this.executeNamedQuery(QUERY_GET_ALL_SUJETO);
    }

    
}
