package fr.lernejo.prediction;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping(path = "/api")

public class PredictionController {

    public final TemperatureService TemperatureService = new TemperatureService();

    @GetMapping(path = "/temperature")

    public @ResponseBody Object TempPays(@RequestParam String pays){

        try {
            ArrayList<Temp1D> Temp2DS = new ArrayList<>();
            Temp2DS.add(new Temp1D(LocalDate.now().minusDays(1).toString(), this.TemperatureService.getTemperature(pays)));
            Temp2DS.add(new Temp1D(LocalDate.now().minusDays(2).toString(), this.TemperatureService.getTemperature(pays)));
            JSONTemp JSONTemp1 = new JSONTemp(pays, Temp2DS);
            return JSONTemp1;
        }
        catch (UnknownCountryException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
