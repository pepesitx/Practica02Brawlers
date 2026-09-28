public class Epic extends Brawler {

    private  int points;


    public Epic(String name, int health, int points) {
        super(name, health);
        this.points = points;

        }
    @Override
    public void actionByCategory(Brawler target) {
        increaseHealth(points);
        System.out.println(getName() + " heals " + points + " health");
    }

    @Override
    public String toString() {
        return "[Epic] " + super.toString() + " | Points: " + points;
    }
}