package xyz.xingfeng.fengNovel.gui;

import xyz.xingfeng.fengNovel.entities.WindowSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class GameWindow extends JFrame {

    private final XTextComponent xTextComponent;
    private XButton xButton;

    public GameWindow(WindowSettings settings){
        // 获取屏幕宽高
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(settings.getWidth(), settings.getHeight()));
        // 设置窗口位置大小
        setBounds(scrSize.width / 2 - settings.getWidth() / 2, scrSize.height / 2 - settings.getHeight() / 2, settings.getWidth(), settings.getHeight());
        //设置标题
        setTitle(settings.getTitle());
        //是否显示
        setVisible(true);
        // 窗体关闭后自动结束后台
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 获取布局
        Container cn = this.getContentPane();
        // 取消布局
        cn.setLayout(null);
        //实际游戏页面始终保持在16：9
        ImageIcon imageIcon = new ImageIcon("E:\\DTlogo\\32x32.png");
        Image image = imageIcon.getImage();
        imageIcon = new ImageIcon(image.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        JLabel label = new JLabel(imageIcon);
        label.setBounds(0,0,100,100);
        label.setOpaque(true);
        label.setBackground(new Color(0xFFB302));
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        cn.add(label);
        label.repaint();

        xButton = new XButton(this);
        xButton.setLocation(0,100);
//        cn.add(xButton);
        addComponentListener(new Component());
        xTextComponent = new XTextComponent(this);
        add(xTextComponent);
        xTextComponent.repaint();
    }
    class Component implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent e) {
            xButton.setNewWidth(e.getComponent());
//            xButton.repaint();
            xTextComponent.dynamicSize(e.getComponent());
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
