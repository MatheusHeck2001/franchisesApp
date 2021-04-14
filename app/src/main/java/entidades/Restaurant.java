package entidades;


public class Restaurant{

    private String name;
    private String address;
    private String city;
    private int logoId;

    public Restaurant(String name, String address, String city, int logoId){
        this.name = name;
        this.address = address;
        this.city = city;
        this.logoId = logoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLogo() {
        return logoId;
    }

    public void setLogo(int logoId) {
        this.logoId = logoId;
    }
}
