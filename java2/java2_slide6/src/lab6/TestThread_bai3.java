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
public class TestThread_bai3 {
    public static void main(String[] args) throws InterruptedException {
        OddThread t1=new OddThread();
        t1.start();
        t1.join();
        System.out.println("");
        EvenThread t2=new EvenThread();
        t2.start();
    }
    
}
