/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking;

public class AccountHolder {
   String name;
   String id;
   String contact_no;
   String address;
   public AccountHolder(String name, String id, String contact_no){
       this.name = name;
       this.id = id;
       this.contact_no = contact_no;
       this.address = "dsfs";
   }
   
    /**
     *
     */
    @Override
    public String toString(){
       return "Nothing";
    }
    public String toWrite(){
        return name+","+id+","+contact_no+","+address;
    }
}
