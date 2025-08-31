package com.uchith.trafficsimulator.component;

import com.uchith.trafficsimulator.util.ImageUtil;
import com.uchith.trafficsimulator.util.enums.Direction;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author uchithvihanga
 */
public class Vehicle extends JLabel{
    
    private int longitude;
    private int latitude;
    private Direction direction;
    private String fileName;
    
    private ArrayList<String> imgList = new ArrayList<>();
    
    public Vehicle(int longitude, int latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }
    
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    
    
    public void init(){
        setLocation(latitude, longitude);
        setSize(70, 70);
        setImage();

    }
      
    private void setImage(){
        ImageUtil.Util util = new ImageUtil().getImage(selectImgAngle());
        setIcon(new ImageIcon(util.getImage()));
        this.fileName = util.getFileName();
    }
    private double selectImgAngle(){
        if(latitude == 0){
            return 90;
        }else if(latitude == getParent().getWidth()){
            return -90;
        }else if(longitude == 0){
            return 180;
        }else if(longitude == getParent().getHeight()){
            return 0;
        }
        return 0;
    }
    
}