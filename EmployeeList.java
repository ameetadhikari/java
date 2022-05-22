
import java.util.ArrayList;


public class EmployeeList  
{
    private ArrayList<Employee> tList;
    public final int MAX;
        
    /** Constructor initialises the empty tenant list and sets the maximum list size 
     *  @param   maxIn The maximum number of Employee in the list
     */
    public EmployeeList(int maxIn)
    {
        tList = new ArrayList<>();
        MAX = maxIn;
    }

    
	
    /** Adds a new Tenant to the list
     *  @param  tIn The Employee to add
     *  @return Returns true if the Employee was added successfully and false otherwise
     */
    public boolean addEmployee(Employee tIn)
    {
        if(!isFull())
        {
            tList.add(tIn);
            return true;
        }
        else
        {
            return false;
        }
    }
        
    /** Removes the tenant in the given room number
     * @param eidIn
     *  @return Returns true if the Employee is removed successfully or false otherwise
     */
    public boolean removeEmployee(int eidIn)
    {
        Employee findT = search(eidIn); // call search method
        if (findT != null) // check Employee is found at given room
        {
            tList.remove(findT); // remove given Employee
            return true;
        }
        else
        {
            return false;
        }
    }       
       
    /** Searches for the Employee in the given room number
     * @param eidIn
     *  @return 
     */
    public Employee search(int eidIn)
    {
        for(Employee currentEmployee: tList)
        {  
            // find Employee with given Employee ID
            if(currentEmployee.geteid() == (eidIn))
            {
                return currentEmployee;
            }
        }
        return null; // no tenant found 
    }
        
    /** Reads the Employee at the given position in the list
     *  @param      eidIn The logical position of the Employee in the list
     *  @return     Returns the Employee at the given logical position in the list
     *              or null if no Employee at that logical position
     */
    public Employee getEmployee(int eidIn)
    {
        if (eidIn<1 || eidIn>getTotal()) // check for valid position
        {
            return null; // no object found at given position
        }
        else
        {
            // remove one frm logical poition to get ArrayList position
            return tList.get(eidIn -1);
        }
    }
 

	/** Reports on whether or not the list is empty
     *  @return Returns true if the list is empty and false otherwise
     */
    public boolean isEmpty()
    {
        return tList.isEmpty();
    }
	
    /** Reports on whether or not the list is full
     *  @return Returns true if the list is full and false otherwise
     */	
    public boolean isFull()
    {
        return tList.size()== MAX;
    }
        
    /** Gets the total number of tenants 
     *  @return Returns the total number of Employee currently in the list 
     */
    public int getTotal()
    {       
        return tList.size();
    }
        
    @Override
    public String toString()
    {
        return tList.toString();
    }
}

