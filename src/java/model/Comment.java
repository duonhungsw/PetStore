package model;

public class Comment {
    private int comment_id;
    private int prod_Id;
    private String acc_id;
    private String description;

    // Getters and setters
    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getProd_Id() {
        return prod_Id;
    }

    public void setProd_Id(int prod_Id) {
        this.prod_Id = prod_Id;
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
