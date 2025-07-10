package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(10, 10, 10, 10));
			pane.setHgap(5.5);
			pane.setVgap(5.5);
			pane.setStyle("-fx-background-color: darkgray");
						
//			Image usFlag = new Image("file:C:\\Users\\lunes\\eclipse-workspace\\SDEV200\\week5\\ch14\\src\\images\\us-flag.png");
//			Image uaFlag = new Image("file:C:\\Users\\lunes\\eclipse-workspace\\SDEV200\\week5\\ch14\\src\\images\\ua-flag.png");
//			Image deFlag = new Image("file:C:\\Users\\lunes\\eclipse-workspace\\SDEV200\\week5\\ch14\\src\\images\\de-flag.png");
//			Image plFlag = new Image("file:C:\\Users\\lunes\\eclipse-workspace\\SDEV200\\week5\\ch14\\src\\images\\pl-flag.png");
			
			String path = getClass().getResource("/images/us-flag.png").toExternalForm();
			Image usFlag = new Image(path);
			String path2 = getClass().getResource("/images/ua-flag.png").toExternalForm();
			Image uaFlag = new Image(path2);
			String path3 = getClass().getResource("/images/de-flag.png").toExternalForm();
			Image deFlag = new Image(path3);
			String path4 = getClass().getResource("/images/pl-flag.png").toExternalForm();
			Image plFlag = new Image(path4);


			
			ImageView pictureViewer = new ImageView(usFlag);
			pictureViewer.setFitHeight(100);
			pictureViewer.setFitWidth(100);
			pictureViewer.setPreserveRatio(true);
			ImageView pictureViewer2 = new ImageView(uaFlag);
			pictureViewer2.setFitHeight(100);
			pictureViewer2.setFitWidth(100);
			pictureViewer2.setPreserveRatio(true);
			ImageView pictureViewer3 = new ImageView(deFlag);
			pictureViewer3.setFitHeight(100);
			pictureViewer3.setFitWidth(100);
			pictureViewer3.setPreserveRatio(true);
			ImageView pictureViewer4 = new ImageView(plFlag);
			pictureViewer4.setFitHeight(100);
			pictureViewer4.setFitWidth(100);
			pictureViewer4.setPreserveRatio(true);
			
			pane.add(pictureViewer, 0, 0);
			pane.add(pictureViewer2, 0, 1);
			pane.add(pictureViewer3, 1, 0);
			pane.add(pictureViewer4, 1, 1);
			
			
			Scene scene = new Scene(pane);
			primaryStage.setTitle("ImageGrid");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
