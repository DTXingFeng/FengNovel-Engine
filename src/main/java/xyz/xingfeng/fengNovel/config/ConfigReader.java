package xyz.xingfeng.fengNovel.config;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigReader {
    private JSONObject config;

    public ConfigReader(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            config = new JSONObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getString(String key) {
        return config.getString(key);
    }

    public int getInt(String key) {
        return config.getInt(key);
    }

    public boolean getBoolean(String key) {
        return config.getBoolean(key);
    }

}
