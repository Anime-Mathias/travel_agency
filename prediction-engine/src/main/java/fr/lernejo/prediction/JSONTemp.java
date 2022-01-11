package fr.lernejo.prediction;
import java.util.ArrayList;

public class JSONTemp {

        public final String pays;
        public final ArrayList<Temp1D> temp;

        public JSONTemp(String pays, ArrayList<Temp1D> temp2DS) {
            this.pays = pays;
            this.temp = temp2DS;
        }
        @Override
        public String toString() {
            return "JSONTemp {" + "pays ='" + pays + '\'' + ", temp2DS =" + temp + '}';
        }
    }
