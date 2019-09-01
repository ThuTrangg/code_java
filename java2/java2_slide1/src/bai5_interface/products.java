/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai5_interface;

/**
 *
 * @author Pham Thu Trang
 */
public class products implements DbAction {

   
    public void insert() {
        System.out.println("products  insert()");}
   
    public void update() {
   System.out.println("products  update()");}

   
    public void delete() {
   System.out.println("products  delete()");}
    
    public void select() {
   System.out.println("products  select()");}
}
