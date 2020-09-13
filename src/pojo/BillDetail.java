package pojo;

public class BillDetail {

    private int billAmount;
    private int distanceCovered;

    public BillDetail(){}

    public BillDetail(int billAmount, int distanceCovered) {
        this.billAmount = billAmount;
        this.distanceCovered = distanceCovered;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }

    public double getDistanceCovered() {
        return distanceCovered;
    }

    public void setDistanceCovered(int distanceCovered) {
        this.distanceCovered = distanceCovered;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("pojo.BillDetail{");
        sb.append("billAmount=").append(billAmount);
        sb.append(", distanceCovered=").append(distanceCovered);
        sb.append('}');
        return sb.toString();
    }
}
