package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import java.sql.*;


public class Main extends Application {
	private Statement statement;
	private TextField tfID = new TextField();
	private TextField tfLastName = new TextField();
	private TextField tfFirstName = new TextField();
	private TextField tfMI = new TextField();
	private TextField tfAddress = new TextField();
	private TextField tfCity = new TextField();
	private TextField tfState = new TextField();
	private TextField tfPhone = new TextField();
	private Label lblStatus = new Label();
	
	private void initializeDB() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded.");
		
		// Create connection to db
		Connection connection = DriverManager.getConnection
				("jdbc:mysql://localhost/javabook", "scott", "tiger");
		
		// Create a statement
		statement = connection.createStatement();
		
		// validate connection was successful
		ResultSet rs = statement.executeQuery("SELECT DATABASE()");
		if (rs.next()) {
			System.out.println("Connected to: " + rs.getString(1));
		}
	}
	
	private void showRecord() {
		String id = tfID.getText();
		try {
			String queryString = "SELECT id , lastName , firstName , mi , address , city , state , telephone , email " +
								"FROM Staff " +
								" WHERE id = '" + tfID.getText() + "'";
			
			ResultSet rset = statement.executeQuery(queryString);
			
			if (rset.next()) {
				String qid = rset.getString(1);
				String lastName = rset.getString(2);
				String firstName = rset.getString(3);
				String mi = rset.getString(4);
				String address = rset.getString(5);
				String city = rset.getString(6);
				String state = rset.getString(7);
				String telephone = rset.getString(8);
				
				tfID.setText(qid);
				tfLastName.setText(lastName);
				tfFirstName.setText(firstName);
				tfMI.setText(mi);
				tfAddress.setText(address);
				tfCity.setText(city);
				tfState.setText(state);
				tfPhone.setText(telephone);
				
			 lblStatus.setText("Record Found."); 
			 } else {
				lblStatus.setText("Record not found.");
			 }
		}

			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	
	private void insertRecord() {

		try {
			if (tfID.getText() != null) {
				
				
				String sql = "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				
				
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, tfID.getText());
				pstmt.setString(2, tfLastName.getText());
				pstmt.setString(3, tfFirstName.getText());
				pstmt.setString(4, tfMI.getText());
				pstmt.setString(5, tfAddress.getText());
				pstmt.setString(6, tfCity.getText());
				pstmt.setString(7, tfState.getText());
				pstmt.setString(8, tfPhone.getText());
				int rowsInserted = pstmt.executeUpdate(sql);
				
				lblStatus.setText("Record successfully added to database.");

				
			} else {
				lblStatus.setText("Record must contain an ID.");
			}
		}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
	}	
		 
	
	
	private void clearRecord() {
		tfID.setText("");
		tfLastName.setText("");
		tfFirstName.setText("");
		tfMI.setText("");
		tfAddress.setText("");
		tfCity.setText("");
		tfState.setText("");
		tfPhone.setText("");
		
		lblStatus.setText("Record cleared from screen.");
	}
	
	
	@Override
	public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
			
		initializeDB();
		System.out.println(statement);
		
		try {
			Button btView = new Button("View");
			Button btIns = new Button("Insert");
			Button btUpdate = new Button("Update");
			Button btClear = new Button("Clear");
			GridPane grid = new GridPane();
			grid.setHgap(5);
			grid.setVgap(8);
			grid.add(lblStatus, 0, 0);
			grid.setColumnSpan(lblStatus, 6);
			grid.add(new Label("ID"), 0, 1);
			grid.add(tfID, 1, 1);
			grid.add(new Label("Last Name"), 0, 2);
			grid.add(tfLastName, 1, 2);
			grid.add(new Label("First Name"), 2, 2);
			grid.add(tfFirstName, 3, 2);
			grid.add(new Label("MI"), 4, 2);
			grid.add(tfMI, 5, 2);
			grid.add(new Label("Address"), 0, 3);
			grid.add(tfAddress, 1, 3);
			grid.add(new Label("City"), 0, 4);
			grid.add(tfCity, 1, 4);
			grid.add(new Label("State"), 2, 4);
			grid.add(tfState, 3, 4);
			grid.add(new Label("Telephone"), 0, 5);
			grid.add(tfPhone, 1, 5);
			grid.add(btView, 0, 6);
			grid.add(btIns, 1, 6);
			grid.add(btUpdate, 2, 6);
			grid.add(btClear, 3, 6);
			
			btView.setOnAction(e -> showRecord());
			btIns.setOnAction(e -> insertRecord());
			
			btClear.setOnAction(e -> clearRecord());
			
			Scene scene = new Scene(grid, 700, 250);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
