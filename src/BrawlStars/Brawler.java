package BrawlStars;

public class Brawler {
    private String name;
    private int health;

    public Brawler(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName(){return name;}
    public int getHealth(){return health;}

    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    public void actionByCategory(Brawler enemy){

    }
}
