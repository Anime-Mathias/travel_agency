package fr.lernejo.travelsite;

public class JSONTemp_Pays {

    public final String pays;
    public final Number temps;

    public JSONTemp_Pays(String pays, Number temps) {

        this.pays = pays;
        this.temps = temps;
    }

    @Override
    public String toString() {
        return "JSONTemp_Pays {" + "pays ='" + pays + '\'' + ", temperature =" + temps + '}';
    }
}
