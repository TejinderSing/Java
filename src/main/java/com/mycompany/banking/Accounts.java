/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking;

/**
 *
 * @author ACER
 */
public class Accounts extends AccountHolder {
    String type;
    String account_number;
    double minimum_balance;
    double current_balance;
    double withdraw_limit;
    
public Accounts(String name, String id, String contact_no, String type, String account_number, double minimum_balance, double current_balance,double withdraw_limit){
        super(name, id, contact_no);
        this.type = type;
        this.account_number = account_number;
        this.minimum_balance = minimum_balance;
        this.current_balance = current_balance;
        this.withdraw_limit = withdraw_limit;
    }

//    Accounts(String name, String id, String contact_no, String type, String account_number, String minimum_balance, String current_balance, String withdraw_limit) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
public double getCurrentBalance(){
    return current_balance;
}
public void setCurrentBalance(double balance){
    this.current_balance = balance;
}
public double getMinimumBalance(){
    return minimum_balance;
}
public double getWithdrawLimit(){
    return withdraw_limit;
}
public String getAccountNumber(){
    return account_number;
}
public String getName(){
    return name;
}
public String getType(){
    return type;
}
    @Override
    public String toString(){
        return "Account Number: "+account_number+"\tAccount Type: "+type+"\nName: "+name+"\tID Number: "+id+"\nCurrent Balance :"+current_balance+"\tMinimum Balance Limit:"+minimum_balance+"\nContact Number: "+contact_no;
    }
    
    @Override
    public String toWrite(){
        return name+","+id+","+contact_no+","+type+","+account_number+","+minimum_balance+","+current_balance+","+withdraw_limit;
    }
}
