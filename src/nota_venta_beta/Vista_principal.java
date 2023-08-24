package nota_venta_beta;

import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.io.IOException;
import pojos.Notas_objetos;
import static java.lang.Double.parseDouble;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Vista_principal extends javax.swing.JFrame {

    TablaMetodos tabla = new TablaMetodos();
    Calendar c = new GregorianCalendar();
    Notas_objetos Datos;
    /* para agregar otros servicios */
    Object[][] data = {};
    String[] columnNames = {"Folio", "Servicio", "Kilos", "Precio", "Total", "Fecha Entrega", "Elimnar"};
    DefaultTableModel  model = new DefaultTableModel(data, columnNames);
    List<Notas_objetos>  lista = new ArrayList<Notas_objetos>();
    CRUDNotas objeto_notas = new CRUDNotas();

    public void limpiarBoton(){
        btnPDF.setEnabled(false);
        btnCSV.setEnabled(false);
        lista = new ArrayList<Notas_objetos>();
        tbRegistrosOrdenes.setModel(new DefaultTableModel(data, columnNames));
         model = new DefaultTableModel(data, columnNames);
        jComboServiciosOtrosServicios.setSelectedItem(0);
        txtNombre.setEditable(true);
        lista.removeAll(lista);
        txtServicioOtros.setText("");
    }
    
    public Vista_principal() throws SQLException {
        initComponents();

        btnPDF.setEnabled(false);
        btnCSV.setEnabled(false);
        lblOtros.setVisible(false);
        txtServicioOtros.setVisible(false);
        tbRegistros.setModel(tabla.CargarDatos(txtbuscar.getText()));
        setLocationRelativeTo(null);
        tbRegistros.setEnabled(false);
        tbRegistrosOrdenes.setEnabled(false);
        Redimencionar();
        lblFecha.setText(Fecha());
        renderisar();
    }

    public void renderisar() {
        tbRegistros.getColumnModel().getColumn(9).setCellRenderer(new ColorCelda());
        tbRegistros.getColumnModel().getColumn(10).setCellRenderer(new ColorCelda());
        tbRegistros.getColumnModel().getColumn(11).setCellRenderer(new ColorCelda());
    }

    public void limpiarCamposOtrosServicios() {
        txtkilo.setText("");
        txtprecio.setText("");
        txtTotal.setText("");
        txtComentarios.setText("");

    }

    public void limpiarTodo() {

        lblfolioActual.setText("folio");
        txtNombre.setText("");
        txtkilo.setText("");
        txtprecio.setText("");
        txtTotal.setText("");
        txtComentarios.setText("");

    }

    public void GenerarFolio(String Cliente) {
        String[] arrSplit_3 = Cliente.split("\\ s");
        String folio = "F_" + arrSplit_3[0] + "0" + (int) (Math.random() * 25);
        lblfolioActual.setText(folio);
    }

    public String Fecha() {
        Date d = new Date();
        c.setTime(d);
        String fecha = fecha = c.get(Calendar.DATE) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.YEAR);
        
        if ((c.get(Calendar.MONTH) + 1)<10 && c.get(Calendar.DATE)<10) {
             fecha = "0"+c.get(Calendar.DATE) + "-" + "0"+(c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.YEAR);
        }else{
           if (c.get(Calendar.DATE)<10) {
         fecha = "0"+c.get(Calendar.DATE) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.YEAR);
        }else{
               if ((c.get(Calendar.MONTH) + 1)<10) {
             fecha = c.get(Calendar.DATE) + "-" + "0"+(c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.YEAR);
        } 
           } 
        }
        
        
        
       
        
        
        
        return fecha;
    }

    public Notas_objetos Datos() {
        try {
            String Cliente = txtNombre.getText();
            Double Kilo = parseDouble(txtkilo.getText());
            Double Precio = parseDouble(txtprecio.getText());
            String servicio = (String) jComboServiciosOtrosServicios.getSelectedItem();
            txtTotal.setText((Math.round((Kilo * Precio) * 100.0) / 100.0) + "");
            // Calendar c = new GregorianCalendar();
            c.setTime(jdateEntregaPedido.getDate());
            String fechaEntrega = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE);
            String Comentario = txtComentarios.getText();
            String folio = lblfolioActual.getText();

            if ("Otros".equals(servicio)) {
                servicio = txtServicioOtros.getText();
            }
            Datos = new Notas_objetos(folio, Cliente, servicio, Kilo, Precio, parseDouble(txtTotal.getText()), fechaEntrega, Comentario);
            System.out.println("Entre en datos ");
            return Datos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Faltan Datos por llenar o en Rojo");

        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbltotal3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRegistros = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        lblkilos = new javax.swing.JLabel();
        txtkilo = new javax.swing.JTextField();
        lblprecio = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        lbltotal = new javax.swing.JLabel();
        btnCSV = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        lbltotal1 = new javax.swing.JLabel();
        lbltotal2 = new javax.swing.JLabel();
        jdateEntregaPedido = new com.toedter.calendar.JDateChooser();
        lblfolioActual = new javax.swing.JLabel();
        lblFolio = new javax.swing.JLabel();
        lbltotal4 = new javax.swing.JLabel();
        jComboServiciosOtrosServicios = new javax.swing.JComboBox<>();
        lblkilos4 = new javax.swing.JLabel();
        lblOtros = new javax.swing.JLabel();
        txtServicioOtros = new javax.swing.JTextField();
        btnAgregarLista_Otros_Servicios1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        lblNombre2 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lbltotal5 = new javax.swing.JLabel();
        lbltotal6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRegistrosOrdenes = new javax.swing.JTable();
        btnLimpiarRegistros = new javax.swing.JButton();

        lbltotal3.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lbltotal3.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal3.setText("Total:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tbRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRegistros.setToolTipText("\n");
        tbRegistros.setPreferredSize(new java.awt.Dimension(700, 264));
        tbRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbRegistros);

        jPanel2.setBackground(new java.awt.Color(133, 206, 242));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generar Nota", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                validar_Panel(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 133, 204)));
        txtNombre.setMinimumSize(new java.awt.Dimension(26, 26));

        txtTotal.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        txtTotal.setToolTipText("Generear total en automatico con un clic");
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 133, 204)));
        txtTotal.setMinimumSize(new java.awt.Dimension(26, 26));
        txtTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTotalMousePressed(evt);
            }
        });

        lblkilos.setBackground(new java.awt.Color(255, 255, 255));
        lblkilos.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lblkilos.setForeground(new java.awt.Color(255, 255, 255));
        lblkilos.setText("Kilos, Pares, Piezas:");
        lblkilos.setToolTipText("Kilos, pares, piezas");

        txtkilo.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        txtkilo.setToolTipText("Kilos, pares, piezas");
        txtkilo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 133, 204)));
        txtkilo.setMinimumSize(new java.awt.Dimension(26, 26));

        lblprecio.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lblprecio.setForeground(new java.awt.Color(255, 255, 255));
        lblprecio.setText("Precio:");
        lblprecio.setToolTipText("Precio");

        txtprecio.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        txtprecio.setToolTipText("Precio");
        txtprecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 133, 204)));
        txtprecio.setMinimumSize(new java.awt.Dimension(26, 26));

        lbltotal.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lbltotal.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal.setText("Total:");
        lbltotal.setToolTipText("Total");

        btnCSV.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnCSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/n.png"))); // NOI18N
        btnCSV.setText("Generar Nota");
        btnCSV.setToolTipText("Se puede  dar clic aquí cuando se captura un solo servio o bien despues de tener una lista de servicios creada");
        btnCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSVActionPerformed(evt);
            }
        });

        btnPDF.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/d.png"))); // NOI18N
        btnPDF.setText("Generar PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblFecha.setText("Fecha");

        lbltotal1.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lbltotal1.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal1.setText("Fecha:");

        lbltotal2.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lbltotal2.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal2.setText("Fecha de Entrega:");
        lbltotal2.setToolTipText("Fecha de Entrega");

        jdateEntregaPedido.setToolTipText("Fecha de Entrega");
        jdateEntregaPedido.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N

        lblfolioActual.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lblfolioActual.setForeground(new java.awt.Color(51, 51, 51));
        lblfolioActual.setText("F0001");

        lblFolio.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lblFolio.setForeground(new java.awt.Color(255, 255, 255));
        lblFolio.setText("Folio:");

        lbltotal4.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lbltotal4.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal4.setText("Comentarios:");
        lbltotal4.setToolTipText("Comentarios");

        jComboServiciosOtrosServicios.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jComboServiciosOtrosServicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ropa", "Cobertores", "Tintoreria", "Calzado", "Costura", "Otros" }));
        jComboServiciosOtrosServicios.setToolTipText("Ropa,\nCobertores,\nTintoreria,\nCalzado,\nCostura,\nOtros\n");
        jComboServiciosOtrosServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboServiciosOtrosServiciosActionPerformed(evt);
            }
        });

        lblkilos4.setBackground(new java.awt.Color(255, 255, 255));
        lblkilos4.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lblkilos4.setForeground(new java.awt.Color(255, 255, 255));
        lblkilos4.setText("Servicios:");

        lblOtros.setBackground(new java.awt.Color(255, 255, 255));
        lblOtros.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lblOtros.setForeground(new java.awt.Color(255, 255, 255));
        lblOtros.setText("Otros:");

        txtServicioOtros.setEditable(false);
        txtServicioOtros.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        txtServicioOtros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 133, 204)));
        txtServicioOtros.setMinimumSize(new java.awt.Dimension(26, 26));

        btnAgregarLista_Otros_Servicios1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAgregarLista_Otros_Servicios1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/agregar.png"))); // NOI18N
        btnAgregarLista_Otros_Servicios1.setText("Agregar");
        btnAgregarLista_Otros_Servicios1.setToolTipText("Permite agregar 1 o mas servicios en una misma nota para despues dar clic en Generar Nota");
        btnAgregarLista_Otros_Servicios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLista_Otros_Servicios1ActionPerformed(evt);
            }
        });

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        jScrollPane3.setViewportView(txtComentarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(lbltotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jdateEntregaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbltotal2)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblprecio)
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtkilo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addComponent(lblfolioActual))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblkilos4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboServiciosOtrosServicios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addComponent(lbltotal1)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblFecha))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtServicioOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnAgregarLista_Otros_Servicios1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnPDF, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbltotal4)
                    .addComponent(lblkilos)
                    .addComponent(lblFolio))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFecha)
                        .addComponent(lbltotal1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblfolioActual)
                            .addComponent(lblFolio))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblkilos4)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboServiciosOtrosServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtServicioOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(lblkilos)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblprecio)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbltotal2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdateEntregaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(lbltotal4)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarLista_Otros_Servicios1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtkilo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblNombre2.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lblNombre2.setText("Buscar Folio o Nombre:");

        txtbuscar.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        txtbuscar.setToolTipText("Permite buscar una nota por el numero de Folio o NOMBRE de la persona dando enter o clic en el botón Buscar");
        txtbuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 133, 204)));
        txtbuscar.setMinimumSize(new java.awt.Dimension(26, 26));
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lupa.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lbltotal5.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lbltotal5.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal5.setText("Entregas:");

        lbltotal6.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        lbltotal6.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal6.setText("Ordenes:");

        tbRegistrosOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRegistrosOrdenes.setPreferredSize(new java.awt.Dimension(400, 264));
        tbRegistrosOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRegistrosOrdenesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbRegistrosOrdenes);

        btnLimpiarRegistros.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLimpiarRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/datos_clean.png"))); // NOI18N
        btnLimpiarRegistros.setText("Limpiar Registros");
        btnLimpiarRegistros.setToolTipText("Permite limpiar todo para capturar uno o lista de servicios");
        btnLimpiarRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarRegistrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbltotal5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(lblNombre2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(lbltotal6)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiarRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(170, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre2)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotal5)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbltotal6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnLimpiarRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane2.addTab("Servicios-Lavandería", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        //        TablaMetodos tabla2 = new TablaMetodos();
        tbRegistros.setModel(tabla.CargarDatos(txtbuscar.getText()));
        tbRegistros.getColumnModel().getColumn(9).setCellRenderer(new ColorCelda());
        tbRegistros.getColumnModel().getColumn(10).setCellRenderer(new ColorCelda());
        tbRegistros.getColumnModel().getColumn(11).setCellRenderer(new ColorCelda());
        Redimencionar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void validar_Panel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_validar_Panel
        Validacion valida = new Validacion();

        String valido = valida.validacionNumeros(txtprecio.getText());
        if ("No".equals(valido)) {
            txtprecio.setBackground(Color.red);
        } else {
            txtprecio.setBackground(Color.white);
        }
        String valido1 = valida.validacionNumeros(txtkilo.getText());
        if ("No".equals(valido1)) {
            txtkilo.setBackground(Color.RED);
        } else {
            txtkilo.setBackground(Color.white);
        }
        String valido2 = valida.validacionTextos(txtNombre.getText());
        if ("No".equals(valido2)) {
            txtNombre.setBackground(Color.red);
        } else {
            txtNombre.setBackground(Color.white);
        }
    }//GEN-LAST:event_validar_Panel


    private void btnAgregarLista_Otros_Servicios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLista_Otros_Servicios1ActionPerformed
        // TODO add your handling code here:        
        btnPDF.setEnabled(true);
        txtNombre.setEditable(false);
