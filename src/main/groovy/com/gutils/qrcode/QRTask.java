package com.gutils.qrcode;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * 构建二维码
 * Created by hyxf on 15/12/24.
 */
public class QRTask extends DefaultTask {

    @TaskAction
    public void qrBuilder(){
        Config config = (Config) this.getProject().getExtensions().getByName(QRCodePlugin.EXT_MAIN);
        if(null == config.getOutPath()){
            config.setOutPath(this.getProject().getBuildDir());
        }
        CodeBuilder cb = new CodeBuilder(config);
        cb.batchBarcode();
    }
}
