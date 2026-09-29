package BrawlStars;

public class Legendario extends Brawler {
    private int damage;

    public Legendario(String name, int health, int damage) {
        super(name, health);
        this.damage = damage;

    }
    public void actionByCategory(Brawler enemy) {
        enemy.setHealth(enemy.getHealth() - this.damage);

        System.out.println("["+getName()+":"+getHealth()+"] Aplica"+this.damage+" de daño a "+enemy.getName());
        System.out.println("["+enemy.getName()+":"+enemy.getHealth()+"]\n" );

    }

}


