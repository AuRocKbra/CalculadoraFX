package gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	public static void showAlertaDeException(String titulo, String header, String msg, AlertType type) {
		Alert alerta = new Alert(type);
		alerta.setTitle(titulo);
		alerta.setHeaderText(header);
		alerta.setContentText(msg);
		alerta.show();
	}
}
