public class Legendario extends Brawler {
    private int damage;

    public Legendario(String name, int health, int damage) {
        super(name, health);
        this.damage = damage;
    }
    @Override
    public void actionByCategory(Brawler target) {
        target.reduceHealth(damage);
        System.out.println(getName() + " hits " + target.getName() + " for " + damage);
    }

    @Override
    public String toString() {
        return "[Legendary] " + super.toString() + " | Damage: " + damage;
    }
}


