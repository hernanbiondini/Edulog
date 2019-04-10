package Controller;

import Model.Categoria;
import Model.Sujeto;
import java.util.List;


public class CategoriaController extends EntityController {

private static CategoriaController categoriaController;
    private static final String QUERY_GET_ALL_CATEGORIA = "categoria.all";

    CategoriaController(){}

    public static CategoriaController getInstance(){
        if(categoriaController ==null){
            categoriaController = new CategoriaController();
        }
        return categoriaController;
    }

    public void guardar(Categoria m) throws Exception{
           this.persist(m);
    }

   public void borrar(Categoria m) throws Exception{
        this.removeCategoria(m);
    }

  
 public List<Sujeto> getAllCategoria(){
        return this.executeNamedQuery(QUERY_GET_ALL_CATEGORIA);
    }

    
}
