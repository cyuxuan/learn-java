/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.code.analyse.window;

import club.beenest.code.analyse.client.ClientThread;
import club.beenest.code.analyse.client.CodeAnalyseClient;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CodeAnalyseMainWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL resource = this.getClass().getClassLoader().getResource("CodeAnalyseMainWindow.fxml");
        assert resource != null;
        BorderPane borderPane = FXMLLoader.load(resource);
        // 窗口标题设置
        stage.setTitle("开发者性能工具");
        Scene scene = new Scene(borderPane);
        // 给窗口设置场景
        stage.setScene(scene);
        // 展示窗口
        stage.show();
        // 窗口启动完成后开始启动客户端, 接收服务信息
        new Thread(() -> {
            try {
                CodeAnalyseClient.start();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
}
