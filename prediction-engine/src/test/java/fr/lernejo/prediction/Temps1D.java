package fr.lernejo.prediction;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Temps1D {
    @ParameterizedTest
    @CsvSource({
        "2022-01-01, -5",
        "2021-05-12, 17",
        "2020-04-11, 13"
    })
    public void TempsPred(String date, Integer TempPred){
        Assertions.assertThat(new Temp1D(date,TempPred))
            .isInstanceOf(Temps1D.class)
            .isNotNull();
    }
}

