/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.lang.reflect.Method;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernan
 */
public class AbrirNavegador {

    private static final String mensajeError = "Error al intentar lanzar el navegador web";

    public static void abrirURL(String url) {

        String nombreSO = System.getProperty("os.name");

        try {
            if (nombreSO.startsWith("Mac OS")) {
                Class manager = Class.forName("com.apple.eio.FileManager");
                Method openURL = manager.getDeclaredMethod("openURL", new Class[]{String.class});
                openURL.invoke(null, new Object[]{url});
            }
            if (nombreSO.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else {
                //se asume  Unix or Linux
                String[] navegadores = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"};
                String navegador = null;
                for (int contador = 0; contador < navegadores.length && navegador == null; contador++) {
                    if (Runtime.getRuntime().exec(new String[]{"which", navegadores[contador]}).waitFor() == 0) {
                        navegador = navegadores[contador];
                    }
                }

                if (navegador == null) {
                    throw new Exception("No se encuentra navegador web");
                } else {
                    Runtime.getRuntime().exec(new String[]{navegador, url});
                }
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, mensajeError + ":\n" + e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Abra el navegagor web y dirijase a : " + url, "Facebook", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
