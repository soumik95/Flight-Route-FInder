package flightreservationsystem;
import java.util.ArrayList;

public class FRSManager {
    
    SearchManager sm;
    DisplayManager dm;
    DataManager dam;
    BookingManager bm;
  
    ArrayList<ComboFlight> Arr;
    ArrayList a1;
    ArrayList a2;
    
    
    ComboFlight cf;
    
    int tickets;
    Booking book;
    
    public  FRSManager() 
    {
        sm= new SearchManager();
        dm=new DisplayManager(this);
        dam=new DataManager();
        bm=new BookingManager();
        a1 = dam.readSpiceJet();
        a2 = dam.readSilkAir();
        
        
        
    }
    public static void main(String[] args) {
        FRSManager frs=new FRSManager();
        frs.dm.show1();
    }
    
    public void getSelectedFlight(int i)
    {
        cf=Arr.get(i);
        //dm.setBook(cf);
        dm.show3();
    }
    
    public void setname(String name)    {
        
        book=bm.book(name, tickets, cf);
        dm.setDetails(book);
       //String[] s=dam.read_book();
      // dam.write_book(s, book);
        dm.show4();
    }
    public void callSearch(String source,String date,int tickets) {
        dam.read_spiceJetArray();
        dam.read_silkAirArray();
        Arr=sm.search(source,date,tickets,a1,a2,dam.a,dam.b);
        dm.setTable(Arr);
        dm.show2();
        this.tickets=tickets;        
    }  
  
}
