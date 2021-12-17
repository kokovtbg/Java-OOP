package InterfacesAndAbstraction.exercise.MilitaryElite;

public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.state = state;
    }

    enum MissionState {
        IN_PROGRESS("inProgress"), FINISHED("finished");
        private String value;

        MissionState(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public String getCodeName() {
        return codeName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
