package com.uchith.trafficsimulator.main;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.uchith.trafficsimulator.component.Vehicle;
import com.uchith.trafficsimulator.service.JMSService;
import com.uchith.trafficsimulator.util.TrafficController;
import com.uchith.trafficsimulator.util.VehicleUtil;
import com.uchith.trafficsimulator.util.enums.Direction;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author uchithvihanga
 */
public class Simiulator extends javax.swing.JFrame {
    
    private final JMSService jMSService;

    public Simiulator() {
        jMSService = new JMSService();
        initComponents();
        start();
        jMSService.start();
    }
    
    
    private void start(){
        
        new TrafficController(this).control();
        
        //LEFT
        new Timer(6000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehicle vehicle = new Vehicle(jPanel2.getLocation().y, 0);
                Direction[] directions = {Direction.BOTTOM,Direction.RIGHT,Direction.TOP};
                Direction d = directions[new Random().nextInt(directions.length)];
                
                vehicle.setDirection(d);
                jPanel12.add(vehicle);
                vehicle.init();
                VehicleUtil util = new VehicleUtil(vehicle);
                int time = util.move();
                
                double speed;

                try {
                    speed = getCanvas().getWidth() / time;
                } catch (ArithmeticException ex) {
                    speed = 1;
                }
                
                HashMap<String, String> map = new HashMap<>();
                map.put("speed", String.valueOf(speed));
                map.put("description", createDescription(Direction.LEFT, d));
                
                jMSService.addToQueue(map);
            }
        
        }).start();
        
        //RIGHT
        new Timer(6000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehicle vehicle = new Vehicle(jPanel2.getLocation().y+(jPanel2.getHeight() - 70),getWidth());
                
                Direction[] directions = {Direction.BOTTOM, Direction.LEFT, Direction.TOP};
                Direction d = directions[new Random().nextInt(directions.length)];
                
                vehicle.setDirection(d);
                jPanel12.add(vehicle);
                vehicle.init();
                VehicleUtil util = new VehicleUtil(vehicle);
                int time = util.move();

                double speed;

                try {
                    speed = getCanvas().getWidth() / time;
                } catch (ArithmeticException ex) {
                    speed = 1;
                }
                
                HashMap<String, String> map = new HashMap<>();
                map.put("speed", String.valueOf(speed));
                map.put("description", createDescription(Direction.RIGHT, d));

                jMSService.addToQueue(map);
                
            }

        }).start();
        
        //TOP
        new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehicle vehicle = new Vehicle(0, jPanel3.getX());
                
                Direction[] directions = {Direction.BOTTOM, Direction.RIGHT, Direction.LEFT};
                Direction d = directions[new Random().nextInt(directions.length)];

                vehicle.setDirection(d);
                jPanel12.add(vehicle);
                vehicle.init();
                VehicleUtil util = new VehicleUtil(vehicle);
                int time = util.move();

                double speed;
                
                try {
                    speed = getCanvas().getHeight()/ time;
                } catch (ArithmeticException ex) {
                    speed = 1;
                }
                
                HashMap<String, String> map = new HashMap<>();
                map.put("speed", String.valueOf(speed));
                map.put("description", createDescription(Direction.TOP, d));

                jMSService.addToQueue(map);
                
            }

        }).start();
        
        //BOTTOM
        new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vehicle vehicle = new Vehicle(jPanel12.getHeight(), getWidth() / 2);
                
                Direction[] directions = {Direction.LEFT, Direction.RIGHT, Direction.TOP};
                Direction d = directions[new Random().nextInt(directions.length)];

                vehicle.setDirection(d);
                jPanel12.add(vehicle);
                vehicle.init();
                VehicleUtil util = new VehicleUtil(vehicle);
                int time = util.move();
                
                double speed;

                try {
                    speed = getCanvas().getHeight() / time;
                } catch (ArithmeticException ex) {
                    speed = 1;
                }
                
                HashMap<String, String> map = new HashMap<>();
                map.put("speed", String.valueOf(speed));
                map.put("description", createDescription(Direction.BOTTOM, d));

                jMSService.addToQueue(map);
                
            }

        }).start();
    }
    
    private String createDescription(Direction start, Direction end){
        
        String startedSide = "";
        String finishedSide = "";
        
        switch (start) {
            case BOTTOM:
                startedSide += "South";
                break;
            case TOP:
                startedSide += "North";
                break;
            case LEFT:
                startedSide += "Left";
                break;
            case RIGHT:
                startedSide += "Right";
                break;
        }
        
        switch (end) {
            case BOTTOM:
                finishedSide += "South";
                break;
            case TOP:
                finishedSide += "North";
                break;
            case LEFT:
                finishedSide += "Left";
                break;
            case RIGHT:
                finishedSide += "Right";
                break;
        }
        
        return "Started from "+startedSide+" and finished from "+finishedSide;
        
    }
    
    public JPanel getPanelLeft(){
        return jPanel5;
    }
    public JPanel getPanelRight() {
        return jPanel4;
    }
    public JPanel getPanelTop() {
        return jPanel7;
    }
    public JPanel getPanelBottom() {
        return jPanel6;
    }
    
    public JPanel getCanvas(){
        return jPanel12;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Traffic Simulator");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel12.setBackground(new java.awt.Color(51, 102, 255));
        jPanel12.setOpaque(false);
        jPanel12.setLayout(null);
        jPanel1.add(jPanel12);
        jPanel12.setBounds(0, 0, 1080, 630);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        jPanel4.setPreferredSize(new java.awt.Dimension(11, 80));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(610, 80, 11, 80);

        jPanel5.setPreferredSize(new java.awt.Dimension(11, 80));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(439, 0, 11, 80);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel13);
        jPanel13.setBounds(110, 70, 160, 10);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel14);
        jPanel14.setBounds(790, 80, 160, 10);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel15);
        jPanel15.setBounds(980, 80, 100, 10);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel16);
        jPanel16.setBounds(610, 80, 160, 10);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel17);
        jPanel17.setBounds(290, 70, 160, 10);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel18);
        jPanel18.setBounds(0, 70, 90, 10);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 240, 1080, 160);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(null);

        jPanel6.setPreferredSize(new java.awt.Dimension(80, 11));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6);
        jPanel6.setBounds(80, 400, 80, 11);

        jPanel8.setPreferredSize(new java.awt.Dimension(11, 100));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8);
        jPanel8.setBounds(72, 0, 11, 100);

        jPanel7.setPreferredSize(new java.awt.Dimension(80, 11));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7);
        jPanel7.setBounds(0, 229, 83, 11);

        jPanel9.setPreferredSize(new java.awt.Dimension(11, 100));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel9);
        jPanel9.setBounds(72, 130, 11, 100);

        jPanel10.setPreferredSize(new java.awt.Dimension(11, 100));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel10);
        jPanel10.setBounds(80, 410, 11, 100);

        jPanel11.setPreferredSize(new java.awt.Dimension(11, 100));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel11);
        jPanel11.setBounds(80, 530, 11, 100);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(450, 0, 160, 630);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel1.setText("<html>&#x2191;</html>");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(610, 160, 35, 50);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel2.setText("<html>&#x2192;</html>");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(650, 210, 50, 30);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel3.setText("<html>&#x2193;</html>");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(410, 430, 35, 50);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel4.setText("<html>&#x2190;</html>");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(360, 400, 50, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatIntelliJLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simiulator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}