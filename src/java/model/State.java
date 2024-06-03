
package model;

public class State {
    private int id;
    private String namestate;

    public State() {
    }

    public State(int id, String namestate) {
        this.id = id;
        this.namestate = namestate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamestate() {
        return namestate;
    }

    public void setNamestate(String namestate) {
        this.namestate = namestate;
    }

    @Override
    public String toString() {
        return "State{" + "id=" + id + ", namestate=" + namestate + '}';
    }
    
    
}
