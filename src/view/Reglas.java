/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.PredicadoController;
import Controller.ReglaController;
import Controller.RepreController;
import Controller.VariablepController;
import Controller.HechoController;
import Controller.SuvaController;
import Model.*;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.observablecollections.ObservableCollections;
import util.Buffer;
import util.Globales;

/**
 *
 * @author Hernan
 */
public class Reglas extends javax.swing.JDialog implements Globales {

    /**
     * Creates new form ABReglas
     */
    public Reglas(java.awt.Frame parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        cambioSet();

        this.jComboBox43.setEnabled(false);
        this.jComboBox44.setEnabled(false);
        this.jComboBox45.setEnabled(false);

        this.jComboBox52.setEnabled(false);
        this.jComboBox46.setEnabled(false);
        this.jComboBox47.setEnabled(false);
        this.jComboBox48.setEnabled(false);

        this.jComboBox54.setEnabled(false);
        this.jComboBox49.setEnabled(false);
        this.jComboBox50.setEnabled(false);
        this.jComboBox51.setEnabled(false);

        // Regla - Predicado
        ArrayList<Color> colores = new ArrayList<Color>();
        ArrayList<String> tooltipsText = new ArrayList<String>();

        for (Object p : repres) {
            Repre r = new Repre();
            r = (Repre) p;
            if (r.getTipo().equals("predicado")) {
                tooltipsText.add(r.getPredicado().getNat());//C
                if (r.getPredicado().getTipo() == 1) {
                    Color darkGreen = new Color(0, 75, 0);
                    colores.add(darkGreen);
                } else {
                    Color darkGreen = new Color(0, 175, 0);
                    colores.add(darkGreen);
                }
            } else {
                tooltipsText.add(r.getRegla().getNat());//C
                colores.add(Color.BLUE);
            }
        }

        colors = new Color[colores.size()];
        tools = new String[colores.size()];//C

        for (int j = 0; j < colores.size(); j++) {
            colors[j] = colores.get(j);
            tools[j] = tooltipsText.get(j);//C
        }

        this.jComboBox37.setRenderer(new Reglas.MyRenderer());
        this.jComboBox41.setRenderer(new Reglas.MyRenderer());
        this.jComboBox45.setRenderer(new Reglas.MyRenderer());
        this.jComboBox48.setRenderer(new Reglas.MyRenderer());
        this.jComboBox51.setRenderer(new Reglas.MyRenderer());

        // Sujeto - Variables
        ArrayList<Color> colores2 = new ArrayList<Color>();
        ArrayList<String> tooltipsText2 = new ArrayList<String>();

        for (Object p : suvas) {
            Suva r = new Suva();
            r = (Suva) p;
            if (r.getTipo().equals("variablep")) {
                tooltipsText2.add(r.getVariablep().getNat());//C
                Color ogange = new Color(0, 134, 139);
                colores2.add(ogange);
            } else {
                Color rojo = new Color(255, 0, 0);
                colores2.add(rojo);
                tooltipsText2.add(r.getSujeto().getNat());//C
            }
        }

        colors2 = new Color[colores2.size()];
        tools2 = new String[colores2.size()];//C

        for (int j = 0; j < colores2.size(); j++) {
            colors2[j] = colores2.get(j);
            tools2[j] = tooltipsText2.get(j);//C        
        }

        this.jComboBox36.setRenderer(new Reglas.MyRenderer2());
        this.jComboBox39.setRenderer(new Reglas.MyRenderer2());
        this.jComboBox40.setRenderer(new Reglas.MyRenderer2());
        this.jComboBox44.setRenderer(new Reglas.MyRenderer2());
        this.jComboBox47.setRenderer(new Reglas.MyRenderer2());
        this.jComboBox50.setRenderer(new Reglas.MyRenderer2());
        this.jComboBox42.setRenderer(new Reglas.MyRenderer2());
        this.jComboBox43.setRenderer(new Reglas.MyRenderer2());
        this.jComboBox46.setRenderer(new Reglas.MyRenderer2());
        this.jComboBox49.setRenderer(new Reglas.MyRenderer2());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        variables = ObservableCollections.observableList(VariablepController.getInstance().getAllVariablep());
        regla1 = new Model.Regla();
        reglas = ObservableCollections.observableList(ReglaController.getInstance().getAllRegla());
        repres = ObservableCollections.observableList(RepreController.getInstance().getAllRepre());
        repre2 = new Model.Repre();
        repre3 = new Model.Repre();
        repre4 = new Model.Repre();
        repre5 = new Model.Repre();
        repre1 = new Model.Repre();
        predicados = ObservableCollections.observableList(PredicadoController.getInstance().getAllPredicado());
        predicado1 = new Model.Predicado();
        suvas = ObservableCollections.observableList(SuvaController.getInstance().getAllSuva2());
        suva1 = new Model.Suva();
        suva2 = new Model.Suva();
        suva3 = new Model.Suva();
        suva4 = new Model.Suva();
        suva5 = new Model.Suva();
        suva6 = new Model.Suva();
        suva7 = new Model.Suva();
        suva8 = new Model.Suva();
        suva9 = new Model.Suva();
        suva10 = new Model.Suva();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jComboBox36 = new javax.swing.JComboBox();
        jComboBox37 = new javax.swing.JComboBox();
        jComboBox38 = new javax.swing.JComboBox();
        jComboBox39 = new javax.swing.JComboBox();
        jComboBox40 = new javax.swing.JComboBox();
        jComboBox41 = new javax.swing.JComboBox();
        jComboBox42 = new javax.swing.JComboBox();
        jComboBox43 = new javax.swing.JComboBox();
        jComboBox44 = new javax.swing.JComboBox();
        jComboBox45 = new javax.swing.JComboBox();
        jComboBox46 = new javax.swing.JComboBox();
        jComboBox47 = new javax.swing.JComboBox();
        jComboBox48 = new javax.swing.JComboBox();
        jComboBox49 = new javax.swing.JComboBox();
        jComboBox50 = new javax.swing.JComboBox();
        jComboBox51 = new javax.swing.JComboBox();
        jComboBox52 = new javax.swing.JComboBox();
        jComboBox53 = new javax.swing.JComboBox();
        jComboBox54 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reglas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, reglas, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Código");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nat}"));
        columnBinding.setColumnName("Regla");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pro}"));
        columnBinding.setColumnName("Pro");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, regla1, org.jdesktop.beansbinding.ObjectProperty.create(), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElements"));
        bindingGroup.addBinding(binding);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(1).setMinWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3000);
            jTable1.getColumnModel().getColumn(3).setMinWidth(0);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/iconos/delete84 (Copiar).png"))); // NOI18N
        jButton13.setText("Borrar regla");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/iconos/delete84 (Copiar).png"))); // NOI18N
        jButton14.setText("Borrar base de reglas");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Base de reglas");

        jComboBox36.setMaximumRowCount(25);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox36);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva1, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox36, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox37.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predicados, jComboBox37);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predicado1, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox37, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox37.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox37ItemStateChanged(evt);
            }
        });
        jComboBox37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox37ActionPerformed(evt);
            }
        });

        jComboBox38.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI" }));

        jComboBox39.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox39);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva2, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox39, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox40.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox40);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva3, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox40, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox41.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, repres, jComboBox41);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, repre2, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox41, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox41.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox41ItemStateChanged(evt);
            }
        });
        jComboBox41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox41ActionPerformed(evt);
            }
        });

        jComboBox42.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox42);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva4, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox42, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox43.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox43);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva6, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox43, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox44.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox44);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva5, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox44, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox45.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, repres, jComboBox45);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, repre3, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox45, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox45.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox45ItemStateChanged(evt);
            }
        });

        jComboBox46.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox46);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva8, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox46, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox47.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox47);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva7, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox47, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox48.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, repres, jComboBox48);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, repre4, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox48, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox48.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox48ItemStateChanged(evt);
            }
        });

        jComboBox49.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox49);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva10, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox49, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox50.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox50);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva9, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox50, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox51.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, repres, jComboBox51);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, repre5, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox51, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox51.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox51ItemStateChanged(evt);
            }
        });
        jComboBox51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox51ActionPerformed(evt);
            }
        });

        jComboBox52.setMaximumRowCount(3);
        jComboBox52.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".", "Y", "O" }));
        jComboBox52.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox52ItemStateChanged(evt);
            }
        });

        jComboBox53.setMaximumRowCount(3);
        jComboBox53.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".", "Y", "O" }));
        jComboBox53.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox53ItemStateChanged(evt);
            }
        });

        jComboBox54.setMaximumRowCount(3);
        jComboBox54.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".", "Y", "O" }));
        jComboBox54.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox54ItemStateChanged(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/iconos/settings51 (Copiar).png"))); // NOI18N
        jButton1.setText("Formar Regla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/iconos/floppy20 (Copiar).png"))); // NOI18N
        jButton2.setText("Guardar Regla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/iconos/Gnome-Edit-Clear-64.png"))); // NOI18N
        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Regla:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("V/S");
        jLabel3.setToolTipText("Variable/Sujeto");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("P");
        jLabel4.setToolTipText("Predicado");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("V/S");
        jLabel5.setToolTipText("Variable/Sujeto");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("V/S");
        jLabel6.setToolTipText("Variable/Sujeto");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("V/S");
        jLabel7.setToolTipText("Variable/Sujeto");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("P/R");
        jLabel8.setToolTipText("Predicado/Regla");

        jButton4.setText("S - P -V");
        jButton4.setToolTipText("Sujetos, predicados y variables.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Negación");

        jCheckBox2.setText("Negación");

        jCheckBox3.setText("Negación");

        jCheckBox4.setText("Negación");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("MV Boli", 0, 15)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setAutoscrolls(false);
        jScrollPane2.setViewportView(jTextArea1);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/iconos/eye105 (Copiar).png"))); // NOI18N
        jButton5.setText("Visualizar Regla");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(jLabel34)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton13)
                                    .addComponent(jButton4)
                                    .addComponent(jButton5))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox36, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox37, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jComboBox39, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3)
                        .addGap(178, 178, 178)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox47, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(68, 68, 68)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8))
                    .addComponent(jComboBox51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(113, 113, 113))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jCheckBox1)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)
                        .addGap(15, 15, 15)
                        .addComponent(jButton14)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jComboBox51.getAccessibleContext().setAccessibleName("");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        this.regla1 = new Regla();
        int linea = jTable1.getSelectedRow();
        int iidd = (Integer) jTable1.getValueAt(linea, 0);
        String nom = jTable1.getValueAt(linea, 1).toString();
        String pro = jTable1.getValueAt(linea, 3).toString();
        regla1.setId(iidd);
        regla1.setNat(nom);
        regla1.setPro(pro);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (this.regla1.getId() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una regla de la tabla", "Borrar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Se borra el hecho de la base de datos
            Object[] options = {"Si", "No", "Cancelar"};
            int n = JOptionPane.showOptionDialog(this, "Esta seguro que desea eliminar la regla?", "Borrando...", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
            if (JOptionPane.OK_OPTION == n) {
                try {
                    String sentencia = "";
                    sentencia = regla1.getPro();
                    ReglaController.getInstance().borrar(regla1);
                    consistencia();
                    String predicado = "";
                    int ifp = sentencia.indexOf("(");
                    predicado = sentencia.substring(0, ifp);
                    if (this.buscarPl(predicado) == false) {
                        System.out.println("desafectarPredicadoC");
                        PredicadoController.getInstance().desafectarPredicadoC(predicado);
                    }
                    refresh();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Exception: " + e.getMessage());
                }

            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        Object[] options = {"Si", "No", "Cancelar"};
        int n = JOptionPane.showOptionDialog(this, "Esta seguro que desea eliminar la base de hechos?", "Borrando...", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
        if (JOptionPane.OK_OPTION == n) {
            // Borra los reglas de la base de hechos
            try {
                ReglaController.getInstance().deletetAllRegla();
                consistenciaR();
                refresh();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Exception: " + e.getMessage());
            }
        }
        refresh();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ((variables.size() > 0) && (repres.size() > 0) && (predicados.size() > 0)) {
            consulta = "";
            jTextArea1.setText("");
            nombrePro = "";
            nombre = "";

            // --------------------------------------------------Cabeza Regla ----------------------------------------------------
            predicado1 = (Predicado) jComboBox37.getSelectedItem();
            suva1 = (Suva) jComboBox36.getSelectedItem();
            suva2 = (Suva) jComboBox39.getSelectedItem();

            String conector1 = jComboBox38.getSelectedItem().toString();
            conector1 = conector1.toLowerCase();
            conector1 = " ''" + conector1 + "'' ";
            String conector1p = ":-";

            Buffer f1 = new Buffer();
            if (suva1.getTipo().equals("variablep")) {
                f1.setNat(suva1.getVariablep().getNat());
                f1.setPro(suva1.getVariablep().getPro());
            } else {
                f1.setNat(suva1.getSujeto().getNat());
                f1.setPro(suva1.getSujeto().getPro());
            }

            Buffer f2 = new Buffer();
            if (suva2.getTipo().equals("variablep")) {
                f2.setNat(suva2.getVariablep().getNat());
                f2.setPro(suva2.getVariablep().getPro());
            } else {
                f2.setNat(suva2.getSujeto().getNat());
                f2.setPro(suva2.getSujeto().getPro());
            }

            if (predicado1.getTipo() == 1) {
                jTextArea1.setText(f1.getNat() + " " + predicado1.getNat() + " " + conector1 + " ");
                consulta = predicado1.getPro() + "(" + f1.getPro() + ")" + conector1p;
                nombre = f1.getNat() + " " + predicado1.getNat();
                nombrePro = predicado1.getPro() + "(" + f1.getPro() + ")";
            } else {

                jTextArea1.setText(f1.getNat() + " " + predicado1.getNat() + " " + f2.getNat() + " " + conector1 + " ");
                consulta = predicado1.getPro() + "(" + f1.getPro() + "," + f2.getPro() + ")" + conector1p;
                nombre = f1.getNat() + " " + predicado1.getNat() + " " + f2.getNat();
                nombrePro = predicado1.getPro() + "(" + f1.getPro() + "," + f2.getPro() + ")";
            }

            //--------------------------------------------- Cuerpo 1 ----------------------------------------------------------
            repre1 = (Repre) jComboBox41.getSelectedItem();
            suva3 = (Suva) jComboBox40.getSelectedItem();
            suva4 = (Suva) jComboBox42.getSelectedItem();

            Buffer f3 = new Buffer();
            if (suva3.getTipo().equals("variablep")) {
                f3.setNat(suva3.getVariablep().getNat());
                f3.setPro(suva3.getVariablep().getPro());
            } else {
                f3.setNat(suva3.getSujeto().getNat());
                f3.setPro(suva3.getSujeto().getPro());
            }

            Buffer f4 = new Buffer();
            if (suva4.getTipo().equals("variablep")) {
                f4.setNat(suva4.getVariablep().getNat());
                f4.setPro(suva4.getVariablep().getPro());
            } else {
                f4.setNat(suva4.getSujeto().getNat());
                f4.setPro(suva4.getSujeto().getPro());
            }

            // Logica negación
            String conectorN1 = " ";
            String conectorP1 = "";
            String conectorPC1 = "";
            if (this.jCheckBox1.isSelected()) {
                if (repre1.getTipo().equals("regla")) {
                    conectorN1 = "  NO  ES CIERTO QUE  ";
                } else {
                    conectorN1 = "  NO  ";
                }
                conectorP1 = "not(";
                conectorPC1 = ")";
            }

            if (repre1.getTipo().equals("regla")) {
                jTextArea1.setText(jTextArea1.getText() + conectorN1 + repre1.getRegla().getNombre());
                consulta = consulta + conectorP1 + repre1.getRegla().getNombrePro() + conectorPC1;
            } else {
                if (repre1.getPredicado().getTipo() == 1) {
                    jTextArea1.setText(jTextArea1.getText() + f3.getNat() + conectorN1 + repre1.getPredicado().getNat());
                    consulta = consulta + conectorP1 + repre1.getPredicado().getPro() + "(" + f3.getPro() + ")" + conectorPC1;
                } else {
                    jTextArea1.setText(jTextArea1.getText() + f3.getNat() + conectorN1 + repre1.getPredicado().getNat() + " " + f4.getNat());
                    consulta = consulta + conectorP1 + repre1.getPredicado().getPro() + "(" + f3.getPro() + "," + f4.getPro() + ")" + conectorPC1;
                }
            }

            //----------------------------------------------- Cuerpo 2 ----------------------------------------------
            repre2 = (Repre) jComboBox45.getSelectedItem();
            suva5 = (Suva) jComboBox44.getSelectedItem();
            suva6 = (Suva) jComboBox43.getSelectedItem();

            String union1 = jComboBox53.getSelectedItem().toString();
            String union1p = "";

            if (union1.equalsIgnoreCase("Y")) {
                union1p = ",";
            }
            if (union1.equalsIgnoreCase("O")) {
                union1p = ";";
            }

            union1 = union1.toLowerCase();

            if (union1.equalsIgnoreCase(".") == false) {

                jTextArea1.setText(jTextArea1.getText() + "  ''" + union1 + "''  ");
                consulta = consulta + union1p;

                Buffer f5 = new Buffer();
                if (suva5.getTipo().equals("variablep")) {
                    f5.setNat(suva5.getVariablep().getNat());
                    f5.setPro(suva5.getVariablep().getPro());
                } else {
                    f5.setNat(suva5.getSujeto().getNat());
                    f5.setPro(suva5.getSujeto().getPro());
                }

                Buffer f6 = new Buffer();
                if (suva6.getTipo().equals("variablep")) {
                    f6.setNat(suva6.getVariablep().getNat());
                    f6.setPro(suva6.getVariablep().getPro());
                } else {
                    f6.setNat(suva6.getSujeto().getNat());
                    f6.setPro(suva6.getSujeto().getPro());
                }

                // Logica negación
                String conectorN2 = " ";
                String conectorP2 = "";
                String conectorPC2 = "";
                if (this.jCheckBox2.isSelected()) {
                    if (repre2.getTipo().equals("regla")) {
                        conectorN2 = "  NO  ES CIERTO QUE  ";
                    } else {
                        conectorN2 = "  NO  ";
                    }
                    conectorP2 = "not(";
                    conectorPC2 = ")";
                }

                if (repre2.getTipo().equals("regla")) {
                    jTextArea1.setText(jTextArea1.getText() + conectorN2 + repre2.getRegla().getNombre());
                    consulta = consulta + conectorP2 + repre2.getRegla().getNombrePro() + conectorPC2;
                } else {
                    if (repre2.getPredicado().getTipo() == 1) {
                        jTextArea1.setText(jTextArea1.getText() + f5.getNat() + conectorN2 + repre2.getPredicado().getNat());
                        consulta = consulta + conectorP2 + repre2.getPredicado().getPro() + "(" + f5.getPro() + ")" + conectorPC2;
                    } else {
                        jTextArea1.setText(jTextArea1.getText() + f5.getNat() + conectorN2 + repre2.getPredicado().getNat() + " " + f6.getNat());
                        consulta = consulta + conectorP2 + repre2.getPredicado().getPro() + "(" + f5.getPro() + "," + f6.getPro() + ")" + conectorPC2;
                    }
                }

                // -------------------------------------- Cuerpo 3 -----------------------------------------------
                repre3 = (Repre) jComboBox48.getSelectedItem();
                suva7 = (Suva) jComboBox47.getSelectedItem();
                suva8 = (Suva) jComboBox46.getSelectedItem();

                String union2 = jComboBox52.getSelectedItem().toString();
                String union2p = "";

                if (union2.equalsIgnoreCase("Y")) {
                    union2p = ",";
                }
                if (union2.equalsIgnoreCase("O")) {
                    union2p = ";";
                }

                union2 = union2.toLowerCase();

                if (union2.equalsIgnoreCase(".") == false) {

                    Buffer f7 = new Buffer();
                    if (suva7.getTipo().equals("variablep")) {
                        f7.setNat(suva7.getVariablep().getNat());
                        f7.setPro(suva7.getVariablep().getPro());
                    } else {
                        f7.setNat(suva7.getSujeto().getNat());
                        f7.setPro(suva7.getSujeto().getPro());
                    }

                    Buffer f8 = new Buffer();
                    if (suva8.getTipo().equals("variablep")) {
                        f8.setNat(suva8.getVariablep().getNat());
                        f8.setPro(suva8.getVariablep().getPro());
                    } else {
                        f8.setNat(suva8.getSujeto().getNat());
                        f8.setPro(suva8.getSujeto().getPro());
                    }

                    jTextArea1.setText(jTextArea1.getText() + "  ''" + union2 + "''  ");
                    consulta = consulta + union2p;

                    // Logica negación
                    String conectorN3 = " ";
                    String conectorP3 = "";
                    String conectorPC3 = "";
                    if (this.jCheckBox3.isSelected()) {
                        conectorN3 = " NO ";
                        conectorP3 = "not(";
                        conectorPC3 = ")";
                        if (repre3.getTipo().equals("regla")) {
                            conectorN3 = "  NO  ES CIERTO QUE  ";
                        } else {
                            conectorN3 = "  NO  ";
                        }
                        conectorP3 = "not(";
                        conectorPC3 = ")";
                    }

                    if (repre3.getTipo().equals("regla")) {
                        jTextArea1.setText(jTextArea1.getText() + conectorN3 + repre3.getRegla().getNombre());
                        consulta = consulta + conectorP3 + repre3.getRegla().getNombrePro() + conectorPC3;
                    } else {
                        if (repre3.getPredicado().getTipo() == 1) {
                            jTextArea1.setText(jTextArea1.getText() + f7.getNat() + conectorN3 + repre3.getPredicado().getNat());
                            consulta = consulta + conectorP3 + repre3.getPredicado().getPro() + "(" + f7.getPro() + ")" + conectorPC3;
                        } else {
                            jTextArea1.setText(jTextArea1.getText() + f7.getNat() + conectorN3 + repre3.getPredicado().getNat() + " " + f8.getNat());
                            consulta = consulta + conectorP3 + repre3.getPredicado().getPro() + "(" + f7.getPro() + "," + f8.getPro() + ")" + conectorPC3;
                        }
                    }

                    //------------------------------------------------ Cuerpo 4 ----------------------------------------------------
                    repre4 = (Repre) jComboBox51.getSelectedItem();
                    suva9 = (Suva) jComboBox50.getSelectedItem();
                    suva10 = (Suva) jComboBox49.getSelectedItem();

                    String union3 = jComboBox54.getSelectedItem().toString();
                    String union3p = "";

                    if (union3.equalsIgnoreCase("Y")) {
                        union3p = ",";
                    }
                    if (union3.equalsIgnoreCase("O")) {
                        union3p = ";";
                    }

                    union3 = union3.toLowerCase();

                    if (union3.equalsIgnoreCase(".") == false) {

                        Buffer f9 = new Buffer();
                        if (suva9.getTipo().equals("variablep")) {
                            f9.setNat(suva9.getVariablep().getNat());
                            f9.setPro(suva9.getVariablep().getPro());
                        } else {
                            f9.setNat(suva9.getSujeto().getNat());
                            f9.setPro(suva9.getSujeto().getPro());
                        }

                        Buffer f10 = new Buffer();
                        if (suva10.getTipo().equals("variablep")) {
                            f10.setNat(suva10.getVariablep().getNat());
                            f10.setPro(suva10.getVariablep().getPro());
                        } else {
                            f10.setNat(suva10.getSujeto().getNat());
                            f10.setPro(suva10.getSujeto().getPro());
                        }

                        jTextArea1.setText(jTextArea1.getText() + "  ''" + union3 + "''  ");
                        consulta = consulta + union3p;

                        // Logica negación
                        String conectorN4 = " ";
                        String conectorP4 = "";
                        String conectorPC4 = "";
                        if (this.jCheckBox4.isSelected()) {
                            conectorN4 = " NO ";
                            conectorP4 = "not(";
                            conectorPC4 = ")";
                            if (repre4.getTipo().equals("regla")) {
                                conectorN4 = "  NO  ES CIERTO QUE  ";
                            } else {
                                conectorN4 = "  NO  ";
                            }
                            conectorP4 = "not(";
                            conectorPC4 = ")";
                        }
                        if (repre4.getTipo().equals("regla")) {
                            jTextArea1.setText(jTextArea1.getText() + conectorN4 + repre4.getRegla().getNombre());
                            consulta = consulta + conectorP4 + repre4.getRegla().getNombrePro() + conectorPC4;
                        } else {
                            if (repre4.getPredicado().getTipo() == 1) {
                                jTextArea1.setText(jTextArea1.getText() + f9.getNat() + conectorN4 + repre4.getPredicado().getNat());
                                consulta = consulta + conectorP4 + repre4.getPredicado().getPro() + "(" + f9.getPro() + ")" + conectorPC4;
                            } else {
                                jTextArea1.setText(jTextArea1.getText() + f9.getNat() + conectorN4 + repre4.getPredicado().getNat() + " " + f10.getNat());
                                consulta = consulta + conectorP4 + repre4.getPredicado().getPro() + "(" + f9.getPro() + "," + f10.getPro() + ")" + conectorPC4;
                            }
                        }

                    } // 3
                } // 2
            } // 1

            System.out.println(" ");
            System.out.println("Regla: " + consulta);
            System.out.println(" ");
        } else {
            JOptionPane.showMessageDialog(this, "Datos insuficientes para formar una regla!", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox37ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox37ItemStateChanged
        if (control.equals("false")) {
            this.jComboBox39.setEnabled(true);
            //this.jComboBox39.setVisible(true);
            Predicado pc1 = new Predicado();
            pc1 = (Predicado) jComboBox37.getSelectedItem();
            if (pc1.getTipo() == 1) {
                this.jComboBox39.setEnabled(false);
                //this.jComboBox39.setVisible(false); 
            }
        }
    }//GEN-LAST:event_jComboBox37ItemStateChanged

    private void jComboBox41ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox41ItemStateChanged
        this.jComboBox40.setEnabled(true);
        //this.jComboBox40.setVisible(true);
        this.jComboBox42.setEnabled(true);
        //this.jComboBox42.setVisible(true);
        Repre re = new Repre();
        re = (Repre) jComboBox41.getSelectedItem();
        if (re.getTipo().equals("regla")) {
            this.jComboBox40.setEnabled(false);
            //this.jComboBox40.setVisible(false);
            this.jComboBox42.setEnabled(false);
            //this.jComboBox42.setVisible(false);
        } else {
            if (re.getPredicado().getTipo() == 1) {
                this.jComboBox42.setEnabled(false);
                //this.jComboBox42.setVisible(false);
            } else {
            }
        }
    }//GEN-LAST:event_jComboBox41ItemStateChanged

    private void jComboBox45ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox45ItemStateChanged
        this.jComboBox44.setEnabled(true);
        //this.jComboBox44.setVisible(true);
        this.jComboBox43.setEnabled(true);
        //this.jComboBox43.setVisible(true);
        Repre re = new Repre();
        re = (Repre) jComboBox45.getSelectedItem();
        if (re.getTipo().equals("regla")) {
            this.jComboBox44.setEnabled(false);
            //this.jComboBox44.setVisible(false);
            this.jComboBox43.setEnabled(false);
            //this.jComboBox43.setVisible(false);
        } else {
            if (re.getPredicado().getTipo() == 1) {
                this.jComboBox43.setEnabled(false);
                //this.jComboBox43.setVisible(false);
            } else {
            }
        }
    }//GEN-LAST:event_jComboBox45ItemStateChanged

    private void jComboBox53ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox53ItemStateChanged
        this.jComboBox43.setEnabled(true);
        this.jComboBox44.setEnabled(true);
        this.jComboBox45.setEnabled(true);
        this.jComboBox52.setEnabled(true);
        String union1 = jComboBox53.getSelectedItem().toString();
        if (union1.equalsIgnoreCase(".")) {
            this.jComboBox43.setEnabled(false);
            this.jComboBox44.setEnabled(false);
            this.jComboBox45.setEnabled(false);

            this.jComboBox52.setEnabled(false);
            this.jComboBox46.setEnabled(false);
            this.jComboBox47.setEnabled(false);
            this.jComboBox48.setEnabled(false);

            this.jComboBox54.setEnabled(false);
            this.jComboBox49.setEnabled(false);
            this.jComboBox50.setEnabled(false);
            this.jComboBox51.setEnabled(false);
        } else {
            Repre re = new Repre();
            re = (Repre) jComboBox45.getSelectedItem();
            if (re.getTipo().equals("regla")) {
                this.jComboBox44.setEnabled(false);
                //this.jComboBox44.setVisible(false);
                this.jComboBox43.setEnabled(false);
                //this.jComboBox43.setVisible(false);
            } else {
                if (re.getPredicado().getTipo() == 1) {
                    this.jComboBox43.setEnabled(false);
                    //this.jComboBox43.setVisible(false);
                } else {
                }
            }
        }
    }//GEN-LAST:event_jComboBox53ItemStateChanged

    private void jComboBox52ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox52ItemStateChanged
        this.jComboBox46.setEnabled(true);
        this.jComboBox47.setEnabled(true);
        this.jComboBox48.setEnabled(true);
        this.jComboBox54.setEnabled(true);
        String union1 = jComboBox52.getSelectedItem().toString();
        if (union1.equalsIgnoreCase(".")) {
            this.jComboBox46.setEnabled(false);
            this.jComboBox47.setEnabled(false);
            this.jComboBox48.setEnabled(false);

            this.jComboBox54.setEnabled(false);
            this.jComboBox49.setEnabled(false);
            this.jComboBox50.setEnabled(false);
            this.jComboBox51.setEnabled(false);
        } else {
            Repre re = new Repre();
            re = (Repre) jComboBox48.getSelectedItem();
            if (re.getTipo().equals("regla")) {
                this.jComboBox47.setEnabled(false);
                //this.jComboBox47.setVisible(false);
                this.jComboBox46.setEnabled(false);
                //this.jComboBox46.setVisible(false);
            } else {
                if (re.getPredicado().getTipo() == 1) {
                    this.jComboBox46.setEnabled(false);
                    //this.jComboBox46.setVisible(false);
                } else {
                }
            }
        }
    }//GEN-LAST:event_jComboBox52ItemStateChanged

    private void jComboBox54ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox54ItemStateChanged
        this.jComboBox49.setEnabled(true);
        this.jComboBox50.setEnabled(true);
        this.jComboBox51.setEnabled(true);
        String union1 = jComboBox54.getSelectedItem().toString();
        if (union1.equalsIgnoreCase(".")) {
            this.jComboBox49.setEnabled(false);
            this.jComboBox50.setEnabled(false);
            this.jComboBox51.setEnabled(false);
        } else {
            Repre re = new Repre();
            re = (Repre) jComboBox51.getSelectedItem();
            if (re.getTipo().equals("regla")) {
                this.jComboBox50.setEnabled(false);
                //this.jComboBox50.setVisible(false);
                this.jComboBox49.setEnabled(false);
                //this.jComboBox49.setVisible(false);
            } else {
                if (re.getPredicado().getTipo() == 1) {
                    this.jComboBox49.setEnabled(false);
                    //this.jComboBox49.setVisible(false);
                } else {
                }
            }
        }
    }//GEN-LAST:event_jComboBox54ItemStateChanged

    private void jComboBox48ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox48ItemStateChanged
        this.jComboBox47.setEnabled(true);
        //this.jComboBox47.setVisible(true);
        this.jComboBox46.setEnabled(true);
        //this.jComboBox46.setVisible(true);
        Repre re = new Repre();
        re = (Repre) jComboBox48.getSelectedItem();
        if (re.getTipo().equals("regla")) {
            this.jComboBox47.setEnabled(false);
            //this.jComboBox47.setVisible(false);
            this.jComboBox46.setEnabled(false);
            //this.jComboBox46.setVisible(false);
        } else {
            if (re.getPredicado().getTipo() == 1) {
                this.jComboBox46.setEnabled(false);
                //this.jComboBox46.setVisible(false);
            } else {
            }
        }
    }//GEN-LAST:event_jComboBox48ItemStateChanged

    private void jComboBox51ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox51ItemStateChanged
        this.jComboBox50.setEnabled(true);
        //this.jComboBox50.setVisible(true);
        this.jComboBox49.setEnabled(true);
        //this.jComboBox49.setVisible(true);
        Repre re = new Repre();
        re = (Repre) jComboBox51.getSelectedItem();
        if (re.getTipo().equals("regla")) {
            this.jComboBox50.setEnabled(false);
            //this.jComboBox50.setVisible(false);
            this.jComboBox49.setEnabled(false);
            //this.jComboBox49.setVisible(false);
        } else {
            if (re.getPredicado().getTipo() == 1) {
                this.jComboBox49.setEnabled(false);
                //this.jComboBox49.setVisible(false);
            } else {
            }
        }
    }//GEN-LAST:event_jComboBox51ItemStateChanged

    private void jComboBox41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox41ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTextArea1.getText().equalsIgnoreCase(".")) {
            JOptionPane.showMessageDialog(this, "Por favor forme una regla", "Atención", JOptionPane.ERROR_MESSAGE);
        } else {
            regla1.setPro(consulta);
            regla1.setNat(jTextArea1.getText());
            regla1.setNombre(nombre);
            regla1.setNombrePro(nombrePro);

            try {
                ReglaController.getInstance().guardar(regla1);
                PredicadoController.getInstance().afectarPredicadoC(predicado1.getId());
                consistencia();
                refresh();
                ///////////////////////////////////////////////////
                try {
                    cambio();
                    this.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(Reglas.class.getName()).log(Level.SEVERE, null, ex);
                }
                /////////////////////////////////////////

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextArea1.setText(".");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            cambio();
            SPV s;
            s = new SPV(null, true);
            s.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Reglas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            cambioSet();
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jComboBox37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox37ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (this.regla1.getId() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una regla de la tabla", "Visualizar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Regla r = new Regla();
                r = ReglaController.getInstance().buscarRegla(regla1);
                VisualizarRegla vr = new VisualizarRegla(null, true, r);
                vr.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox51ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox jComboBox36;
    private javax.swing.JComboBox jComboBox37;
    private javax.swing.JComboBox jComboBox38;
    private javax.swing.JComboBox jComboBox39;
    private javax.swing.JComboBox jComboBox40;
    private javax.swing.JComboBox jComboBox41;
    private javax.swing.JComboBox jComboBox42;
    private javax.swing.JComboBox jComboBox43;
    private javax.swing.JComboBox jComboBox44;
    private javax.swing.JComboBox jComboBox45;
    private javax.swing.JComboBox jComboBox46;
    private javax.swing.JComboBox jComboBox47;
    private javax.swing.JComboBox jComboBox48;
    private javax.swing.JComboBox jComboBox49;
    private javax.swing.JComboBox jComboBox50;
    private javax.swing.JComboBox jComboBox51;
    private javax.swing.JComboBox jComboBox52;
    private javax.swing.JComboBox jComboBox53;
    private javax.swing.JComboBox jComboBox54;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private Model.Predicado predicado1;
    private java.util.List predicados;
    private Model.Regla regla1;
    private java.util.List reglas;
    private Model.Repre repre1;
    private Model.Repre repre2;
    private Model.Repre repre3;
    private Model.Repre repre4;
    private Model.Repre repre5;
    private java.util.List repres;
    private Model.Suva suva1;
    private Model.Suva suva10;
    private Model.Suva suva2;
    private Model.Suva suva3;
    private Model.Suva suva4;
    private Model.Suva suva5;
    private Model.Suva suva6;
    private Model.Suva suva7;
    private Model.Suva suva8;
    private Model.Suva suva9;
    private java.util.List suvas;
    private java.util.List variables;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private String consulta;
    String nombrePro = "";
    String nombre = "";
    String control = "false";
    Color colors[];
    Color colors2[];
    String tools[];//C
    String tools2[];//C

    public void refreshCombos() {
        initComponents();
    }

    public void refresh() {  // Grilla
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();
        reglas = ObservableCollections.observableList(ReglaController.getInstance().getAllRegla());

        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, reglas, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Código");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nat}"));
        columnBinding.setColumnName("Regla");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pro}"));
        columnBinding.setColumnName("Pro");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, regla1, org.jdesktop.beansbinding.ObjectProperty.create(), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElements"));
        bindingGroup.addBinding(binding);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(1).setMinWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3000);
            jTable1.getColumnModel().getColumn(3).setMinWidth(0);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        bindingGroup.bind();
        pack();

    }

    public void consistencia() {
        String consulta = "";
        // Se borra el archivo .pl
        try {
            java.io.File file = new java.io.File("family.pl");
            file.delete();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Se vuelve a escribir recorriendo la base de hechos
        List<Hecho> al = new ArrayList();
        al = HechoController.getInstance().getAllHecho3();

        for (Iterator<Hecho> it = al.iterator(); it.hasNext();) {

            Hecho h = it.next();
            consulta = h.getPro();
            FileWriter archivo = null;
            PrintWriter pw = null;
            try {
                archivo = new FileWriter("family.pl", true);
            } catch (IOException ex) {
                Logger.getLogger(ABHechos.class.getName()).log(Level.SEVERE, null, ex);
            }
            pw = new PrintWriter(archivo);
            pw.println(consulta + ".");
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(ABHechos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }//for
// Se vuelve a escribir recorriendo la base de reglas
        List<Regla> al2 = new ArrayList();
        al2 = ReglaController.getInstance().getAllRegla2();

        for (Iterator<Regla> it = al2.iterator(); it.hasNext();) {

            Regla h = it.next();
            consulta = h.getPro();
            FileWriter archivo = null;
            PrintWriter pw = null;
            try {
                archivo = new FileWriter("family.pl", true);
            } catch (IOException ex) {
                Logger.getLogger(ABHechos.class.getName()).log(Level.SEVERE, null, ex);
            }
            pw = new PrintWriter(archivo);
            pw.println(consulta + ".");
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(ABHechos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }//for

    }

    public void consistenciaR() {
        String consulta = "";
        // Se borra el archivo .pl
        try {
            java.io.File file = new java.io.File("family.pl");
            file.delete();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Se vuelve a escribir recorriendo la base de hechos
        List<Hecho> al = new ArrayList();
        al = HechoController.getInstance().getAllHecho3();

        for (Iterator<Hecho> it = al.iterator(); it.hasNext();) {

            Hecho h = it.next();
            consulta = h.getPro();
            FileWriter archivo = null;
            PrintWriter pw = null;
            try {
                archivo = new FileWriter("family.pl", true);
            } catch (IOException ex) {
                Logger.getLogger(ABHechos.class.getName()).log(Level.SEVERE, null, ex);
            }
            pw = new PrintWriter(archivo);
            pw.println(consulta + ".");
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(ABHechos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }//for
    }

    private void cambio() throws FileNotFoundException, IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("conf.txt"));
        p.setProperty("cambio", "true");
        FileOutputStream out = new FileOutputStream("conf.txt");
        p.save(out, "/* properties updated */");
    }

    public void cambioSet() throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("conf.txt"));
        p.setProperty("cambio", "false");
        FileOutputStream out = new FileOutputStream("conf.txt");
        p.save(out, "/* properties updated */");
    }

// RENDER
    class MyRenderer extends DefaultListCellRenderer {

        // METODO RENDER
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (index > -1) {
                lbl.setForeground(colors[index]);
                lbl.setToolTipText(tools[index]);//C
            }
            return lbl;
        }
    }

    // RENDER
    class MyRenderer2 extends DefaultListCellRenderer {

        // METODO RENDER
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (index > -1) {
                lbl.setForeground(colors2[index]);
                lbl.setToolTipText(tools2[index]);//C
            }
            return lbl;
        }
    }

    private boolean buscarPl(String predicado) {
        String codigo = new String(), path = "family.pl";
        File archivo = new File(path);
        boolean encontrado = false;
        FileReader fr = null;
        BufferedReader entrada = null;
        try {
            fr = new FileReader(path);
            entrada = new BufferedReader(fr);
            while (entrada.ready()) {
                codigo = entrada.readLine();
                if (codigo.contains(":-")) {
                    int c = codigo.indexOf(":-");
                    String cabeza = codigo.substring(0,c);
                    System.out.println("cabeza: " + cabeza);
                    if (cabeza.contains(predicado)) {
                        encontrado = true;
                        System.out.println("encontrado");
                        break;
                    }

                }

            }
            return encontrado;
        } catch (IOException e) {
            e.printStackTrace();
            return encontrado;
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return encontrado;
            }
        }
    }
}
