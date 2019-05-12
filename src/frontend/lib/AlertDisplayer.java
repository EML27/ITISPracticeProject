package frontend.lib;

import javafx.scene.control.Alert;

import static javafx.scene.control.Alert.AlertType;

public class AlertDisplayer {

    public static void display(String header, String title, String content, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(header);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }


}
