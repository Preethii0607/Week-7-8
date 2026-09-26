class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // starts at max health
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health -= amount;
            if (health < 0) {
                health = 0; // clamp at 0
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health += amount;
            if (health > maxHealth) {
                health = maxHealth; // clamp at max health
            }
        }
    }

    public int getHealth() {
        return health;
    }
}

public class HealthBarTest {
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30); 
        System.out.println("health = " + c.getHealth()); // 70
        c.heal(50); 
        System.out.println("health = " + c.getHealth()); // 100 (capped)
        c.takeDamage(150); 
        System.out.println("health = " + c.getHealth()); // 0 (floored)
    }
}