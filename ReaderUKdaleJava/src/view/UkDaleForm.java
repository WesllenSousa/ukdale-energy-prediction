package view;

import controle.arff.ArffFilter;
import controle.arff.UkDaleToARFF;
import entidades.Building;
import entidades.activities.ActivityBean;
import entidades.appliance.ApplianceBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import ukdale.metadata.building.Appliance;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import ukdale.ScriptPostgres;
import ukdale.UKDale;
import util.Database;
import util.DateUtil;
import util.Messages;

/**
 *
 * @author Wesllen Sousa
 */
public class UkDaleForm extends javax.swing.JFrame {

    private JFileChooser fileChooser = new JFileChooser();

    private Thread thread;
    private final Messages messages;

    private final UKDale uKDale;
    private Appliance appliance;

    private final ArrayList<Building> buildings;

    private String formatString = "ss";
    private String groupData = "second";

    public UkDaleForm() {
        initComponents();
        setLocationRelativeTo(null);

        uKDale = new UKDale();
        messages = new Messages();
        buildings = new ArrayList<>();

        if (uKDale.getDataSet() != null) {
            listAppliance();
            fillInformation();
            popularTabelaBuilding();
            fileChooser.setCurrentDirectory(new File(UKDale.DIR_DATASET));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupby = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        tf_contact = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tf_date = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tf_publisher = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tf_dataInit = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tf_dataEnd = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ta_descriptionDataset = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lt_appliances = new javax.swing.JList();
        jLabel23 = new javax.swing.JLabel();
        tf_nameDataset = new javax.swing.JTextField();
        cb_dataset = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        tf_institution = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tb_pane = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_room = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tf_name = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_brand = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tf_model = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tf_yearPurchace = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tf_consumption = new javax.swing.JTextField();
        tf_siteMeter = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_meter = new javax.swing.JTextField();
        tf_submeterof = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_startMeter = new javax.swing.JTextField();
        tf_endMeter = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        tf_deviceModel = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_description = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        df_dataInit = new com.toedter.calendar.JDateChooser();
        df_dataEnd = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pn_graph = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_data = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        bt_arff = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        cb_second = new javax.swing.JRadioButton();
        cb_hour = new javax.swing.JRadioButton();
        cb_day = new javax.swing.JRadioButton();
        cb_month = new javax.swing.JRadioButton();
        bt_seach = new javax.swing.JButton();
        sx_busySearch = new org.jdesktop.swingx.JXBusyLabel();
        cb_minute = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_log = new javax.swing.JTextArea();
        jPanel15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        bt_insert = new javax.swing.JButton();
        sx_busyInsert = new org.jdesktop.swingx.JXBusyLabel();
        bt_stopInsert = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UK Dale Dataset Tool");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Contact:");

        tf_contact.setEditable(false);
        tf_contact.setOpaque(false);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Updated:");

        tf_date.setEditable(false);
        tf_date.setOpaque(false);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Publisher:");

        tf_publisher.setEditable(false);
        tf_publisher.setOpaque(false);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Data init:");

        tf_dataInit.setEditable(false);
        tf_dataInit.setOpaque(false);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Data end:");

        tf_dataEnd.setEditable(false);
        tf_dataEnd.setOpaque(false);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Description:");

        ta_descriptionDataset.setEditable(false);
        ta_descriptionDataset.setColumns(20);
        ta_descriptionDataset.setLineWrap(true);
        ta_descriptionDataset.setRows(5);
        ta_descriptionDataset.setWrapStyleWord(true);
        jScrollPane4.setViewportView(ta_descriptionDataset);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tf_publisher, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_dataInit, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(tf_contact))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_date, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(tf_dataEnd)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tf_publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tf_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(tf_dataInit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(tf_dataEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Appliances"));

        lt_appliances.setAutoscrolls(false);
        lt_appliances.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lt_appliancesMouseClicked(evt);
            }
        });
        lt_appliances.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lt_appliancesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lt_appliances);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Name:");

        tf_nameDataset.setEditable(false);
        tf_nameDataset.setOpaque(false);

        cb_dataset.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "House 1", "House 2", "House 3", "House 4", "House 5" }));
        cb_dataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_datasetActionPerformed(evt);
            }
        });

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Institution:");

        tf_institution.setEditable(false);
        tf_institution.setOpaque(false);

        jButton1.setText("Uk Dale location");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_dataset, 0, 275, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nameDataset)
                            .addComponent(tf_institution)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(tf_nameDataset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(tf_institution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_dataset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Room:");

        tf_room.setEditable(false);
        tf_room.setOpaque(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Name:");

        tf_name.setEditable(false);
        tf_name.setOpaque(false);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Brand:");

        tf_brand.setEditable(false);
        tf_brand.setOpaque(false);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Model:");

        tf_model.setEditable(false);
        tf_model.setOpaque(false);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Year pucharce:");

        tf_yearPurchace.setEditable(false);
        tf_yearPurchace.setOpaque(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_name)
                    .addComponent(tf_room)
                    .addComponent(tf_brand)
                    .addComponent(tf_model)
                    .addComponent(tf_yearPurchace))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tf_brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tf_model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tf_yearPurchace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Energy"));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Consumption:");

        tf_consumption.setEditable(false);
        tf_consumption.setOpaque(false);

        tf_siteMeter.setEditable(false);
        tf_siteMeter.setOpaque(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Site meter:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Meter:");

        tf_meter.setEditable(false);
        tf_meter.setOpaque(false);

        tf_submeterof.setEditable(false);
        tf_submeterof.setOpaque(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Submeter of:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Start meter:");

        tf_startMeter.setEditable(false);
        tf_startMeter.setOpaque(false);

        tf_endMeter.setEditable(false);
        tf_endMeter.setOpaque(false);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("End meter:");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Device model:");

        tf_deviceModel.setEditable(false);
        tf_deviceModel.setOpaque(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_meter)
                    .addComponent(tf_submeterof)
                    .addComponent(tf_startMeter)
                    .addComponent(tf_endMeter)
                    .addComponent(tf_deviceModel)
                    .addComponent(tf_siteMeter)
                    .addComponent(tf_consumption))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_consumption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tf_siteMeter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tf_meter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(tf_deviceModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_submeterof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_startMeter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tf_endMeter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Description:");

        ta_description.setEditable(false);
        ta_description.setColumns(20);
        ta_description.setLineWrap(true);
        ta_description.setRows(5);
        ta_description.setWrapStyleWord(true);
        jScrollPane3.setViewportView(ta_description);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 86, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tb_pane.addTab("Detail", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Interval"));

        jLabel9.setText("Data init: ");

        jLabel10.setText("Data end: ");

        df_dataInit.setDateFormatString("dd/MM/yyyy-HH:mm:ss");

        df_dataEnd.setDateFormatString("dd/MM/yyyy-HH:mm:ss");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(df_dataInit, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(df_dataEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(df_dataInit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(df_dataEnd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));

        javax.swing.GroupLayout pn_graphLayout = new javax.swing.GroupLayout(pn_graph);
        pn_graph.setLayout(pn_graphLayout);
        pn_graphLayout.setHorizontalGroup(
            pn_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );
        pn_graphLayout.setVerticalGroup(
            pn_graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Graphic", pn_graph);

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_data.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane5.setViewportView(tb_data);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Data", jPanel16);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        bt_arff.setText("Generete ARFF File");
        bt_arff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_arffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_arff)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(bt_arff))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Group by"));

        groupby.add(cb_second);
        cb_second.setSelected(true);
        cb_second.setText("Second");
        cb_second.setOpaque(false);

        groupby.add(cb_hour);
        cb_hour.setText("Hour");
        cb_hour.setOpaque(false);

        groupby.add(cb_day);
        cb_day.setText("Day");
        cb_day.setOpaque(false);

        groupby.add(cb_month);
        cb_month.setText("Month");
        cb_month.setOpaque(false);

        bt_seach.setText("Get consumption");
        bt_seach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_seachActionPerformed(evt);
            }
        });

        groupby.add(cb_minute);
        cb_minute.setText("Minute");
        cb_minute.setOpaque(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_second)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_minute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_hour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_day)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_month)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_seach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sx_busySearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cb_second)
                .addComponent(cb_hour)
                .addComponent(cb_day)
                .addComponent(cb_month)
                .addComponent(cb_minute))
            .addComponent(bt_seach)
            .addComponent(sx_busySearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tb_pane.addTab("Data", jPanel7);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));

        ta_log.setEditable(false);
        ta_log.setColumns(20);
        ta_log.setRows(5);
        jScrollPane2.setViewportView(ta_log);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        jLabel15.setText("Insert data on PostgresSQL:");

        bt_insert.setText("Insert");
        bt_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_insertActionPerformed(evt);
            }
        });

        bt_stopInsert.setText("Stop");
        bt_stopInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_stopInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_insert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_stopInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                .addComponent(sx_busyInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(bt_insert)
                    .addComponent(bt_stopInsert))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(sx_busyInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tb_pane.addTab("Insert", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tb_pane)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tb_pane))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu2.setText("Edit");

        jMenuItem1.setText("Options");
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 958, 830);
    }// </editor-fold>//GEN-END:initComponents

    private void cb_datasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_datasetActionPerformed
        listAppliance();
    }//GEN-LAST:event_cb_datasetActionPerformed

    private void lt_appliancesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lt_appliancesKeyReleased
        fillDetail();
    }//GEN-LAST:event_lt_appliancesKeyReleased

    private void lt_appliancesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lt_appliancesMouseClicked
        fillDetail();
    }//GEN-LAST:event_lt_appliancesMouseClicked

    private void bt_seachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_seachActionPerformed
        thread = new Thread(this::carregaDadosPostgreSQL);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }//GEN-LAST:event_bt_seachActionPerformed

    private void bt_arffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_arffActionPerformed
        genereteARFFile();
    }//GEN-LAST:event_bt_arffActionPerformed

    private void bt_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_insertActionPerformed
        ScriptPostgres.STOP = false;
        thread = new Thread(this::insertInPostgresSQL);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }//GEN-LAST:event_bt_insertActionPerformed

    private void bt_stopInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_stopInsertActionPerformed
        if (thread != null) {
            ScriptPostgres.STOP = true;
        }
    }//GEN-LAST:event_bt_stopInsertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ukDaleLocation();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_arff;
    private javax.swing.JButton bt_insert;
    private javax.swing.JButton bt_seach;
    private javax.swing.JButton bt_stopInsert;
    private javax.swing.JComboBox cb_dataset;
    private javax.swing.JRadioButton cb_day;
    private javax.swing.JRadioButton cb_hour;
    private javax.swing.JRadioButton cb_minute;
    private javax.swing.JRadioButton cb_month;
    private javax.swing.JRadioButton cb_second;
    private com.toedter.calendar.JDateChooser df_dataEnd;
    private com.toedter.calendar.JDateChooser df_dataInit;
    private javax.swing.ButtonGroup groupby;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JList lt_appliances;
    private javax.swing.JPanel pn_graph;
    private org.jdesktop.swingx.JXBusyLabel sx_busyInsert;
    private org.jdesktop.swingx.JXBusyLabel sx_busySearch;
    private javax.swing.JTextArea ta_description;
    private javax.swing.JTextArea ta_descriptionDataset;
    public static javax.swing.JTextArea ta_log;
    private javax.swing.JTable tb_data;
    private javax.swing.JTabbedPane tb_pane;
    private javax.swing.JTextField tf_brand;
    private javax.swing.JTextField tf_consumption;
    private javax.swing.JTextField tf_contact;
    private javax.swing.JTextField tf_dataEnd;
    private javax.swing.JTextField tf_dataInit;
    private javax.swing.JTextField tf_date;
    private javax.swing.JTextField tf_deviceModel;
    private javax.swing.JTextField tf_endMeter;
    private javax.swing.JTextField tf_institution;
    private javax.swing.JTextField tf_meter;
    private javax.swing.JTextField tf_model;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_nameDataset;
    private javax.swing.JTextField tf_publisher;
    private javax.swing.JTextField tf_room;
    private javax.swing.JTextField tf_siteMeter;
    private javax.swing.JTextField tf_startMeter;
    private javax.swing.JTextField tf_submeterof;
    private javax.swing.JTextField tf_yearPurchace;
    // End of variables declaration//GEN-END:variables

    private void listAppliance() {
        clearFields();
        tb_pane.setSelectedIndex(0);
        tf_nameDataset.setText(uKDale.getDataSet().getName());
        tf_institution.setText(uKDale.getDataSet().getInstitution());
        DefaultListModel defaultListModel = new DefaultListModel<>();
        defaultListModel.addElement("All appliances");
        uKDale.listAppliances(cb_dataset.getSelectedIndex() + 1).stream().forEach((a) -> {
            if (!a.getOriginalName().equals("")) {
                defaultListModel.addElement(a);
            }
        });
        lt_appliances.setModel(defaultListModel);
        lt_appliances.setSelectedIndex(0);
        lt_appliances.requestFocus();
        fillDetail();
    }

    private void fillInformation() {
        tf_publisher.setText(uKDale.getDataSet().getPublisher());
        tf_date.setText(uKDale.getDataSet().getDate());
        tf_contact.setText(uKDale.getDataSet().getContact());
        tf_dataInit.setText(uKDale.getDataSet().getTimeframe().getStart());
        tf_dataEnd.setText(uKDale.getDataSet().getTimeframe().getEnd());
        ta_descriptionDataset.setText(uKDale.getDataSet().getDescription());
    }

    private void fillDetail() {
        clearFields();
        Integer building = cb_dataset.getSelectedIndex() + 1;
        String originalName = lt_appliances.getSelectedValue().toString();
        appliance = uKDale.selectAppliance(building, originalName);
        if (appliance != null) {
            tf_name.setText(appliance.getOriginalName());
            tf_room.setText(appliance.getRoom());
            tf_brand.setText(appliance.getBrand());
            tf_model.setText(appliance.getModel());
            tf_yearPurchace.setText(appliance.getYearOfPurchase().toString());
            ta_description.setText(appliance.getDescription());
            if (appliance.getNominalConsumption() != null) {
                tf_consumption.setText(appliance.getNominalConsumption().getOnPower().toString());
            }
            if (appliance.getMeter() != null) {
                tf_siteMeter.setText(appliance.getMeter().getSiteMeter().toString());
                tf_meter.setText(appliance.getMeters().get(0).toString());
                tf_deviceModel.setText(appliance.getMeter().getDeviceModel());
                tf_submeterof.setText(appliance.getMeter().getSubmeterOf().toString());
                tf_startMeter.setText(appliance.getMeter().getTimeframe().getStart());
                tf_endMeter.setText(appliance.getMeter().getTimeframe().getEnd());

                df_dataInit.setDate(DateUtil.parseDateUTC(appliance.getMeter().getTimeframe().getStart()));
                df_dataEnd.setDate(DateUtil.parseDateUTC(appliance.getMeter().getTimeframe().getEnd()));
            }
        }
    }

    private void clearFields() {
        tf_name.setText("");
        tf_room.setText("");
        tf_brand.setText("");
        tf_model.setText("");
        tf_yearPurchace.setText("");
        ta_description.setText("");
        tf_consumption.setText("");
        tf_siteMeter.setText("");
        tf_meter.setText("");
        tf_deviceModel.setText("");
        tf_submeterof.setText("");
        tf_startMeter.setText("");
        tf_endMeter.setText("");
    }

    private void carregaDadosPostgreSQL() {
        sx_busySearch.setBusy(true);

        groupData();
        mountListBuildings();
        TimeSeries data = mountTimeSeries();
        popularTabelaBuilding();

        pn_graph.removeAll();
        pn_graph.setLayout(new BorderLayout());
        pn_graph.add(generateGraphic(data), BorderLayout.CENTER);
        pn_graph.updateUI();
        sx_busySearch.setBusy(false);
    }

    private void mountListBuildings() {
        Integer building = cb_dataset.getSelectedIndex() + 1;
        Integer meter = 0;
        if (appliance != null) {
            meter = appliance.getMeters().get(0);
        }
        buildings.clear();
        if (building == 1) {
            ArrayList<Object[]> building1s = new ArrayList<>();
            if (appliance != null) {
                building1s = Database.listMeteringByIntervalBuilding1(groupData, df_dataInit.getDate(), df_dataEnd.getDate(), building, meter);
            } else {
                building1s = Database.listMeteringAllIntervalBuilding1(groupData, df_dataInit.getDate(), df_dataEnd.getDate());
            }
            for (int i = 0; i < building1s.size(); i++) {
                Building b = new Building();
                b.setDateTime((Date) building1s.get(i)[0]);
                b.setPower(((BigInteger) building1s.get(i)[1]).intValue());
                if (appliance != null) {
                    b.setMeter((Integer) building1s.get(i)[2]);
                    b.setBuilding((Integer) building1s.get(i)[3]);
                }
                buildings.add(b);
            }
        } else if (building == 2) {
            ArrayList<Object[]> building2s = new ArrayList<>();
            if (appliance != null) {
                building2s = Database.listMeteringByIntervalBuilding2(groupData, df_dataInit.getDate(), df_dataEnd.getDate(), building, meter);
            } else {
                building2s = Database.listMeteringAllIntervalBuilding2(groupData, df_dataInit.getDate(), df_dataEnd.getDate());
            }
            for (int i = 0; i < building2s.size(); i++) {
                Building b = new Building();
                b.setDateTime((Date) building2s.get(i)[0]);
                b.setPower(((BigInteger) building2s.get(i)[1]).intValue());
                if (appliance != null) {
                    b.setMeter((Integer) building2s.get(i)[2]);
                    b.setBuilding((Integer) building2s.get(i)[3]);
                }
                buildings.add(b);
            }
        } else if (building == 3) {
            ArrayList<Object[]> building3s = new ArrayList<>();
            if (appliance != null) {
                building3s = Database.listMeteringByIntervalBuilding3(groupData, df_dataInit.getDate(), df_dataEnd.getDate(), building, meter);
            } else {
                building3s = Database.listMeteringAllIntervalBuilding3(groupData, df_dataInit.getDate(), df_dataEnd.getDate());
            }
            for (int i = 0; i < building3s.size(); i++) {
                Building b = new Building();
                b.setDateTime((Date) building3s.get(i)[0]);
                b.setPower(((BigInteger) building3s.get(i)[1]).intValue());
                if (appliance != null) {
                    b.setMeter((Integer) building3s.get(i)[2]);
                    b.setBuilding((Integer) building3s.get(i)[3]);
                }
                buildings.add(b);
            }
        } else if (building == 4) {
            ArrayList<Object[]> building4s = new ArrayList<>();
            if (appliance != null) {
                building4s = Database.listMeteringByIntervalBuilding4(groupData, df_dataInit.getDate(), df_dataEnd.getDate(), building, meter);
            } else {
                building4s = Database.listMeteringAllIntervalBuilding4(groupData, df_dataInit.getDate(), df_dataEnd.getDate());
            }
            for (int i = 0; i < building4s.size(); i++) {
                Building b = new Building();
                b.setDateTime((Date) building4s.get(i)[0]);
                b.setPower(((BigInteger) building4s.get(i)[1]).intValue());
                if (appliance != null) {
                    b.setMeter((Integer) building4s.get(i)[2]);
                    b.setBuilding((Integer) building4s.get(i)[3]);
                }
                buildings.add(b);
            }
        } else if (building == 5) {
            ArrayList<Object[]> building5s = new ArrayList<>();
            if (appliance != null) {
                building5s = Database.listMeteringByIntervalBuilding5(groupData, df_dataInit.getDate(), df_dataEnd.getDate(), building, meter);
            } else {
                building5s = Database.listMeteringAllIntervalBuilding5(groupData, df_dataInit.getDate(), df_dataEnd.getDate());
            }
            for (int i = 0; i < building5s.size(); i++) {
                Building b = new Building();
                b.setDateTime((Date) building5s.get(i)[0]);
                b.setPower(((BigInteger) building5s.get(i)[1]).intValue());
                if (appliance != null) {
                    b.setMeter((Integer) building5s.get(i)[2]);
                    b.setBuilding((Integer) building5s.get(i)[3]);
                }
                buildings.add(b);
            }
        }
    }

    private void groupData() {
        if (cb_second.isSelected()) {
            formatString = "MMM/dd yyyy";
            groupData = "second";
        } else if (cb_minute.isSelected()) {
            formatString = "MMM/dd yyyy";
            groupData = "minute";
        } else if (cb_hour.isSelected()) {
            formatString = "MMM/dd yyyy";
            groupData = "hour";
        } else if (cb_day.isSelected()) {
            formatString = "MMM/dd yyyy";
            groupData = "day";
        } else {
            formatString = "MMM/dd yyyy";
            groupData = "month";
        }
    }

    private TimeSeries mountTimeSeries() {
        TimeSeries data = new TimeSeries("Consumo de Energia", Second.class);
        try {
            for (Building b : buildings) {
                data.add(new Second(b.getDateTime()), b.getPower());
            }
        } catch (SeriesException ex) {
            messages.aviso(ex.toString());
        }
        return data;
    }

    private void popularTabelaBuilding() {
        BuildingDataTableModel modelo = new BuildingDataTableModel(buildings);
        tb_data.setModel(modelo);
        formataTabela();
    }

    private void formataTabela() {
        tb_data.getColumnModel().getColumn(0).setPreferredWidth(200);
        tb_data.getColumnModel().getColumn(1).setPreferredWidth(100);
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
        tb_data.getColumnModel().getColumn(0).setCellRenderer(rendererEsquerda);
        tb_data.getColumnModel().getColumn(1).setCellRenderer(rendererCentro);
    }

    private JPanel generateGraphic(TimeSeries dados) {
        String name = "house";
        if (appliance != null) {
            name = appliance.getOriginalName();
        }
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(dados);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Consumo de Energia do " + name,
                "", // x-axis Label
                "Watts", // y-axis Label 
                dataset, // Dataset
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );
        XYPlot plot = chart.getXYPlot();
        plot.setOutlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.white);
        //plot.setDomainCrosshairVisible(true);

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setDateFormatOverride(new SimpleDateFormat(formatString));

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDomainZoomable(true);
        return chartPanel;
    }

    private void insertInPostgresSQL() {
        ta_log.setText("");
        bt_insert.setEnabled(false);
        sx_busyInsert.setBusy(true);
        lt_appliances.setEnabled(false);
        cb_dataset.setEnabled(false);

        int buildingID = cb_dataset.getSelectedIndex() + 1;
        int meter = appliance.getMeters().get(0);
        if (appliance.getMeter() != null) {
            ScriptPostgres.checkBuilding(appliance, buildingID, meter);
        }

        bt_insert.setEnabled(true);
        sx_busyInsert.setBusy(false);
        lt_appliances.setEnabled(true);
        cb_dataset.setEnabled(true);
    }

    private static void log(String msg) {
        //System.out.println(msg);
        ta_log.setText(ta_log.getText() + "\n" + msg);
    }

    private void genereteARFFile() {
        fileChooser.addChoosableFileFilter(new ArffFilter());
        fileChooser.setAcceptAllFileFilterUsed(false);

        Integer retorno = fileChooser.showDialog(this, "Salvar");
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String dir = fileChooser.getSelectedFile().getParent();
            String nameFile = fileChooser.getSelectedFile().getName();
            fileChooser.setCurrentDirectory(new File(dir));

            UkDaleToARFF arff = new UkDaleToARFF();
            ArrayList<String> attributes = new ArrayList<>();
            attributes.add("timestamp");
            attributes.add("power");
            try {
                arff.listUkDaleToARFF(dir, nameFile, attributes, buildings);
            } catch (IOException ex) {
                messages.bug(ex.toString());
            }
        }
    }

    private void ukDaleLocation() {
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        Integer retorno = fileChooser.showDialog(this, "Choose");
        if (retorno == JFileChooser.OPEN_DIALOG) {
            String dir = fileChooser.getSelectedFile().getAbsolutePath();
            UKDale.DIR_DATASET = dir + File.separator;
            fileChooser.setCurrentDirectory(new File(dir));
            if (uKDale.getDataSet() != null) {
                listAppliance();
                fillInformation();
                popularTabelaBuilding();
            }
        }
    }

}
