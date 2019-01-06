/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ControllerXML;

import Controller.*;
import Model.Variablep;
import java.util.List;

public class VariablepControllerXML extends EntityControllerXML {



private static VariablepControllerXML variablepController;
    private static final String QUERY_GET_ALL_VARIABLEP = "variablep.all";

    VariablepControllerXML(){}

    public static VariablepControllerXML getInstance(){
        if(variablepController ==null){
            variablepController = new VariablepControllerXML();
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


