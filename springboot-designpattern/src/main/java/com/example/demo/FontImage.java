package com.example.demo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
    
public class FontImage {    
    public static void main(String[] args) throws Exception {    
        createImage("请在这里输入文字", new Font("微软雅黑", Font.PLAIN, 32), new File("./a.png"), 500, 64);
    }    
    
    // 根据str,font的样式以及输出文件目录    
    public static void createImage(String str, Font font, File outFile,    
            Integer width, Integer height) throws Exception {    
        // 创建图片    
        BufferedImage image = new BufferedImage(width, height,    
                BufferedImage.TYPE_INT_BGR);    
        Graphics g = image.getGraphics();    
        g.setClip(0, 0, width, height);    
        g.setColor(Color.white);    
        g.fillRect(0, 0, width, height);// 先用黑色填充整张图片,也就是背景    
        g.setColor(Color.black);// 在换成黑色    
        g.setFont(font);// 设置画笔字体

        // 画边框,在drawImage后面，下面代码给图片加上两个像素的白边
        g.setColor(Color.GREEN);
        g.drawRect(0, 0, width - 1, height - 1);
        g.drawRect(1, 1, width - 1, height - 1);
        g.drawRect(0, 0, width - 2, height - 2);

        /** 用于获得垂直居中y */    
        Rectangle clip = g.getClipBounds();    
        FontMetrics fm = g.getFontMetrics(font);    
        int ascent = fm.getAscent();    
        int descent = fm.getDescent();    
        int y = (clip.height - (ascent + descent)) / 2 + ascent;    
        for (int i = 0; i < 6; i++) {// 256 340 0 680    
            g.drawString(str, i * 680, y);// 画出字符串    
        }    
        g.dispose();    
        ImageIO.write(image, "png", outFile);// 输出png图片    
    }    
}    