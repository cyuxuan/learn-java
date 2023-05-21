/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.code.analyse.client;

import club.beenest.code.analyse.log.Log;
import club.beenest.code.analyse.widget.WidgetRegister;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class ClientThread implements Runnable {

    private Selector selector;

    public ClientThread(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            // 循环监听响应数据
            while (true) {
                // 获取channel数量
                int readChannels = selector.select();
                if (readChannels == 0) {
                    continue;
                }
                // 获取可用的channel
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                // 遍历集合
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();

                    // 移除set集合当前selectionKey
                    iterator.remove();

                    // 如果可读状态
                    if (selectionKey.isReadable()) {
                        readOperator(selector, selectionKey);
                    }
                }
            }
        } catch (Exception e) {
            Log.log("Socket Error !!!");
        }
    }

    /**
     * 处理可读状态操作
     *
     * @param selector     选择器
     * @param selectionKey 键
     * @throws IOException IO异常
     */
    private void readOperator(Selector selector, SelectionKey selectionKey) throws IOException {
        // 1 从SelectionKey获取到已经就绪的通道
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        // 2 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 3 循环读取客户端消息
        int readLength = socketChannel.read(byteBuffer);
        String message = "";
        if (readLength > 0) {
            // 切换读模式
            byteBuffer.flip();

            // 读取内容
            message += StandardCharsets.UTF_8.decode(byteBuffer);
        }

        // 4 将channel再次注册到选择器上，监听可读状态
        socketChannel.register(selector, SelectionKey.OP_READ);

        // 5 处理客户端读取到的消息
        TreeView<String> treeView = WidgetRegister.getWidget("treeView", TreeView.class);

        // 获取根节点节点
        TreeItem<String> root;
        if(treeView.getRoot() == null) {
            root = new TreeItem("根节点");
            treeView.setRoot(root);
        } else {
            root = treeView.getRoot();
        }

        // 生成对应的节点
        TreeItem<String> sub = new TreeItem<>(message);

        root.getChildren().add(sub);
    }

}
