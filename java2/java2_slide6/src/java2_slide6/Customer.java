/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_slide6;

/**
 *
 * @author Pham Thu Trang
 */
public class Customer {
    int amount=1000;
    public synchronized  void withdraw(int m){
        System.out.println("banj dang rut tien");
        if(amount<m){
            System.out.println("khong dur tien der rut");
            try{
                wait();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        amount=amount+m;
        System.out.println("ban dax rut tien thanh cong");
    }
    synchronized void deposit(int m){
        System.out.println("banj dang nap tien.....");
       amount=amount+m;
        System.out.println("nap tien thanh cong");
        notify();
    }
    public static void main(String[] args) {
        final Customer c=new Customer();
        Thread thl=new Thread(){
            public void run(){
                c.withdraw(1500);
            }
        };
        thl.start();
        
        Thread th2=new Thread(){
             public void run(){
        
        c.deposit(2000);
         }
        };
        th2.start();
    }}
    
