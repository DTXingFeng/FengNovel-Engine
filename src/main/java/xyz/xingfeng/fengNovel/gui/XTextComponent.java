package xyz.xingfeng.fengNovel.gui;

import xyz.xingfeng.fengNovel.util.GameFont;

import javax.swing.*;
import java.awt.*;

/**
 *这个是游戏文本框类
 * @author Administrator
 */
public class XTextComponent extends JComponent {


    private final JLabel nameComp;
    private JLabel textComp;

    /**
     * @param c 传入的对象是父容器，方便后期动态调节容器大小
     */
    public XTextComponent(Component c){
//        setOpaque(true);
//        setBackground(new Color(0xFF00D2));
        //游戏文本显示框
        textComp = new JLabel("我是游戏文本显示位置", SwingConstants.LEADING);
        textComp.setOpaque(true);
        textComp.setBackground(new Color(0x00FFFF));
        textComp.setFont(GameFont.CUSTOM_FONT);
        add(textComp);
        //昵称显示框
        nameComp = new JLabel("我是昵称显示框");
        nameComp.setFont(GameFont.CUSTOM_FONT);
        //获得理想宽高
        nameComp.setSize(nameComp.getPreferredSize());

        add(nameComp);
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
        textComp.setBounds((int) (getWidth()*0.02), (int) (getHeight()*0.15), (int) (getWidth()*0.96), (int) (getHeight()*0.7));
        nameComp.setLocation((int)(getWidth()*0.02),(int)(getHeight()*0.15)-nameComp.getHeight());
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
