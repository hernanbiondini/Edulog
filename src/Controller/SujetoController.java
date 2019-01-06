package Controller;



import Model.Sujeto;
import java.util.List;


public class SujetoController extends EntityController {



private static SujetoController sujetoController;
    private static final String QUERY_GET_ALL_SUJETO = "sujeto.all";

    SujetoController(){}

    public static SujetoController getInstance(){
        if(sujetoController ==null){
            sujetoController = new SujetoController();
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
