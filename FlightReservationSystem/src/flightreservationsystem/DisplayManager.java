/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem;

import java.util.ArrayList;


/**
 *
 * @author SKC
 */
public class DisplayManager {
    private frsUI sc1;
    private flightList sc2;
    private BookingScreen sc3;
    private confirmation sc4;
    FRSManager frs;
    Integer Tickets;
    String Source;
    String Date;
    
 
    public DisplayManager(FRSManager frs) {
        this.frs=frs;
        //DisplayManager dm=new DisplayManager();
        sc1=new frsUI(this);
        sc2=new flightList(this);
        sc3=new BookingScreen(this);
        sc4=new confirmation(this);
    }

    
    public void callSearch(String s, String d, int t) {
        frs.callSearch(s, d, t);
    }
    
    public void setTable(ArrayList<ComboFlight> flight) {
        sc2.setTable(flight);
    }
   
     public void getPassengerName(){
       String name=sc3.name;
   }
    public void getSelectedFlight(int i){
        frs.getSelectedFlight(i);
    }
    
    public void setBook(ComboFlight cf)
    {
      //  sc3.setBook(cf);
    }
    
    public void setname(String name)
    {
        frs.setname(name);
    }
    
    public Integer getTickets(){
     String t= sc1.tickets; 
     Tickets=Integer.parseInt(t);
     return Tickets;
    }
    
    public void setDetails(Booking book) 
    {
        sc4.setDetails(book);
    }
            
    public String getSource(){
     Source= sc1.s; 
     return Source;
    }
    
    public String getDate(){
      Date= sc1.d; 
     return Date;
    }
    
    /*public static void main(String[] args) {
        DisplayManager dm=new DisplayManager();
        dm.sc1=new frsUI(dm);
        dm.sc2=new flightList(dm);
        dm.sc3=new booking(dm);
        dm.sc4=new confirmation(dm);
        dm.show1();
    }*/
    
    
    
    public void show1() {
        sc1.setVisible(true);
        sc2.setVisible(false);
        sc3.setVisible(false);
        sc4.setVisible(false);
        sc1.setResizable(false);
    }
    public void show2() {
        sc1.setVisible(false);
        sc2.setVisible(true);
        sc3.setVisible(false);
        sc4.setVisible(false);
        sc2.setResizable(false);
    }
    public void show3() {
        sc1.setVisible(false);
        sc2.setVisible(false);
        sc3.setVisible(true);
        sc4.setVisible(false);
        sc3.setResizable(false);
}
    public void show4() {
        sc1.setVisible(false);
        sc2.setVisible(false);
        sc3.setVisible(false);
        sc4.setVisible(true);
        sc4.setResizable(false);
}
}
