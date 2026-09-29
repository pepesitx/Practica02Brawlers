package BrawlStars;

public class Epic extends Brawler {

    private int heals;

    public Epic(String name, int health, int heals) {
        super(name, health);
        this.heals = heals;
    }

    public void actionByCategory(Brawler enemy) {
        setHealth(getHealth() + this.heals);

        System.out.println("["+getName()+":"+getHealth()+"] Incrementa vida a: "+getHealth());
        System.out.println("["+enemy.getName()+":"+enemy.getHealth()+"]\n" );
    }
}