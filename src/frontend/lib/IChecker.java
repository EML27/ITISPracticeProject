package frontend.lib;

import javafx.fxml.FXML;

public interface IChecker{

    @FXML
    boolean checkFirstTime();

    @FXML
    boolean checkOpenSettings();

    @FXML
    boolean checkSearchingFiles();
}
