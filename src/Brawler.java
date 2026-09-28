public class Brawler {
    private String name;
    private int health;

    public Brawler(String name, int health){
        this.name = name;
        this.health = health;
    }

    public String getName(){return name;}
    public int getHealth(){return health;}

    public void reduceHealth(int damage){
        this.health -= damage;
    }
    public void increaseHealth(int points){
        this.health += points;
    }
    public void actionByCategory(Brawler enemy){

    }
}
