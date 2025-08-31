package com.uchith.trafficsimulator.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author uchithvihanga
 */
public class ImageUtil {
    private static final ArrayList<String> IMG_LIST = new ArrayList<>();
    private Util util;
    
    public ImageUtil(){
        IMG_LIST.add("/car_blue.png");
        IMG_LIST.add("/car_yellow.png");
        IMG_LIST.add("/truck.png");
        util = new Util();
    }
    
    public ImageUtil.Util getImage(double angle) {
        
        BufferedImage img = getRandomImage();
        if(img != null){
            int width = img.getWidth();
            int height = img.getHeight();

            BufferedImage newImage = new BufferedImage(
                    img.getWidth(), img.getHeight(), img.getType());

            Graphics2D g2 = newImage.createGraphics();

            g2.rotate(Math.toRadians(angle), width / 2,
                    height / 2);
            g2.drawImage(img, null, 0, 0);

            util.setImage(newImage);
            
            return util;
        }
        return null;
    }
    
    public BufferedImage getImage(double angle, String fileName){
        
        BufferedImage img = getRandomImage(fileName);

        if (img != null) {
            int width = img.getWidth();
            int height = img.getHeight();

            BufferedImage newImage = new BufferedImage(
                    img.getWidth(), img.getHeight(), img.getType());

            Graphics2D g2 = newImage.createGraphics();

            g2.rotate(Math.toRadians(angle), width / 2,
                    height / 2);
            g2.drawImage(img, null, 0, 0);

            return newImage;
        }
        return null;
    }
    
    private BufferedImage getRandomImage(){
        String name = IMG_LIST.get(new Random().nextInt(IMG_LIST.size()));
        util.setFileName(name);
        try {
            return ImageIO.read(getClass().getResource(name));
        } catch (IOException ex) {
            Logger.getLogger(ImageUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private BufferedImage getRandomImage(String name) {
        try {
            return ImageIO.read(getClass().getResource(name));
        } catch (IOException ex) {
            Logger.getLogger(ImageUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public class Util{
        private String fileName;
        private BufferedImage image;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public BufferedImage getImage() {
            return image;
        }

        public void setImage(BufferedImage image) {
            this.image = image;
        }
        
    }
}