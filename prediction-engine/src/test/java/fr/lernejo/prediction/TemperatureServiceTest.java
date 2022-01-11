package fr.lernejo.prediction;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TemperatureServiceTest {

    private final TemperatureService service = new TemperatureService();
<<<<<<< HEAD

    @Test
    void TempPaysRincon() {
        Assertions.assertThatExceptionOfType(UnknownCountryException.class)
            .isThrownBy(() -> service.getTemperature("hasard"))
            .withMessage("Pays : 'hasard' inconnu.");
    }

    @ParameterizedTest
    @CsvSource({
        "France",
        "france",
        "FRANCE"
    })
    void TempFrance(String pays) {
        double temperature = service.getTemperature(pays);
        assertThat(temperature).isBetween(8D, 32D);
    }
=======
>>>>>>> e944e64 (Correction des bugs/Fix bug)
}


