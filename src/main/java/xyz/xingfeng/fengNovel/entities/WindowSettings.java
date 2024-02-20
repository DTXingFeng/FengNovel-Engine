package xyz.xingfeng.fengNovel.entities;

import org.json.JSONObject;

/**
 * @author Administrator
 * 窗口属性实体类
 */
public class WindowSettings {
    private String title = "窗口标题";
    private int width = 600;
    private int height = 400;
    private int x = 0;
    private int y = 0;

    public WindowSettings(JSONObject settings){
        setTitle(settings.getString("Title"));
        setWidth(settings.getInt("Width"));
        setHeight(settings.getInt("Height"));
        setX(settings.getInt("x"));
        setY(settings.getInt("y"));
    }

    public WindowSettings(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
