package Controller;

import Model.Lista;
import java.util.List;


public class ListaController extends EntityController {



private static ListaController listaController;
    private static final String QUERY_GET_ALL_LISTA = "lista.all";

    ListaController(){}

    public static ListaController getInstance(){
        if(listaController ==null){
            listaController = new ListaController();
        }
        return listaController;
    }

    public void guardar(Lista m) throws Exception{
           this.persist(m);
    }

   public void borrar(Lista m) throws Exception{
        this.removeLista(m);
    }

  
 public List<Lista> getAllLista(){
        return this.executeNamedQuery(QUERY_GET_ALL_LISTA);
    }

    
}
