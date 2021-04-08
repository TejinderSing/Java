package com.mycompany.banking;

import java.util.*;
import java.io.*;
public class Main {
    
    public static void main(String[] args) throws IOException {
        //Creating array list
        ArrayList <Accounts> bank = new ArrayList<>();
        //Scanner object
        Scanner sc = new Scanner(System.in);
        //Write Data on File
        
        //Read Data from File
        
        //Print data of file
//        printData(bank);
        do{
            System.out.println("Please select an option:\n1 For Bank Employee\n2. For Bank Customer");
            switch (sc.next()){
                case "1":
                    do{
                        System.out.println("Please select an option:\n1 Creating an Account\n2. Getting user Information");
                        switch (sc.next()){
                            case "1":
                                fillData(bank);
                                break;
                            case "2":
                                printData(bank);
                                break;
                            default:
                                System.out.println("Make a valid choice");
                        }
                        System.out.println("Enter 0 to exit to Main Screen");
                    }while(sc.nextInt() != 0);
                    break;
                case "2":
                    transactions(bank);
                    break;
                default:
                    System.out.println("Make a valid choice");
            }
            System.out.println("Enter 0 to exit from Banking App");
        }while(sc.nextInt() != 0);
        
    }
    
    //Creating function to fillData
    public static void fillData(ArrayList<Accounts>bank) throws IOException{
        //Creating File object
        FileWriter cus = new FileWriter("bank.txt",true);
	PrintWriter pw=new PrintWriter(cus);
        
        //Class object
        Accounts obj;
        
        //Creating scanner class object
        Scanner sc = new Scanner(System.in);
        
//        //creating a flag
//        boolean flag = true;
        //getting data from user
        //counters
        //defining variable;
        String type;
        String account_number;
        double current_balance;
        double minimum_balance;
        double withdraw_limit;
        int choice;
        do{
            String select;
            System.out.println("Select a type of account:\n1. For Savings\n2. For Current");
            select = sc.next();
            System.out.println("Enter First Name");
            String fname = sc.next();
            System.out.println("Enter Last Name");
            String lname = sc.next();
            String name = fname+" "+lname;
            System.out.println("Enter ID number");
            String id = sc.next();
            System.out.println("Enter Contact Number");
            String contact_no = sc.next();
            switch (select){
                case "1":
                    System.out.println("Provide an Account number");
                    account_number = "SAV" + sc.next();
                    System.out.println("Enter money customer want to deposit");
                    current_balance = sc.nextDouble();
                    type = "Savings";
                    minimum_balance = 1000;
                    withdraw_limit = 25000;
                    obj = new Accounts(name,id,contact_no,type,account_number,minimum_balance,current_balance,withdraw_limit);
                    bank.add(obj);
                    pw.println(obj.toWrite());
                    break;
                case "2":
                    System.out.println("Provide an Account number");
                    account_number = "CUR" + sc.next();
                    System.out.println("Enter money customer want to deposit");
                    current_balance = sc.nextDouble();
                    type = "Current";
                    minimum_balance = 0;
                    withdraw_limit = 0;
                    obj = new Accounts(name,id,contact_no,type,account_number,minimum_balance,current_balance,withdraw_limit);
                    bank.add(obj);
                    pw.println(obj.toWrite());
                    break;
                default:
                    System.out.println("Wrong Choice");
                    
            }
            System.out.println("Press 0 to stop");
            choice = sc.nextInt();
        }while(choice != 0);
        pw.close();
    }
    
