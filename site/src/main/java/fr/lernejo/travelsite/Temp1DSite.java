package fr.lernejo.travelsite;

public class Temp1DSite {
    public final String date;
    public final Number temp;

    public Temp1DSite(){
        this.date = null;
        this.temp = null;
    }

    public Temp1DSite(String date, Number temp) {
        this.date = date;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return " {" + "date ='" + date + '\'' + ", temperature =" + temp + "°C}";
    }
}
