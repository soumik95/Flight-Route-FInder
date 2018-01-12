package flightreservationsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soumalya
 */
public class ComboFlight {
    private Flight f_spicejet;
    private Flight f_silkair;
    private String source;
    private String destination;
    private int transit_time;
    private int flight1_index;
    private int flight2_index;
    private int total_journey_time;

    public ComboFlight(Flight f_spicejet,Flight f_silkair,String source,String destination,int transit_time,int flight1_index,int flight2_index,int total_journey_time){
       this.f_spicejet=f_spicejet;
       this.f_silkair=f_silkair;
       this.source=source;
       this.destination=destination;
       this.transit_time=transit_time;
       this.flight1_index=flight1_index;
       this.flight2_index=flight2_index;
       this.total_journey_time=total_journey_time;
      // this.transitTime=transitTime;
    }
    /*The two flights are available and each and every field of search screen can be accessed from here*/


   
    
    public String getSource(){return source;}
    public String getDestination(){return destination;}
    public Flight getMatchFlightSpicejet(){return f_spicejet;}//details of Spicejet flight(flight 1)
    public Flight getMatchFlightSilkair(){return f_silkair;}//details of SilkAir flight(flight 2)
    public int gettransitTime(){return transit_time;}//The total time of journey
    public int get_flight1_index(){return flight1_index;}
    public int get_flight2_index(){return flight2_index;}
    public int get_totaltime() { return total_journey_time;}
}
