import org.junit.Test;

import static org.junit.Assert.*;

public class ElephantHerdTest {
    ElephantHerd list = new ElephantHerd();
    Elephant Sam = new Elephant("Sam",1,2);
    Elephant Sue = new Elephant("Sue",5,4);
    Elephant Bob = new Elephant("Bob",2,9);



    @Test
    public void add() {
        list.add(Sam);
        System.out.println(Sam);
        System.out.println(list);
    }

    @Test
    public void find() {
        list.add(Sam);
        list.add(Sue);
        assertEquals(Sue,list.find("Su"));
    }

    @Test
    public void remove() {
        list.add(Sam);
        list.add(Sue);
        list.add(Bob);
        System.out.println(list);
        list.remove(1); //removing Sue
        System.out.println(list);


    }

    @Test
    public void sort() {
        list.add(Sam);
        list.add(Bob);
        list.add(Sue);
        list.sort();
        System.out.println(list);
    }

    @Test
    public void getTopKLargestElephants() {
        list.add(Sam);
        list.add(Bob);
        list.add(Sue);
        Elephant[] result = list.getTopKLargestElephants(2);
        assertEquals(Bob,result[0]); //Bob is tallest
        assertEquals(Sue,result[1]); //Sue is 2nd tallest
        // Sam is not included
    }
}


// Ali Meddeb x500:medde001