
public class Employee
{
	private String name;
	private int eid;
        private String email;
        private int number;
        private String ni;
	private SalarlyList Salarly;
	public static final int MAX = 12;
	
  /** Constructor initialises the name and Employee ID  of the Employee
	*  and sets the payments made to the empty list
  	*  @param  nameIn: name of Employee
     * @param eidIn
     * @param emailIn
     * @param numberIn
     * @param niIn
     
	*/
	public Employee(String nameIn, int eidIn, String emailIn, int numberIn, String niIn)
	{
            name = nameIn;
            eid = eidIn;
            email= emailIn;
            number= numberIn;
            ni=niIn;
            Salarly = new SalarlyList(MAX);
	}
	
  /** Records a payment for the tenant 
   *  @param salarlyIn: payment made by tenant
   */
	public void makeSalarly(Salarly salarlyIn)
	{
            Salarly.addSalarly(salarlyIn); // call PaymentList method
	}
        
  /** Reads the name of the tenant
   *  @return Returns the name of the Employee
   */
	public String getName()
	{
            return name;
	}
	
  /** Reads the room of the tenant 
   *  @return Returns the Employee ID of the Employee
   */
	public int geteid()
	{
            return eid;
	}
	/** Reads the room of the tenant 
   *  @return 
   */
        public String getemail()
        {
            return email;
        }
        
        /** Reads the room of the tenant 
   *  @return 
   */
        public int getnumber()
        {
            return number;
        }
        
        /**
         *
         * @return 
         */
        public String getninumber()
        {
            return ni;
        }
        
  /** Reads the payments of the tenant 
   *  @return 
   */
	public SalarlyList getSalarly()
	{
            return Salarly;
	}
        
   @Override
	public String toString()
   {
            return eid +", "+ Salarly +","+ name +", "+ email +","+ number+"," + ni;
   }

    
    


}
 