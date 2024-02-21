package xyz.xingfeng.fengNovel.util;

import javax.swing.ImageIcon;

/**
 * @author Administrator
 */
public class Sprite {
    private ImageIcon image;

    public Sprite(String imagePath) {
        this.image = new ImageIcon(imagePath);
    }

    public ImageIcon getImage() {
        return image;
    }
}

