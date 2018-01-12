/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DataManager {   
    public int[] a=new int[57];
    public int[] b=new int[16];
    String path1=System.getProperty("user.dir").replace((char)92,(char)47)+"/spicejet_seats.txt";   
     String path2=System.getProperty("user.dir").replace((char)92,(char)47)+"/silkair_seats.txt"; 
     String pathsilkair=System.getProperty("user.dir").replace('\\', '/') + "/2016.silkair.csv";
       String pathspicejet= System.getProperty("user.dir").replace('\\', '/') + "/2016.spicejet.csv";
    public void read_silkAirArray(){     
        int i=0;
        try{
        BufferedReader br=new BufferedReader(new FileReader(path2));
        String s=br.readLine();
        
        while(s!=null){
          b[i]=Integer.parseInt(s);
           i++;
           s=br.readLine();           
       }
        }
        catch(Exception e){System.out.print("Exception");}
       
    }
     public void read_spiceJetArray(){     
        int i=0;
        try{
        BufferedReader br=new BufferedReader(new FileReader(path1));
        String s=br.readLine();        
        while(s!=null){
          a[i]=Integer.parseInt(s);
           i++;
           s=br.readLine();           
       }
        }
        catch(Exception e){System.out.print("Exception");}
       
    }
     public boolean write_silkAir(int x,int c){
         boolean bo=false;
          read_silkAirArray();
         try{
     if(b[x]>c){
            b[x]-=c;
            bo=true;
        }
        else{bo=false;}       
       BufferedWriter bw;
        FileWriter fo1=new FileWriter(path2);
        bw = new BufferedWriter(fo1);
        for(int i=0;i<16;i++){
            String s=b[i]+"";
            bw.write(s);
            bw.newLine();
        }
        bw.close();}catch(Exception e){System.out.println("Exception");}
        return bo;
    }
      public boolean write_spiceJet(int x,int c){
         boolean bo=false;
          read_spiceJetArray();
         try{
     if(a[x]>c){
            a[x]-=c;
            bo=true;
        }
        else{bo=false;}       
       BufferedWriter bw;
        FileWriter fo1=new FileWriter(path1);
        bw = new BufferedWriter(fo1);
        for(int i=0;i<57;i++){
            String s=a[i]+"";
            bw.write(s);
            bw.newLine();
        }
        bw.close();}catch(Exception e){System.out.println("Exception");}
        return bo;
    }
     
    
   public ArrayList<Flight> readSilkAir() {
        BufferedReader br = null;
        ArrayList al = new ArrayList();
        String effectiveFrom = "";
        String effectiveTill = "";

        try {
            String e = pathsilkair;
            br = new BufferedReader(new FileReader(e));
            String[] s = new String[20];
            s[0] = br.readLine();

            for(int i = 0; s[i] != null; s[i] = br.readLine()) {
                ++i;
            }

            for(int j = 3; j <= 18; ++j) {
                StringTokenizer st = new StringTokenizer(s[j], "|");
                String ef = null;
                String et = null;
                String[] var10000 = new String[]{"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
                String s1 = st.nextToken().toString();
                String s2 = "Singapore";
                String s3 = st.nextToken().toString();
                String s4 = st.nextToken().toString();
                String x = st.nextToken();
                StringTokenizer t = new StringTokenizer(x, "/");
                String s5 = t.nextToken(); String exc = "";
                String s6 = t.nextToken();
                if(st.hasMoreTokens()){
                String s7 = st.nextToken();
               
                StringTokenizer st1;
                String y;
                if(s7.contains("Exc")) {
                    st1 = new StringTokenizer(s7, "Exc. ,");
                    y = st1.nextToken();
                    String z = st1.nextToken();

                    while(st1.hasMoreTokens()) {
                        if(exc != "") {
                            exc = exc + "+" + this.date_format(st1.nextToken());
                        } else {
                            exc = exc + "" + this.date_format(st1.nextToken());
                        }
                    }
                }

                if(s7.contains("-")) {
                    st1 = new StringTokenizer(s7, " ");
                    ef = this.date_format(st1.nextToken());
                    y = st1.nextToken();
                    et = this.date_format(st1.nextToken());
                } else {
                    st1 = new StringTokenizer(s7, " ");
                    String d;
                    if(s7.contains("Disc")) {
                        ef = "160101";
                        x = st1.nextToken();
                        d = st1.nextToken();
                        et = this.date_format(d);
                    } else if(s7.contains("Eff.")) {
                        et = "161231";
                        x = st1.nextToken();
                        d = st1.nextToken();
                        ef = this.date_format(d);
                    } else {
                        ef = "160101";
                        et = "161231";
                    }
                }
                }
                else{
                ef = "160101";
                 et = "161231";}

                //System.out.println(ef + " " + et + " " + exc);
                al.add(new Flight(s1, s2, s3, s4, s5, s6, ef, et, exc));
            }
        } catch (FileNotFoundException var27) {
            System.out.println("File not there");
        } catch (IOException var28) {
            System.out.println("IOException");
        }

        return al;
    }
    public ArrayList<Flight> readSpiceJet() {
        BufferedReader br = null;
        String exc = "";
        ArrayList al = new ArrayList();

        try {
            String e =pathspicejet;
            br = new BufferedReader(new FileReader(e));
            byte size = 100;
            String[] s = new String[size];
            int i = 0;

            for(s[0] = br.readLine(); s[i] != null; s[i] = br.readLine()) {
                ++i;
            }

            for(int j = 5; j <= 61; ++j) {
                StringTokenizer st = new StringTokenizer(s[j], "|");
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                String s3 = st.nextToken();
                String s4 = st.nextToken();
                String s5 = st.nextToken();
                s5 = this.timeManager(s5);
                String s6 = st.nextToken();
                s6 = this.timeManager(s6);
                String s7 = st.nextToken();
                String s8 = st.nextToken();
                String s9 = st.nextToken();
                StringTokenizer st1 = new StringTokenizer(s8, " ");
                StringTokenizer st2 = new StringTokenizer(s9, " ");
                String d1 = st1.nextToken();
                String m1 = st1.nextToken();
                String[] month = new String[]{"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

                int k;
                for(k = 0; k < 12; ++k) {
                    if(s8.contains(month[k])) {
                        if(k < 9) {
                            m1 = "0" + (k + 1) + "";
                        } else {
                            m1 = k + 1 + "";
                        }
                        break;
                    }
                }

                s8 = st1.nextToken() + m1 + d1;
                String d2 = st2.nextToken();
                String m2 = st2.nextToken();

                for(k = 0; k < 12; ++k) {
                    if(s9.contains(month[k])) {
                        if(k < 9) {
                            m2 = "0" + (k + 1) + "";
                        } else {
                            m2 = k + 1 + "";
                        }
                        break;
                    }
                }

                s9 = st2.nextToken() + m2 + d2;
                al.add(new Flight(s1, s2, s3, s4, s5, s6, s8, s9, exc));
            }
        } catch (FileNotFoundException var28) {
            System.out.println("File not there");
        } catch (IOException var29) {
            System.out.println("IOexception");
        }

        return al;
    }

    public String timeManager(String s) {
        StringTokenizer st;
        StringTokenizer st1;
        if(s.contains("AM")) {
            st = new StringTokenizer(s, " ");
            s = st.nextToken();
            st1 = new StringTokenizer(s, ":");
            s = st1.nextToken() + st1.nextToken();
        } else if(s.contains("PM")) {
            st = new StringTokenizer(s, " ");
            s = st.nextToken();
            st1 = new StringTokenizer(s, ":");
            s = (12 + Integer.parseInt(st1.nextToken())) % 24 + st1.nextToken();
        }

        if(s.length() == 3) {
            s = "0" + s;
        }

        return s;
    }

    public String date_format(String x) {
        String s = "";
        String s1 = "";
        String[] month = new String[]{"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

        int i;
        for(i = 0; i < 12; ++i) {
            if(x.contains(month[i])) {
                if(i <= 8) {
                    s1 = "0" + (i + 1);
                } else {
                    s1 = i + 1 + "";
                }

                s = "16" + s1 + "";
                break;
            }
        }

        s1 = "";

        for(i = 0; i < x.length(); ++i) {
            if(x.charAt(i) >= 48 && x.charAt(i) <= 57) {
                s1 = s1 + x.charAt(i);
            }
        }

        if(s1.length() == 1) {
            s1 = "0" + s1;
        }

        s = s + s1;
        return s;
    }
  public String[] read_book(){
        String[] s=new String[240];
        String booktxt=System.getProperty("user.dir").replace((char)92,(char)47)+"/book.txt";  
        try{
            FileReader fin=new FileReader(booktxt);
            BufferedReader br=new BufferedReader(fin);
            int i=0;
            String x=br.readLine();
            while(x!=null){
                s[i]=x;i++;
                x=br.readLine();                
            }
        }
        catch(Exception e){System.out.println("Exception");}
        return s;
    }
   
   
        /*FileWriter fout=new FileWriter(booktxt); 
        BufferedWriter bw=new BufferedWriter(fout);               
         /*while(s[i]!=null){
             bw.write(s[i]);i++;
             bw.newLine();
             System.out.println(s[i]);
         }*/
         //ComboFlight x=b.getComboFlight();
        // Flight f1,f2;
         //f1=x.getMatchFlightSpicejet();
         //f2=x.getMatchFlightSilkair();
         //String y=b.getBookingNumber()+"+"+b.getName()+"+"+b.getNumberOfTickets();
         //y=y+"+"+f1.getdepartureCity()+"+"+f1.getarrivalCity();
        
    public void write_book(String s[]) throws IOException{
        String booktxt=System.getProperty("user.dir").replace((char)92,(char)47)+"/book.txt"; 
        FileWriter fout=new FileWriter(booktxt);
        int i=0;
        while(s[i]!=null){
            System.out.println(s[i]);i++;
        }
        i=0;
        BufferedWriter br=new BufferedWriter(fout);
        i=0;
       while(s[i]!=null){
           br.write(s[i]);i++;
           br.newLine();
       }
        //ComboFlight x=b.getComboFlight();
        // Flight f1,f2;
         //f1=x.getMatchFlightSpicejet();
         //f2=x.getMatchFlightSilkair();
         //String y=b.getBookingNumber()+"+"+b.getName()+"+"+b.getNumberOfTickets();
         //y=y+"+"+f1.getdepartureCity()+"+"+f1.getarrivalCity();
         String y="hi";
       br.write(y);
       br.newLine();
       br.close();
    }
        
}

