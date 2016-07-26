import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by xuan on 7/26/2016.
 */
@RunWith(JUnit4.class)
public class MedianTest {

    private Median median;

    @Before
    public void init(){
        this.median = new Median();
    }

    @Test
    public void testAddOnce() {
        this.median.add(1);
        assertEquals(1, this.median.maxHeap.size());
        assertEquals(new Integer(1), this.median.maxHeap.peek());
    }
    @Test
    public void testAddTwice() {
        this.median.add(2);
        this.median.add(1);
        assertEquals(1, this.median.maxHeap.size());
        assertEquals(new Integer(1), this.median.maxHeap.peek());
        assertEquals(1, this.median.minHeap.size());
        assertEquals(new Integer(2), this.median.minHeap.peek());
    }

    @Test
    public void testAddTwice2() {
        this.median.add(1);
        this.median.add(3);
        assertEquals(1, this.median.maxHeap.size());
        assertEquals(new Integer(1), this.median.maxHeap.peek());
        assertEquals(1, this.median.minHeap.size());
        assertEquals(new Integer(3), this.median.minHeap.peek());
    }

    @Test
    public void testAddThreeTimes(){
        this.median.add(1);
        this.median.add(2);
        this.median.add(3);
        assertEquals(new Integer(2), this.median.maxHeap.poll());
        assertEquals(new Integer(1), this.median.maxHeap.poll());
        assertEquals(new Integer(3), this.median.minHeap.poll());
    }

    @Test
    public void testGetMedianWithOneElement() {
        this.median.add(1);
        assertEquals(new Double(1), this.median.getMedian());
    }

    @Test
    public void testGetMedianWithTwoElements(){
        this.median.add(1);
        this.median.add(3);
        assertEquals(new Double(2), this.median.getMedian());
    }

    @Test
    public void testGetMedianWithThreeElements(){
        this.median.add(8);
        this.median.add(5);
        this.median.add(4);
        assertEquals(new Double(5), this.median.getMedian());
    }

    @Test(expected = NullPointerException.class)
    public void testGetMedianWithNoElements(){
        this.median.getMedian();
    }
}
