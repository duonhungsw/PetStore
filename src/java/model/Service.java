package model;

public class Service {

    private int service_id;
    private String service_name;
    private int service_price;
    private String service_img;

    public Service(int service_id, String service_name, int service_price, String service_img) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_price = service_price;
        this.service_img = service_img;
    }

    public Service() {
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getService_price() {
        return service_price;
    }

    public void setService_price(int service_price) {
        this.service_price = service_price;
    }

    public String getService_img() {
        return service_img;
    }

    public void setService_img(String service_img) {
        this.service_img = service_img;
    }

    @Override
    public String toString() {
        return "Service{" + "service_id=" + service_id + ", service_name=" + service_name + ", service_price=" + service_price + ", service_img=" + service_img + '}';
    }
    
    
}
