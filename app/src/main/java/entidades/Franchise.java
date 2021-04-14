package entidades;

import com.example.trabalho1.R;

import java.util.ArrayList;

public class Franchise{

    private String name;
    private String description;
    private int franchiseLogoId;
    private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

    public Franchise(String name, String description, int franchiseLogoId){
        this.name = name;
        this.description = description;
        this.franchiseLogoId = franchiseLogoId;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFranchiseLogoId() {
        return franchiseLogoId;
    }

    public void setFranchiseLogo(int franchiseLogoId) {
        this.franchiseLogoId = franchiseLogoId;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurants(Restaurant r) {
        this.restaurants.add(r);
    }

    public int getNumOfRestaurants(){
        return restaurants.size();
    }

    public static int getNumOfFranchises(){
        return(loadFranchises().size());
    }


    //dados mock
    public static ArrayList<Franchise> loadFranchises(){
        ArrayList<Franchise> list = new ArrayList<>();

        //Starbucks franchise and restaurants
        Franchise f = new Franchise("Starbucks", "It's more than coffee!", R.drawable.starbuckslogo);
        Restaurant r = new Restaurant("Starbucks Florida", "1 Microcentro", "Florida", R.drawable.starbucks1);
        f.addRestaurants(r);
        r = new Restaurant("Starbucks California", "580 California Street", "San Francisco", R.drawable.starbucks2);
        f.addRestaurants(r);
        r = new Restaurant("Starbucks Miami", "110 SE 3rd Ave", "Miami", R.drawable.starbucks3);
        f.addRestaurants(r);
        list.add(f);

        //McDonalds franchise and restaurants
        f = new Franchise("McDonalds", "Amo muito tudo isso!", R.drawable.mcdonaldslogo);
        r = new Restaurant("McDonalds NY", "160 Broadway", "New York", R.drawable.mc1);
        f.addRestaurants(r);
        r = new Restaurant("McDonalds NJ", "98 NJ-70, Lakehurst", "New Jersey", R.drawable.mc2);
        f.addRestaurants(r);
        r = new Restaurant("McDonalds SD", "1280 12th Ave", "San Diego", R.drawable.mc3);
        f.addRestaurants(r);
        list.add(f);

        //Habibs franchise and restaurants
        f = new Franchise("Habib's", "Habib's é muito mais", R.drawable.habibs);
        r = new Restaurant("Habib's FLN", "Av. Beira Mar Norte 3826", "Florianópolis", R.drawable.habibs1);
        f.addRestaurants(r);
        r = new Restaurant("Habib's CWB", "R. João Negrão 156, Centro", "Curitiba", R.drawable.habibs2);
        f.addRestaurants(r);
        r = new Restaurant("Habib's POA", "Av. Assis Brasil 5049", "Porto Alegre", R.drawable.habibs3);
        f.addRestaurants(r);
        list.add(f);

        //Ben & Jerry's franchise and restaurants
        f = new Franchise("Ben & Jerry's", "Paz, Amor e Sorvete!", R.drawable.benandjerryslogo);
        r = new Restaurant("Ben & Jerry's CHA", "7800 Fairview Rd", "Charlotte", R.drawable.bj1);
        f.addRestaurants(r);
        r = new Restaurant("Ben & Jerry's DEN", "2339 E Evans Ave", "Denver", R.drawable.bj2);
        f.addRestaurants(r);
        r = new Restaurant("Ben & Jerry's MEM", "5007 Black Rd Space 110", "Memphis", R.drawable.bj3);
        f.addRestaurants(r);
        list.add(f);

        //Bobs franchise and restaurants
        f = new Franchise("Bob's", "Gostoso é no Bob's", R.drawable.bobs);
        r = new Restaurant("Bob's FLN", "R. Gen Eurico Gaspar Dutra 1375", "Florianópolis", R.drawable.bobs1);
        f.addRestaurants(r);
        r = new Restaurant("Bob's RJ", "Av Vinte de Janeiro SN", "Rio de Janeiro", R.drawable.bobs2);
        f.addRestaurants(r);
        r = new Restaurant("Bob's SBC", "Av Lions 2333", "São Bernardo do Campo", R.drawable.bobs3);
        f.addRestaurants(r);
        list.add(f);

        //Burger King franchise and restaurants
        f = new Franchise("Burger King", "Have It Your Way!", R.drawable.bk);
        r = new Restaurant("Burger King MIA", "1100 5th St, Miami Beach", "Miami", R.drawable.bk1);
        f.addRestaurants(r);
        r = new Restaurant("Burger King MAT", "1508 Charleston Ave", "Mattoon", R.drawable.bk2);
        f.addRestaurants(r);
        r = new Restaurant("Burger King HOU", "1620 S Loop W", "Houston", R.drawable.bk3);
        f.addRestaurants(r);
        list.add(f);

        return list;

    }
}
