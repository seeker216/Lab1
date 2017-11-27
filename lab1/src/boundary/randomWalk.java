package boundary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import control.randomWalkControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class randomWalk {
	private String textToFile = new String("");
	@FXML
	private Button rWnext, rWend,rWstorepath;
	@FXML
	private TextArea rWresult;
	@FXML
	protected void nextStep(ActionEvent event) {
		randomWalkControl randomWalkControl = new randomWalkControl();
		String node = randomWalkControl.randomWalk();
		rWresult.appendText(node);
		if (!(node.equals("\r\nthe path is over!") || node.equals("\r\nthe path already exists!"))) {
			textToFile = textToFile.concat(node);
		}
	}

	@FXML
	protected void storePath(ActionEvent event) throws IOException {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String fileName = "D:\\" + dateFormat.format(date) + ".txt";
		File file = new File(fileName);
		file.createNewFile();
		BufferedWriter output = new BufferedWriter(new FileWriter(file));
		output.write(textToFile);
		output.close();
		Stage stage = new Stage();
		Label label = new Label("文件保存成功，路径为:" + fileName);
		Pane pane = new Pane();
		pane.getChildren().add(label);
		Scene myScene = new Scene(pane);
		stage.setScene(myScene);
		stage.show();
	}
}
