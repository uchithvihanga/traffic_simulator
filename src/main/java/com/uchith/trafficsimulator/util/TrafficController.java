package com.uchith.trafficsimulator.util;

import com.uchith.trafficsimulator.main.Simiulator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author uchithvihanga
 */
public class TrafficController {

    private final Simiulator simiulator;
    private static final int TOP_TO_BOTTOM = 1;
    private static final int LEFT_TO_RIGHT = 2;

    private static final int GO = 3;
    private static final int STOP = 4;

    private int direction;

    public TrafficController(Simiulator simiulator) {
        this.simiulator = simiulator;
    }

    public void control() {
        leftAndRight(GO);
        topAndBottom(STOP);
        new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (direction == TOP_TO_BOTTOM) {
                    topAndBottom(STOP);
                    leftAndRight(GO);
                } else if (direction == LEFT_TO_RIGHT) {
                    leftAndRight(STOP);
                    topAndBottom(GO);
                }

            }
        }).start();
    }

    private void leftAndRight(int command) {
        direction = LEFT_TO_RIGHT;
        if (command == GO) {
            System.out.println("LEFT_TO_RIGHT GO");
            simiulator.getPanelLeft().setBackground(Color.GREEN);
            simiulator.getPanelRight().setBackground(Color.GREEN);
        } else if (command == STOP) {
            System.out.println("LEFT_TO_RIGHT STOP");
            simiulator.getPanelLeft().setBackground(Color.RED);
            simiulator.getPanelRight().setBackground(Color.RED);
        }
    }

    private void topAndBottom(int command) {
        direction = TOP_TO_BOTTOM;
        if (command == GO) {
            System.out.println("TOP_TO_BOTTOM GO");
            simiulator.getPanelTop().setBackground(Color.GREEN);
            simiulator.getPanelBottom().setBackground(Color.GREEN);
        } else if (command == STOP) {
            System.out.println("TOP_TO_BOTTOM STOP");
            simiulator.getPanelTop().setBackground(Color.RED);
            simiulator.getPanelBottom().setBackground(Color.RED);
        }
    }

}
