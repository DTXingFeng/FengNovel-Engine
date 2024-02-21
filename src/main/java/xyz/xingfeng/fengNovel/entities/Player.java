package xyz.xingfeng.fengNovel.entities;


/**
 * @author Administrator
 * 玩家类
 */
public class Player {
    /**
     * 表示玩家当前选项路径
     */
    private Option option;
    private String name = "玩家";

    /**
     * 获取玩家当前选择的选项。
     * @return 当前选项
     */
    public Option getOption() {
        return option;
    }

    /**
     * 设置玩家当前选择的选项。
     * @param option 要设置的选项
     */
    public void setOption(Option option) {
        this.option = option;
    }


    /**
     * 获取玩家昵称
     * @return 玩家昵称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置玩家昵称
     * @param name 要设置的玩家昵称
     */
    public void setName(String name) {
        this.name = name;
    }
}
