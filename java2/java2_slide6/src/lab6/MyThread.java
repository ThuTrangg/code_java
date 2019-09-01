package lab6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pham Thu Trang
 */
public class MyThread implements Runnable{
    public void run(){
            for(int i=0;i<=10;i++){
                System.out.println(i);
                try{
                    Thread.sleep(500);
                }
                catch(InterruptedException e){
                    break;
                }
            }
        }
    
    public static void main(String[] args) throws InterruptedException {
        MyThread run=new MyThread();
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        t1.start();
        t1.join();
        t2.start();
    }
    
    
}
