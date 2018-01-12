package flightreservationsystem;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soumalya
 */
public class BookingManager {

    ComboFlight cf;
     String name;int no_of_tickets;
     String booking_number;
  
      public Booking book(String  name,int no_of_tickets,ComboFlight cf){
          this.cf=cf;
          booking_number=randomNumberGenerator();
           Booking b=new Booking(name, no_of_tickets, booking_number, cf);
           return b;
       }
      public String randomNumberGenerator(){
           int min=10000,max=99999;
           int randomNum = min + (int)(Math.random() * max);
           String s="ss"+randomNum;
           return s;
      }

}