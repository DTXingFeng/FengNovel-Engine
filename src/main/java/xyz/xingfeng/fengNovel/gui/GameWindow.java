package xyz.xingfeng.fengNovel.gui;

import xyz.xingfeng.fengNovel.entities.WindowSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GameWindow extends JFrame {
    private Container c = this.getContentPane();
    private final XMainComponent jPanel;
    private XButton xButton;

    public GameWindow(WindowSettings settings){
        ImageIcon imageIcon = new ImageIcon("E:\\DTlogo\\32x32.png");
        setIconImage(imageIcon.getImage());
        // 获取屏幕宽高
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        // 设置窗口位置大小
        jPanel = new XMainComponent(new Dimension(settings.getWidth(),settings.getHeight()));
        add(jPanel,SwingConstants.CENTER);
        jPanel.setLayout(null);

        pack();
        c.setLayout(null);
        setLocation(scrSize.width / 2 - getWidth() / 2, scrSize.height / 2 - getHeight() / 2);
        //设置标题
        setTitle(settings.getTitle());
        //是否显示
        setVisible(true);
        // 窗体关闭后自动结束后台
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //实际游戏页面始终保持在16：9
        addComponentListener(new Component());

    }
    class Component implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent e) {
            jPanel.dynamicSize(c);
        }

        @Override
        public void componentMoved(ComponentEvent e) {

        }

        @Override
        public void componentShown(ComponentEvent e) {

        }

        @Override
        public void componentHidden(ComponentEvent e) {

        }
    }
}
