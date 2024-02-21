package xyz.xingfeng.fengNovel.entities;

import xyz.xingfeng.fengNovel.util.Sprite;
import xyz.xingfeng.fengNovel.util.Vector2D;

/**
 * @author Administrator
 */
public class GameObject {

    private String name;
    private Vector2D position;
    private Sprite sprite;

    public GameObject(String name, Vector2D position, Sprite sprite) {
        this.name = name;
        this.position = position;
        this.sprite = sprite;
    }

    public void update(float deltaTime) {
        // 更新游戏对象的逻辑
        // 可以包括移动、碰撞检测、状态更新等
    }

    public void render() {
        // 渲染游戏对象的图形
        // 可以使用渲染引擎或图形库进行绘制
    }

    // 可以包括其他与游戏对象相关的方法和属性
}

