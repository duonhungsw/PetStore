package model;

public class PetGroomerInfo {

    private int groomer_id;
    private String groomer_name;

    public PetGroomerInfo() {
    }

    public PetGroomerInfo(int groomer_id, String groomer_name) {

        this.groomer_id = groomer_id;
        this.groomer_name = groomer_name;
    }


    public int getGroomer_id() {
        return groomer_id;
    }

    public void setGroomer_id(int groomer_id) {
        this.groomer_id = groomer_id;
    }

    public String getGroomer_name() {
        return groomer_name;
    }

    public void setGroomer_name(String groomer_name) {
        this.groomer_name = groomer_name;
    }

    @Override
    public String toString() {
        return "PetGroomerInfo{" + "groomer_id=" + groomer_id + ", groomer_name=" + groomer_name + '}';
    }

    

    
}
