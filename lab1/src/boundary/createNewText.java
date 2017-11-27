package boundary;

import control.createNewTextControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class createNewText {
	@FXML
	private TextArea oldText,newText;
	@FXML
	private Button cTbutton;
	@FXML
	void subCreateNewText(ActionEvent event) {
		createNewTextControl createNewTextControl = new createNewTextControl();
		String input = oldText.getText();
		newText.setText("the new text is as follows:" + createNewTextControl.generateNewText(input));
	}
}
