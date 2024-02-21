package xyz.xingfeng.fengNovel.game;

import org.json.JSONObject;
import xyz.xingfeng.fengNovel.entities.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private int sceneId;
    private String text;

    public Scene(JSONObject scene) {
        this.sceneId = scene.getInt("sceneId");
        this.text = scene.getString("text");
    }

    public Scene(){
        this.sceneId = 0;
        this.text = "结束了";
    }

    public void load() {
        // 在切换到该场景时执行的加载逻辑
        // 可以包括加载资源、初始化游戏对象等
        System.out.println("Scene loaded: " + sceneId);
    }

    public void unload() {
        // 在切换离开该场景时执行的卸载逻辑
        // 可以包括释放资源、清理状态等
        System.out.println("Scene unloaded: " + sceneId);
    }

    public int getSceneId() {
        return sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
