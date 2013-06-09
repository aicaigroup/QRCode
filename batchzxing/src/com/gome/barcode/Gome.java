package com.gome.barcode;

/**
 * 二维码批量生成程序
 * 
 * @author qiudongchao
 * 
 */
public class Gome {

	/**
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Gome gome = new Gome();
		gome.run();
	}

	/**
	 * 执行转换
	 */
	public void run() {
		Config config = new Config(); // 对批量生成二维码进行参数配置
		config.setOutPath("d://hello/"); // 设置输出路径
		config.setContentRegex("http://shouji.gome.com.cn/down/*.html");// *为通配符,匹配渠道号
		config.setChanngeFileName("channge.txt"); // 渠道文件
		config.setDot(""); // 渠道分隔符--为空时默认渠道好分隔符为空格
		// -------------------------------------------------------
		CodeBuilder cb = new CodeBuilder(config);
		cb.batchBarcode();
	}
}
