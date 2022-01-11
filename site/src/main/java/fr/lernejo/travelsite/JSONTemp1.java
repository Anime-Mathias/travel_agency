package fr.lernejo.travelsite;
import java.util.ArrayList;

public class JSONTemp1 {

    public final String pays;
    public final ArrayList<Temp1DSite> temp;

    public JSONTemp1() {
        this.pays = null;
        this.temp = null;
    }

    public JSONTemp1(String pays, ArrayList<Temp1DSite> temp2DS) {
        this.pays = pays;
        this.temp = temp2DS;
    }

    @Override
    public String toString() {
        return " {" + "pays ='" + pays + '\'' + ", temp2DS =" + temp + '}';
    }
}
