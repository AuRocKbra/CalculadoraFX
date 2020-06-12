package gui.util;

import javafx.scene.control.TextField;

public class Constrains {
	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches(".=")) {
				txt.setText(oldValue);
			}
		});
	}
}
