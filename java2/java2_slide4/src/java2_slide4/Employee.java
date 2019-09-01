/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2_slide4;



/**
 *
 * @author Pham Thu Trang
 */
public class Employee{
   public static void main(String args[]){
     try         {
            badMethod();  
            System.out.print("A"); 
        }  catch (Exception ex)  {
            System.out.print("B");  
        } finally {
            System.out.print("C"); 
        } 
        System.out.print("D"); 
    }  
    public static void badMethod()     {
        throw new Error(); 
    } 
}
    
   
