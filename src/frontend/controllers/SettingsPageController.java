package frontend.controllers;

import fileDeliver.ContainerDealer;
import fileDeliver.CopyMaker;
import frontend.lib.AlertDisplayer;
import frontend.lib.Checker;
import frontend.lib.InitHelper;
import frontend.lib.PropertiesHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Scanner;


public class SettingsPageController implements ISettingsPageController{

    public static LinkedList<String> programsList;

    @FXML
    public ListView<String> programsListView;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Checker.getInstance().checkSearchingFiles()) {
            programsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            programsList = InitHelper.initProgramsList();
            ObservableList<String> observableList = FXCollections.observableList(programsList);
            programsListView.setItems(observableList);
        }
    }

    @FXML
    @Override
    public void selectAll() {

    }

    @Override
    public void save() throws IOException {
        ContainerDealer.initiate();
        for(String elem : programsListView.getSelectionModel().getSelectedItems()) {
            File temp = new File("configs/" + elem);
            System.out.println(temp);
            File conf = ContainerDealer.add(temp, "options" + PropertiesHandler.getInstance().get("options-id"));
            System.out.println(conf.toString());
            PropertiesHandler.getInstance().save("options-id", getOptionPropertyValue());
            CopyMaker.makeCopy(conf, new File("./support/"+ elem +".txt"));
        }
//        try {
//            FilesToDBHandler.getInstance().convert(getFilesReadyForHandler());
//        } catch (SQLException e) {
//            throw new IllegalArgumentAlert(e);
//        }
        AlertDisplayer.display("Статус:", "Сохранено!", "Все настройки программ успешно сохранены!", Alert.AlertType.INFORMATION);
    }

    private String getOptionPropertyValue() {
        String s = PropertiesHandler.getInstance().get("options-id");
        Scanner scanner = new Scanner(s);
        int value = scanner.nextInt();
        value++;
        return "" + value;
    }

//    private List<File> getFilesReadyForHandler() {
//        List<File> listFiles = new ArrayList<>();
//        return listFiles;
//    }
}
