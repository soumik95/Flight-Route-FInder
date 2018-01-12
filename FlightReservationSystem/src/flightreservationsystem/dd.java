/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Soumalya
 */
public class dd {
   public static void main(String args[]) throws IOException{
     DataManager m = new DataManager();
    ArrayList<Flight> al=m.readSilkAir();
   //m.read_spiceJetArray();
      //String[] s=m.read_book();
      // boo
      int i=0;
     /* while(s[i]!=null){
          System.out.println(s[i]);i++;
      }*/
      //m.write_book(s);
      //m.readSilkAir();
      
    }
}
