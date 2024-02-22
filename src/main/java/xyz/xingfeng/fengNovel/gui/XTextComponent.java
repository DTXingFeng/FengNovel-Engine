package xyz.xingfeng.fengNovel.gui;

import xyz.xingfeng.fengNovel.util.GameFont;

import javax.swing.*;
import java.awt.*;

/**
 *这个是游戏文本框类
 * @author Administrator
 */
public class XTextComponent extends JComponent {


    private JLabel textComp;

    /**
     * @param c 传入的对象是父容器，方便后期动态调节容器大小
     */
    public XTextComponent(Component c){
        setOpaque(true);
        setBackground(new Color(0xFF00D2));
        textComp = new JLabel("我是游戏文本显示位置", SwingConstants.LEADING);
        textComp.setOpaque(true);
        textComp.setBackground(new Color(0x00FFFF));
        textComp.setFont(GameFont.CUSTOM_FONT);
        add(textComp);
        //初始化位置与大小
        dynamicSize(c);

    }

    /**
     * 动态设置大小
     * @param c 父容器
     */
    public void dynamicSize(Component c){
        addNotify();
        //占比高度最小10%最大30%
        setBounds(0, (int) (c.getHeight()*0.7),c.getWidth(), (int) (c.getHeight()*0.3));
        //内边距10%
        textComp.setBounds((int) (getWidth()*0.05), (int) (getHeight()*0.1), (int) (getWidth()*0.9), (int) (getHeight()*0.8));

    }

    public void setText(String text){
        textComp.setText(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 绘制背景颜色
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
