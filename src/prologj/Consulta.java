package prologj;

import jpl.JPLException;
import jpl.PrologException;
import jpl.Query;

public class Consulta {

    public Consulta() {

        System.out.println("--------------------------Conexion-----------------------------");
        String t1 = "consult('family.pl')";
        String men = "Conexion con base de conocimiento: " ;
        Query q1 = new Query(t1);
        System.out.println(men + " " + (q1.hasSolution() ? "succeeded" : "failed"));
        System.out.println("---------------------------------------------------------------");
        System.out.println(" ");


    }

    public String preguntar(String consulta) {

        Query q2 = new Query(consulta);
        System.out.println( "--------------------------Soluciones---------------------------");
        System.out.println( "Solucion de: " + consulta + ": ");
        System.out.println(q2.hasSolution() ? "provable" : "not provable");
        System.out.println( "");
        
        return ((q2.hasSolution() ? "SI" : "NO"));
    }

    public java.util.Hashtable[] preguntarVar(String consulta) {

//        Query q4 = new Query(consulta);
//        java.util.Hashtable[] ss4 = q4.allSolutions();
//        System.out.println( "--------------------------------");
//        System.out.println( "all solutions of " + consulta);
//        for ( int i=0 ; i<ss4.length ; i++ ) {
//                System.out.println( "X = " + ss4[i].get("X")+ "Y = " + ss4[i].get("Y")+ "Z = " + ss4[i].get("Z"));
//        }
//        System.out.println( "--------------------------------");
        
        Query q4 = new Query(consulta);
        java.util.Hashtable<String,Double>[] ss4 = q4.allSolutions();
        System.out.println( "Todas las soluciones de: " + consulta + ": ");
        
        for ( int i=0 ; i<ss4.length ; i++ ) {
                String[] claves = (String[]) ss4[i].keySet().toArray(new String[0]);
                java.util.Arrays.sort(claves);
                for(String clave : claves) {
                    System.out.println(clave + " : " + ss4[i].get(clave));
                }  
        }
        System.out.println( "---------------------------------------------------------------");
        
        return ss4;
    }
    
     public String verificar(String consulta) throws PrologException, JPLException {
        Query q2 = new Query(consulta);
        System.out.println( "--------------------------Verificacion---------------------------");
        System.out.println( "Solucion de: " + consulta + ": ");
        System.out.println(q2.hasSolution() ? "provable" : "not provable");
        System.out.println( "");
        
        return ((q2.hasSolution() ? "SI" : "NO"));
    }
}
