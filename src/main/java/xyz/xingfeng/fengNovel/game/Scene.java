package xyz.xingfeng.fengNovel.game;

import org.json.JSONObject;

public class Scene {

    private int sceneId;
    private String text;
    /**
     * 名字,默认为空，空则不显示
     */
    private String name = null;

    public Scene(JSONObject scene) {
        this.sceneId = scene.getInt("sceneId");
        this.text = scene.getString("text");
        this.name = scene.getString("name");
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


    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }
}
