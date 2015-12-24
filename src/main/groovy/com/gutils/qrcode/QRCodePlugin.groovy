package com.gutils.qrcode

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 版本管理插件
 */
class QRCodePlugin implements Plugin<Project> {
    public static final String EXT_MAIN = "qrcode"
    public static final String TASK_CLEAN = "clean"
    public static final String TASK_QR = "build"

    void apply(Project project) {
        project.extensions.create(EXT_MAIN, Config.class)
        QRTask qrTask = project.tasks.create(TASK_QR,QRTask.class)
        CleanTask cleanTask = project.tasks.create(TASK_CLEAN,CleanTask.class)
        qrTask.dependsOn(cleanTask)
    }

}
