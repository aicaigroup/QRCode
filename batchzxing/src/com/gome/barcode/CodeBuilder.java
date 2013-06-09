package com.gome.barcode;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.utils.QRCoder;

/**
 * 二维码批量生成类
 * 
 * @author qiudongchao
 * 
 */
public class CodeBuilder {

	private Config mConfig;

	/**
	 * 构造函数
	 */
	public CodeBuilder(Config config) {
		mConfig = config;
	}

	/**
	 * 批量生成二维码
	 * 
	 * @param list
	 */
	public void batchBarcode() {
		ArrayList<String> list = getStringFromTxt(mConfig.getChanngeFileName(),
				mConfig.getDot());
		if (list != null && list.size() > 0) {
			System.out.println("生成开始.......................");
			for (String string : list) {
				StringToBarcode(string);
				System.out.println("渠道：" + string + " -- 生成完毕！");
			}
			System.out.println("生成完毕.......................");
		} else {
			System.out.println("error:列表不能为空！");
		}
	}

	/**
	 * 字符串转二维码
	 * 
	 * @param str
	 *            渠道号
	 */
	private void StringToBarcode(String str) {
		BitMatrix byteMatrix = null;
		try {
			// 如果目录不存在-创建目录
			File doc = new File(mConfig.getOutPath());
			if (!doc.exists()) {
				doc.mkdir();
			}
			String change = new String(str.getBytes(mConfig.getCharCode()),
					mConfig.getCharCode());
			String content = mConfig.getContentRegex().replace("*", change);
			QRCoder bc = new QRCoder();
//			bc.createQrCode(content, mConfig.getWidth(), mConfig.getHeight(),
//					mConfig.getOutPath() + str + "." + mConfig.getFormate(),
//					mConfig.getFormate());
			//将logo放入输出文件夹
			bc.createQrCode(content, mConfig.getWidth(), mConfig.getHeight(), mConfig.getOutPath() + str + "." + mConfig.getFormate(), mConfig.getOutPath() +"icon.png", mConfig.getFormate(), 0xFF00000F,0xFFFFFFFF);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (byteMatrix != null) {
				byteMatrix.clear();
				byteMatrix = null;
			}
		}
	}

	/**
	 * 读取渠道信息
	 * 
	 * @param channge
	 * @return
	 */
	private ArrayList<String> getStringFromTxt(String channge, String dot) {
		ArrayList<String> list = new ArrayList<String>();
		String string = "";
		InputStream is = null;
		try {
			is = CodeBuilder.class.getResourceAsStream(channge);
			string = IOUtils.toString(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(is);
		}
		if (dot != null && dot != "") {
			if (string != null && string != "" && string.contains(dot)) {
				String[] temp = string.split(dot);
				int size = temp.length;
				if (size > 0) {
					list.ensureCapacity(size);
					for (int i = 0; i < size; i++) {
						list.add(temp[i]);
					}
				} else {
					System.out.println("error:渠道号解析错误！");
				}
			} else {
				System.out.println("error:暂无渠道信息！");
			}
		} else {// 空格分割符
			Pattern pat = Pattern.compile("\\w+");
			Matcher mat = pat.matcher(string);
			while (mat.find()) {
				list.add(mat.group());
			}
		}

		return list;
	}

}
