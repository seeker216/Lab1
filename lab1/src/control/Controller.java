package control;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import entity.Graph;
import entity.GraphViz;
import entity.PointInf;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {
	static Graph myGraph=new Graph();
	private final Desktop desktop = Desktop.getDesktop();
	public static final int MAX = 10000;
	public static String rand_point, rand_start, rand_pair, rand_show;
	public static boolean rand_finish;
	public static ArrayList<String> rand_pool;
	@FXML
	private Button showgraphb, seekbrigewordb, createnewtextb, seekshortestpathb, randomwalkb;
	
	@FXML
	protected void readText(ActionEvent event) {
		Stage stage1 = new Stage();
		openText(stage1);
	}

	@FXML
	protected void showDirectedGraph(ActionEvent event) {// draw the directed graph by graphviz
		GraphViz gV = new GraphViz();
		String adj;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		ArrayList<String> points;
		gV.addln(gV.start_graph());
		for (String value : myGraph.graph.keySet()) {
			points = myGraph.graph.get(value).getAdj();
			for (String des : points) {
				adj = value + "->" + des + "[label=\"" + myGraph.graph.get(value).getWeight().get(points.indexOf(des)) + "\"]";// add
				gV.addln(adj);
			}
		}
		gV.addln(gV.end_graph());
		String fileName = "D:\\" + dateFormat.format(date) + ".jpg";
		File file = new File(fileName);
		gV.writeGraphToFile(gV.getGraph(gV.getDotSource(), "jpg"), file);
		try {
			Desktop.getDesktop().open(new File(fileName));// open the graph
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	protected void seekBrigeWord(ActionEvent event) {
		Stage stage3 = new Stage();
		seekBrige(stage3);
	}
	
	@FXML
	protected void createNewText(ActionEvent event) {
		Stage stage4 = new Stage();
		createText(stage4);
	}

	@FXML
	protected void seekShortestPath(ActionEvent event) {
		Stage stage5 = new Stage();
		findPath(stage5);
	}

	@FXML
	protected void randWalk(ActionEvent event) {
		Stage stage6 = new Stage();
		randWalk(stage6);
	}

	public void buildGraph(String[] str_array) { // function producing the graph global variable
		PointInf value;
		int index;
		Integer w;
		for (int i = 0; i < str_array.length; i++) {
			if (str_array[i].equals("")) {
				continue;
			} else {
				value = myGraph.graph.get(str_array[i]);
				if (value == null)
					value = new PointInf();
				for (int j = i + 1; j < str_array.length; j++)
					if (!str_array[j].equals("")) {
						index = value.getAdj().indexOf(str_array[j]);
						if (index == -1) {
							value.getAdj().add(str_array[j]);
							value.getWeight().add(value.getAdj().indexOf(str_array[j]), 1);
						} else {
							w = value.getWeight().get(index) + 1;
							value.getWeight().add(index, w);
						}
						break;
					}
				myGraph.graph.put(str_array[i], value);
			}
		}
	}

	void openText(Stage stage) {
		stage.setTitle("选择文件");
		final FileChooser fileChooser = new FileChooser();
		Button openButton = new Button("打开文件");
		Label openLabel = new Label("...");
		openLabel.setWrapText(true);
		openLabel.setTranslateX(200);
		openButton.setOnAction((final ActionEvent e) -> {
			File file = fileChooser.showOpenDialog(stage);
			if (file != null) {
				openLabel.setText("文件打开成功");// if the file has been opened successfully,the other buttons will be visible
				showgraphb.setVisible(true);
				seekbrigewordb.setVisible(true);
				createnewtextb.setVisible(true);
				seekshortestpathb.setVisible(true);
				randomwalkb.setVisible(true);
				char[] buffer;
				Reader input = null;
				try {
					input = new FileReader(file);
					buffer = new char[(int) file.length()]; // text buffer
					input.read(buffer);
					String[] str_array = new String(buffer).toLowerCase().split("[^a-zA-Z]"); // split the original text
					input.close();
					buildGraph(str_array);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			} else {
				openLabel.setText("文件打开失败");// when failed to open the text,the other buttons won't be visible
				showgraphb.setVisible(false);
				seekbrigewordb.setVisible(false);
				createnewtextb.setVisible(false);
				seekshortestpathb.setVisible(false);
				randomwalkb.setVisible(false);
			}
		});

		GridPane inputGridPane = new GridPane();

		GridPane.setConstraints(openButton, 0, 0);
		inputGridPane.setHgap(6);
		inputGridPane.setVgap(6);
		inputGridPane.getChildren().addAll(openLabel);
		inputGridPane.getChildren().addAll(openButton);

		FlowPane rootGroup = new FlowPane();
		rootGroup.getChildren().addAll(inputGridPane);
		rootGroup.setPadding(new Insets(12, 12, 12, 12));

		stage.setScene(new Scene(rootGroup));
		stage.show();
	}

	void openFile(File file) {
		EventQueue.invokeLater(() -> {
			try {
				desktop.open(file);
			} catch (IOException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
	}
	
	void seekBrige(Stage stage) {
		stage.setTitle("查找桥接词");
		Pane myPane = null;
		try {
			myPane = (Pane) FXMLLoader.load(getClass().getResource("seekBridgeWordPage.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene myScene = new Scene(myPane);
		stage.setScene(myScene);
		stage.show();
	}

	void createText(Stage stage) {
		stage.setTitle("生成新文本");
		Pane myPane = new Pane();
		try {
			myPane = (Pane) FXMLLoader.load(getClass().getResource("createNewText.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene myScene = new Scene(myPane);
		stage.setScene(myScene);
		stage.show();
	}

	void findPath(Stage stage) {
		stage.setTitle("查找最短路径");
		Pane myPane = null;
		try {
			myPane = (Pane) FXMLLoader.load(getClass().getResource("seekShortestPath.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene myScene = new Scene(myPane);
		stage.setScene(myScene);
		stage.show();
	}

	void randWalk(Stage stage) {
		stage.setTitle("随机游走");
		rand_pool = new ArrayList<String>();
		rand_pair = rand_start = rand_point = "";
		rand_finish = false;
		Pane myPane = null;
		try {
			myPane = (Pane) FXMLLoader.load(getClass().getResource("randomWalk.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene myScene = new Scene(myPane);
		stage.setScene(myScene);
		stage.show();
	}

}
