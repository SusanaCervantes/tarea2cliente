/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.stage.StageStyle;
import task2.Task2;
import task2.controller.Controller;

public class FlowController {

    private static FlowController INSTANCE = null;
    private static Stage mainStage;
    
    private static HashMap<String, FXMLLoader> loaders = new HashMap<>();

    private FlowController() {
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            synchronized (FlowController.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FlowController();
                }
            }
        }
    }

    public static FlowController getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void InitializeFlow(Stage stage) {
        getInstance();
        this.mainStage = stage;
    }

    private FXMLLoader getLoader(String name) {
        FXMLLoader loader = loaders.get(name);
        if (loader == null) {
            synchronized (FlowController.class) {
                loader = getFXMLLoader(name);
            }
        }
        return loader;
    }
    
    private FXMLLoader getFXMLLoader(String name){
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(Task2.class.getResource("views/" + name + ".fxml"));
            loader.load();
            loaders.put(name, loader);
        } catch (IOException ex) {
            loader = null;
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Creando loader [" + name + "].", ex);
        }
        return loader;
    }
    
    public void cargarFXMLLoader(String name){
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(Task2.class.getResource("views/" + name + ".fxml"));
            loader.load();
            loaders.put(name, loader);
        } catch (IOException ex) {
            loader = null;
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Creando loader [" + name + "].", ex);
        }
    }

    public void goMain() {
        try {
            AppContext.getInstance().set("mainStage", this.mainStage);
            FXMLLoader loader = getLoader("");
            Controller controller = loader.getController();
            this.mainStage.setScene(new Scene(loader.getRoot()));
            controller.initialize();
            controller.setStage(mainStage);
            this.mainStage.setMaximized(false);
            this.mainStage.setResizable(true);
            this.mainStage.setMaxWidth(1050);
            this.mainStage.setMinWidth(800);
            this.mainStage.setMaxHeight(700);
            this.mainStage.setMinHeight(580);
            //this.mainStage.getIcons().add(new Image(""));
            this.mainStage.setTitle("");
            this.mainStage.show();
            
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Error inicializando la vista base.", ex);
        }
    }

    public void goView(String viewName) {
        goView(viewName, "Center", null);
    }

    public void goView(String viewName, String accion) {
        goView(viewName, "Center", accion);
    }

    public void goView(String viewName, String location, String accion) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setAccion(accion);
        controller.initialize();
        Stage stage = controller.getStage();
        if (stage == null) {
            stage = this.mainStage;
            controller.setStage(stage);
        }
        switch (location) {
            case "Center":
                ((VBox) ((BorderPane) stage.getScene().getRoot()).getCenter()).getChildren().clear();
                ((VBox) ((BorderPane) stage.getScene().getRoot()).getCenter()).getChildren().add(loader.getRoot());
                break;
            case "Top": break;
            case "Bottom": break;
            case "Right": break;
            case "Left": break;
            default: break;
        }
    }

    public void goViewInStage(String viewName, Stage stage) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setStage(stage);
        stage.getScene().setRoot(loader.getRoot());
    }

    public void goViewInWindow(String viewName, Boolean resizable, Boolean maximized) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        Stage stage = new Stage();
    //    stage.getIcons().add(new Image(""));
    //    stage.setTitle("");
        stage.setOnHidden((WindowEvent event) -> {
            controller.getStage().getScene().setRoot(new Pane());
            controller.setStage(null);
        });
        controller.setStage(stage);
        controller.initialize();
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(resizable.booleanValue());
        stage.setMaximized(maximized.booleanValue());
        stage.show();

    }

    public void goViewInWindowModal(String viewName, Boolean resizable, StageStyle stageStyle) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        Stage stage = new Stage();
    //    stage.getIcons().add(new Image(""));
    //    stage.setTitle("");
        stage.setResizable(resizable);
        stage.setOnHidden((WindowEvent event) -> {
            controller.getStage().getScene().setRoot(new Pane());
            controller.setStage(null);
        });
        controller.setStage(stage);
        controller.initialize();
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(stageStyle);
        stage.centerOnScreen();
        stage.showAndWait();

    }

    public Controller getController(String viewName) {
        return getLoader(viewName).getController();
    }
    
    public void initialize() {
        this.loaders.clear();
    }

    public void salir() {
        this.mainStage.close();
    }

    public FXMLLoader getNewLoader(String name){
        return getFXMLLoader(name);
    }
    
    public Stage getMainStage(){
        return this.mainStage;
    }
    
    public Boolean hayLoader(String nombre){
        FXMLLoader load = loaders.get(nombre);
        if(load != null){
            return true;
        }
        return false;
    }
    
    public void eliminarLoader(String name){
        if(hayLoader(name)){
            loaders.remove(name);
        }
    }
}
