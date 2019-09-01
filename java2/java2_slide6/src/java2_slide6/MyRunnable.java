/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_slide6;

import static com.sun.glass.ui.Application.run;

/**
 *
 * @author Pham Thu Trang
 */
public class MyRunnable implements Runnable{
    public  synchronized void run(){
     for(int i=0;i<=10;i++){
         System.out.print(i);
         try{
             Thread.sleep(500);
             
         }
         catch(InterruptedException e){
             break;
         }
         
     }   
    }

public static void main(String[] args){
    MyRunnable run=new MyRunnable();
Thread t1=new Thread(run);//new MyRunnable());
t1.start();
    System.out.println("------");
Thread t2=new Thread( run);//new MyRunnable());
t2.start();
}
} 

