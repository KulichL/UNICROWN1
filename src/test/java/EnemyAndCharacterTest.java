import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyAndCharacterTest {

    @Test
    void takeDamage_shouldReduceHealth() {
        Enemy enemy = new Enemy("Strážce", 30, 8);

        enemy.takeDamage(10);

        assertEquals(20, enemy.getHealth());
        assertTrue(enemy.isAlive());
    }

    @Test
    void takeDamage_shouldNotDropHealthBelowZero() {
        Enemy enemy = new Enemy("Strážce", 30, 8);

        enemy.takeDamage(100);

        assertEquals(0, enemy.getHealth());
        assertFalse(enemy.isAlive());
    }
}
