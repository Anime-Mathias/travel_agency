package fr.lernejo.travelsite;

public class JSONInscript {

        public final String userEmail;
        public final String userName;
        public final String userCountry;
        public final weatherExpectation weatherExpectation1;
        public final Integer minimumTemperatureDistance;

        public JSONInscript(){
            this.userEmail = null;
            this.userName = null;
            this.userCountry = null;
            this.weatherExpectation1 = null;
            this.minimumTemperatureDistance = null;
        }

        public JSONInscript(String userEmail, String userName, String userCountry, String weatherExpectation1, Integer minimumTemperatureDistance) {
            this.userEmail = userEmail;
            this.userName = userName;
            this.userCountry = userCountry;
            this.weatherExpectation1 = weatherExpectation.valueOf(weatherExpectation1);
            this.minimumTemperatureDistance = minimumTemperatureDistance;
        }
        @Override
        public String toString() {
            return "JSONInscript{" +
                "userEmail='" + userEmail + '\'' + ", userName='" + userName + '\'' + ", userCountry='" + userCountry + '\'' + ", weatherExpectation=" + weatherExpectation1 + ", minimumTemperatureDistance=" + minimumTemperatureDistance + '}';
        }
    }
