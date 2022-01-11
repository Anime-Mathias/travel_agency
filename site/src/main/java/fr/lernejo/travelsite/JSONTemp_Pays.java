package fr.lernejo.travelsite;

public class JSONTemp_Pays {

    public final String pays;
    public final Number temp;

    public JSONTemp_Pays(String pays, Number temp) {

        this.pays = pays;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "JSONTemp_Pays {" + "pays ='" + pays + '\'' + ", temperature =" + temp + '}';
    }
}
