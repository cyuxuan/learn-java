/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.code.analyse.boot;

import club.beenest.code.analyse.window.CodeAnalyseMainWindow;
import javafx.application.Application;

public class CodeAnalyseApplication {
    public static void main(String[] args) {
        // 启动窗口程序
        Application.launch(CodeAnalyseMainWindow.class, args);
    }
}