package xyz.xingfeng.fengNovel;

import org.junit.jupiter.api.Test;
import org.lwjgl.vulkan.VK10;
import org.lwjgl.vulkan.VkApplicationInfo;
import org.lwjgl.vulkan.VkInstanceCreateInfo;
import org.lwjgl.system.MemoryUtil;

import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.LongBuffer;


class FengNovelApplicationTests {
    @Test
    public void a(){
        // 指定根目录
        String rootDirectory = "src/main/java/xyz/xingfeng/fengNovel";  // 修改为你的项目根目录路径

        // 递归打印包结构
        printPackageStructure(new File(rootDirectory), "");
    }

    private static void printPackageStructure(File directory, String indent) {
        if (directory.isDirectory()) {
            System.out.println(indent + directory.getName() + "/");
            for (File file : directory.listFiles()) {
                printPackageStructure(file, indent + "  ");
            }
        } else if (directory.isFile() && directory.getName().endsWith(".java")) {
            System.out.println(indent + "|-- " + directory.getName());
        }
    }

}
