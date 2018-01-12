package flightreservationsystem;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Flight {
    private String departureCity;
    private String arrivalCity;
    private String frequency;
    private String arrivalTime;
    private String departureTime;
    private String flightno;
    private String effectiveFrom;
    private String effectiveTill;
    private String exc;

    public Flight(String departureCity, String arrivalCity, String frequency, String flightno, String departureTime, String arrivalTime, String effectiveFrom, String effectiveTill, String exc) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.frequency = frequency;
        this.flightno = flightno;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTill = effectiveTill;
        this.exc = exc;
    }

    public String getdepartureCity() {
        return this.departureCity;
    }

    public String getarrivalCity() {
        return this.arrivalCity;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public String getFlightNo() {
        return this.flightno;
    }

    public String getarrivalTime() {
        return this.arrivalTime;
    }

    public String getdepartureTime() {
        return this.departureTime;
    }

    public String getEffectiveFrom() {
        return this.effectiveFrom;
    }

    public String getEffectiveTill() {
        return this.effectiveTill;
    }

    public String getExc() {
        return this.exc;
    }
}