//      Calendar c = new GregorianCalendar();
        c.setTime(jdateEntregaPedido.getDate());
        String fechaEntrega = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE);
        // Add a new row to the table
        String servicio = (String) jComboServiciosOtrosServicios.getSelectedItem();
        if ("Otros".equals(servicio)) {
            servicio = txtServicioOtros.getText();
        }
        lista.add(Datos());
        System.out.println("tamaño de lista"+ lista.size());
        
        model.addRow(new Object[]{lblfolioActual.getText(), servicio, txtkilo.getText(), txtprecio.getText(), txtTotal.getText(), fechaEntrega, "Eliiminar"});
        tbRegistrosOrdenes.setModel(model);
        limpiarCamposOtrosServicios();

    }//GEN-LAST:event_btnAgregarLista_Otros_Servicios1ActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        btnCSV.setEnabled(true);
        CrearPDF obj = new CrearPDF();
          if (lista.size() > 0) {
            try {
                obj.crearPDFLista(lista, Fecha());
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(Vista_principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                obj.crearPDF(Datos(), Fecha());
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(Vista_principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            recargarTabla();
            lblfolioActual.setText("folio");
            txtNombre.setText("");
            txtkilo.setText("");
            txtprecio.setText("");
            txtTotal.setText("");
            txtComentarios.setText("");
        }
        System.out.println("Listo el PDF");
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSVActionPerformed
       // lista = new ArrayList<Notas_objetos>();
        
        CrearCSV obj = new CrearCSV();
        if (lista.size() > 0) {
            obj.NotaLista(lista, Fecha());
        } else {
            obj.Notas(Datos(), Fecha());
            recargarTabla();
            lblfolioActual.setText("folio");
            txtNombre.setText("");
            txtkilo.setText("");
            txtprecio.setText("");
            txtTotal.setText("");
            txtComentarios.setText("");
        }
         model = new DefaultTableModel(data, columnNames);
        tbRegistrosOrdenes.setModel(new DefaultTableModel(data, columnNames));
        jComboServiciosOtrosServicios.setSelectedItem(0);
        txtNombre.setEditable(true);
        limpiarTodo();
        limpiarBoton();
    }//GEN-LAST:event_btnCSVActionPerformed

    private void txtTotalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTotalMousePressed
        // TODO add your handling code here:
       // lista = new ArrayList<Notas_objetos>();
        txtTotal.setText(Datos().getTotal() + "");
        String str2 = String.format("%.2f", parseDouble(txtprecio.getText()));
        txtprecio.setText(str2);
        String str3 = String.format("%.2f", parseDouble(txtkilo.getText()));
        txtkilo.setText(str3);
        if (lista.isEmpty()) {
            GenerarFolio(txtNombre.getText());
        }
    }//GEN-LAST:event_txtTotalMousePressed

    private void tbRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRegistrosMouseClicked
        int columna = tbRegistros.columnAtPoint(evt.getPoint());
        String id = String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 0));
        String folio = String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 1));
        String persona = String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 2));
        String servicios = String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 3));
        String kilos = String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 4));
        String precios = String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 5));
        String total = String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 6));
        String comentario = String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 7));
        String fechaLlegada = String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 8));
        String fechaEntrega = String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 9));

        if (columna >= 0 && columna <= 8) {
            JOptionPane.showMessageDialog(null, "Datos de la Nota. \n " + "Id: " + id + "\n Folio: " + folio + "\n Persona: " + persona + "\n Servicios: " + servicios + "\n Kilos: " + kilos + "\n Precios: " + precios + "\n Total: " + total + "\n Comentarios: " + comentario + "\n Fecha Llegada: " + fechaLlegada + "\n Fecha Entrega: " + fechaEntrega);
        }

        if (columna == 9) {
            int input = JOptionPane.showConfirmDialog(null, "ENTREGAR PEDIDO " + folio, "Entregar Ropa", JOptionPane.ERROR_MESSAGE);
            if (input == 0) {

                try {
                    // System.out.println("Se Entrego Pedido " + );
                    objeto_notas.EntregarPedido(folio);
                    recargarTabla();
                } catch (SQLException ex) {
                    Logger.getLogger(Vista_principal.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        if (columna == 10) {
            int input = JOptionPane.showConfirmDialog(null, "Quieres reimprimir la Nota de " + persona, "Reimprimir Nota", JOptionPane.ERROR_MESSAGE);
            // 0=yes, 1=no, 2=cancel
            if (input == 0) {
                //generamos pdf nuevamente
                CrearPDF obj = new CrearPDF();
//                Notas_objetos reimprimirObjeto = new Notas_objetos();
//                //falta mandar objeto bien
//                reimprimirObjeto.setFolio(String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 0)));
//                reimprimirObjeto.setNombre(String.valueOf(tbRegistros.getValueAt(tbRegistros.rowAtPoint(evt.getPoint()), 1)));
               try {
                    CRUDNotas objCargarNotas = new CRUDNotas();
                    System.out.println("va el folio " +folio);
                    obj.crearPDFLista(objCargarNotas.CargarNotas(folio), Fecha());
                } catch (DocumentException | IOException | SQLException ex) {
                    Logger.getLogger(Vista_principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Listo el PDF");
            }
        }
        if (columna == 11) {

            int input = JOptionPane.showConfirmDialog(null, "Seguro de eliminar el registro de " + persona, "Eliminar Registro", JOptionPane.ERROR_MESSAGE);
            // 0=yes, 1=no, 2=cancel
            if (input == 0) {
                String name = JOptionPane.showInputDialog(null, "Ingrese contraseña de confirmación");
                if ("1234".equals(name)) {
                    //entramos a eliminar y recargar tabla

                    try {
                        objeto_notas.EliminarRegistro(folio,servicios);
                        recargarTabla();
                    } catch (SQLException ex) {
                        Logger.getLogger(Vista_principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña No valida");
                }
            }
        }
    }//GEN-LAST:event_tbRegistrosMouseClicked

    private void jComboServiciosOtrosServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboServiciosOtrosServiciosActionPerformed
        // TODO add your handling code here:
        if (jComboServiciosOtrosServicios.getSelectedItem() == "Otros") {
            System.out.println("entre en otros");
            lblOtros.setVisible(true);
            txtServicioOtros.setVisible(true);
            txtServicioOtros.setEditable(true);
        } else {
            lblOtros.setVisible(false);
            txtServicioOtros.setVisible(false);
            txtServicioOtros.setEditable(false);
        }
    }//GEN-LAST:event_jComboServiciosOtrosServiciosActionPerformed

    private void tbRegistrosOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRegistrosOrdenesMouseClicked
        // TODO add your handling code here:
        String descrpcion = "<html>Enlista todos los servicios de un cliente en una misma  nota.<br>"
                + "*Para visualizar los detalles damos clic en alguno de los registros. <br>"
                + "Si se quiere eliminar alguno damos clic en ELIMINAR y confirmamos. <br> "
                + "Para guardar la nota damos clic en <strong>GENERAR NOTA </strong>.</html>";
        tbRegistrosOrdenes.setToolTipText(descrpcion);
        if (lista.size() > 0) {

            int columna = tbRegistrosOrdenes.columnAtPoint(evt.getPoint());
            int row = tbRegistrosOrdenes.rowAtPoint(evt.getPoint());
            System.out.println("column lista "+ columna + "row lista " + row);
            String servicio = String.valueOf(tbRegistrosOrdenes.getValueAt(tbRegistrosOrdenes.rowAtPoint(evt.getPoint()), 1));
            if (columna >= 0 && columna < 6) {
                JOptionPane.showMessageDialog(null, "Datos de la Nota. \n " + "\n Folio: " + lista.get(row).getFolio() + "\n Persona: " + lista.get(row).getNombre() + "\n Kilos: " + lista.get(row).getKilo()
                        + "\n Precios: " + lista.get(row).getPrecio() + "\n Total: " + lista.get(row).getTotal() + "\n Comentarios: " + lista.get(row).getComentario() + "\n Fecha Llegada: " + lblFecha.getText()
                        + "\n Fecha Entrega: " + lista.get(row).getFechaEntrega());
            } else {
                int input = JOptionPane.showConfirmDialog(null, "Seguro de eliminar el registro de " + servicio, "Eliminar Registro", JOptionPane.ERROR_MESSAGE);
                // 0=yes, 1=no, 2=cancel
                if (input == 0) {
                    lista.remove(tbRegistrosOrdenes.rowAtPoint(evt.getPoint()));
                    model.removeRow(tbRegistrosOrdenes.rowAtPoint(evt.getPoint()));
                }
            }
        }
    }//GEN-LAST:event_tbRegistrosOrdenesMouseClicked

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        tbRegistros.setModel(tabla.CargarDatos(txtbuscar.getText()));
        renderisar();
        Redimencionar();
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnLimpiarRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarRegistrosActionPerformed
limpiarBoton(); 
        limpiarTodo();

    }//GEN-LAST:event_btnLimpiarRegistrosActionPerformed
    private void Redimencionar() {

        tbRegistros.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbRegistros.getColumnModel().getColumn(1).setPreferredWidth(350);
        tbRegistros.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbRegistros.getColumnModel().getColumn(3).setPreferredWidth(250);
        tbRegistros.getColumnModel().getColumn(8).setPreferredWidth(410);
        tbRegistros.getColumnModel().getColumn(9).setPreferredWidth(390);
        tbRegistros.getColumnModel().getColumn(10).setPreferredWidth(350);
        tbRegistros.getColumnModel().getColumn(11).setPreferredWidth(250);
        //tbRegistros.setPreferredSize();
        String prueba = "<html> Tabla de Entregas en la que se puede: <br>"
                + "*Dar clic sobre un registro para visualizar toda la información <br>"
                + "*Dar clic en la columna ENTREGAR para hacer entrega del pedido y este se quite de la lista <br>"
                + "Los colores nos dice: <br>"
                + "- AMARILLO: Tenemos tiempo para realizar la actividad <br>"
                + "- VERDE: Hoy se entregara el pedido. <br>"
                + "- ROJO: Se tiene atraso en la entrega o no pasarón por ella aún. <br>"
                + "REIMPRIMIR: permite reimprimir la nota en la que hacemos clic <br>"
                + "ELIMINAR:  Permite eliminar una nota pero esta requiere contraseña de confirmación. <br>"
                + "</html> ";
        tbRegistros.setToolTipText(prueba);

    }

    public void recargarTabla() {
        tbRegistros.setModel(tabla.CargarDatos(txtbuscar.getText()));
        renderisar();
        Redimencionar();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Vista_principal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Vista_principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarLista_Otros_Servicios1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCSV;
    private javax.swing.JButton btnLimpiarRegistros;
    private javax.swing.JButton btnPDF;
    private javax.swing.JComboBox<String> jComboServiciosOtrosServicios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private com.toedter.calendar.JDateChooser jdateEntregaPedido;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblOtros;
    private javax.swing.JLabel lblfolioActual;
    private javax.swing.JLabel lblkilos;
    private javax.swing.JLabel lblkilos4;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JLabel lbltotal1;
    private javax.swing.JLabel lbltotal2;
    private javax.swing.JLabel lbltotal3;
    private javax.swing.JLabel lbltotal4;
    private javax.swing.JLabel lbltotal5;
    private javax.swing.JLabel lbltotal6;
    private javax.swing.JTable tbRegistros;
    private javax.swing.JTable tbRegistrosOrdenes;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtServicioOtros;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtkilo;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables

}
