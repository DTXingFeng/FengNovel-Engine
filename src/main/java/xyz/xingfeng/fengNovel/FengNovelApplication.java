package xyz.xingfeng.fengNovel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.xingfeng.fengNovel.config.ConfigReader;
import xyz.xingfeng.fengNovel.entities.WindowSettings;
import xyz.xingfeng.fengNovel.gui.GameWindow;

//@SpringBootApplication
public class FengNovelApplication {

	public static void main(String[] args) {
		// 设置系统属性，模拟非 headless 环境
//		System.setProperty("java.awt.headless", "false");
//		SpringApplication.run(FengNovelApplication.class, args);
		new Thread(new Runnable() {
			@Override
			public void run() {
				new GameWindow(new WindowSettings(new ConfigReader("config.json").getJson("Window")));
			}
		}).start();

	}

}
