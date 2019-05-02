/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Controller.HechoController;
import Controller.ReglaController;
import Model.Hecho;
import Model.Regla;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Consultas;

/**
 *
 * @author hernan
 */
public class ModuloExterno {

    private String servicio_externo = "";
    private String url_servicio_externo = "";
    private static File archivo = null;
    private static FileReader fr = null;
    private static BufferedReader br = null;

    public String getServicio_externo() {
        return servicio_externo;
    }

    public void setServicio_externo(String servicio_externo) {
        this.servicio_externo = servicio_externo;
    }

    public String getUrl_servicio_externo() {
        return url_servicio_externo;
    }

    public void setUrl_servicio_externo(String url_servicio_externo) {
        this.url_servicio_externo = url_servicio_externo;
    }

    // Consultar ws, si hubo respuesta sigo
    // Borro hechos externos antiguos
    // Leo archivo y escribo hechos nuevos
    public void procesarHechosExternos() {
        conf();
        if (this.getServicio_externo().equals("SI")) {
            // Ejecutar modulo externo
            ejecutarModuloExterno();
            try {
                Thread.sleep(4000);
                HechoController.getInstance().borrarAllHechoExterno();
                leer();
                consistencia();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException: " + ex.getMessage());
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                System.out.println("InterruptedException: " + e.getMessage());
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    private static void leer() {
        try {
            archivo = new File("datos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            Hecho hecho1 = new Hecho();
            int cont = 0;
            while ((linea = br.readLine()) != null) {
                if (cont > 0) {
                    System.out.println("Linea: " + linea);
                    hecho1 = procesarString(linea);
                    HechoController.getInstance().guardar(hecho1);
                }
                cont = cont + 1;
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println("Exception: " + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    private static Hecho procesarString(String linea) {
        String respuesta = "";
        Hecho hecho0 = new Hecho();
        try {
            String[] parts = linea.split("=");
            String part1 = parts[0]; 
            String part2 = parts[1]; 
            String conector = "es_valor_de";
            respuesta = conector + "(" + part2 + "," + part1 + ")";
            hecho0.setPro(respuesta);
            conector = conector.replace("_", " ");
            respuesta = part2 + " " + conector + " " + part1;
            hecho0.setNat(respuesta);
            hecho0.setExterno(1);
        } catch (Exception e2) {
            System.out.println("Exception: " + e2.getMessage());
            e2.printStackTrace();
        }
        return hecho0;
    }

    private void ejecutarModuloExterno() {
        String urlSe = this.getUrl_servicio_externo();
//        System.out.println("url_servicio_externo: " + urlSe);//modulos_externos/WSweatherunlocked.jar
        try {
            String path = new File(".").getCanonicalPath();
            String url = path + urlSe;
            String[] cmd = {"java", "-jar", url};
            Runtime.getRuntime().exec(cmd);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void consistencia() {
        String consulta = "";
        // Se borra el archivo .pl
        try {
            java.io.File file = new java.io.File("family.pl");
            file.delete();

            // Se vuelve a escribir recorriendo la base de hechos
            List<Hecho> al = new ArrayList();
            //al = HechoController.getInstance().getAllHecho3();
            al = HechoController.getInstance().getAllHechopro();

            consulta = " % Hechos.";
            FileWriter archivo = null;
            PrintWriter pw = null;
            archivo = new FileWriter("family.pl", true);
            pw = new PrintWriter(archivo);
            pw.println(consulta);
            archivo.close();

            for (Iterator<Hecho> it = al.iterator(); it.hasNext();) {

                Hecho h = it.next();
                consulta = h.getPro();
                archivo = null;
                pw = null;

                archivo = new FileWriter("family.pl", true);

                pw = new PrintWriter(archivo);
                pw.println(consulta + ".");

                archivo.close();

            }//for

            consulta = "\n";
            archivo = null;
            pw = null;
            archivo = new FileWriter("family.pl", true);
            pw = new PrintWriter(archivo);
            pw.println(consulta);
            archivo.close();

            // Se vuelve a escribir recorriendo la base de reglas
            List<Regla> al2 = new ArrayList();
            //al2 = ReglaController.getInstance().getAllRegla();
            al2 = ReglaController.getInstance().getAllReglaPro();

            consulta = "% Reglas.";
            archivo = null;
            pw = null;
            archivo = new FileWriter("family.pl", true);
            pw = new PrintWriter(archivo);
            pw.println(consulta);
            archivo.close();

            for (Iterator<Regla> it = al2.iterator(); it.hasNext();) {

                Regla h = it.next();
                consulta = h.getPro();
                archivo = null;
                pw = null;

                archivo = new FileWriter("family.pl", true);

                pw = new PrintWriter(archivo);
                pw.println(consulta + ".");

                archivo.close();

            }//for
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

        public void conf() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("conf.txt"));
            this.setServicio_externo(p.getProperty("servicio_externo"));
            this.setUrl_servicio_externo(p.getProperty("url_servicio_externo"));
        } catch (Exception e) {
            System.out.println("Error Configuracion: " + e);
        }
    }
        
}
