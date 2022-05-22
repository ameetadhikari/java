import java.text.NumberFormat;




public class MainMenu 
{  
  //   static int noOfRoomsIn;
  //   static TenantList list;

     
    public static void main(String[] args)
    {
        int eid;
        EmployeeList list;

     
     System.out.print("Enter total Position: ");
     eid = EasyScanner.nextInt(); // call private method 
     int position = eid ;
	 	// initialise Employee list
                System.out.print("This company have "+position+" position.");
     list  = new EmployeeList(eid);   
    EmployeeFileHandler.readRecords(list);
     
     char choice;
     do
     {   
        System.out.println();
        System.out.println("1. Add Employee");
        System.out.println("2. Employee Details");
        System.out.println("3. Fire Employee");
        System.out.println("4. Pay an Employee");
        System.out.println("5. List Of Payment");
        System.out.println("6. Save and Quit");
        System.out.println();
        System.out.print("Enter choice (1-6): ");
        choice = EasyScanner.nextChar();
        System.out.println();
        
        switch(choice)
        {
            case '1': addHandler(eid,list);
                      break;
            case '2': displayHandler(list);
                      break;
            case '3': removeHandler(eid,list);
                      break;
            case '4': paymentHandler(eid,list);
                      break;
            case '5': listHandler(eid,list);
                      break;
            case '6': saveAndQuitHandler(eid,list);
                      break;
            default: System.out.println("Enter 1-6 only");
                      
        }
     }while(choice!= '6');
        
        
    }

    /**
     * Method to request number of hostel rooms from the user
     * @return number of Employee id
     */


    static void addHandler(int noOfeidIn, EmployeeList listIn)
    {
        
        System.out.println("Enter Employee ID: ");
        int eidEntered = EasyScanner.nextInt();
        System.out.println("Enter Employee name: ");
        String nameEntered = EasyScanner.nextString();
        System.out.println("Enter Employee Email: ");
        String emailEntered = EasyScanner.nextString();
        System.out.println("Enter Phone Number: ");
        int numberEntered = EasyScanner.nextInt();
        System.out.println("Enter NI Number: ");
        String niEntered = EasyScanner.nextString();
     
        if(eidEntered < 1 || eidEntered > noOfeidIn)
        {
            System.out.println ("There are only "  + noOfeidIn  + " employee in company.");
      } 
        else if(listIn.search(eidEntered) !=  null)
        {
            System.out.println("The employee ID "  + eidEntered  + " is already taken.");
        }
        else  // ok to add a Employee
        {
            Employee t =  new Employee(nameEntered,eidEntered,emailEntered,numberEntered,niEntered);
            
            listIn.addEmployee(t);
            System.out.println("New employee with employee ID " +  eidEntered +  " successfully created.");
        }
    }
    
    static void displayHandler(EmployeeList listIn)
    {
        int i;
        if(listIn.isEmpty()) // no employee id to display
        {
            System.out.println("There is no one in this company.");
        } 
        else // display rooms
        {
            System.out.println("EmployeeID" +  "\t" +  "Name" + "\t"+"NI Number"+"\t"+ "Email"+ "\t\t"+ "Number" + "\n");
            for(i = 1; i <=  listIn.getTotal(); i++ )
            {
                System.out.println(listIn.getEmployee(i).geteid() 
                                        + "\t\t" 
                                        + listIn.getEmployee(i).getName()
                                        +"\t"
                                        +listIn.getEmployee(i).getninumber()
                                        + "\t\t"
                                        +listIn.getEmployee(i).getemail()
                                        + "\t\t"
                                        + listIn.getEmployee(i).getnumber());
            }
        }
    }
    
  static void removeHandler(int noOfeidIn, EmployeeList listIn)
    {
        System.out.println("Enter Employee ID: ");
        int eidEntered = EasyScanner.nextInt();
        // check for errors
        if(eidEntered < 1 || eidEntered>noOfeidIn)
        {
            System.out.println("The employee ID is invalid.");
        } 
        else if(listIn.search(eidEntered)== null)
        {
            System.out.println("There is no any employee with ID " +  eidEntered );
        } 
        else // ok to remove Employee
        {
            listIn.removeEmployee(eidEntered);
            System.out.println("Employee with employee ID " +  eidEntered +" is fired.");
        }
    }
    
    static void paymentHandler(int noOfeidIn, EmployeeList listIn)
    {
        double tax=0;
        double amount;
        double ani = 0;
        //double gpay;
        System.out.println("Enter employee ID: ");
        int eidEntered = EasyScanner.nextInt();
        System.out.println("Enter month of payment: ");
        String monthEntered = EasyScanner.nextString();
        System.out.println("Enter monthly salarly: ");
        double gpay = EasyScanner.nextDouble();
      
        // check for errors
      
        if(eidEntered < 1 || eidEntered>noOfeidIn)
        {
            System.out.println("The employee ID is invalid.");
        } 
        else if(listIn.search(eidEntered) == null)
        {
            System.out.println("There is no any employee with ID "+  eidEntered );
        } 
        else // ok to process payment
        {
            if(gpay <= 1000){
                    tax= 0;
                    ani=0;
                }
            else if (gpay>1000 || gpay<=3000)
                    {
                        tax= gpay*0.1;
                        ani= gpay*0.05;
                    }
            
            else
            {
                    tax= gpay*0.2;
                    ani= gpay*0.12;
                    }
            
            amount = gpay - (tax+ ani);
            Salarly p =  new Salarly(monthEntered,amount,tax,ani,gpay);
            listIn.search(eidEntered).makeSalarly(p);
            System.out.println("Payment succesfull.");
        }
    }
    
    static void listHandler(int noOfeidIn, EmployeeList listIn)
    {
        int i;
        System.out.println("Enter emplyee ID: ");
        int eidEntered = EasyScanner.nextInt();
        // check for errors
        if(eidEntered < 1 || eidEntered > noOfeidIn)
        {
            System.out.println("The employee ID is invalid.");
        } 
        else if(listIn.search(eidEntered) == null)
        {
            System.out.println("There is no any employee with ID " + eidEntered );
        } 
        else // ok to list payments
        {
            Employee t =  listIn.search(eidEntered);
            SalarlyList p  = t.getSalarly();
            if(t.getSalarly().getTotal() == 0)
            {
                System.out.println("There is no any payment record for this employee.");
            } 
            else
            {  
                // The NumberFormat class is similar to the DecimalFormat class that we previously.
                //   The getCurrencyInstance method of this class reads the system values to find out 				     
              //  which country we are in, then uses the correct currency symbol 
                NumberFormat nf =  NumberFormat.getCurrencyInstance();
                String s;
                System.out.println("Month" +  "\t" +  "Gross Pay" + "\t"+"Tax Amount"+"\t"+ "NI Amount"+ "\t"+ "Net Pay" + "\n");
                for(i =  1; i <=  p.getTotal(); i++  )
                {
                    s =  nf.format(p.getSalarly(i).getAmount());
                    System.out.println(""+ p.getSalarly(i).getMonth() + "\t" + p.getSalarly(i).getGpay() +"\t"+p.getSalarly(i).getTax()+"\t"+p.getSalarly(i).getAni()+"\t"+s+"\n");
                } 
                System.out.println("\n" + "Total paid so far :   " + 	nf.format(p.calculateTotalPaid()));
             } 
       } 
    }
    
    static void saveAndQuitHandler(int noOfeidIn, EmployeeList listIn)
    {
               EmployeeFileHandler.saveRecords(noOfeidIn,listIn);
    }

   

  

}


