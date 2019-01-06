/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hernan
 */
public class ValidadorSintactico {

    public String validarConsulta(String cadena) {
        System.out.println("cadena: " + cadena);
         Pattern pat = Pattern.compile("(not)*[(]{0,1}[a-zA-Z_]{1,200}([(]{1,1}[a-zA-Z_]{1,200}([,]{1,1}[a-zA-Z_]{1,200})*[)]{1,1})+[)]{0,1}");
        Matcher mat = pat.matcher(cadena);
        if (mat.matches()) {
            System.out.println("SI");
            return "SI";
        } else {
            System.out.println("NO");
            return "NO";
        }

    }

}
