import java.util.*; //importing useful java input package

public class Bank_Security    //public class name {Bank_Security}
{
    Map<String, Integer> valid = new HashMap<>(3);   //declaring a global hashmap to store the constraint outputs
    private long mainAccountCheck(Scanner in) {                    //function to check all the given constraints
        long number;                                            //instance input variable declaration
        while (true) {
            System.out.print("\nPlease Enter a Valid Account Number: ");       
            if (in.hasNextLong()){                              //checking for invalid input
                number = in.nextLong();
                getAccountLength(number);
                getAccountDigits(number);
                getAccountSumTotal(number);
                if(validAccount()==true)
                {
                    System.out.println("\n~::: ACCOUNT NUMBER VALID. THANK YOU FOR CHOOSING OUR BANK:::~");     //Displaying Appropriate Message for Valid Input
                    break;
                }
            }
            else{
                System.out.println("__Invalid Account Number. Account Number does not contain digits from 0 to 9.");
                in.next(); // Clear the invalid input
            }
        }
        return number;
    }
    public boolean validAccount()
    {
        int f=1;
        for(Map.Entry<String, Integer> entry : valid.entrySet()) 
        {
            String key = entry.getKey();    // Get the key
            Integer value = entry.getValue(); // Get the value
            if(value==0)
            {
                System.out.println(key);
                f=-1;
            }  
        }
        if(f==1)
        return true;
        else
        return false;
    }
    public void getAccountLength(long number) //constraint 1 boolean function to check if the Account Number Length is of 12 digits or not
    {
        int len=0;
        while(number!=0)
        {
            number/=10;
            ++len;                        //calculating the length
        }
        if(len<12 || len>12)             //checking if the length is of 12 
        valid.put("__Invalid Account Number. Account Number does not contain exactly 12 digits.",0);
        else
        valid.put("__Invalid Account Number. Account Number does not contain exactly 12 digits.",1);
    }
    public void getAccountDigits(long number) {    //constraint 2 boolean function to check if the Account Number contains digits from 0 to 9
        String numberStr = Long.toString(number);  // Convert long to string
        
        for (int i = 0; i < numberStr.length(); i++) {
            char digit = numberStr.charAt(i);
            if (digit < '0' || digit > '9') {            //checking if the input has digits from 0 to 9 and no string or characters
                valid.put("__Invalid Account Number. Account Number does not contain digits from 0 to 9.",0);
            }
        }
        valid.put("__Invalid Account Number. Account Number does not contain digits from 0 to 9.",1);
    }
    public void getAccountSumTotal(long number){  /***constraint 3 boolean function to check if the sum total of all 
                                                             the digits of the Account Number is equal to the last digit or not***/
        long sum=0;
        if(number % 9==0)                                    
        sum=9;
        else
        sum=number%9;

        if(sum==(number%10))               //checking if the sum total is equal to the last digit
        valid.put("__Invalid Account Number. The Sum total of the digits is not matching the last digit.",1);
        else
        valid.put("__Invalid Account Number. The Sum total of the digits is not matching the last digit.",0);
    }
    public static void main(String args[])  //main function of the class for calling the mainAccountCheck function
    {
        Scanner in = new Scanner(System.in);    //Creating object of Scanner class
        Bank_Security obj = new Bank_Security();     ///cfeating object of class {Bank_Security}
        obj.mainAccountCheck(in);                 //Passing the scanner class object as parameter to the maincheck function
        in.close();                         //closing the input stream to free memory resources
    } //end of main function()
} //end of class