import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    // pomocná testovací třída, protože Item je abstract
    static class TestItem extends Item {
        public TestItem(String id, String name) {
            super(id, name);
        }

        @Override
        public CommandResult use(Game game) {
            return CommandResult.message("test");
        }
    }

    @Test
    void add_shouldAddItemWhenInventoryHasSpace() {
        Inventory inventory = new Inventory(2);
        Item sword = new TestItem("mec", "Meč");

        boolean result = inventory.add(sword);

        assertTrue(result);
        assertFalse(inventory.isEmpty());
    }

    @Test
    void add_shouldReturnFalseWhenInventoryIsFull() {
        Inventory inventory = new Inventory(1);
        inventory.add(new TestItem("mec", "Meč"));

        boolean result = inventory.add(new TestItem("stit", "Štít"));

        assertFalse(result);
    }

    @Test
    void findByIdOrName_shouldFindItemByIdAndByName() {
        Inventory inventory = new Inventory(3);
        Item powder = new TestItem("prasek", "Kouzelný prášek");
        inventory.add(powder);

        Item foundById = inventory.findByIdOrName("prasek");
        Item foundByName = inventory.findByIdOrName("prášek");

        assertNotNull(foundById);
        assertNotNull(foundByName);
        assertEquals("prasek", foundById.getId());
        assertEquals("Kouzelný prášek", foundByName.getName());
    }
}
