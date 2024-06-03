
package model;

public class Administrative_regions {
    private int id;
    private String name;
    private String name_en;
    private String code_name;
    private String code_name_en;

    public Administrative_regions() {
    }

    public Administrative_regions(int id, String name, String name_en, String code_name, String code_name_en) {
        this.id = id;
        this.name = name;
        this.name_en = name_en;
        this.code_name = code_name;
        this.code_name_en = code_name_en;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Administrative_regions{" + "id=" + id + ", name=" + name + ", name_en=" + name_en + ", code_name=" + code_name + ", code_name_en=" + code_name_en + '}';
    }
}
