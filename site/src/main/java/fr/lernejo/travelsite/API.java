package fr.lernejo.travelsite;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class API {

    public final ArrayList<JSONInscript> predictionEngineClient = new ArrayList<JSONInscript>();
    public final ArrayList<USERapi> APIServ = new ArrayList<USERapi>();

    @PostMapping(path = "/inscription")
    public ArrayList<JSONInscript> JSONInscription1(@RequestBody JSONInscript newUser) {
       predictionEngineClient.add(newUser);
       return predictionEngineClient;
    }

    @GetMapping(path = "/travels")
    public @ResponseBody
    Object Destination(@RequestParam String userName){
        return this.APIServ;
    }
}
