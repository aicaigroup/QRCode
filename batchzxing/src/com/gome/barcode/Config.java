package com.gome.barcode;

/**
 * 批量生成配置参数
 * 
 * @author qiudongchao
 * 
 */
public class Config {
	/**
	 * 输出路径
	 */
	private String outPath = "D://GomeBarCode/";
	/**
	 * 二维码宽度
	 */
	private int width = 200;
	/**
	 * 二维码高度
	 */
	private int height = 200;
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
	private String contentRegex = "http://shouji.gome.com.cn/down/*.html";
	/**
	 * 渠道名
	 */
	private String channgeFileName = "channge.txt";
	/**
	 * 渠道号分割符
	 */
	private String dot = ",";
	/**
	 * logo路径
	 */
	private String logo = ""; 
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDot() {
		return dot;
	}

	public void setDot(String dot) {
		this.dot = dot;
	}

	public String getChanngeFileName() {
		return channgeFileName;
	}

	public void setChanngeFileName(String channgeFileName) {
		this.channgeFileName = channgeFileName;
	}

	public String getContentRegex() {
		return contentRegex;
	}

	public void setContentRegex(String contentRegex) {
		this.contentRegex = contentRegex;
	}

	public String getOutPath() {
		return outPath;
	}

	public void setOutPath(String outPath) {
		this.outPath = outPath;
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
}
