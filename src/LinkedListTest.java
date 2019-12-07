import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList list = new LinkedList();

    @org.junit.Test
    public void add() {
        list.add(5);
        list.add(6);
        list.add(7);
        assertEquals(3,list.size());
        assertEquals(6,list.get(1));
    }

    @Test
    public void add1() {
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(1,55);
        assertEquals(55,list.get(1));
        assertEquals(6,list.get(2)); //6 pushed
    }

    @org.junit.Test
    public void get(){
        list.add(5);
        list.add(6);
        list.add(7); //index 2
        list.add(8);
        assertEquals(7,list.get(2));
        assertEquals(7,list.get(2));


    }
    @org.junit.Test
    public void indexOf(){
        list.add(5);
        list.add(6);
        list.add(7); //index 2
        list.add(8);
        list.sort(true);
        assertEquals(1,list.indexOf(6));
        assertEquals(3,list.indexOf(8));


    }

    @Test
    public void clear() {
        list.add(5);
        list.add(6);
        list.add(7);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void contains() {
        list.add(5);
        list.add(6);
        list.add(7);
        assertFalse(list.contains(12));
        assertTrue(list.contains(7));
    }

    @Test
    public void contains1() { //contains() with sorted list
        list.add(8);
        list.add(6);
        list.add(3);
        list.add(7);
        list.sort(true);
        assertFalse(list.contains(12));
        assertTrue(list.contains(8));
    }


    @Test
    public void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(5);
        assertFalse(list.isEmpty());
    }

    @Test
    public void lastIndexOf() {
        list.add(5);
        list.add(6);
        list.add(5); //index 2
        list.add(8);
        assertEquals(2,list.lastIndexOf(5));
    }

    @Test
    public void set() {
        list.add("ali");
        list.add("will");
        list.add("bob");
        assertEquals("will",list.set(1,"King")); //will popped and replaced
        assertEquals("King",list.get(1)); //changed will to King


    }

    @Test
    public void size() {
        assertEquals(0,list.size());
        list.add(1);
        list.add(2);
        assertEquals(2,list.size());
    }

    @Test
    public void sort() {
        list.add('z');
        list.add('e');
        list.add('a');
        list.add('c');
        list.add('b');
        list.add('n');
        list.sort(true); //Ascending order
        System.out.println(list);
        list.sort(false); //Descending order
        System.out.println(list);
    }

    @Test
    public void remove() {
        list.add("hello");
        list.add("bot");
        list.add("Girl");
        list.add("McDonald's");
        list.remove("bot");
        assertEquals("Girl",list.get(1)); //Girl takes bot's place in index 1
    }

    @Test
    public void remove1() {
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(11);
        assertEquals(7,list.remove(2)); //popped 7
        assertEquals(11,list.get(2)); // 11 is pushed back
    }


}

// Ali Meddeb x500:medde001