/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.code.analyse.controller;

import club.beenest.code.analyse.widget.WidgetRegister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class CodeAnalyseMainWindowController implements Initializable {
    @FXML
    private TreeView<String> treeView;

    @FXML
    private TextArea textArea;

    @FXML
    private TextArea textAreaBottom;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // 控制器初始化时注册组件到全局组件中
        TreeItem<String> root = new TreeItem<>("根节点", null);
        treeView.setRoot(root);
        WidgetRegister.register("treeView", treeView);
        WidgetRegister.register("textArea", textArea);
        WidgetRegister.register("textAreaBottom", textAreaBottom);
        WidgetRegister.register("main", this);
    }

    @FXML
    protected void refreshTreeView(ActionEvent event) {
        System.out.println("收到了刷新事件");
    }
}
