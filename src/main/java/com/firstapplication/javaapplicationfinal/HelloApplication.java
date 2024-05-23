package com.firstapplication.javaapplicationfinal;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox rootnode=fxmlLoader.load();

        Scene scene = new Scene(rootnode, 400, 300);
        MenuBar menuBar=createMenu();


        rootnode.getChildren().addAll(menuBar);
        stage.setTitle("Hello!");

        stage.setScene(scene);

        stage.show();
        System.out.println("start");
    }

    private MenuBar  createMenu(){

        Menu FileMenu=new Menu("File");
        MenuItem newMenuItem=new MenuItem("New");

        newMenuItem.setOnAction(actionEvent -> System.out.println("new item is clicked"));
        SeparatorMenuItem SeparatorMenuItem=new SeparatorMenuItem();
        SeparatorMenuItem SeparatorMenuItem1=new SeparatorMenuItem();
        MenuItem quitMenuItem=new MenuItem("Quit");

        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });


        FileMenu.getItems().addAll(newMenuItem,SeparatorMenuItem1,quitMenuItem);


        Menu HelpMenu=new Menu("Help");
        MenuItem newHelpMenu=new MenuItem("Help");
        MenuItem aboutHelpmenu=new MenuItem("about");

        aboutHelpmenu.setOnAction(actionEvent -> aboutApp());

        HelpMenu.getItems().addAll(newHelpMenu,SeparatorMenuItem,aboutHelpmenu);


        MenuBar menuBar=new MenuBar();

        menuBar.getMenus().addAll(FileMenu,HelpMenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop Application");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText(" I am koushik and i am best java game developer.");

        ButtonType yesbtn=new ButtonType("yes");
        ButtonType nobtn=new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesbtn,nobtn);

        alertDialog.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}