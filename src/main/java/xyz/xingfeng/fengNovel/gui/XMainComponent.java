package xyz.xingfeng.fengNovel.gui;

import xyz.xingfeng.fengNovel.config.ConfigReader;
import xyz.xingfeng.fengNovel.exception.NullFileException;
import xyz.xingfeng.fengNovel.game.Scene;
import xyz.xingfeng.fengNovel.game.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 主显示容器，游戏所有内容都要以此为父容器
 * @author Administrator
 */
public class XMainComponent extends JComponent {

    private final XTextComponent xTextComponent;
    private final SceneManager sceneManager;

    public XMainComponent(Dimension d){
        setOpaque(true);
        setBackground(Color.BLUE);
        setPreferredSize(d);
        xTextComponent = new XTextComponent(this);
        add(xTextComponent);
        //加载游戏资源
        sceneManager = new SceneManager();
        try {
            sceneManager.loadScene(new ConfigReader("config.json").getJson("Game"));
        } catch (NullFileException e) {
            throw new RuntimeException(e);
        }
        addMouseListener(new MouseListen());

    }

    /**
     * 动态调整大小，默认比例为16：9
     * @param c 一般为父窗口的容器
     */
    public void dynamicSize(Component c){
        System.out.println(c.getHeight());
        double aspectRatio = (double) c.getWidth() / (double) c.getHeight();
        Dimension newSize;

        if (aspectRatio > 16.0 / 9.0) {
            // 过宽，以高度为基准
            newSize = new Dimension(c.getHeight() * 16 / 9, c.getHeight());
            setLocation((c.getWidth() - newSize.width) / 2, 0); // 水平居中
        } else {
            // 过窄，以宽度为基准
            newSize = new Dimension(c.getWidth(), c.getWidth() * 9 / 16);
            setLocation(0, (c.getHeight() - newSize.height) / 2); // 垂直居中
        }

        setSize(newSize);
        xTextComponent.dynamicSize(this);
        revalidate(); // 重新验证布局
        repaint(); // 重绘
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 绘制背景颜色
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    class MouseListen implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            //鼠标点击事件
            Scene nextScene = sceneManager.getNextScene();
            System.out.println("id:"+nextScene.getSceneId());
            System.out.println(nextScene.getText());
            xTextComponent.setText(nextScene.getText());
            if (nextScene.getSceneId() == 0){
                System.out.println("游戏结束了");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
