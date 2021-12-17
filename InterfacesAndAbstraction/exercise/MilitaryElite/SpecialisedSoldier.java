package InterfacesAndAbstraction.exercise.MilitaryElite;

public interface SpecialisedSoldier extends Private {
    enum Corps {
        AIR_FORCES("Airforces"), MARINES("Marines");
        private String value;

        Corps(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
