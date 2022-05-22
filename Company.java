
import java.text.NumberFormat;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;



public class Company extends Application
{
    // the attributes
    
    private int noOfeids;
    private EmployeeList list;
    // WIDTH and HEIGHT of GUI stored as constants 
    private final int WIDTH = 1100;
    private final int HEIGHT = 650;
    // visual components
    private Label headingLabel = new Label("Amit's Company");
    
    private Label eidLabel1 = new Label("ID*");
    private TextField eidField1 =  new TextField();
    private Label nameLabel = new Label("Name");
    private TextField nameField =  new TextField();
    private Label emailLabel = new Label("Email");
    private TextField emailField =  new TextField();
    private Label numberLabel = new Label("Phone Number");
    private TextField numberField =  new TextField();
    private Label niLabel = new Label("NI Number");
    private TextField niField =  new TextField();
    private Button addButton = new Button("Add Employee");
    private Button displayButton =  new  Button("Display Employees");
    private Button removeButton  = new Button("Remove Employee");
    private Button saveAndQuitButton  = new Button("Save and Quit");
    private TextArea displayArea1  = new TextArea();
    private Label eidLabel2 = new Label("ID*");
    private TextField eidField2  = new TextField();
    private Label monthLabel = new Label("Month");
    private TextField monthField  = new TextField();
//    private Label amountLabel = new Label("Amount");
//    private TextField amountField =  new TextField();
//    private Label taxLabel = new Label("Tax");
//    private TextField taxField =  new TextField();
//    private Label aniLabel = new Label("NI Amount");
//    private TextField aniField =  new TextField();
    private Label gpayLabel = new Label("Gross Pay");
    private TextField gpayField =  new TextField();
    private Button paymentButton  = new Button("Make Payment");
    private Button listButton  = new Button("List Payments"); 
    private TextArea displayArea2 =  new TextArea();
	
     

    
    @Override
    /** Initialises the screen 
     *  @param stage:   The scene's stage 
     */
    public void start(Stage stage)
    {
        
     
        
        
        
    
        
        
       noOfeids = getNumberOfeids(); // call private method 
	 	// initialise Employee list
       list  = new EmployeeList(noOfeids);   
       EmployeeFileHandler.readRecords(list);
            
       // create four HBoxes
       HBox eidDetails = new HBox (10);
       HBox employeeButtons = new HBox(10);
       HBox paymentDetails = new HBox(10);
       HBox paymentButtons = new HBox(10);
       // add components to HBoxes
       eidDetails.getChildren().addAll(eidLabel1, eidField1, nameLabel, nameField,emailLabel,emailField,numberLabel,numberField,niLabel,niField);
       employeeButtons.getChildren().addAll(	addButton, displayButton, removeButton,	saveAndQuitButton);
       paymentDetails.getChildren().addAll(	eidLabel2, eidField2, monthLabel, monthField, gpayLabel, gpayField);
       paymentButtons.getChildren().addAll(   paymentButton, listButton);
       // create VBox
       VBox root = new VBox(10);
       //StackPane eroot = new StackPane();
      //eroot.setId("pane");
        
       
       root.setId("pane");
       // add all components to VBox
       root.getChildren().addAll(headingLabel, eidDetails, employeeButtons, displayArea1,
 										paymentDetails, paymentButtons, displayArea2);
       // create the scene
      // Scene scene = new Scene(root, Color.LIGHTBLUE);
       Scene scene = new Scene(root, Color.LIGHTGREEN);
       
       
       //scene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
        
		// set font of heading
       Font font = new Font("Calibri", 40);
       headingLabel.setFont(font);
       
 		// set alignment of HBoxes
       eidDetails.setAlignment(Pos.CENTER);
       employeeButtons.setAlignment(Pos.CENTER);
       paymentDetails.setAlignment(Pos.CENTER);
       paymentButtons.setAlignment(Pos.CENTER);
       // set alignment of VBox
       root.setAlignment(Pos.CENTER);
        
       // set minimum and maximum width of components 
       eidField1.setMaxWidth(50);
       eidField2.setMaxWidth(50);
        
       eidDetails.setMinWidth(WIDTH);
       eidDetails.setMaxWidth(WIDTH);
        
       employeeButtons.setMinWidth(WIDTH);
       employeeButtons.setMaxWidth(WIDTH);
        
       paymentDetails.setMinWidth(WIDTH);
       paymentDetails.setMaxWidth(WIDTH);
        
       paymentButtons.setMinWidth(WIDTH);
       paymentButtons.setMaxWidth(WIDTH);
        
       root.setMinSize(WIDTH, HEIGHT);
       root.setMaxSize(WIDTH, HEIGHT);
        
       displayArea1.setMaxSize(WIDTH - 80, HEIGHT/5);
       displayArea2.setMaxSize(WIDTH - 80, HEIGHT/5);
         
       stage.setWidth(WIDTH);
       stage.setHeight(HEIGHT);    

       // customise the visual components
        
       // customise the VBox border and background
       BorderStroke style = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
                                                                                           new CornerRadii(0), new BorderWidths(2) );
       root.setBorder(new Border (style));
       root.setBackground(Background.EMPTY);
               
