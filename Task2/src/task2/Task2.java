/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import task2.util.FlowController;

/**
 *
 * @author IVAN
 */
public class Task2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FlowController.getInstance().InitializeFlow(stage);
        FlowController.getInstance().goViewInWindowModal("Loging", Boolean.TRUE, StageStyle.UTILITY);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
