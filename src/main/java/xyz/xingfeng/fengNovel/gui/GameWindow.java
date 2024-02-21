package xyz.xingfeng.fengNovel.gui;

import xyz.xingfeng.fengNovel.entities.WindowSettings;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow(WindowSettings settings){
        //设置标题
        setTitle(settings.getTitle());
        //设置大小位置
        setBounds(settings.getX(),settings.getY(),settings.getWidth(),settings.getHeight());
        setVisible(true);
    }
}
