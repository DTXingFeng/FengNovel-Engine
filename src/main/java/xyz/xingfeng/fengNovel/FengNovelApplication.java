package xyz.xingfeng.fengNovel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.xingfeng.fengNovel.config.ConfigReader;
import xyz.xingfeng.fengNovel.entities.WindowSettings;
import xyz.xingfeng.fengNovel.exception.NullFileException;
import xyz.xingfeng.fengNovel.game.Scene;
import xyz.xingfeng.fengNovel.game.SceneManager;
import xyz.xingfeng.fengNovel.gui.GameWindow;

import java.io.InputStream;
import java.util.Scanner;

//@SpringBootApplication
public class FengNovelApplication {

	public static void main(String[] args) {
		// 设置系统属性，模拟非 headless 环境
//		System.setProperty("java.awt.headless", "false");
//		SpringApplication.run(FengNovelApplication.class, args);
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				new GameWindow(new WindowSettings(new ConfigReader("config.json").getJson("Window")));
//			}
//		}).start();

		SceneManager sceneManager = new SceneManager();
		try {
			sceneManager.loadScene(new ConfigReader("config.json").getJson("Game"));
		} catch (NullFileException e) {
			throw new RuntimeException(e);
		}
		// 创建 Scanner 对象
		Scanner scanner = new Scanner(System.in);
		while (!"1".equals(scanner.nextLine())){
			Scene nextScene = sceneManager.getNextScene();
			System.out.println("id:"+nextScene.getSceneId());
			System.out.println(nextScene.getText());
			if (nextScene.getSceneId() == 0){
				return;
			}
		}
	}

}
