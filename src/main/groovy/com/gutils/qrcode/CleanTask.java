package com.gutils.qrcode;

import org.apache.commons.io.FileUtils;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;

/**
 * 执行clean操作
 * Created by hyxf on 15/12/7.
 */
public class CleanTask extends DefaultTask {
    @TaskAction
    public void cleanDoc() {
        Project project = this.getProject();
        File buildDir = project.getBuildDir();
        try {
            if (buildDir.exists()) {
                FileUtils.deleteDirectory(buildDir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
