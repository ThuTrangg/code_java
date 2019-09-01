/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author Pham Thu Trang
 */
public class OddThread  extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            if(i%2!=0){
                System.out.println(i);
            }
            try{
                Thread.sleep(10);
            }
            catch(InterruptedException e){
                break;
            }
        }
    }
    
}
