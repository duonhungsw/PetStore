
package model;

public class Provinces {
    private String code;
    private String name;
    private String name_en;
    private String full_name;
    private String full_name_en;
    private String code_name;
    private Administrative_units administrative_units;
    private Administrative_regions administrative_regions;

    public Provinces() {
    }

    public Provinces(String code, String name, String name_en, String full_name, String full_name_en, String code_name, Administrative_units administrative_units, Administrative_regions administrative_regions) {
        this.code = code;
        this.name = name;
        this.name_en = name_en;
        this.full_name = full_name;
        this.full_name_en = full_name_en;
        this.code_name = code_name;
        this.administrative_units = administrative_units;
        this.administrative_regions = administrative_regions;
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

    public Administrative_units getAdministrative_units() {
        return administrative_units;
    }

    public void setAdministrative_units(Administrative_units administrative_units) {
        this.administrative_units = administrative_units;
    }

    public Administrative_regions getAdministrative_regions() {
        return administrative_regions;
    }

    public void setAdministrative_regions(Administrative_regions administrative_regions) {
        this.administrative_regions = administrative_regions;
    }

    @Override
    public String toString() {
        return "Provinces{" + "code=" + code + ", name=" + name + ", name_en=" + name_en + ", full_name=" + full_name + ", full_name_en=" + full_name_en + ", code_name=" + code_name + ", administrative_units=" + administrative_units + ", administrative_regions=" + administrative_regions + '}';
    }
}
