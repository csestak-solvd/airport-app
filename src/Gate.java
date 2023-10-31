public class Gate extends Airplane {
    private String gateNumber;
    private String gateStatus;
    private String gateType;

    public Gate(String gateNumber, String gateStatus, String gateType) {
        super(75, 7755);
        this.gateNumber = gateNumber;
        this.gateStatus = gateStatus;
        this.gateType = gateType;
    }
}