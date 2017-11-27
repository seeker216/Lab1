package boundary;

import control.seekShortestPathControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class seekShortestPath {
	@FXML
	private TextField sPword1, sPword2;
	@FXML
	private TextArea sPresult;
	@FXML
	private Button sPbutton;
	@FXML
	protected void shortestPath(ActionEvent event) {
		seekShortestPathControl seekShortestPathControl = new seekShortestPathControl();
		sPresult.setText(seekShortestPathControl.calcShortestPath(sPword1.getText(), sPword2.getText()));
	}
}