    //reading the file putting it in arrayList
    public static void readFile(ArrayList<Accounts>bank) throws IOException{
        bank.clear();
        FileInputStream empFile=new FileInputStream("bank.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(empFile));
		
		Accounts obj;
		String line;
		while((line=br.readLine())!=null) {
			String fields[]=line.split(",");
			String name = fields[0];
                        String id = fields[1];
                        String contact_no = fields[2]; 
                        String type = fields[3]; 
                        String account_number = fields[4]; 
                        double minimum_balance = Double.parseDouble(fields[5]);
                        double current_balance = Double.parseDouble(fields[6]);
                        double withdraw_limit = Double.parseDouble(fields[7]);
                        
			obj=new Accounts(name,id,contact_no,type,account_number,minimum_balance,current_balance,withdraw_limit);
			bank.add(obj);
		}
//                for(Accounts ob:bank){
////                  System.out.println("Hello1");
//                    System.out.println(ob);
//                    System.out.println("================================================================");
//                }
    }
    public static void printData(ArrayList<Accounts> bank) throws IOException{
        readFile(bank);
        for(Accounts ob:bank){
//            System.out.println("Hello1");

            System.out.println(ob);
        }
    }
    
    public static void transactions(ArrayList<Accounts>bank) throws IOException{
        //calling readFile()
        readFile(bank);
        FileWriter cus = new FileWriter("bank.txt",false);
	PrintWriter pw=new PrintWriter(cus);
        
        //scanner object
        Scanner sc = new Scanner(System.in);
        //counter
        int count = 0;
        //variables
        double amount;
        System.out.println("Enter Account Number");
        String acc_number =sc.next();    
        for(Accounts obj:bank){
            if(obj.getAccountNumber().equals(acc_number)){
                System.out.println(obj);
                count += 1;
                
                do{
                    System.out.println("Select an Option:\n1. For Money Deposit\n2. For Money Withdraw\n3. For Money Transfer\n4. Balance Enqiury");
                    switch(sc.next()){
                        case "1":
                            System.out.println("Enter amount you want to deposit");
                            amount = sc.nextDouble();
                            obj.setCurrentBalance(obj.getCurrentBalance() + amount);
                            break;
                        case "2":
                            System.out.println("Enter amount you want to withdraw");
                            amount = sc.nextDouble(); 
                            if(obj.getType().equals("Savings")){
                                if(obj.getWithdrawLimit() < amount){
                                    System.out.println("Amount is exceeded than withdraw limit!!!!!");
                                }
                                else{
                                    obj.setCurrentBalance(obj.getCurrentBalance() - amount);
                                }
                            }
                            else{
                                obj.setCurrentBalance(obj.getCurrentBalance() - amount);
                            }
                            break;
                        case "3":
                            System.out.println("Enter recipient's account number");
                            String recip_account = sc.next();
                            count = 0;
                            for(Accounts obj1:bank){
                                if(recip_account.equals(obj1.getAccountNumber())){
                                    count +=1;
                                    System.out.println("Name of the Recipient: "+obj1.getName());
                                    System.out.println("Enter amount you want to transfer");
                                    amount = sc.nextDouble();
                                    obj1.setCurrentBalance(obj1.getCurrentBalance() + amount);
                                    obj.setCurrentBalance(obj.getCurrentBalance() - amount);
                                    System.out.println("Transaction compeleted");
                                }
                            }
                            if(count == 0){
                                System.out.println("Account number not found!!!!");
                            }
                            break;
                        case "4":
                            System.out.println("Your balance is :" + obj.getCurrentBalance());
                            break;
                        default:
                            System.out.println("Wrong Choice");
                    }
                    System.out.println("Enter 0 to Exit or press any key to Continue");
                }while(sc.nextInt() != 0);
            }
            pw.println(obj.toWrite());
        }
        if(count == 0){
            System.out.println("Account Doesn't Found");
        }
        
        
        
        
        
//        do{
//            System.out.println("Select an Option:\n1. For Savings\n2. For Current");
//            switch(sc.next()){
//                case "1":
//                    do{
//                        count = 0;
//                        System.out.println("Enter Account Number");
//                        String acc_number =sc.next();
//                        for(Accounts obj:bank){
//                            if(obj.getAccountNumber().equals(acc_number) && obj.getType()=="Savings"){
//                                count += 1;
//                                System.out.println(obj);
//                                
//                            }
//                        }
//                                if(count == 0){
//                                    System.out.println("Account Doesn't Found");
//                                }
//                                System.out.println("Enter 0 to Exit to Customer  Screen or Press any other key to Continue");
//                            
//                            }while(sc.nextInt() != 0);     
//                    break;
//                case "2":
//                    
//                    break;
//                default:
//            }
//            System.out.println("Enter 0 to Exit to Main Screen or Enter any other key to Continue");
//        }while(sc.nextInt() != 0);
        
//        System.out.println("Enter Account Number");
//        String acc_number = "SAV" + sc.next();
//        for(Accounts obj:bank){
//            if(obj.getAccountNumber().equals(acc_number)){
//                System.out.println("Enter amount you want to deposit");
//                double amount = sc.nextDouble();
//                obj.setCurrentBalance(obj.getCurrentBalance() + amount);
//            }
//            pw.println(obj.toWrite());
//        }
        pw.close();
        cus.close();
       
        
    }
    
}
//do{
//                        System.out.println("Select an Option:\n1. For Money Deposit\n2. For Money Withdraw\n3. For Money Transfer\n4. Balance Enqiury");
//                        switch(sc.next()){
//                            case "1":
//                                System.out.println("Enter Account Number");
//                                String acc_number =sc.next();
//                                for(Accounts obj:bank){
//                                    if(obj.getAccountNumber().equals(acc_number)){
//                                        System.out.println("Enter amount you want to deposit");
//                                        double amount = sc.nextDouble();
//                                        obj.setCurrentBalance(obj.getCurrentBalance() + amount);
//                                    }
//                                    pw.println(obj.toWrite());
//                                }                                
//                            case "2":
//                            case "3":
//                            case "4":
//                            default:
//                        }
//                        System.out.println("Enter 0 to Exit to Customer  Screen or Press any other key to Continue");
//                    }while(sc.nextInt() != 0);
//                    break;