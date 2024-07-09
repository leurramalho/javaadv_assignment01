package ca.georgian.chart;

public class Sales {
    private int id;
    private String region;
    private String client;
    private String vendor;
    private float value;
    private int quantity;

    private Sales() {
    }

    public Sales(int id, String region, String client, String vendor, float value, int quantity) {
        this.id = id;
        this.region = region;
        this.client = client;
        this.vendor = vendor;
        this.value = value;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
