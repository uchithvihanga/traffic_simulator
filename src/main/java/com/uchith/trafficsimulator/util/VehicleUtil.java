package com.uchith.trafficsimulator.util;

import com.uchith.trafficsimulator.component.Vehicle;
import com.uchith.trafficsimulator.main.Simiulator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class VehicleUtil {

    private final Vehicle vehicle;
    private final int[] startLocation;
    private final Simiulator simiulator;

    public VehicleUtil(Vehicle vehicle) {
        this.vehicle = vehicle;
        startLocation = new int[2];
        startLocation[0] = vehicle.getLatitude();
        startLocation[1] = vehicle.getLongitude();
        simiulator = (Simiulator) vehicle.getParent().getParent().getParent().getParent().getParent().getParent();
    }

    public int move() {
        
        int time = new Random().nextInt(100);
        
        new Timer(time, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (startLocation[0] == 0) {
                    //Vehical that start on left
                    switch (vehicle.getDirection()) {
                        case TOP:
                            if (!(simiulator.getPanelLeft().getX() == (vehicle.getLatitude() + 70) && simiulator.getPanelLeft().getBackground().getRGB() == Color.RED.getRGB())) {
                                if (((simiulator.getWidth() / 2)) > vehicle.getLatitude()) {
                                    int i = vehicle.getLatitude() + 1;
                                    vehicle.setLocation(i, vehicle.getLongitude());
                                    vehicle.setLatitude(i);
                                } else {
                                    vehicle.setIcon(new ImageIcon(new ImageUtil().getImage(0, vehicle.getFileName())));
                                    int i = vehicle.getLongitude() - 1;
                                    vehicle.setLocation(vehicle.getLatitude(), i);
                                    vehicle.setLongitude(i);
                                }
                            }   break;
                        case BOTTOM:
                            if (!(simiulator.getPanelLeft().getX() == (vehicle.getLatitude() + 70) && simiulator.getPanelLeft().getBackground().getRGB() == Color.RED.getRGB())) {
                                if (((simiulator.getWidth() / 2) - 70) > vehicle.getLatitude()) {
                                    int i = vehicle.getLatitude() + 1;
                                    vehicle.setLocation(i, vehicle.getLongitude());
                                    vehicle.setLatitude(i);
                                } else {
                                    vehicle.setIcon(new ImageIcon(new ImageUtil().getImage(180, vehicle.getFileName())));
                                    int i = vehicle.getLongitude() + 1;
                                    vehicle.setLocation(vehicle.getLatitude(), i);
                                    vehicle.setLongitude(i);
                                }
                            }   break;
                        default:
                            if (!(simiulator.getPanelLeft().getX() == (vehicle.getLatitude() + 70) && simiulator.getPanelLeft().getBackground().getRGB() == Color.RED.getRGB())) {
                                int i = vehicle.getLatitude() + 1;
                                vehicle.setLocation(i, vehicle.getLongitude());
                                vehicle.setLatitude(i);
                            }   break;
                    }

                } else if (startLocation[0] == vehicle.getParent().getWidth()) {
                    //Vehicle that start on right
                    switch (vehicle.getDirection()) {
                        case TOP:
                            if (!(simiulator.getPanelRight().getX() == (vehicle.getLatitude()) && simiulator.getPanelRight().getBackground().getRGB() == Color.RED.getRGB())) {
                                if (((simiulator.getWidth() / 2)) < vehicle.getLatitude()) {
                                    int i = vehicle.getLatitude() - 1;
                                    vehicle.setLocation(i, vehicle.getLongitude());
                                    vehicle.setLatitude(i);
                                } else {
                                    vehicle.setIcon(new ImageIcon(new ImageUtil().getImage(0, vehicle.getFileName())));
                                    int i = vehicle.getLongitude() - 1;
                                    vehicle.setLocation(vehicle.getLatitude(), i);
                                    vehicle.setLongitude(i);
                                }
                            }   break;
                        case BOTTOM:
                            if (!(simiulator.getPanelRight().getX() == (vehicle.getLatitude()) && simiulator.getPanelRight().getBackground().getRGB() == Color.RED.getRGB())) {
                                
                                if (((simiulator.getWidth() / 2) - 70) < vehicle.getLatitude()) {
                                    int i = vehicle.getLatitude() - 1;
                                    vehicle.setLocation(i, vehicle.getLongitude());
                                    vehicle.setLatitude(i);
                                } else {
                                    vehicle.setIcon(new ImageIcon(new ImageUtil().getImage(180, vehicle.getFileName())));
                                    int i = vehicle.getLongitude() + 1;
                                    vehicle.setLocation(vehicle.getLatitude(), i);
                                    vehicle.setLongitude(i);
                                }
                            }   break;
                        default:
                            if (!(simiulator.getPanelRight().getX() == (vehicle.getLatitude()) && simiulator.getPanelRight().getBackground().getRGB() == Color.RED.getRGB())) {
                                int i = vehicle.getLatitude() - 1;
                                vehicle.setLocation(i, vehicle.getLongitude());
                                vehicle.setLatitude(i);
                            }   break;
                    }

                } else if (startLocation[1] == 0) {
                    //Vehicle that start on top
                    switch (vehicle.getDirection()) {
                        case LEFT:
                            if (!(simiulator.getPanelTop().getY() == (vehicle.getLongitude() + 70) && simiulator.getPanelTop().getBackground().getRGB() == Color.RED.getRGB())) {
                                if (((simiulator.getCanvas().getHeight() / 2)) > vehicle.getLongitude()) {
                                    int i = vehicle.getLongitude() + 1;
                                    vehicle.setLocation(vehicle.getLatitude(), i);
                                    vehicle.setLongitude(i);
                                } else {
                                    vehicle.setIcon(new ImageIcon(new ImageUtil().getImage(-90, vehicle.getFileName())));
                                    int i = vehicle.getLatitude()- 1;
                                    vehicle.setLocation(i, vehicle.getLongitude());
                                    vehicle.setLatitude(i);
                                }
                            }   break;
                        case RIGHT:
                            if (!(simiulator.getPanelTop().getY() == (vehicle.getLongitude() + 70) && simiulator.getPanelTop().getBackground().getRGB() == Color.RED.getRGB())) {
                                
                                if (((simiulator.getCanvas().getHeight() / 2) - 70) > vehicle.getLongitude()) {
                                    int i = vehicle.getLongitude()+ 1;
                                    vehicle.setLocation(vehicle.getLatitude(), i);
                                    vehicle.setLongitude(i);
                                } else {
                                    vehicle.setIcon(new ImageIcon(new ImageUtil().getImage(90, vehicle.getFileName())));
                                    int i = vehicle.getLatitude()+ 1;
                                    vehicle.setLocation(i, vehicle.getLongitude());
                                    vehicle.setLatitude(i);
                                }
                            }   break;
                        default:
                            if (!(simiulator.getPanelTop().getY() == (vehicle.getLongitude() + 70) && simiulator.getPanelTop().getBackground().getRGB() == Color.RED.getRGB())) {
                                int i = vehicle.getLongitude() + 1;
                                vehicle.setLocation(vehicle.getLatitude(), i);
                                vehicle.setLongitude(i);
                            }   break;
                    }

                } else if (startLocation[1] == vehicle.getParent().getHeight()) {
                    //Vehicle that start on bottom
                    switch (vehicle.getDirection()) {
                        case LEFT:
                            if (!(simiulator.getPanelBottom().getY() == (vehicle.getLongitude()) && simiulator.getPanelBottom().getBackground().getRGB() == Color.RED.getRGB())) {
                                if (((simiulator.getCanvas().getHeight() / 2)) < vehicle.getLongitude()) {
                                    int i = vehicle.getLongitude() - 1;
                                    vehicle.setLocation(vehicle.getLatitude(), i);
                                    vehicle.setLongitude(i);
                                } else {
                                    vehicle.setIcon(new ImageIcon(new ImageUtil().getImage(-90, vehicle.getFileName())));
                                    int i = vehicle.getLatitude() - 1;
                                    vehicle.setLocation(i, vehicle.getLongitude());
                                    vehicle.setLatitude(i);
                                }
                            }   break;
                        case RIGHT:
                            if (!(simiulator.getPanelBottom().getY() == (vehicle.getLongitude()) && simiulator.getPanelBottom().getBackground().getRGB() == Color.RED.getRGB())) {
                                
                                if (((simiulator.getCanvas().getHeight() / 2) - 70) < vehicle.getLongitude()) {
                                    int i = vehicle.getLongitude() - 1;
                                    vehicle.setLocation(vehicle.getLatitude(), i);
                                    vehicle.setLongitude(i);
                                } else {
                                    vehicle.setIcon(new ImageIcon(new ImageUtil().getImage(90, vehicle.getFileName())));
                                    int i = vehicle.getLatitude() + 1;
                                    vehicle.setLocation(i, vehicle.getLongitude());
                                    vehicle.setLatitude(i);
                                }
                            }   break;
                        default:
                            if (!(simiulator.getPanelBottom().getY() == (vehicle.getLongitude()) && simiulator.getPanelBottom().getBackground().getRGB() == Color.RED.getRGB())) {
                                int i = vehicle.getLongitude() - 1;
                                vehicle.setLocation(vehicle.getLatitude(), i);
                                vehicle.setLongitude(i);
                            }   break;
                    }

                }

            }

        }).start();
        return time;
    }
}
