package xyz.xingfeng.fengNovel.util;

import javax.swing.*;
import java.awt.*;

/**
 * 图像调整工具类
 * 用于对图像进行比例缩放
 * @author Administrator
 */
public class ImageAdjustment {
    private Image image = null;
    private int height = 0;
    private int width = 0;

    /**
     * 构造函数
     * @param image ImageIcon表示的图像
     */
    public ImageAdjustment(ImageIcon image){
        this.image = image.getImage();
        this.height = image.getIconHeight();
        this.width = image.getIconWidth();
    }

    /**
     * 以指定高度等比例缩放图像
     * @param targetHeight 目标高度
     * @return 缩放后的图像
     */
    public Image proportionalScalingOnHeight(int targetHeight){
        int newWidth = (targetHeight * this.width) / this.height;
        return this.image.getScaledInstance(newWidth, targetHeight, Image.SCALE_AREA_AVERAGING);
    }

    /**
     * 以指定宽度等比例缩放图像
     * @param targetWidth 目标宽度
     * @return 缩放后的图像
     */
    public Image proportionalScalingOnWidth(int targetWidth){
        int newHeight = (targetWidth * this.height) / this.width;
        return this.image.getScaledInstance(targetWidth, newHeight, Image.SCALE_AREA_AVERAGING);
    }

    /**
     * 等比例缩放图像
     * @param targetWidth 目标宽度
     * @param targetHeight 目标高度
     * @return 缩放后的图像
     */
    public Image proportionalScaling(int targetWidth, int targetHeight){
        double widthRatio = (double) targetWidth / this.width;
        double heightRatio = (double) targetHeight / this.height;

        double scale = Math.min(widthRatio, heightRatio);

        int newWidth = (int) (this.width * scale);
        int newHeight = (int) (this.height * scale);

        return this.image.getScaledInstance(newWidth, newHeight, Image.SCALE_AREA_AVERAGING);
    }
}
