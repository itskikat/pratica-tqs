/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author ico0
 */
public class SetOfNaturalsTest {
    private SetOfNaturals setA;
    private SetOfNaturals setB;
    private SetOfNaturals setC;
    private SetOfNaturals setD;

    @BeforeEach
    void setUp() {
        setA = new SetOfNaturals();
        setB = SetOfNaturals.fromArray(new int[]{10, 20, 30, 40, 50, 60});

        setC = new SetOfNaturals();
        for (int i = 5; i < 50; i++) {
            setC.add(i * 10);
        }
        setD = SetOfNaturals.fromArray(new int[]{30, 40, 50, 60, 10, 20});
    }

    @AfterEach
    void tearDown() {
        setA = setB = setC = setD = null;
    }

    @Test
    void testAddElement() {

        setA.add(99);
        assertTrue(setA.contains(99), "add: added element not found in set.");
        assertEquals(1, setA.size());

        setB.add(11);
        assertTrue(setB.contains(11), "add: added element not found in set.");
        assertEquals(7, setB.size(), "add: elements count not as expected.");
    }

    @Test
    void testAddBadArray() {
        int[] elems = new int[]{10, 20, -30};

        // must fail with exception
        assertThrows(IllegalArgumentException.class, () -> setA.add(elems));
    }


    @Test
    void testIntersectForNoIntersection() {
        assertFalse(setA.intersects(setB), "no intersection but was reported as existing");

    }

    // EXTRA
    @DisplayName("No duplicates should be allowed (single element)")
    @Test
    void testDuplicateElement() {
        assertThrows(IllegalArgumentException.class, () -> setD.add(30));
    }

    @DisplayName("No duplicates should be allowed (array version)")
    @Test
    void testDuplicatesArray() {
        int[] elems = new int[]{1, 1, 2};
        assertThrows(IllegalArgumentException.class, () -> setA.add(elems));

        int[] elems2 = new int[]{30, 40, 50};
        assertThrows(IllegalArgumentException.class, () -> setD.add(elems2));
    }

    @DisplayName("No duplicates should be allowed (adding from array version)")
    @Test
    void testDuplicatesFromArray() {
        int[] elems = new int[]{1, 1, 2};
        assertThrows(IllegalArgumentException.class, () -> setA.fromArray(elems));
    }

    @DisplayName("Contains element")
    @Test
    void testContains() {
        assertFalse(setA.contains(2), () -> "Empty set reporting as containing '2'");
    }

    @DisplayName("Size set")
    @Test
    void testSize() {
        assertEquals(0, setA.size());
    }

    @DisplayName("Valid Intersection between sets")
    @Test
    void testIntersectForValidIntersection() {
        assertTrue(setB.intersects(setD), "no intersection but was reported as existing");

    }

    @DisplayName("Invalid Element")
    @Test
    void testAddInvalidElement() {
        assertThrows(IllegalArgumentException.class, () -> setA.add(-1));
    }

}
