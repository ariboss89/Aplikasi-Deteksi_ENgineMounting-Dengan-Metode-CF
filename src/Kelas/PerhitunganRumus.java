/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kelas;

/**
 *
 * @author User
 */
public class PerhitunganRumus {
    private double cfUserxPakar;
    private double cfOld;
    private double cfOld2;
    private Double test;
    
    public double hitungCfUser(double cfUser, double cfPakar){        
        cfUserxPakar = cfUser*cfPakar;
        return cfUserxPakar;
    }
    
    public double hitungCfOld(double cf1, double cf2){
        cfOld = cf1+cf2*(1-cf1);
        return cfOld;
    }
    
    public double hitungCfOld2(double cf3){
        
        test=cfOld;
        //cfOld2 = cfOld+cf3*(1-cfOld);
        //return cfOld2;
        return test;
    }
    
    public String getNama(String nama){
        return nama;
    }
}
