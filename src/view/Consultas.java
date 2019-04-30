/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.HechoController;
import Controller.HereController;
import Model.Predicado;
import Model.Suva;
import Controller.PredicadoController;
import Controller.ReglaController;
import Controller.SuvaController;
import Model.Hecho;
import Model.Regla;
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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import prologj.Consulta;

/**
 *
 * @author Hernan
 */
public class Consultas extends javax.swing.JDialog {

    /**
     * Creates new form Consultas
     */
    public Consultas(java.awt.Frame parent, boolean modal) throws IOException {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        cambioSet();
        this.jTextArea2.setLineWrap(true);

        this.jComboBox6.setEnabled(false);
        this.jComboBox7.setEnabled(false);
        this.jComboBox8.setEnabled(false);
        this.jComboBox53.setEnabled(false);

        this.jComboBox9.setEnabled(false);
        this.jComboBox10.setEnabled(false);
        this.jComboBox11.setEnabled(false);
        this.jComboBox55.setEnabled(false);

        this.jComboBox12.setEnabled(false);
        this.jComboBox13.setEnabled(false);
        this.jComboBox14.setEnabled(false);

        this.jTextArea1.setText(".");
        this.jTextArea2.setText(".");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/ca.jpg"))); // NOI18N

        // Predicado
        ArrayList<Color> colores = new ArrayList<Color>();
        ArrayList<String> tooltipsText = new ArrayList<String>();

        for (Object p : predicados) {
            Predicado r = new Predicado();
            r = (Predicado) p;
            if (r.getTipo() == 1) {
                tooltipsText.add(r.getNat());//C
                Color darkGreen = new Color(0, 75, 0);
                colores.add(darkGreen);
            } else {
                tooltipsText.add(r.getNat());//C
                Color darkGreen = new Color(0, 175, 0);
                colores.add(darkGreen);
            }
        }

        colors = new Color[colores.size()];
        tools = new String[colores.size()];//C
        for (int j = 0; j < colores.size(); j++) {
            colors[j] = colores.get(j);
            tools[j] = tooltipsText.get(j);//C
        }

        this.jComboBox4.setRenderer(new Consultas.MyRenderer());
        this.jComboBox7.setRenderer(new Consultas.MyRenderer());
        this.jComboBox10.setRenderer(new Consultas.MyRenderer());
        this.jComboBox13.setRenderer(new Consultas.MyRenderer());

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
                tooltipsText2.add(r.getSujeto().getNat());//C
                Color rojo = new Color(255, 0, 0);
                colores2.add(rojo);
            }
        }

        colors2 = new Color[colores2.size()];
        tools2 = new String[colores2.size()];//C
        for (int j = 0; j < colores2.size(); j++) {
            colors2[j] = colores2.get(j);
            tools2[j] = tooltipsText2.get(j);//C
        }

        this.jComboBox3.setRenderer(new Consultas.MyRenderer2());
        this.jComboBox5.setRenderer(new Consultas.MyRenderer2());
        this.jComboBox6.setRenderer(new Consultas.MyRenderer2());
        this.jComboBox8.setRenderer(new Consultas.MyRenderer2());
        this.jComboBox9.setRenderer(new Consultas.MyRenderer2());
        this.jComboBox11.setRenderer(new Consultas.MyRenderer2());
        this.jComboBox12.setRenderer(new Consultas.MyRenderer2());
        this.jComboBox14.setRenderer(new Consultas.MyRenderer2());

        // Se vuelve a escribir el .pl leyendo hechos y reglas de la base de datos
        consistencia();
        this.conf();
        // Se lee el contenido del .pl recien escrito
        //leerPl();

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

        predicado1 = new Model.Predicado();
        suva1 = new Model.Suva();
        suva2 = new Model.Suva();
        suvas = ObservableCollections.observableList(SuvaController.getInstance().getAllSuva());
        predicados = ObservableCollections.observableList(PredicadoController.getInstance().getAllPredicado3());
        suva3 = new Model.Suva();
        suva4 = new Model.Suva();
        suva5 = new Model.Suva();
        suva6 = new Model.Suva();
        suva7 = new Model.Suva();
        suva8 = new Model.Suva();
        predicado2 = new Model.Predicado();
        predicado3 = new Model.Predicado();
        predicado4 = new Model.Predicado();
        heres = ObservableCollections.observableList(HereController.getInstance().getAllHeRe());
        heRe1 = new Model.HeRe();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox7 = new javax.swing.JComboBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jComboBox8 = new javax.swing.JComboBox();
        jComboBox9 = new javax.swing.JComboBox();
        jComboBox10 = new javax.swing.JComboBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jComboBox11 = new javax.swing.JComboBox();
        jComboBox12 = new javax.swing.JComboBox();
        jComboBox13 = new javax.swing.JComboBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jComboBox14 = new javax.swing.JComboBox();
        jComboBox53 = new javax.swing.JComboBox();
        jComboBox54 = new javax.swing.JComboBox();
        jComboBox55 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setToolTipText("");

        jPanel3.setPreferredSize(new java.awt.Dimension(1106, 5));

        jComboBox3.setMaximumRowCount(25);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox3);
        bindingGroup.addBinding(jComboBoxBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva1, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox3, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox4.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predicados, jComboBox4);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predicado1, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox4, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jComboBox5.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox5);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva2, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox5, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/iconos/settings51 (Copiar).png"))); // NOI18N
        jButton6.setText("Formar consulta");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/iconos/right246 (Copiar).png"))); // NOI18N
        jButton7.setText("Ejecutar consulta");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/iconos/Gnome-Edit-Clear-64.png"))); // NOI18N
        jButton8.setText("Limpiar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(10);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCheckBox2.setText("Negación");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Sujeto/Variable");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Sujeto/Variable");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Predicado");

        jComboBox6.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox6);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva3, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox6, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox7.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predicados, jComboBox7);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predicado3, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox7, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox7ItemStateChanged(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCheckBox3.setText("Negación");

        jComboBox8.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox8);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva4, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox8, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox8ActionPerformed(evt);
            }
        });

        jComboBox9.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox9);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva5, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox9, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox10.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predicados, jComboBox10);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predicado3, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox10, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox10ItemStateChanged(evt);
            }
        });

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCheckBox4.setText("Negación");

        jComboBox11.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox11);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva6, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox11, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });

        jComboBox12.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox12);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva7, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox12, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox13.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predicados, jComboBox13);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, predicado4, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox13, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox13.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox13ItemStateChanged(evt);
            }
        });

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCheckBox5.setText("Negación");

        jComboBox14.setMaximumRowCount(25);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suvas, jComboBox14);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suva8, org.jdesktop.beansbinding.ObjectProperty.create(), jComboBox14, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox14ActionPerformed(evt);
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

        jComboBox55.setMaximumRowCount(3);
        jComboBox55.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".", "Y", "O" }));
        jComboBox55.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox55ItemStateChanged(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("BC");
        jButton1.setToolTipText("Consultar Base de Conocimiento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("S - P - V");
        jButton3.setToolTipText("Sujetos, predicados y variables.");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Vani", 2, 14)); // NOI18N
        jLabel10.setText(".");

        jLabel12.setFont(new java.awt.Font("Vani", 2, 14)); // NOI18N
        jLabel12.setText(".");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("MV Boli", 0, 15)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setAutoscrolls(false);
        jScrollPane3.setViewportView(jTextArea1);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("MV Boli", 0, 15)); // NOI18N
        jTextArea3.setRows(1);
        jTextArea3.setAutoscrolls(false);
        jScrollPane4.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(402, 402, 402)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jCheckBox2))
                                .addGap(380, 380, 380))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(379, 379, 379))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jComboBox53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jComboBox3, 0, 250, Short.MAX_VALUE)
                                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox12, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox7, 0, 250, Short.MAX_VALUE)
                                        .addComponent(jComboBox10, 0, 250, Short.MAX_VALUE)
                                        .addComponent(jComboBox13, 0, 250, Short.MAX_VALUE)
                                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBox14, javax.swing.GroupLayout.Alignment.LEADING, 0, 249, Short.MAX_VALUE)
                                        .addComponent(jComboBox11, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox8, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCheckBox2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton1))))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultas", jPanel3);

        jPanel1.setPreferredSize(new java.awt.Dimension(50, 627));

        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, heres, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, heRe1, org.jdesktop.beansbinding.ObjectProperty.create(), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(900);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(900);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(900);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Natural", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1120, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(556, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            cambioSet();
        } catch (IOException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            cambio();
            SPV s;
            s = new SPV(null, true);
            s.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Reglas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BaseConocimiento s = new BaseConocimiento(null, true);
        s.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox55ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox55ItemStateChanged
        this.jComboBox12.setEnabled(true);
        this.jComboBox13.setEnabled(true);
        this.jComboBox14.setEnabled(true);
        String union1 = jComboBox55.getSelectedItem().toString();
        if (union1.equalsIgnoreCase(".")) {

            this.jComboBox12.setEnabled(false);
            this.jComboBox13.setEnabled(false);
            this.jComboBox14.setEnabled(false);

        } else {
            this.jComboBox14.setEnabled(true);
            Predicado p = new Predicado();
            p = (Predicado) jComboBox13.getSelectedItem();
            if (p.getTipo() == 1) {
                this.jComboBox14.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jComboBox55ItemStateChanged

    private void jComboBox54ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox54ItemStateChanged
        this.jComboBox6.setEnabled(true);
        this.jComboBox7.setEnabled(true);
        this.jComboBox8.setEnabled(true);
        this.jComboBox53.setEnabled(true);
        String union1 = jComboBox54.getSelectedItem().toString();
        if (union1.equalsIgnoreCase(".")) {
            this.jComboBox6.setEnabled(false);
            this.jComboBox7.setEnabled(false);
            this.jComboBox8.setEnabled(false);
            this.jComboBox53.setEnabled(false);

            this.jComboBox9.setEnabled(false);
            this.jComboBox10.setEnabled(false);
            this.jComboBox11.setEnabled(false);
            this.jComboBox55.setEnabled(false);

            this.jComboBox12.setEnabled(false);
            this.jComboBox13.setEnabled(false);
            this.jComboBox14.setEnabled(false);

        } else {
            this.jComboBox8.setEnabled(true);
            Predicado p = new Predicado();
            p = (Predicado) jComboBox7.getSelectedItem();
            if (p.getTipo() == 1) {
                this.jComboBox8.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jComboBox54ItemStateChanged

    private void jComboBox53ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox53ItemStateChanged
        this.jComboBox9.setEnabled(true);
        this.jComboBox10.setEnabled(true);
        this.jComboBox11.setEnabled(true);
        this.jComboBox55.setEnabled(true);
        String union1 = jComboBox53.getSelectedItem().toString();
        if (union1.equalsIgnoreCase(".")) {

            this.jComboBox9.setEnabled(false);
            this.jComboBox10.setEnabled(false);
            this.jComboBox11.setEnabled(false);
            this.jComboBox55.setEnabled(false);

            this.jComboBox12.setEnabled(false);
            this.jComboBox13.setEnabled(false);
            this.jComboBox14.setEnabled(false);

        } else {
            this.jComboBox11.setEnabled(true);
            Predicado p = new Predicado();
            p = (Predicado) jComboBox10.getSelectedItem();
            if (p.getTipo() == 1) {
                this.jComboBox11.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jComboBox53ItemStateChanged

    private void jComboBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox14ActionPerformed

    private void jComboBox13ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox13ItemStateChanged
        this.jComboBox14.setEnabled(true);
        Predicado p = new Predicado();
        p = (Predicado) jComboBox13.getSelectedItem();
        if (p.getTipo() == 1) {
            this.jComboBox14.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox13ItemStateChanged

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jComboBox10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox10ItemStateChanged
        this.jComboBox11.setEnabled(true);
        Predicado p = new Predicado();
        p = (Predicado) jComboBox10.getSelectedItem();
        if (p.getTipo() == 1) {
            this.jComboBox11.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox10ItemStateChanged

    private void jComboBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox8ActionPerformed

    private void jComboBox7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox7ItemStateChanged
        this.jComboBox8.setEnabled(true);
        Predicado p = new Predicado();
        p = (Predicado) jComboBox7.getSelectedItem();
        if (p.getTipo() == 1) {
            this.jComboBox8.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox7ItemStateChanged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/ca.jpg"))); // NOI18N
        jTextArea1.setText(".");
        jLabel10.setText(".");
        jTextArea3.setText(".");
        jLabel12.setText(".");
        jTextArea2.setText(".");
    }//GEN-LAST:event_jButton8ActionPerformed

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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTextArea2.setForeground(Color.BLACK);
        if (jTextArea1.getText().equalsIgnoreCase(".")) {
            Icon Imagen;
            Random rnd = new Random();
            int hhh = (int) (rnd.nextDouble() * 100 + 1);
            if (hhh < 50) {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/mierda.jpg"))); // NOI18N
                Imagen = new javax.swing.ImageIcon(getClass().getResource("/view/memes/mierda.jpg"));
            } else {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/FacePalm.png"))); // NOI18N
                Imagen = new javax.swing.ImageIcon(getClass().getResource("/view/memes/FacePalm.png"));
            }
            JOptionPane.showMessageDialog(this, "Por favor forme una consulta!", "Atención", JOptionPane.ERROR_MESSAGE, Imagen);
        } else {

            jTextArea2.setText("");
            Consulta c = new Consulta();

            try {

                procesarHechosExternos();

                String respuestaUnica = "";
                String respuestaMultiple = "";
                String respuestaFinal = "";

                respuestaUnica = c.preguntar(consulta);

                java.util.Hashtable[] s = c.preguntarVar(consulta);
                for (int i = 0; i < s.length; i++) {
                    String[] claves = (String[]) s[i].keySet().toArray(new String[0]);
                    java.util.Arrays.sort(claves);

//                    for (String clave : claves) {
//                        respuestaMultiple = respuestaMultiple + (clave + ":" + s[i].get(clave) + " ");
//                    }
                    String resp = "";
                    boolean bandera = false;
                    for (String clave : claves) {
                        resp = clave + ":" + s[i].get(clave);
                        if (respuestaMultiple.contains(resp) == false) {
                            respuestaMultiple = respuestaMultiple + (resp + " ");
                            bandera = true;
                        }
                    }

                    if (respuestaMultiple.equals("") == false) {
                        if (bandera) {
                            respuestaMultiple = respuestaMultiple + ",  ";
                        }
                    }

                }
                if (respuestaMultiple.length() > 3) {
                    respuestaMultiple = respuestaMultiple.substring(0, respuestaMultiple.length() - 3);
                }
                if (respuestaUnica.equals("") == false) {

                    respuestaFinal = respuestaUnica;
                    Random rnd = new Random();
                    int hhh = (int) (rnd.nextDouble() * 100 + 1);
                    if (hhh < 18) {
                        exito = "sir";
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/nome digas.png"))); // NOI18N
                    } else {
                        rnd = new Random();
                        hhh = (int) (rnd.nextDouble() * 100 + 1);

                        if (hhh >= 0 && hhh <= 20) {
                            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/fuck.jpg")));
                        }
                        if (hhh > 20 && hhh <= 40) {
                            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/true.png")));
                        }
                        if (hhh > 40 && hhh <= 60) {
                            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/fredy.jpg")));
                        }
                        if (hhh > 60 && hhh <= 80) {
                            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/sir.png")));
                        }
                        if (hhh > 80 && hhh <= 100) {
                            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/cereal2.png")));
                        }
                    }
                }
                if (respuestaMultiple.equals("") == false) {
                    Random rnd = new Random();
                    int hhh;
                    hhh = (int) (rnd.nextDouble() * 100 + 1);
                    respuestaFinal = respuestaFinal + " /  " + respuestaMultiple;
                    if (hhh >= 0 && hhh <= 25) {
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/gordo.jpg")));
                    }
                    if (hhh > 25 && hhh <= 50) {
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/mother.jpg")));
                    }
                    if (hhh > 50 && hhh <= 75) {
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/obama.jpg")));
                    }
                    if (hhh > 75 && hhh <= 100) {
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/Surprice.png")));
                    }

                }

                respuestaFinal = respuestaFinal.replace('_', ' ');
                jTextArea2.setText(respuestaFinal);
                if (jTextArea2.getText().trim().equals("")) {
                    Random rnd = new Random();
                    int hhh = (int) (rnd.nextDouble() * 100 + 1);
                    if (hhh < 50) {
                        jTextArea2.append("No se puede responder a la consulta actual: datos insuficientes en la Base de Conocimiento!");
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/mierda.jpg"))); // NOI18N
                        Icon Imagen = new javax.swing.ImageIcon(getClass().getResource("/view/memes/mierda.jpg"));
                        JOptionPane.showMessageDialog(this, "Por favor forme una consulta!", "Atención", JOptionPane.ERROR_MESSAGE, Imagen);
                    } else {
                        jTextArea2.append("No se puede responder a la consulta actual: datos insuficientes en la Base de Conocimiento!");
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/FacePalm.png"))); // NOI18N
                        Icon Imagen = new javax.swing.ImageIcon(getClass().getResource("/view/memes/FacePalm.png"));
                        JOptionPane.showMessageDialog(this, "Por favor forme una consulta!", "Atención", JOptionPane.ERROR_MESSAGE, Imagen);
                    }

                }
            } catch (Exception e) {
                Logger.getLogger(ABHechos.class.getName()).log(Level.SEVERE, null, e);
                jTextArea2.append("ERROR EN LA CONSULTA: Algún predicado no se encuentra en la base de conocimiento!");
                jTextArea2.setForeground(Color.red);
                //JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Exception: " + e.getMessage());
                Random rnd = new Random();
                int hhh = (int) (rnd.nextDouble() * 100 + 1);
                if (hhh >= 0 && hhh <= 25) {
                    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/okay.jpg"))); // NOI18N
                }
                if (hhh > 25 && hhh <= 50) {
                    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/lpm.jpg"))); // NOI18N
                }
                if (hhh > 50 && hhh <= 75) {
                    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/pocker.jpg"))); // NOI18N
                }
                if (hhh > 75 && hhh <= 100) {
                    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/WtF.png"))); // NOI18N
                }
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if ((suvas.size() > 0) && (predicados.size() > 0)) {
            consulta = "";
            this.jTextArea2.setText("");
            this.jTextArea1.setText("");
            this.jTextArea3.setText("");
            this.jLabel10.setText("¿Es cierto que...");
            this.jLabel12.setText(".");

            // -------------------------------------------------- Consulta parte 1 ----------------------------------------------------
            predicado1 = (Predicado) jComboBox4.getSelectedItem();
            suva1 = (Suva) jComboBox3.getSelectedItem();
            suva2 = (Suva) jComboBox5.getSelectedItem();

            // Logica negación
            String conectorN = " ";
            String conectorP = "";
            String conectorPC = "";
            if (this.jCheckBox2.isSelected()) {
                conectorN = " NO ";
                conectorP = "not(";
                conectorPC = ")";
            }

            if (predicado1.getTipo() == 1) { // Tipo 1
                if (suva1.getTipo().equals("sujeto")) {
                    jTextArea1.setText(suva1.getSujeto().getNat() + conectorN + predicado1.getNat());
                    consulta = conectorP + predicado1.getPro() + "(" + suva1.getSujeto().getPro() + ")" + conectorPC;
                } else {
                    jTextArea1.setText(suva1.getVariablep().getNat() + conectorN + predicado1.getNat());
                    consulta = conectorP + predicado1.getPro() + "(" + suva1.getVariablep().getPro() + ")" + conectorPC;

                }

            } else { // Tipo 2
                if (suva1.getTipo().equals("sujeto")) {
                    jTextArea1.setText(suva1.getSujeto().getNat() + conectorN + predicado1.getNat());
                    consulta = conectorP + predicado1.getPro() + "(" + suva1.getSujeto().getPro();
                } else {
                    jTextArea1.setText(suva1.getVariablep().getNat() + conectorN + predicado1.getNat());
                    consulta = conectorP + predicado1.getPro() + "(" + suva1.getVariablep().getPro();
                }
                if (suva2.getTipo().equals("sujeto")) {
                    jTextArea1.setText(jTextArea1.getText() + " " + suva2.getSujeto().getNat());
                    consulta = consulta + "," + suva2.getSujeto().getPro() + ")" + conectorPC;
                } else {
                    jTextArea1.setText(jTextArea1.getText() + " " + suva2.getVariablep().getNat());
                    consulta = consulta + "," + suva2.getVariablep().getPro() + ")" + conectorPC;
                }
            } // Fin p1

            // -------------------------------------------------- Consulta parte 2 ----------------------------------------------------
            String union1 = jComboBox54.getSelectedItem().toString();
            String union1p = "";

            // Logica union
            if (union1.equalsIgnoreCase(".") == false) {

                if (union1.equalsIgnoreCase("Y")) {
                    union1p = ",";
                }
                if (union1.equalsIgnoreCase("O")) {
                    union1p = ";";
                }

                union1 = union1.toLowerCase();
                union1 = " ''" + union1 + "'' ";

                jTextArea1.setText(jTextArea1.getText() + " " + union1 + " ");
                consulta = consulta + union1p;

                predicado2 = (Predicado) jComboBox7.getSelectedItem();
                suva3 = (Suva) jComboBox6.getSelectedItem();
                suva4 = (Suva) jComboBox8.getSelectedItem();

                // Logica negación
                String conectorN1 = " ";
                String conectorP1 = "";
                String conectorPC1 = "";

                if (this.jCheckBox3.isSelected()) {
                    conectorN1 = " NO ";
                    conectorP1 = "not(";
                    conectorPC1 = ")";
                }

                if (predicado2.getTipo() == 1) { // Tipo 1
                    if (suva3.getTipo().equals("sujeto")) {
                        jTextArea1.setText(jTextArea1.getText() + " " + suva3.getSujeto().getNat() + conectorN1 + predicado2.getNat());
                        consulta = consulta + conectorP1 + predicado2.getPro() + "(" + suva3.getSujeto().getPro() + ")" + conectorPC1;
                    } else {
                        jTextArea1.setText(jTextArea1.getText() + " " + suva3.getVariablep().getNat() + conectorN1 + predicado2.getNat());
                        consulta = consulta + conectorP1 + predicado2.getPro() + "(" + suva3.getVariablep().getPro() + ")" + conectorPC1;
                    }

                } else { // Tipo 2
                    if (suva3.getTipo().equals("sujeto")) {
                        jTextArea1.setText(jTextArea1.getText() + " " + suva3.getSujeto().getNat() + conectorN1 + predicado2.getNat());
                        consulta = consulta + conectorP1 + predicado2.getPro() + "(" + suva3.getSujeto().getPro();
                    } else {
                        jTextArea1.setText(jTextArea1.getText() + " " + suva3.getVariablep().getNat() + conectorN1 + predicado2.getNat());
                        consulta = consulta + conectorP1 + predicado2.getPro() + "(" + suva3.getVariablep().getPro();
                    }
                    if (suva4.getTipo().equals("sujeto")) {
                        jTextArea1.setText(jTextArea1.getText() + " " + suva4.getSujeto().getNat());
                        consulta = consulta + "," + suva4.getSujeto().getPro() + ")" + conectorPC1;
                    } else {
                        jTextArea1.setText(jTextArea1.getText() + " " + suva4.getVariablep().getNat());
                        consulta = consulta + "," + suva4.getVariablep().getPro() + ")" + conectorPC1;
                    }
                } //Fin p2

                // -------------------------------------------------- Consulta parte 3 ----------------------------------------------------
                String union2 = jComboBox53.getSelectedItem().toString();
                String union2p = "";

                // Logica union
                if (union2.equalsIgnoreCase(".") == false) {

                    if (union2.equalsIgnoreCase("Y")) {
                        union2p = ",";
                    }
                    if (union2.equalsIgnoreCase("O")) {
                        union2p = ";";
                    }

                    union2 = union2.toLowerCase();
                    union2 = " ''" + union2 + "'' ";

                    jTextArea1.setText(jTextArea1.getText() + " " + union2 + " ");
                    consulta = consulta + union2p;

                    predicado3 = (Predicado) jComboBox10.getSelectedItem();
                    suva5 = (Suva) jComboBox9.getSelectedItem();
                    suva6 = (Suva) jComboBox11.getSelectedItem();

                    // Logica negación
                    String conectorN2 = " ";
                    String conectorP2 = "";
                    String conectorPC2 = "";

                    if (this.jCheckBox4.isSelected()) {
                        conectorN2 = " NO ";
                        conectorP2 = "not(";
                        conectorPC2 = ")";
                    }

                    if (predicado3.getTipo() == 1) { // Tipo 1
                        if (suva5.getTipo().equals("sujeto")) {
                            jTextArea1.setText(jTextArea1.getText() + " " + suva5.getSujeto().getNat() + conectorN2 + predicado3.getNat());
                            consulta = consulta + conectorP2 + predicado3.getPro() + "(" + suva5.getSujeto().getPro() + ")" + conectorPC2;
                        } else {
                            jTextArea1.setText(jTextArea1.getText() + " " + suva5.getVariablep().getNat() + conectorN2 + predicado3.getNat());
                            consulta = consulta + conectorP2 + predicado3.getPro() + "(" + suva5.getVariablep().getPro() + ")" + conectorPC2;
                        }

                    } else { // Tipo 2
                        if (suva5.getTipo().equals("sujeto")) {
                            jTextArea1.setText(jTextArea1.getText() + " " + suva5.getSujeto().getNat() + conectorN2 + predicado3.getNat());
                            consulta = consulta + conectorP2 + predicado3.getPro() + "(" + suva5.getSujeto().getPro();
                        } else {
                            jTextArea1.setText(jTextArea1.getText() + " " + suva5.getVariablep().getNat() + conectorN2 + predicado3.getNat());
                            consulta = consulta + conectorP2 + predicado3.getPro() + "(" + suva5.getVariablep().getPro();
                        }
                        if (suva6.getTipo().equals("sujeto")) {
                            jTextArea1.setText(jTextArea1.getText() + " " + suva6.getSujeto().getNat());
                            consulta = consulta + "," + suva6.getSujeto().getPro() + ")" + conectorPC2;
                        } else {
                            jTextArea1.setText(jTextArea1.getText() + " " + suva6.getVariablep().getNat());
                            consulta = consulta + "," + suva6.getVariablep().getPro() + ")" + conectorPC2;
                        }
                    } //Fin p3

                    // -------------------------------------------------- Consulta parte 4 ----------------------------------------------------
                    String union3 = jComboBox55.getSelectedItem().toString();
                    String union3p = "";

                    // Logica union
                    if (union3.equalsIgnoreCase(".") == false) {

                        if (union3.equalsIgnoreCase("Y")) {
                            union3p = ",";
                        }
                        if (union3.equalsIgnoreCase("O")) {
                            union3p = ";";
                        }
                        union3 = union3.toLowerCase();
                        union3 = " ''" + union3 + "'' ";

                        jTextArea1.setText(jTextArea1.getText() + " " + union3 + " ");
                        consulta = consulta + union3p;

                        predicado4 = (Predicado) jComboBox13.getSelectedItem();
                        suva7 = (Suva) jComboBox12.getSelectedItem();
                        suva8 = (Suva) jComboBox14.getSelectedItem();

                        // Logica negación
                        String conectorN3 = " ";
                        String conectorP3 = "";
                        String conectorPC3 = "";

                        if (this.jCheckBox5.isSelected()) {
                            conectorN3 = " NO ";
                            conectorP3 = "not(";
                            conectorPC3 = ")";
                        }

                        if (predicado4.getTipo() == 1) { // Tipo 1
                            if (suva7.getTipo().equals("sujeto")) {
                                jTextArea1.setText(jTextArea1.getText() + " " + suva7.getSujeto().getNat() + conectorN3 + predicado4.getNat());
                                consulta = consulta + conectorP3 + predicado4.getPro() + "(" + suva7.getSujeto().getPro() + ")" + conectorPC3;
                            } else {
                                jTextArea1.setText(jTextArea1.getText() + " " + suva7.getVariablep().getNat() + conectorN3 + predicado4.getNat());
                                consulta = consulta + conectorP3 + predicado4.getPro() + "(" + suva7.getVariablep().getPro() + ")" + conectorPC3;
                            }

                        } else { // Tipo 2
                            if (suva7.getTipo().equals("sujeto")) {
                                jTextArea1.setText(jTextArea1.getText() + " " + suva7.getSujeto().getNat() + conectorN3 + predicado4.getNat());
                                consulta = consulta + conectorP3 + predicado4.getPro() + "(" + suva7.getSujeto().getPro();
                            } else {
                                jTextArea1.setText(jTextArea1.getText() + " " + suva7.getVariablep().getNat() + conectorN3 + predicado4.getNat());
                                consulta = consulta + conectorP3 + predicado4.getPro() + "(" + suva7.getVariablep().getPro();
                            }
                            if (suva8.getTipo().equals("sujeto")) {
                                jTextArea1.setText(jTextArea1.getText() + " " + suva8.getSujeto().getNat());
                                consulta = consulta + "," + suva8.getSujeto().getPro() + ")" + conectorPC3;
                            } else {
                                jTextArea1.setText(jTextArea1.getText() + " " + suva8.getVariablep().getNat());
                                consulta = consulta + "," + suva8.getVariablep().getPro() + ")" + conectorPC3;
                            }
                        } //Fin p4

                    } // Fin conector 3
                } // Fin conector 2
            } // Fin conector 1

            // Logica etiqueta consulta
            String variables = "";
            List<String> var = new ArrayList();
            String jlabel11b = jTextArea1.getText();
            jTextArea1.setText(jTextArea1.getText() + "?   ");
            System.out.println(" ");
            System.out.println("Consulta: " + consulta);
            System.out.println(" ");

            if (this.jComboBox3.isEnabled() == true) {
                if (this.suva1.getTipo().equals("variablep")) {
                    //variables = variables + suva1.getVariablep().getNat() + ", ";
                    if (!var.contains(suva1.getVariablep().getNat())) {
                        var.add((suva1.getVariablep().getNat()));
                    }
                }
            }
            if (this.jComboBox5.isEnabled() == true) {
                if (this.suva2.getTipo().equals("variablep")) {
                    // variables = variables + suva2.getVariablep().getNat() + ", ";
                    if (!var.contains(suva2.getVariablep().getNat())) {
                        var.add((suva2.getVariablep().getNat()));
                    }
                }
            }
            if (this.jComboBox6.isEnabled() == true) {
                if (this.suva3.getTipo().equals("variablep")) {
                    //variables = variables + suva3.getVariablep().getNat() + ", ";
                    if (!var.contains(suva3.getVariablep().getNat())) {
                        var.add((suva3.getVariablep().getNat()));
                    }
                }
            }
            if (this.jComboBox8.isEnabled() == true) {
                if (this.suva4.getTipo().equals("variablep")) {
                    //variables = variables + suva4.getVariablep().getNat() + ", ";
                    if (!var.contains(suva4.getVariablep().getNat())) {
                        var.add((suva4.getVariablep().getNat()));
                    }
                }
            }
            if (this.jComboBox9.isEnabled() == true) {
                if (this.suva5.getTipo().equals("variablep")) {
                    //variables = variables + suva5.getVariablep().getNat() + ", ";
                    if (!var.contains(suva5.getVariablep().getNat())) {
                        var.add((suva5.getVariablep().getNat()));
                    }
                }
            }
            if (this.jComboBox11.isEnabled() == true) {
                if (this.suva6.getTipo().equals("variablep")) {
                    //variables = variables + suva6.getVariablep().getNat() + ", ";
                    if (!var.contains(suva6.getVariablep().getNat())) {
                        var.add((suva6.getVariablep().getNat()));
                    }
                }
            }
            if (this.jComboBox12.isEnabled() == true) {
                if (this.suva7.getTipo().equals("variablep")) {
                    //variables = variables + suva7.getVariablep().getNat() + ", ";
                    if (!var.contains(suva7.getVariablep().getNat())) {
                        var.add((suva7.getVariablep().getNat()));
                    }
                }
            }
            if (this.jComboBox14.isEnabled() == true) {
                if (this.suva8.getTipo().equals("variablep")) {
                    // variables = variables + suva8.getVariablep().getNat() + ", ";
                    if (!var.contains(suva8.getVariablep().getNat())) {
                        var.add((suva8.getVariablep().getNat()));
                    }
                }
            }

            for (String s : var) {
                variables = variables + s + ",";
            }

            if (variables.trim().length() > 0) {
                variables = variables.substring(0, variables.length() - 1);
            }

            if (variables.trim().equals("") == false) {
                String cons = "Todos los ";
                cons = cons + variables + " tal que ...";
                jLabel12.setText(cons);
                jTextArea3.setText(jlabel11b);
            }

            boolean ban1 = false;
            boolean ban2 = false;

            // Logica imagen meme
            if (((predicado1.getTipo() == 2) && (suva1.getTipo().equals("sujeto")) && (suva2.getTipo().equals("sujeto"))) || ((predicado1.getTipo() == 2) && (suva1.getTipo().equals("sujeto") == false) && (suva2.getTipo().equals("sujeto") == false))) {

                if (suva1.getTipo().equals("sujeto") && suva1.getTipo().equals("sujeto")) {
                    if (suva1.getSujeto().getPro().equals(suva2.getSujeto().getPro())) {
                        ban1 = true;
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/ts.jpg"))); // NOI18N
                    }
                }

                if (suva1.getTipo().equals("sujeto") == false && suva2.getTipo().equals("sujeto") == false) {
                    if (suva1.getVariablep().getPro().equals(suva2.getVariablep().getPro())) {
                        ban2 = true;
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/ts.jpg"))); // NOI18N
                    }
                }

            }
            if (!ban1 && !ban2) {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/pensando.jpg"))); // NOI18N
            }
        } else {
            JOptionPane.showMessageDialog(this, "Datos insuficientes para formar una consulta!", "Atención", JOptionPane.ERROR_MESSAGE);
            Random rnd = new Random();
            int hhh = (int) (rnd.nextDouble() * 100 + 1);
            if (hhh < 50) {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/mierda.jpg"))); // NOI18N
            } else {
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/memes/FacePalm.png"))); // NOI18N
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed

    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        this.jComboBox5.setEnabled(true);
        Predicado p = new Predicado();
        p = (Predicado) jComboBox4.getSelectedItem();
        if (p.getTipo() == 1) {
            this.jComboBox5.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox4ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Model.HeRe heRe1;
    private java.util.List heres;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox13;
    private javax.swing.JComboBox jComboBox14;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox53;
    private javax.swing.JComboBox jComboBox54;
    private javax.swing.JComboBox jComboBox55;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private Model.Predicado predicado1;
    private Model.Predicado predicado2;
    private Model.Predicado predicado3;
    private Model.Predicado predicado4;
    private java.util.List predicados;
    private Model.Suva suva1;
    private Model.Suva suva2;
    private Model.Suva suva3;
    private Model.Suva suva4;
    private Model.Suva suva5;
    private Model.Suva suva6;
    private Model.Suva suva7;
    private Model.Suva suva8;
    private java.util.List suvas;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private String consulta = "";
    private String exitoMultiple = "";
    private String exito = "";
    private String errorBase = "";
    private String error = "";
    private String servicio_externo = "";
    private String url_servicio_externo = "";
    Color colors[];
    Color colors2[];
    String tools[];//C
    String tools2[];//C
    private static File archivo = null;
    private static FileReader fr = null;
    private static BufferedReader br = null;
    private static String hecho = null;

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

    private String modo = "";

    private void leerPl() {
        String codigo = new String(), path = "family.pl";
        File archivo = new File(path);

        FileReader fr = null;
        BufferedReader entrada = null;
        try {
            fr = new FileReader(path);
            entrada = new BufferedReader(fr);

            while (entrada.ready()) {
                codigo += entrada.readLine();
                codigo = codigo + "\n";
            }
            // jTextArea4.setText(codigo);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
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
            p.load(new FileInputStream("conf.ini"));
            this.setServicio_externo(p.getProperty("servicio_externo"));
            this.setUrl_servicio_externo(p.getProperty("url_servicio_externo"));
        } catch (Exception e) {
            System.out.println("Error Configuracion: " + e);
        }
    }

    // Consultar ws, si hubo respuesta sigo
    // Borro hechos externos antiguos
    // Leo archivo y escribo hechos nuevos
    private void procesarHechosExternos() {
        System.out.println("procesarHechosExternos");
        if (this.getServicio_externo().equals("SI")) {
            // Ejecutar modulo externo
            ejecutarModuloExterno();
            HechoController.getInstance().borrarAllHechoExterno();
            leer();
        }
    }

    private static void leer() {
        System.out.println("leer");
        try {
            archivo = new File("datos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            Hecho hecho1 = new Hecho();
            while ((linea = br.readLine()) != null) {
                //System.out.println("Linea: " + linea);
                hecho1 = procesarString(linea);
                HechoController.getInstance().guardar(hecho1);
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
        System.out.println("procesarString");
        String respuesta = "";
        Hecho hecho0 = new Hecho();
        String[] parts = linea.split("=");
        String part1 = parts[0]; // 123
        String part2 = parts[1]; // 654321
        String conector = "es_valor_de";
        respuesta = conector + "(" + part2 + "," + part1 + ")";
        System.out.println("Hecho: " + respuesta);
        hecho0.setPro(respuesta);
        conector = conector.replace("_", " ");
        respuesta = part2 + " " + conector + " " + part1;
        System.out.println("Hecho: " + respuesta);
        hecho0.setNat(respuesta);
        hecho0.setExterno(1);
        return hecho0;
    }

    private void ejecutarModuloExterno() {
        String urlSe = this.getUrl_servicio_externo();
        // /home/hernanbiondini/NetBeansProjects/EjecutaJarExterno/modulos_externos/WSweatherunlocked.jar
        System.out.println("url_servicio_externo: " + urlSe);//modulos_externos/WSweatherunlocked.jar
        try { 
            String path = new File(".").getCanonicalPath();
            String url = path + urlSe;
            System.out.println("url: " + url);
            String[] cmd = {"java", "-jar", url};
            Runtime.getRuntime().exec(cmd);       
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

}
