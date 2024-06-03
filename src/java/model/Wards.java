package model;

public class Wards {

    private String code;
    private String name;
    private String name_en;
    private String full_name;
    private String full_name_en;
    private String code_name;
    private Districts districts;
    private Administrative_units administrative_units;

    public Wards() {
    }

    public Wards(String code, String name, String name_en, String full_name, String full_name_en, String code_name, Districts districts, Administrative_units administrative_units) {
        this.code = code;
        this.name = name;
        this.name_en = name_en;
        this.full_name = full_name;
        this.full_name_en = full_name_en;
        this.code_name = code_name;
        this.districts = districts;
        this.administrative_units = administrative_units;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
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

    public String getCode_name() {
        return code_name;
    }

    public void setCode_name(String code_name) {
        this.code_name = code_name;
    }

    public Districts getDistricts() {
        return districts;
    }

    public void setDistricts(Districts districts) {
        this.districts = districts;
    }

    public Administrative_units getAdministrative_units() {
        return administrative_units;
    }

    public void setAdministrative_units(Administrative_units administrative_units) {
        this.administrative_units = administrative_units;
    }

    @Override
    public String toString() {
        return "Wards{" + "code=" + code + ", name=" + name + ", name_en=" + name_en + ", full_name=" + full_name + ", full_name_en=" + full_name_en + ", code_name=" + code_name + ", districts=" + districts + ", administrative_units=" + administrative_units + '}';
    }
    
    
}
