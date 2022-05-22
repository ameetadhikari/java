
// This class is used to store details of a single payment in a hostel

public class Salarly
{
	private String month;
	public double amount;
        //public int eid;
        public double tax;
        public double ani;
        public double gpay;
	
	public Salarly(String monthIn, double amountIn,double taxIn, double aniIn, double gpayIn)
	{
            month = monthIn;
            amount= amountIn;
            //eid= eidIn;
            tax=taxIn;
            ani=aniIn;
            gpay= gpayIn;
            
	}
	
	public String getMonth()
	{
            return month;
	}
	
	public double getAmount()
	{
           
            return amount;
	}
     
        public double getTax()
        {
            return tax;
        }
        public double getAni()
        {
            return ani;
        }
        public double getGpay()
        {
            return gpay;
        }
   @Override
	public String toString()
   {
            return "( " + month + ", "+  amount +"," +tax+","+ ani+","+ gpay +")";
   }

}

