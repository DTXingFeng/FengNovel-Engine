package xyz.xingfeng.fengNovel.game;

import org.json.JSONArray;
import org.json.JSONObject;
import xyz.xingfeng.fengNovel.exception.NullFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 场景管理类
 * @author Administrator
 */
public class SceneManager {

    private List<Scene> scenes;
    private Scene currentScene;
    private int currentSceneIndex = -1; // 当前场景的索引
    public SceneManager() {
        this.scenes = new ArrayList<>();
        this.currentScene = null;
    }


    /**
     * 加载场景
     * @param jsonObject 配置名为Game的json
     * @throws NullFileException 无文件错误(游戏文件不完整)
     */
    public void loadScene(JSONObject jsonObject) throws NullFileException {
        String path = jsonObject.getString("path");
        File file = new File(path);

        try {
            if (file.isFile() && file.exists()) {
                // 文件存在
                String fileContent = readFileContent(file);
                JSONObject sceneJson = parseToJson(fileContent);
                processScenes(sceneJson.getJSONArray("scenes"));
            } else {
                // 文件不存在，抛出异常
                throw new NullFileException("文件" + path + "不存在");
            }
        } catch (IOException e) {
            // 将IOException包装在NullFileException中
            throw new NullFileException("文件读取失败: " + e.getMessage());
        }
    }

    private String readFileContent(File file) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            // 逐行读取文件内容
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            return stringBuilder.toString();
        }
    }

    private JSONObject parseToJson(String jsonContent) {
        return new JSONObject(jsonContent);
    }

    private void processScenes(JSONArray scenesJson) {
        for (int i = 0; i < scenesJson.length(); i++) {
            JSONObject scene = scenesJson.getJSONObject(i);
            this.scenes.add(new Scene(scene));
        }
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public Scene getNextScene() {
        if (currentSceneIndex < 0){
            //说明还未进行游戏
            currentSceneIndex = 0;
            currentScene = scenes.get(currentSceneIndex);
            return currentScene;
        }
        if (currentSceneIndex >= 0 && currentSceneIndex < scenes.size() - 1) {
            currentSceneIndex++;
            currentScene = scenes.get(currentSceneIndex);
            return currentScene;
        } else {
            // 已经到达最后一个场景，可以返回 null 或者抛出异常，取决于你的设计
            return new Scene();
        }
    }


}

