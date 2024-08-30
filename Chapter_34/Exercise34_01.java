mport javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class Ex34_1 extends Application {
    // Create Labels and fields
    private Label lblStatus = new Label();

    private Label lblID = new Label("ID");
    private TextField txtID =  new TextField();

    private Label lblLastName = new Label("Last Name");
    private TextField txtLastName =  new TextField();

    private Label lblFirstName = new Label("First Name");
    private TextField txtFirstName =  new TextField();

    private Label lblMiddleInitial = new Label("Middle Initial");
    private TextField txtMiddleInitial =  new TextField();

    private Label lblAddress = new Label("Address");
    private TextField txtAddress =  new TextField();

    private Label lblCity = new Label("City");
    private TextField txtCity =  new TextField();

    private Label lblState = new Label("State");
    private TextField txtState =  new TextField();

    private Label lblTelephone = new Label("Telephone");
    private TextField txtTelephone =  new TextField();

    private Label lblEmail = new Label("Email");
    private TextField txtEmail =  new TextField();

    private Button btnView = new Button("View");
    private Button btnInsert = new Button("Insert");
    private Button btnUpdate = new Button("Update");
    private Button btnClear = new Button("Clear");

    private Statement stmt;     // Holds SQL statements


    @Override // Override the start method in Application class
    public void start(Stage primaryStage) throws Exception {

        // Create Boxes for Labels and Fields
        HBox hbox1 = new HBox(5);
        hbox1.getChildren().addAll(lblID, txtID);
        HBox hbox2 = new HBox(5);
        txtMiddleInitial.setPrefWidth(25);
        hbox2.getChildren().addAll(lblLastName, txtLastName, lblFirstName, txtFirstName,
                lblMiddleInitial, txtMiddleInitial);
        HBox hbox3 = new HBox(5);
        hbox3.getChildren().addAll(lblAddress, txtAddress);
        HBox hbox4 = new HBox(5);
        hbox4.getChildren().addAll(lblCity, txtCity, lblState, txtState);
        HBox hbox5 = new HBox(5);
        hbox5.getChildren().addAll(lblTelephone, txtTelephone, lblEmail, txtEmail);

        // Create Vbox to hold Hbox
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5);

        // Create Hbox for buttons
        HBox btnBox =  new HBox(5);
        btnBox.getChildren().addAll(btnView, btnInsert, btnUpdate, btnClear);
        btnBox.setAlignment(Pos.CENTER);

        // Create BorderPane to hold all other boxes
        BorderPane pane = new BorderPane();
        pane.setTop(lblStatus);     // status field to top
        pane.setCenter(vbox);       // Main Labels and Fields to Center
        pane.setBottom(btnBox);     // Buttons set to bottom

        // Create a scene and set it in stage
        Scene scene =  new Scene(pane, 535, 200);
        primaryStage.setTitle("Chapter 34 Ex.1 - Staff");   // Set Title
        primaryStage.setScene(scene);   // Place scene in stage
        primaryStage.show();    // show stage

        // Initialize Database
        initializeDB();

        // Connect buttons to methods
        btnView.setOnAction(e -> view());
        btnInsert.setOnAction(e -> insert());
        btnClear.setOnAction(e -> clear());
        btnUpdate.setOnAction(e -> update());
    }

    //  sets text in txt fields from respective data in database entry
    private void loadFields(ResultSet rs) throws SQLException {
        if (rs.next()) {
            txtLastName.setText(rs.getString(2));
            txtFirstName.setText(rs.getString(3));
            txtMiddleInitial.setText(rs.getString(4));
            txtAddress.setText(rs.getString(5));
            txtCity.setText(rs.getString(6));
            txtState.setText(rs.getString(7));
            txtTelephone.setText(rs.getString(8));
            txtEmail.setText(rs.getString(9));
            lblStatus.setText("Record Found");
        } else {
            txtLastName.setText("");
            txtFirstName.setText("");
            txtMiddleInitial.setText("");
            txtAddress.setText("");
            txtCity.setText("");
            txtState.setText("");
            txtTelephone.setText("");
            txtEmail.setText("");
            lblStatus.setText("Record Not Found");
        }
    }

    // View takes ID from form to get info from database
    private void view() {
        String query = "SELECT * FROM staff WHERE ID = '" + txtID.getText().trim() + "'";
        try {
            ResultSet rs = stmt.executeQuery(query);
            loadFields(rs);
        }
        catch (SQLException ex) {
            lblStatus.setText("Query Failed");
            System.out.println("There is a problem with the query" + ex);
        }
    }

    // insert method takes info from field to make a new entry in database
    private void insert() {
        String insertQuery = "INSERT INTO staff (id, lastName, firstName, mi, address," +
                "city, state, telephone, email) VALUES ('" + txtID.getText().trim() +
                "' , '" + txtLastName.getText().trim() +
                "' , '" + txtFirstName.getText().trim() +
                "' , '" + txtMiddleInitial.getText().trim() +
                "' , '" + txtAddress.getText().trim() +
                "' , '" + txtCity.getText().trim() +
                "' , '" + txtState.getText().trim() +
                "' , '" + txtTelephone.getText().trim() +
                "' , '" + txtEmail.getText().trim() + "');";
        try {
            stmt.executeUpdate(insertQuery);
            lblStatus.setText("Insert Successful");
            System.out.println("Insert Successful");
        }
        catch (SQLException ex) {
            lblStatus.setText("Insert Failed" + ex);
            System.out.println("Insert Failed" + ex);
        }

    }

    // void clears form of all text
    private void clear() {
        txtID.setText(null);
        txtLastName.setText(null);
        txtFirstName.setText(null);
        txtMiddleInitial.setText(null);
        txtAddress.setText(null);
        txtCity.setText(null);
        txtState.setText(null);
        txtTelephone.setText(null);
        txtEmail.setText(null);
        lblStatus.setText(null);
    }

    // updates database entry matching ID with fields from form
    private void update() {
        String updateQuery = "UPDATE staff SET " +
                " lastName = '" + txtLastName.getText().trim() +
                "' , firstName = '" + txtFirstName.getText().trim() +
                "' , mi = '" + txtMiddleInitial.getText().trim() +
                "' , address = '" + txtAddress.getText().trim() +
                "' , city = '" + txtCity.getText().trim() +
                "' , state = '" + txtState.getText().trim() +
                "' , telephone = '" + txtTelephone.getText().trim() +
                "' , email = '" + txtEmail.getText().trim() +
                "' WHERE id = '" + txtID.getText().trim() + "';";
        try {
            stmt.executeUpdate(updateQuery);
            lblStatus.setText("Record Updated");
        } catch (SQLException ex) {
            lblStatus.setText("Update Failed " + ex);
            System.out.println("Update Failed " + ex);
        }

    }

    // Loads driver and connects to database
    private void initializeDB() {
        try {
            // Loads Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded\n");
            // Connects to database
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/javabook", "scott", "tiger");
            System.out.println("Database connected\n");
            lblStatus.setText("Database Connected");
            stmt = connection.createStatement();

        } catch (Exception Ex) {
            System.out.println("Something went wrong with the Database" + Ex);
            lblStatus.setText("Database Connection Failed");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
} 
