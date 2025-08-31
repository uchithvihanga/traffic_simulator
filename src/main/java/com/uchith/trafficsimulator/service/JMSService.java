package com.uchith.trafficsimulator.service;

import jakarta.jms.JMSException;
import jakarta.jms.ObjectMessage;
import jakarta.jms.QueueConnection;
import jakarta.jms.QueueConnectionFactory;
import jakarta.jms.QueueSender;
import jakarta.jms.QueueSession;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.Timer;

/**
 *
 * @author uchithvihanga
 */
public class JMSService {
    private final Queue<HashMap<String, String>> dataList;
    
    public JMSService(){
        dataList = new LinkedList<>();
    }
    
    public void addToQueue(HashMap<String, String> map){
        dataList.add(map);
    }
    
    public void start(){
        Iterator<HashMap<String, String>> iterator = dataList.iterator();
        
        new Timer(500,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while(iterator.hasNext()){
                    try {
                        InitialContext context = new InitialContext();
                        QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("trafficQueueConnection");
                        
                        QueueConnection connection = factory.createQueueConnection();
                        connection.start();
                        
                        QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
                        
                        jakarta.jms.Queue queue = (jakarta.jms.Queue) context.lookup("trafficQueue");
                        
                        QueueSender sender = session.createSender(queue);
                        
                        ObjectMessage message = session.createObjectMessage(dataList.poll());
                        sender.send(message);
                        
                        connection.close();
                    } catch (NamingException ex) {
                        Logger.getLogger(JMSService.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JMSException ex) {
                        Logger.getLogger(JMSService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
}
