package com.gutils.qrcode;

import java.io.File;
import java.util.ArrayList;

/**
 * 批量生成配置参数
 *
 * @author qiudongchao
 */
public class Config {
    /**
     * 输出目录
     */
    private File outPath;
    /**
     * 二维码宽度
     */
    private int width = 200;

    /**
     * 字符串编码
     */
    private String charCode = "utf-8";

    /**
     * 生成图片格式
     */
    private String formate = "png";

    /**
     * 二维码内容匹配规则
     */
    private String contentRegex = "http://www.baidu.com/*.html";

    /**
     * 渠道
     */
    private ArrayList<String> channels;

    /**
     * logo 文件
     */
    private File logo;

    /**
     * logo占比,1.2.3.4.5.6
     */
    private int logoCent = 5;

    public int getLogoCent() {
        return logoCent;
    }

    public void setLogoCent(int logoCent) {
        this.logoCent = logoCent;
    }

    public ArrayList<String> getChannels() {
        return channels;
    }

    public void channels(String... chans) {
        if(chans.length > 0){
            this.channels = new ArrayList<>(chans.length);
            for (String str : chans){
                this.channels.add(str);
            }
        }
    }

    public File getLogo() {
        return logo;
    }

    public void setLogo(File logo) {
        this.logo = logo;
    }

    public String getContentRegex() {
        return contentRegex;
    }

    public void setContentRegex(String contentRegex) {
        this.contentRegex = contentRegex;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    public File getOutPath() {
        return outPath;
    }

    public void setOutPath(File outPath) {
        this.outPath = outPath;
    }
}
