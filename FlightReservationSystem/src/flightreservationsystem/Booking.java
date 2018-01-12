package flightreservationsystem;


import flightreservationsystem.ComboFlight;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soumalya
 */
public class Booking {
     private String name,booking_reference_number;
     private int no_of_tickets;
   private ComboFlight cf;
    Boolean b;
    Booking(String name,int no_of_tickets,String booking_reference_number,ComboFlight cf){
    this.name=name;
    this.booking_reference_number=booking_reference_number;
    this.no_of_tickets=no_of_tickets;
    this.cf=cf;
    //this.transitTime=transitTime;    
     }
    public String getName(){return name;}
    public String getBookingNumber(){return booking_reference_number;}
    public int getNumberOfTickets(){return no_of_tickets;}
    public ComboFlight getComboFlight(){return cf;}
    
}
