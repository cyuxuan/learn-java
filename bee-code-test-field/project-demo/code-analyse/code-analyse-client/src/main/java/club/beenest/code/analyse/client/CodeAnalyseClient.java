/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.code.analyse.client;

import club.beenest.code.analyse.widget.WidgetRegister;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class CodeAnalyseClient {
    public void reciveMsg() throws IOException, InterruptedException {
        // 连接服务端
        int retry = 1;
        SocketChannel socketChannel = null;
        while (true) {
            try {
                socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 7099));
                break;
            } catch (Exception e) {
                if (retry == 0) {
                    TextArea textArea = WidgetRegister.getWidget("textAreaBottom", TextArea.class);
                    textArea.insertText(0, "网络链接异常！！！");
                    throw new IOException();
                } else {
                    retry--;
                    Thread.sleep(5000);
                }
            }
        }
        // 接收服务端响应数据
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);

        // 创建线程-开启服务响应监听-更新界面信息
        Platform.runLater(new ClientThread(selector));
    }

    public static CodeAnalyseClient start() throws IOException, InterruptedException {
        CodeAnalyseClient codeAnalyseClient = new CodeAnalyseClient();
        codeAnalyseClient.reciveMsg();
        return codeAnalyseClient;
    }
}
