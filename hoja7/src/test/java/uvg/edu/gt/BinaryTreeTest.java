package uvg.edu.gt;
import static org.junit.Assert.*;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testInsertionAndSearch() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.add("5", "cinco");
        tree.add("3", "tres");
        tree.add("7", "siete");
        tree.add("1", "uno");
        tree.add("4", "cuatro");

        assertEquals("cinco", tree.get("5"));
        assertEquals("tres", tree.get("3"));
        assertEquals("siete", tree.get("7"));
        assertEquals("uno", tree.get("1"));
        assertEquals("cuatro", tree.get("4"));

    }

    @Test
    public void testAssociation() {
        Association<Integer, String> association = new Association<>(1, "one");

        assertEquals(Integer.valueOf(1), association.getKey());
        assertEquals("one", association.getValue());
    }
}

