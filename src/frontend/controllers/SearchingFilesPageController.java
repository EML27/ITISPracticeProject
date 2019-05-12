package frontend.controllers;

import frontend.lib.Checker;
import frontend.lib.PropertiesHandler;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import progFinder.FileGetter;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class SearchingFilesPageController implements ISearchingFilesPageController {

    @FXML
    public Text statusText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void onLoad(Event event){
        if(!Checker.getInstance().checkSearchingFiles()) {
            LinkedList<String> programsPaths = new LinkedList<>();
            FileGetter fg = new FileGetter(programsPaths);
            fg.run();
            PropertiesHandler.getInstance().save("searching-completed", "true");
        }
        statusText.setText("Статус: Успешно!!!");
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
        //TODO Обновить окно настроек
    }
}
