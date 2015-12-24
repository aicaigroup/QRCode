package com.gutils.qrcode;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.utils.QRCoder;
import org.gradle.api.GradleException;

import java.io.File;
import java.util.ArrayList;

/**
 * 二维码批量生成类
 *
 * @author qiudongchao
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
     */
    public void batchBarcode() {
        ArrayList<String> list = mConfig.getChannels();
        if (list != null && list.size() > 0) {
            System.out.println("生成开始.......................");
            for (String string : list) {
                StringToBarcode(string);
                System.out.println("渠道：" + string + " -- 生成完毕！");
            }
            System.out.println("生成完毕.......................");
        } else {
            throw new GradleException("渠道列表不能为空！");
        }
    }

    /**
     * 字符串转二维码
     *
     * @param str 渠道号
     */
    private void StringToBarcode(String str) {
        BitMatrix byteMatrix = null;
        try {
            // 如果目录不存在-创建目录
            if (!mConfig.getOutPath().exists()) {
                mConfig.getOutPath().mkdir();
            }
            String change = new String(str.getBytes(mConfig.getCharCode()),
                    mConfig.getCharCode());
            //二维码内容
            String content = mConfig.getContentRegex().replace("*", change);
            //二维码宽度
            int width = mConfig.getWidth();
            QRCoder bc = new QRCoder();
            //输出文件
            String outPutFile = mConfig.getOutPath().getPath() + File.separator + str + "." + mConfig.getFormate();

            bc.createQrCode(content, width, width, outPutFile, mConfig.getLogo(), mConfig.getFormate(), 0xFF00000F, 0xFFFFFFFF,mConfig.getLogoCent());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (byteMatrix != null) {
                byteMatrix.clear();
            }
        }
    }

}
