package frontend.controllers;

import fileDeliver.CopyMaker;
import frontend.lib.AlertDisplayer;
import frontend.lib.IllegalArgumentAlert;
import frontend.lib.InitHelper;
import frontend.lib.PropertiesHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ResetPageController implements IResetPageController {

    public static LinkedList<String> programsList;

    @FXML
    public ListView<String> programsListView;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        programsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        programsList = InitHelper.initProgramsList();
        ObservableList<String> observableList = FXCollections.observableList(programsList);
        programsListView.setItems(observableList);
    }


    @FXML
    @Override
    public void fix() {
        for(String elem : programsListView.getSelectionModel().getSelectedItems()) {
            String id = PropertiesHandler.getInstance().get("options-id");
            int value = Integer.parseInt(id);
            File configsPathList = new File("./configs/" + elem + "/options" + (--value) + "/realNames.txt");
            Scanner scanner;
            try {
                scanner = new Scanner(configsPathList);
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentAlert(e);
            }
            while(scanner.hasNext()) {
                String config = scanner.next();
                String configPath = scanner.next();
                File toWhere = new File(configPath);
                File toCopy = new File("./configs/" + elem + "/options" + (--value) + "/" + config);
                try {
                    CopyMaker.copyUtil(toCopy, toWhere);
                } catch (IOException e) {
                    throw new IllegalArgumentAlert("Невозможно вставить файл " + toCopy);
                }
            }
        }
        AlertDisplayer.display("Статус:", "Восстановлено!", "Все настройки программ успешно восстановлены!", Alert.AlertType.INFORMATION);
    }

    @FXML
    @Override
    public void selectAll() {

    }
}
