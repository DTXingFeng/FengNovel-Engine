package xyz.xingfeng.fengNovel.gui;

import xyz.xingfeng.fengNovel.util.ImageAdjustment;

import javax.swing.*;
import java.awt.*;

public class XBackgroundImage extends JLabel {
    private ImageIcon image;
    private int height = 0;
    private int width = 0;
    private ImageAdjustment imageAdjustment;

    public XBackgroundImage(ImageIcon image){
        setLocation(0,0);
        setSize(image.getIconWidth(),image.getIconHeight());
        this.image = image;
        this.height = image.getIconHeight();
        this.width = image.getIconWidth();
        imageAdjustment = new ImageAdjustment(image);
        setIcon(image);
    }

    public XBackgroundImage(){
        setLocation(0,0);
    }
    public void dynamicSize(Component c){
        setIcon(null);
        ImageIcon imageIcon = new ImageIcon();
        //自适应大小
        if (height < width){
            imageIcon = new ImageIcon(imageAdjustment.proportionalScalingOnWidth(c.getWidth()));
        }else if (width < height){
            imageIcon = new ImageIcon(imageAdjustment.proportionalScalingOnHeight(c.getHeight()));
        }else {
            imageIcon = new ImageIcon(imageAdjustment.proportionalScaling(c.getWidth(),c.getHeight()));
        }
        setBounds(0,0,c.getWidth(),c.getHeight());
        setIcon(imageIcon);
    }
    public void setNewImage(ImageIcon image, Component c) {
        // 清除之前的图像
        setIcon(null);
        this.image = image;
        this.height = image.getIconHeight();
        this.width = image.getIconWidth();
        setIcon(image);
        imageAdjustment = new ImageAdjustment(image);
        dynamicSize(c);
    }
}
