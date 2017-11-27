package boundary;

import control.seekBridgeWordControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class seekBridgeWord {
	@FXML
	private TextField bWword1, bWword2, bWresult;
	@FXML
	private Button bWbutton;
	@FXML
	void setBrigeWord(ActionEvent event) {
		seekBridgeWordControl seekBridgeWordControl=new seekBridgeWordControl();
		String ret = seekBridgeWordControl.queryBridgeWords(bWword1.getText(), bWword2.getText());
		if (ret.equals("")) {
			bWresult.setText("No "+bWword1.getText()+" or "+bWword2.getText()+" in the graph!");
		} else if (ret.equals(" ")) {
			bWresult.setText("No bridge words from word1 to word2!");
		} else {
			String out = "";
			String[] str_list = ret.split(" ");
			if (str_list.length == 1) {
				out = out + str_list[0];
			} else {
				for (int index = 0; index < str_list.length; index++) {// form the format
					if (index == str_list.length - 1) {
						out = out + " and " + str_list[index] + ".";
					} else if (index == str_list.length - 2) {
						out = out + str_list[index];
					} else {
						out = out + str_list[index] + ',';
					}
				}
			}
			bWresult.setText("The bridge words from word1 to word2 are:" + out + ".");
		}
	}
}
