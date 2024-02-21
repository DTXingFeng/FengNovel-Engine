package xyz.xingfeng.fengNovel.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 表示决策树中的一个选项节点。
 * @author Administrator
 */
public class Option {
    private String id;            // 选项的唯一标识符
    private String text;          // 选项显示的文本
    private String action;        // 选择该选项后的行为或事件标识符
    private List<Option> children; // 子节点列表，表示该选项的所有可能的下一步选项

    /**
     * 构造函数，用于初始化选项。
     * @param id 选项的唯一标识符
     * @param text 选项显示的文本
     * @param action 选择该选项后的行为或事件标识符
     */
    public Option(String id, String text, String action) {
        this.id = id;
        this.text = text;
        this.action = action;
        this.children = new ArrayList<>();
    }

    /**
     * 添加子节点，表示该选项的一个可能的下一步选项。
     * @param child 要添加的子节点
     */
    public void addChild(Option child) {
        this.children.add(child);
    }

    // Getters and setters

    /**
     * 获取选项的唯一标识符。
     * @return 选项的唯一标识符
     */
    public String getId() {
        return id;
    }

    /**
     * 获取选项显示的文本。
     * @return 选项显示的文本
     */
    public String getText() {
        return text;
    }

    /**
     * 获取选择该选项后的行为或事件标识符。
     * @return 行为或事件标识符
     */
    public String getAction() {
        return action;
    }

    /**
     * 获取子节点列表，表示该选项的所有可能的下一步选项。
     * @return 子节点列表
     */
    public List<Option> getChildren() {
        return children;
    }
}
