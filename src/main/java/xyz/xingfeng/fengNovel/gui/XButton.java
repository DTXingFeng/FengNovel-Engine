package xyz.xingfeng.fengNovel.gui;

import xyz.xingfeng.fengNovel.config.ConfigReader;
import xyz.xingfeng.fengNovel.exception.NullFileException;
import xyz.xingfeng.fengNovel.game.Scene;
import xyz.xingfeng.fengNovel.game.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Dimension2D;

/**
 * @author Administrator
 */
public class XButton extends JButton {

    private static SceneManager sceneManager;

    public XButton(Component component){
        super();
        setSize(component.getWidth(),component.getHeight()/2);
        this.addActionListener(new Action(this));
        setOpaque(true);
        setText("点击开始游戏");
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setForeground(new Color(0x0057FF));
        //加载游戏
        sceneManager = new SceneManager();
		try {
			sceneManager.loadScene(new ConfigReader("config.json").getJson("Game"));
		} catch (NullFileException e) {
			throw new RuntimeException(e);
		}
    }

    public void setNewWidth(Component component){
        setSize(component.getWidth(),component.getHeight()/2);
    }
    static class Action implements ActionListener{
        XButton c = null;
        public Action(XButton c){
            this.c = c;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Scene nextScene = sceneManager.getNextScene();
			System.out.println("id:"+nextScene.getSceneId());
			System.out.println(nextScene.getText());
            c.setText(nextScene.getText());
			if (nextScene.getSceneId() == 0){
                System.out.println("游戏结束了");
			}
        }
    }
}
