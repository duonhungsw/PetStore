package model;

public class Administrative_units {

    private int id;
    private String full_name;
    private String full_name_en;
    private String short_name;
    private String short_name_en;
    private String code_name;
    private String code_name_en;

    public Administrative_units() {
    }

    public Administrative_units(int id, String full_name, String full_name_en, String short_name, String short_name_en, String code_name, String code_name_en) {
        this.id = id;
        this.full_name = full_name;
        this.full_name_en = full_name_en;
        this.short_name = short_name;
        this.short_name_en = short_name_en;
        this.code_name = code_name;
        this.code_name_en = code_name_en;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getFull_name_en() {
        return full_name_en;
    }

    public void setFull_name_en(String full_name_en) {
        this.full_name_en = full_name_en;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getShort_name_en() {
        return short_name_en;
    }

    public void setShort_name_en(String short_name_en) {
        this.short_name_en = short_name_en;
    }

    public String getCode_name() {
        return code_name;
    }

    public void setCode_name(String code_name) {
        this.code_name = code_name;
    }

    public String getCode_name_en() {
        return code_name_en;
    }

    public void setCode_name_en(String code_name_en) {
        this.code_name_en = code_name_en;
    }

    @Override
    public String toString() {
        return "Administrative_units{" + "id=" + id + ", full_name=" + full_name + ", full_name_en=" + full_name_en + ", short_name=" + short_name + ", short_name_en=" + short_name_en + ", code_name=" + code_name + ", code_name_en=" + code_name_en + '}';
    }
    
    
}
