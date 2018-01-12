package flightreservationsystem;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchManager {    
    int diff;
    int total_journey_time;
    String origin_city;
    String journey_date;
    int no_of_tickets;
     public ArrayList<ComboFlight> search(String origin_city,String journey_date,int no_of_tickets,ArrayList a1,ArrayList a2,int a[],int b[])
       {     
        int flight1_date;
        String flight1_day;
        int flight2_date;
        String flight2_day;
     
        ArrayList al_cf = new ArrayList();
        
  
        // Conversion from dd/mm/yyy to yymmdd
         String[] st = journey_date.split("/");
        st[2] = Integer.toString(Integer.parseInt(st[2]) % 100);
        flight1_date = (Integer.parseInt(st[2]) * 100 + Integer.parseInt(st[1])) * 100 + Integer.parseInt(st[0]);
      
        flight1_day=get_day_of_week(Integer.toString(flight1_date+1));
        //flight1_day="SATURDAY";
            System.out.println(flight1_day);
        //Combo-Flight
        for(int i = 0; i < a1.size(); ++i) 
        {
            
            Flight f1 = (Flight)a1.get(i);
            //System.out.println(f1.getdepartureTime());
            String flight1_departure_city = f1.getdepartureCity();
            String flight1_arrival_city = f1.getarrivalCity();
            
            if(origin_city.equalsIgnoreCase(flight1_departure_city)) 
            {
               if(f1.getFrequency().equalsIgnoreCase("daily") || f1.getFrequency().toLowerCase().contains(flight1_day.toLowerCase())) 
                {
                    if(flight1_date >= Integer.parseInt(f1.getEffectiveFrom()) && flight1_date <= Integer.parseInt(f1.getEffectiveTill())) 
                    {
                        int flight1_departure_time = Integer.parseInt(f1.getdepartureTime());
                        int flight1_arrival_time = Integer.parseInt(f1.getarrivalTime());
                        
                        //Printig Flight1 Details
                       /* System.out.println("\n \n\n\n\nDeparture City for Flight1 is" + flight1_departure_city);
                        System.out.println("Flight 1: Effective from (in yymmdd format) " + f1.getEffectiveFrom() + " Till " + f1.getEffectiveTill());
                        System.out.println("Arrival City for Flight1 is" + flight1_arrival_city);
                        System.out.println("Frequency for Flight1: " + f1.getFrequency() + "Journey Day: "+flight1_day);
                        System.out.println("Flight1 Departure Time is "+ flight1_departure_time);
                        System.out.println("Flight1 Arrival Time is "+  flight1_arrival_time);
                           */
                        for(int j = 0; j < a2.size(); j++) 
                        {
                            Flight f2 = (Flight)a2.get(j);
                            
                            flight2_date = flight1_date;
                            flight2_day = flight1_day;
                            
                            if(f2.getdepartureCity().toLowerCase().contains(flight1_arrival_city.toLowerCase())) 
                            {
                             
                                int flight2_departure_time = Integer.parseInt(f2.getdepartureTime());
                                int flight2_arrival_time = Integer.parseInt(f2.getarrivalTime().substring(0,4));
                                
                                
                                if(flight2_date >= Integer.parseInt(f2.getEffectiveFrom()) && flight2_date <= Integer.parseInt(f2.getEffectiveTill()))
                                {
                                    //Flight 2 Details (To check Failed cases too)
                                    /*System.out.println("\n****Flight 2***");
                                    System.out.println("\t\tDeparture City for 2nd Flight is" + flight1_arrival_city);
                                    System.out.println("\t\tFlight 2: Effective from (in yymmdd format) " + f2.getEffectiveFrom() + " Till " + f2.getEffectiveTill());
                                    System.out.println("\t\tDeparture Time for 2nd Flight is" + flight2_departure_time);
                                     */try{
                                    String ans=check_timegap(flight1_arrival_time, flight2_departure_time,f2.getFrequency(),flight2_date,flight2_day);
                                    
                                    
                                   
                                    
                                    if(ans.equals("NA"))
                                    { //System.out.println("\t\tSorry Bruh,You Better Stay at Home");
                                    }
                                    if(ans.equals("sameday"))
                                    {
                                        if(f2.getExc().contains(Integer.toString(flight2_date)) == false)
                                        {
                                          total_journey_time=get_journey_time(flight1_departure_time,flight1_arrival_time)+get_journey_time(flight2_departure_time,flight2_arrival_time); 
                                            
                                          
                                         // if(a[i]>=no_of_tickets && b[i]>=no_of_tickets)
                                            al_cf.add(new ComboFlight(f1, f2, f1.getdepartureCity(),"SINGAPORE", diff,i,j,total_journey_time));
                                        }
                                       /* //Flight 2 Details after matching
                                        System.out.println("\n\t\t\t****Congratulations (Your Shitty Code Finally Works)***");
                                        System.out.println("\t\t\tSameday Flight");
                                        System.out.println("\t\t\tDeparture Time for 2nd Flight is" + flight2_departure_time);
                                        System.out.println("\t\t\tFlight 2 Frequency" + flight2_day);
                                        //Display the Two Flight Details
                                        System.out.println("\t\t\t\tFlight1 No: " + f1.getFlightNo() + "  & Journey date(yymmdd): " + flight1_date);
                                        System.out.println("\t\t\t\tFlight2 No: " + f2.getFlightNo() + "  & Journey date(yymmdd): " + flight2_date);
                                        //ComboFlight cf=new ComboFlight(f1, f2, f1.getdepartureCity(),"SINGAPORE", diff);
                                       */ 
                                        
                                        
                                          
                                        
                                    } 
                                    
                                    if(ans.equals("nextday"))
                                    {
                                        flight2_date++;
                                        flight2_day= get_day_of_week(Integer.toString(flight2_date));
                                        
                                        //Flight 2 Details after matching
                                       /* System.out.println("\n\t\t\t****Congratulations (Your Shitty Code Finally Works)***");
                                        System.out.println("\t\t\tNextday Flight");
                                        System.out.println("\t\t\tDeparture Time for 2nd Flight is" + flight2_departure_time);
                                        System.out.println("\t\t\tFlight 2 Frequency" + flight2_day);
                                        //Display the Two Flight Details
                                        System.out.println("\t\t\t\tFlight1 No: " + f1.getFlightNo() + "  & Journey date:" + flight1_date);
                                        System.out.println("\t\t\t\tFlight2 No: " + f2.getFlightNo() + "  & Journey date:" + flight2_date);
                                        */ 
                                       
                                        if(f2.getExc().contains(Integer.toString(flight2_date)) == false)
                                        {
                                          total_journey_time=get_journey_time(flight1_departure_time,flight1_arrival_time)+get_journey_time(flight2_departure_time,flight2_arrival_time); 
                                            
                                         
                                        //  if(a[i]>=no_of_tickets && b[i]>=no_of_tickets)
                                            al_cf.add(new ComboFlight(f1, f2, f1.getdepartureCity(),"SINGAPORE", diff,i,j,total_journey_time));
                                        }
                                      }
                                     }
                                     catch(Exception e){System.out.println("Exception");}
                                    }
                                }
                            }
                        }
                    }
                }
            }

        return al_cf;
        }

    private static String get_day_of_week(String s) {
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yymmdd");
        Date MyDate = null;
        try {
            MyDate = newDateFormat.parse(s);
        } catch (ParseException var18) {
            Logger.getLogger(SearchManager.class.getName()).log(Level.SEVERE, (String)null, var18);
        }
        newDateFormat.applyPattern("EEEE");
        return newDateFormat.format(MyDate);
    }

    public String check_timegap(int x, int y,String freq,int fdate,String fday) throws ParseException 
    {
        //converting into minutes
        int tempx = x / 100 * 60 + x % 100;
        int tempy = y / 100 * 60 + y % 100;
        
        //if on the same day
        if(tempx < tempy && freq.toLowerCase().contains(fday.substring(0,3).toLowerCase())) 
        {
            diff = tempy - tempx;
            if(diff >= 120 && diff <= 360) 
                return "sameday";  
        }

        //if two different days
        fdate++; 
        fday=get_day_of_week(Integer.toString(fdate));
        if(tempx > tempy && freq.toLowerCase().contains(fday.substring(0,3).toLowerCase())) 
        {
            int temp3 = 1440;
            int diff = temp3 - tempx;
            diff += tempy;
            if(diff >= 120 && diff <= 360) {
                return "nextday";
            }
        }
        //if failed
        return "NA";
    }
    
    public int get_journey_time(int dept,int arr)
    {
        int t=0;
        int tempd = dept / 100 * 60 + dept % 100;
        int tempa = arr / 100 * 60 + arr % 100;
        if(tempa >tempd)
            t=tempa-tempd;
        else
            t=tempa+ (1440-tempd);
        
        return t;
    }
  }

