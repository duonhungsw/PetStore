package model;

public class Account {
    private int accId;
    private Role role_id;
    private Coin coin_id;
    private String email;
    private String username;
    private String pass;
    private String name;
    private String phone;
    private String address;
    private String image;
    private String creation_datetime;
    private int status;
    private String token;


    public Account() {
    }

    public Account(int accId, Role role_id, Coin coin_id, String email, String username, String pass, String name, String phone, String address, String image, String creation_datetime, int status, String token) {
        this.accId = accId;
        this.role_id = role_id;
        this.coin_id = coin_id;
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.creation_datetime = creation_datetime;
        this.status = status;
        this.token = token;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public Coin getCoin_id() {
        return coin_id;
    }

    public void setCoin_id(Coin coin_id) {
        this.coin_id = coin_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreation_datetime() {
        return creation_datetime;
    }

    public void setCreation_datetime(String creation_datetime) {
        this.creation_datetime = creation_datetime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Account{" + "accId=" + accId + ", role_id=" + role_id + ", coin_id=" + coin_id + ", email=" + email + ", username=" + username + ", pass=" + pass + ", name=" + name + ", phone=" + phone + ", address=" + address + ", image=" + image + ", creation_datetime=" + creation_datetime + ", status=" + status + ", token=" + token + '}';
    }

    
}
