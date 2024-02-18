/*
/****  SINGLETON DESIGN PATTERN ****

  >> single ton design pattern is mostly used creational pattern in s/w development
  >> the disadvantages of using it outweigh the advantages it brings. For this reason, the singleton pattern is sometimes considered an antipattern or pattern singleton.
  
  >>when?
     >> only need one instance of class for client from well known access

   Real world eg:
      >> database Manager
	  >> logger
	  >> config
	  >> Hardware access
	  
    
   >>>>>>>> """ How to make a class into single ton """ <<<<<<<<

    1. make constructor as private
    2. Create one static instance class in inside of class
    3. method should be static , check every time for creation of object if null instance then only create obj instance other wise simply return already allocated instance	
	
	
	****>>>   It is not working when in the time of multi threading so to over come this problem use locking and unlocking (Synchronised) and double check
	
*/

    // code in java 
	import java.lang.*;
	import java.util.*;
	import java.io.*;
	
	 class SingleTon{
	     
		 public static SingleTon instance;
		 public static int count=0;
		 private SingleTon(){
			 count++;
		 }
		 
		 
		 public static SingleTon getInstance(){
			 
			 if(instance==null){
				 synchronized(SingleTon.class){
					 if(instance==null){
						 instance=new SingleTon();
					 }
				 }
			 }
			 System.out.println(count);
			 return instance;
		 }
	}
	
	public class SingleTon1{
		
		public static void main(String[] args){
			SingleTon obj=SingleTon.getInstance();
			SingleTon on=SingleTon.getInstance();
		}
	}