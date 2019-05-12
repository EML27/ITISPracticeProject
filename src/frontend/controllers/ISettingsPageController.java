package frontend.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;

public interface ISettingsPageController extends Initializable {

    @FXML
    void selectAll();

    @FXML
    void save() throws IOException;

}
