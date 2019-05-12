package frontend.controllers;

import frontend.lib.Checker;
import frontend.lib.PropertiesHandler;
import frontend.lib.PropertiesSetter;
import frontend.lib.References;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements IMainPageController{

    @FXML
    @Override
    public void openSettingsPage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(References.SETTINGS_PAGE_FXML_PATH));
        Scene scene = new Scene(root);
        Stage stage2 = new Stage(StageStyle.DECORATED);
        stage2.setResizable(false);
        stage2.setTitle("Настройки");
        stage2.setScene(scene);
        stage2.show();
        if (Checker.getInstance().checkFirstTime()) {
            Parent root1 = FXMLLoader.load(getClass().getResource(References.SEARCHING_FILES_PAGE_FXML_PATH));
            Scene scene1 = new Scene(root1);
            Stage stage1 = new Stage(StageStyle.DECORATED);
            stage1.setTitle("Поиск файлов");
            stage1.setScene(scene1);
            stage1.setResizable(false);
            stage1.setOnCloseRequest(Event::consume);
            stage1.initModality(Modality.APPLICATION_MODAL);
            stage1.show();
            PropertiesHandler.getInstance().save("first-time", "false");
        }
        PropertiesHandler.getInstance().save("open-settings", "true");
    }

    @FXML
    @Override
    public void openResetPage() throws IOException {
        Parent root;
        if(!Checker.getInstance().checkOpenSettings()) {
            root = FXMLLoader.load(getClass().getResource(References.RESET_FIRSTTIME_PAGE_FXML_PATH));
            Scene scene = new Scene(root);
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("Ошибка!");
            stage.setScene(scene);
            stage.show();
        } else {
            root = FXMLLoader.load(getClass().getResource(References.RESET_PAGE_FXML_PATH));
            Scene scene = new Scene(root);
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Восстановить");
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PropertiesSetter.getInstance().initialize();
    }
}
