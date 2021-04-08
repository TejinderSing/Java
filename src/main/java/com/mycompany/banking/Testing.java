package com.mycompany.banking;

import java.util.*;
import java.io.*;
public class Testing {
    
    Scanner sc=new Scanner(System.in);
    public static void fillData() throws IOException{
            FileWriter emp = new FileWriter("employe.txt",true);
            PrintWriter pw = new PrintWriter(emp);
            
            Scanner sc = new Scanner(System.in);
            
            do{
                System.out.println("Enter Name");
                String name = sc.next();
                System.out.println("Enter city");
                String city = sc.next();
                pw.println("[name: "+name+" city: "+city+" ]");
                System.out.println("Press 0 to stop");
            }while(sc.nextInt() != 0);
            pw.close();
        }
    public static void readData() throws IOException{
        FileInputStream empFile=new FileInputStream("employe.txt");
        BufferedReader br=new BufferedReader(new InputStreamReader(empFile));
        String line;
        String fellas[] = null;
        while((line = br.readLine())!=null){
            fellas = line.split(",");
        }
        for(String ee:fellas){
            System.out.println(ee);
        }
    }
//    public static void main(String[] args) {
//        
////		ArrayList<Fulltime> empList=new ArrayList<>();
////		fillData();
//		
////		readFromFile();
////		printList();
//	
//
//	}
//    
////        public static void fillData() throws IOException{
////            FileWriter emp = new FileWriter("employe.txt",true);
////            PrintWriter pw = new PrintWriter(emp);
////            
////            Scanner sc = new Scanner(System.in);
////            
////            do{
////                System.out.println("Enter Name");
////                String name = sc.next();
////                System.out.println("Enter city");
////                String city = sc.next();
////                pw.println("[name: "+name+" city: "+city+" ]");
////                System.out.println("Press 0 to stop");
////            }while(sc.nextInt() != 0);
////            pw.close();
////        }
//	//method to read the details of the employees entered by the user
//	//fill the details in the list and finally fill the list into a text file
////	public static void fillData() throws IOException {
////		
////		//create a new file named employee.txt, if the file exists will be overwritten
////		FileWriter emp = new FileWriter("employee.txt",true);
////		PrintWriter pw=new PrintWriter(emp);
////		
////		Scanner sc=new Scanner(System.in);
//////		do {
//////			System.out.println("Enter the id:");
//////			int id=sc.nextInt();
//////			System.out.println("Enter the first name:");
//////			String first=sc.next();
//////			System.out.println("Enter the last name:");
//////			String last=sc.next();
//////			System.out.println("Enter the address:");
//////			sc.nextLine();
//////			String address=sc.nextLine();
//////			System.out.println("Enter the age:");
//////			int age=sc.nextInt();
//////			System.out.println("Press 1 for Full time and 2 for Part time:");
//////			switch(sc.nextInt()) {
//////			case 1:
//////				System.out.println("Enter the salary:");
//////				double salary=sc.nextDouble();
////////				Fulltime ft=new Fulltime(id,first,last,address,salary,age);
////////				empList.add(ft);
//////				pw.println(ft.writeToFile());
//////				break;
//////			case 2:
//////				System.out.println("Enter the hour rate:");
//////				double rate=sc.nextDouble();
//////				System.out.println("Enter no. of hours:");
//////				int hours=sc.nextInt();
//////				Fulltime pt=new Parttime(id,first,last,address,rate,age,hours);
//////				empList.add(pt);
//////				pw.println(pt.writeToFile());
//////				break;
//////				default:System.out.println("wrng choice");
//////			
//////			}
//////			System.out.println("Press 0 to stop or any number to insert more employees:");
//////		}while(sc.nextInt()!=0);
//////		pw.close();
//////	}
////	
////	//a method to read form the file and then do whatever
////	//here we will read form the file and fill the array list
////	Scanner sc=new Scanner(System.in);
////		ArrayList<Fulltime> empList=new ArrayList<>();
////		fillData(empList);
////		
////		readFromFile(empList);
////		printList(empList);
////		
////
////	}
////	//method to read the details of the employees entered by the user
////	//fill the details in the list and finally fill the list into a text file
////	public static void fillData(ArrayList<Fulltime> empList) throws IOException {
////		
////		//create a new file named employee.txt, if the file exists will be overwritten
////		FileWriter emp = new FileWriter("employee.txt",true);
////		PrintWriter pw=new PrintWriter(emp);
////		
////		Scanner sc=new Scanner(System.in);
////		do {
////			System.out.println("Enter the id:");
////			int id=sc.nextInt();
////			System.out.println("Enter the first name:");
////			String first=sc.next();
////			System.out.println("Enter the last name:");
////			String last=sc.next();
////			System.out.println("Enter the address:");
////			sc.nextLine();
////			String address=sc.nextLine();
////			System.out.println("Enter the age:");
////			int age=sc.nextInt();
////			System.out.println("Press 1 for Full time and 2 for Part time:");
////			switch(sc.nextInt()) {
////			case 1:
////				System.out.println("Enter the salary:");
////				double salary=sc.nextDouble();
////				Fulltime ft=new Fulltime(id,first,last,address,salary,age);
////				empList.add(ft);
////				pw.println(ft.writeToFile());
////				break;
////			case 2:
////				System.out.println("Enter the hour rate:");
////				double rate=sc.nextDouble();
////				System.out.println("Enter no. of hours:");
////				int hours=sc.nextInt();
////				Fulltime pt=new Parttime(id,first,last,address,rate,age,hours);
////				empList.add(pt);
////				pw.println(pt.writeToFile());
////				break;
////				default:System.out.println("wrng choice");
////			
////			}
////			System.out.println("Press 0 to stop or any number to insert more employees:");
////		}while(sc.nextInt()!=0);
////		pw.close();
////	}
////	
////	//a method to read form the file and then do whatever
////	//here we will read form the file and fill the array list
////	public static void readFromFile(ArrayList<Fulltime> empList) throws IOException
////	{
////		FileInputStream empFile=new FileInputStream("employee.txt");
////		BufferedReader br=new BufferedReader(new InputStreamReader(empFile));
////		
////		Fulltime ft;
////		String line;
////		while((line=br.readLine())!=null) {
////			String fields[]=line.split(",");
////			int id=Integer.parseInt(fields[0]);
////			String fullName=fields[1];
////			String names[]=fullName.split(" ");
////			double sal=Double.parseDouble(fields[3]);
////			int age=Integer.parseInt(fields[4]);
////			if(fields.length==5) {
////				ft=new Fulltime(id,names[0],names[1],fields[3],sal,age);
////				empList.add(ft);
////			}
////			else {
////				int hours=Integer.parseInt(fields[5]);
////				ft=new Parttime(id,names[0],names[1],fields[3],sal,age,hours);
////				empList.add(ft);
////			}
////			
////			
////		}
////		
////		
////		
////	}
////	//print the content of the array list
////			public static void printList(ArrayList<Fulltime> empList) {
////				for(Fulltime emp:empList)
////					System.out.println(emp);
////				
////}
////	//print the content of the array list
////			public static void printList(ArrayList<Fulltime> empList) {
////				for(Fulltime emp:empList)
////					System.out.println(emp);
////				
////
////    }
//    
}
