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
public class MyThread  extends Thread{
    public void run(){
     for(int i=0;i<=10;i++){
         System.out.println(i);
         try{
             Thread.sleep(1000);
             
         }
         catch(InterruptedException e){
             break;
         }
         
     }   
    }

public static void main(String[] args) throws InterruptedException{
MyThread t1=new MyThread();
t1.start();
t1.join();
MyThread t2=new MyThread();
t2.start();
//    System.out.println("Định Danh :"+t2.getId());
//    System.out.println("Tên :"+t2.getName());
//    System.out.println("Độ ưu tiên: "+t2.getPriority());
//    System.out.println("Trạng Thái :"+t2.getState());
//    System.out.println("Đang hoạt động :"+t2.isAlive());
//    System.out.println("Số lượng thread :"+Thread.activeCount());
}
}
