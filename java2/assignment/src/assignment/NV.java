/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.io.Serializable;

/**
 *
 * @author Pham Thu Trang
 */
public class NV implements Serializable {

    public String MNV, HoTen, Email;
    public int Tuoi;
    public long Luong;

    public NV(String MNV, String HoTen, String Email, int Tuoi, long Luong) {
        this.MNV = MNV;
        this.HoTen = HoTen;
        this.Email = Email;
        this.Tuoi = Tuoi;
        this.Luong = Luong;
    }
     NV() {
        MNV=null;
        HoTen=null;
        Email=null;
        Tuoi=0;
        Luong=0;
    }

    public String getMNV() {
        return MNV;
    }

    public void setMNV(String MNV) {
        this.MNV = MNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public long getLuong() {
        return Luong;
    }

    public void setLuong(long Luong) {
        this.Luong = Luong;
    }
    
}