/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Variablep;
import java.util.List;

public class VariablepController extends EntityController {



private static VariablepController variablepController;
    private static final String QUERY_GET_ALL_VARIABLEP = "variablep.all";

    VariablepController(){}

    public static VariablepController getInstance(){
        if(variablepController ==null){
            variablepController = new VariablepController();
        }
        return variablepController;
    }

    public void guardar(Variablep m) throws Exception{
           this.persist(m);
    }

   public void borrar(Variablep m) throws Exception{
        this.removeVariablep(m);
    }


 public List<Variablep> getAllVariablep(){
        return this.executeNamedQuery(QUERY_GET_ALL_VARIABLEP);
    }


}


