
import java.io.*;

class EmployeeFileHandler
{
    public static void saveRecords(int noOfRoomsIn, EmployeeList listIn)
    {

            try
            {
                FileOutputStream employeeFile = new FileOutputStream("Employees.dat");
                DataOutputStream employeeWriter;
                employeeWriter = new DataOutputStream(employeeFile);
                employeeWriter.writeInt(listIn.getTotal());
                for(int i=1; i <= noOfRoomsIn; i++)
                {
                       if(listIn.getEmployee(i) != null)
                       {
                          employeeWriter.writeInt(listIn.getEmployee(i).geteid());
                          employeeWriter.writeUTF(listIn.getEmployee(i).getName());
                          employeeWriter.writeUTF(listIn.getEmployee(i).getemail());
                          employeeWriter.writeUTF(listIn.getEmployee(i).getninumber());
                          employeeWriter.writeInt(listIn.getEmployee(i).getnumber());
                          employeeWriter.writeInt(listIn.getEmployee(i).getSalarly().getTotal());
                          for(int j = 1; j<= listIn.getEmployee(i).getSalarly().getTotal(); j++)
                          {
                              employeeWriter.writeUTF(listIn.getEmployee(i).getSalarly().getSalarly(j).getMonth());
                              employeeWriter.writeDouble(listIn.getEmployee(i).getSalarly().getSalarly(j).getAmount());
                              employeeWriter.writeDouble(listIn.getEmployee(i).getSalarly().getSalarly(j).getTax());
                              employeeWriter.writeDouble(listIn.getEmployee(i).getSalarly().getSalarly(j).getAni());
                              employeeWriter.writeDouble(listIn.getEmployee(i).getSalarly().getSalarly(j).getGpay());
                              
                           }
                       }
                }
                employeeWriter.flush();
                employeeWriter.close();
            }
            catch(IOException ioe)
            {
                System.out.println("Error writing file");
            }

    }

    public static void readRecords(EmployeeList listIn)
    {

        try
        {
            
               FileInputStream employeeFile = new FileInputStream("Employees.dat");
               DataInputStream employeeReader;
               employeeReader = new DataInputStream(employeeFile);

               int tempeid = 0;
               int tempnumber = 0;
               String tempName = new String("");
               
               String tempemail = new String("");
               String tempni = new String("");
               String tempMonth = new String("");
               double tempAmount = 0 ;
               double tempAni = 0;
               double tempTax = 0;
               double tempGpay = 0;
               Employee tempEmployee = null;
               Salarly tempSalarly =  null;
               int tot = 0;
               int totpay = 0;

               tot = employeeReader.readInt();
               
               for(int j = 1; j<=tot; j++)
               {
                      tempeid = employeeReader.readInt();
                      tempName = employeeReader.readUTF();
                      tempemail = employeeReader.readUTF();
                      tempnumber = employeeReader.readInt();
                      tempni = employeeReader.readUTF();
                      tempEmployee = new Employee( tempName,tempeid,tempemail,tempnumber,tempni);
                      
                      totpay = employeeReader.readInt();
                      
                      for(int k = 1; k<= totpay; k++)
                      {
                          
                          tempMonth = employeeReader.readUTF();
                          
                          tempAmount = employeeReader.readDouble();
                          tempTax = employeeReader.readDouble();
                          tempAni = employeeReader.readDouble();
                          tempGpay = employeeReader.readDouble();
                          tempSalarly = new Salarly(tempMonth, tempAmount,tempTax,tempAni,tempGpay);
                          tempEmployee.makeSalarly(tempSalarly);
                          
                      }
                      listIn.addEmployee(tempEmployee);
                      
                  }
                  employeeReader.close();
         }

         catch(IOException ioe)
         {
            System.out.println("No records found");
         }

    }
}