       // customise buttons
       addButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,     
    									new CornerRadii(10), Insets.EMPTY)));
       displayButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW, 
											new CornerRadii(10), Insets.EMPTY)));
       removeButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW, 
										new CornerRadii(10), Insets.EMPTY)));
       saveAndQuitButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW, 
												new CornerRadii(10), Insets.EMPTY)));
       paymentButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW, 
											new CornerRadii(10), Insets.EMPTY)));
       listButton.setBackground(	new Background(new BackgroundFill(Color.LIGHTYELLOW, 
										new CornerRadii(10), Insets.EMPTY)));
        
       // call private methods for button event handlers
       addButton.setOnAction(e -> addHandler());
       displayButton.setOnAction(e -> displayHandler() );
       removeButton.setOnAction( e -> removeHandler());
       paymentButton.setOnAction( e -> paymentHandler());
       listButton.setOnAction( e -> listHandler());
        saveAndQuitButton.setOnAction( e -> saveAndQuitHandler());
        
       // configure the stage and make the stage visible
       stage.setScene(scene);
		stage.setTitle("Amit's Company");
       stage.setResizable(false); // see discussion below
       stage.show(); 
    
    }

    /**
     * Method to request number of Company eids from the user
     * @return number of eids
     */
    private int getNumberOfeids()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Entere the number of Employee?");
        dialog.setTitle("Employee Information Request");
          
        String response = dialog.showAndWait().get(); 
        return Integer.parseInt(response);    }

	// event handler methods

    private void addHandler()
    {
        String eidEntered =  eidField1.getText();
        String nameEntered =  nameField.getText();
        String emailEntered =  emailField.getText();
        String numberEntered =  numberField.getText();
        String niEntered =  niField.getText();
        // check for errors
        if(eidEntered.length()== 0 || nameEntered.length()== 0) 
        {
            displayArea1.setText ("Employee details must be entered");
        } 
        else if(Integer.parseInt(eidEntered)< 1 || Integer.parseInt(eidEntered)>noOfeids)
        {
            displayArea1.setText ("There are only "  + noOfeids  + " Employee");
        } 
        else if(list.search(Integer.parseInt(eidEntered)) !=  null)
        {
            displayArea1.setText("Employee ID " +  Integer.parseInt(eidEntered)  + " is occupied");
        }
        else  // ok to add a Employee
        {
            
            Employee t =  new Employee(nameEntered,Integer.parseInt(eidEntered),emailEntered, Integer.parseInt(numberEntered), niEntered);
            list.addEmployee(t);
            eidField1.setText("");
            nameField.setText("");
            emailField.setText("");
            numberField.setText("");
            niField.setText("");
            displayArea1.setText("New Employee with ID " +  eidEntered +  " successfully added");
        }
    }
    
    public void displayHandler()
    {
        int i;
        if(list.isEmpty()) // no eids to display
        {
            displayArea1.setText("There is no any employee in this company.");
        } 
        else // display eids
        {
            displayArea1.setText("ID" +  "\t\t" +  "Name" + "\t\t"+"NI Number"+"\t\t"+ "Email"+ "\t\t"+ "Number" + "\n");
            for(i = 1; i <=  list.getTotal(); i++ )
            {
                displayArea1.appendText(list.getEmployee(i).geteid() 
                                        + "\t\t" 
                                        + list.getEmployee(i).getName()
                                        +"\t\t"
                                        +list.getEmployee(i).getninumber()
                                        + "\t\t\t"
                                        +list.getEmployee(i).getemail()
                                        + "\t\t"
                                        + list.getEmployee(i).getnumber());
            }
        }
    }
    
    private void removeHandler()
    {
        String eidEntered =  eidField1.getText();
        // check for errors
        if(eidEntered.length()== 0)
        {
            displayArea1.setText("Employee ID must be entered.");
        } 
        else if(Integer.parseInt(eidEntered) < 1 || Integer.parseInt(eidEntered)>noOfeids)
        {
            displayArea1.setText("Invalid Imployee ID.");
        } 
        else if(list.search(Integer.parseInt(eidEntered))== null)
        {
            displayArea1.setText("Employee ID " +  eidEntered +  " is empty");
        } 
        else // ok to remove Employee
        {
            list.removeEmployee(Integer.parseInt(eidEntered));
            displayArea1.setText("Employee with ID " +  Integer.parseInt(eidEntered)+" is removed.");
        }
    }
    
    private void paymentHandler()
    {
        
        double taxEntered;
        double amountEntered;
        double aniEntered ;
        String eidEntered = eidField2.getText();
        String monthEntered = monthField.getText();
 //       double amountEntered =Double.parseDouble( amountField.getText());
//        double taxEntered = Double.parseDouble(taxField.getText());
//        double aniEntered = Double.parseDouble(aniField.getText());
         double gpayEntered = Double.parseDouble(gpayField.getText());
      
        // check for errors
        if(eidField2.getLength()== 0 || monthField.getLength()== 0 || gpayField.getLength()== 0)
        {
            displayArea2.setText("Employee ID, Month and Amount must all be entered.");
        } 
        else if(Integer.parseInt(eidEntered) < 1 || Integer.parseInt(eidEntered)>noOfeids)
        {
            displayArea2.setText("Invalid Employee ID.");
        } 
        else if(list.search(Integer.parseInt(eidEntered)) == null)
        {
            displayArea2.setText("Employee ID " +  eidEntered +  " is empty.");
        } 
        else // ok to process payment
        {
            
            
            if(gpayEntered <= 1000){
                    taxEntered= 0;
                    aniEntered=0;
                }
            else if (gpayEntered>1000 || gpayEntered<=3000)
                    {
                        taxEntered= gpayEntered*0.1;
                        aniEntered= gpayEntered*0.05;
                    }
            
            else
            {
                    taxEntered= gpayEntered*0.2;
                    aniEntered= gpayEntered*0.12;
       
                    }
            
            amountEntered = gpayEntered - (taxEntered+ aniEntered);
            Salarly p =  new Salarly(monthEntered,amountEntered,taxEntered,aniEntered,gpayEntered);
            list.search(Integer.parseInt(eidEntered)).makeSalarly(p);
            displayArea2.setText("Payment succesfull.");
        }
//            Payment p =  new Payment(monthEntered,Double.parseDouble(amountEntered));
//            list.search(Integer.parseInt(eidEntered)).makePayment(p);
//            displayArea2.setText("Payment recorded");
//        }
    }
    
    private void listHandler()
    {
        int i;
        String eidEntered =  eidField2.getText();
        // check for errors
        if(eidEntered.length()== 0)
        {
            displayArea2.setText("Employee ID must be entered.");
        } 
        else if(Integer.parseInt(eidEntered) < 1 || Integer.parseInt(eidEntered) > noOfeids)
        {
            displayArea2.setText("Invalid Employee ID.");
        } 
        else if(list.search(Integer.parseInt(eidEntered)) == null)
        {
            displayArea2.setText("Employee with ID " + Integer.parseInt(eidEntered) + " is empty");
        } 
        else // ok to list payments
        {
            Employee t =  list.search(Integer.parseInt(eidEntered));
            SalarlyList p  = t.getSalarly();
            if(t.getSalarly().getTotal() == 0)
            {
                displayArea2.setText("No payments made for this Employee");
            } 
            else
            {  
         /* The NumberFormat class is similar to the DecimalFormat class that we used
 					  previously.
    The getCurrencyInstance method of this class reads the system values to find out which country we are in, then uses the correct currency symbol */
                NumberFormat nf =  NumberFormat.getCurrencyInstance();
                String s;
                displayArea2.setText("Month" +  "\t\t" +  "Net Amount" +"\t\t"+
                                                        "Tax Amount"+"\t"+"Ni Amount"+"\t\t"+"Gross Amount"+  "\n");
                for(i =  1; i <=  p.getTotal(); i++  )
                {
                    s =  nf.format(p.getSalarly(i).getAmount());
                    displayArea2.appendText("" + p.getSalarly(i).getMonth() +  "\t\t" + s 
                                                    +"\t\t\t "
                                                    + p.getSalarly(i).getTax()
                                                    +"\t\t\t"
                                                    + p.getSalarly(i).getAni()
                                                    +"\t\t\t"
                                                    + p.getSalarly(i).getGpay()
                                                    +"\n");
                } 
                displayArea2.appendText("\n" + "Total paid so far :   " + nf.format(p.calculateTotalPaid()));
                monthField.setText("");
                gpayField.setText("");
            } 
       }
    }
    
    private void saveAndQuitHandler()
    {
       EmployeeFileHandler.saveRecords(noOfeids,list);
		Platform.exit();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    

}

