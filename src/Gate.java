public class Gate extends Airplane {
    private String gateNumber;
    private String gateStatus;
    private String gateType;

    public Gate(String gateNumber, String gateStatus, String gateType, int capacity, int tailNumber) {
        super(capacity, tailNumber);
        this.gateNumber = gateNumber;
        this.gateStatus = gateStatus;
        this.gateType = gateType;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public String getGateStatus() {
        return gateStatus;
    }

    public String getGateType() {
        return gateType;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void setGateStatus(String gateStatus) {
        this.gateStatus = gateStatus;
    }

    public void setGateType(String gateType) {
        this.gateType = gateType;
    }

    @Override
    public String toString() {
        return "Gate number: " + this.gateNumber + "Gate Status: " + this.gateStatus + "Gate Type: " + this.gateType;
    }
}