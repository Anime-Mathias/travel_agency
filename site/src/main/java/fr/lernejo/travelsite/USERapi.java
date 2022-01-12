package fr.lernejo.travelsite;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import retrofit2.Call;
import retrofit2.Response;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class USERapi {
    public final PredictionEngineClient predictionEngineClient;
    public final ArrayList<JSONInscript> JSONR = new ArrayList<>();
    public final ArrayList<JSONTemp_Pays> JSONP = new ArrayList<>();
    public final List<String> pays;

    public USERapi(PredictionEngineClient predictionEngineClient){
        this.predictionEngineClient = predictionEngineClient;
        InputStream AsStream = USERapi.class.getClassLoader().getResourceAsStream("countries.txt");
        try {
            String contenu = new String(AsStream.readAllBytes(), StandardCharsets.UTF_8);
            pays = contenu.lines().collect(Collectors.toCollection(ArrayList::new));
        }
        catch (IOException exception) {
            throw new IllegalStateException("Pas de fichier 'countries.txt' dans le Path");
        }
    }

    public Iterable<JSONInscript> inscription_de_utilisateur(JSONInscript post) {
        if(!this.JSONR.contains(post)) this.JSONR.add(post);
        return this.JSONR;
    }

    public Object arrival(String nom_utilisateur) {
        JSONInscript trouverOK = null;
        for (JSONInscript inscription : this.JSONR) {
            if (inscription.userName.equals(nom_utilisateur)) trouverOK = inscription;
        }
        if(trouverOK != null) {
            Queue queue = new LinkedList();
            for (String pays : this.pays) queue.add(pays);
            Iterator iteratorNoOK = queue.iterator();
            while(iteratorNoOK.hasNext()){
                TempMoyenne((String) iteratorNoOK.next());
            } return PaysExceptionOK(trouverOK);
        }
        else return new ResponseEntity<>("Le nom d'utilisateur n'existe pas.", HttpStatus.EXPECTATION_FAILED);
    }

    private void TempMoyenne(String pays) {
        Call<JSONTemp1> AfficheTemp = this.predictionEngineClient.listTemperature(pays);
        if (AfficheTemp != null) {
            try {
                int tempMoy;
                Response<JSONTemp1> response = AfficheTemp.execute();
                tempMoy = (response.body().temps.get(0).temp.intValue() + response.body().temps.get(1).temp.intValue())/2;
                JSONP.add(new JSONTemp_Pays(pays, tempMoy));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
    private Iterable<JSONTemp_Pays> PaysExceptionOK(JSONInscript post){

        int TempPays = 0;
        ArrayList<JSONTemp_Pays> paysOK = new ArrayList<>();

        for (JSONTemp_Pays jsonCountry : this.JSONP) {
            if (jsonCountry.pays.equals(post.userCountry)) TempPays = jsonCountry.temps.intValue();
        }

        for (JSONTemp_Pays jsonCountry : this.JSONP) {
            if (!jsonCountry.pays.equals(post.userCountry) && ((jsonCountry.temps.intValue() < (TempPays - post.minimumTemperatureDistance) && post.weatherExpectation1.equals(weatherExpectation.COLDER))
                || (jsonCountry.temps.intValue() > (post.minimumTemperatureDistance + TempPays) && post.weatherExpectation1.equals(weatherExpectation.WARMER)))) { paysOK.add(jsonCountry);
            }
        }
        this.JSONP.clear();
        return paysOK;
    }
}
