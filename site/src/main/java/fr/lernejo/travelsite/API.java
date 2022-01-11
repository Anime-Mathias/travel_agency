package fr.lernejo.travelsite;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/api")
public class API {

    public final PredictionEngineClient predictionEngineClient = new Launcher().predictionEngineClient();
    public final USERapi APIServ = new USERapi(this.predictionEngineClient);

    @PostMapping(path = "/inscription")
    public @ResponseBody Iterable<JSONInscript> newUser(@RequestBody JSONInscript post){
        return this.APIServ.inscription_de_utilisateur(post);
    }

    @GetMapping(path = "/travels")
    public @ResponseBody
    Object Destination(@RequestParam String userName){
        return this.APIServ.arrival(userName);
    }
}
