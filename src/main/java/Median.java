import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xuan on 7/26/2016.
 */
public class Median {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return - o1.compareTo(o2);
        }
    });

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public Double getMedian(){
        assert this.maxHeap.size() >= this.minHeap.size();
        assert this.maxHeap.size() <= this.minHeap.size() + 1;
        if(this.maxHeap.size() == 0) {
            throw new NullPointerException("List is empty");
        }
        
        if(this.maxHeap.size() == this.minHeap.size()) {
            return (this.maxHeap.peek() + this.minHeap.peek()) / 2.0;
        }else{
            return new Double(this.maxHeap.peek());
        }
    }

    public void add(Integer value) {
        assert this.maxHeap.size() >= this.minHeap.size();
        assert this.maxHeap.size() <= this.minHeap.size() + 1;

        if(this.maxHeap.size() == this.minHeap.size()) {
            if(this.minHeap.size() > 0 && value > this.minHeap.peek()) {
                Integer min = this.minHeap.poll();
                this.minHeap.add(value);
                this.maxHeap.add(min);
            }else{
                this.maxHeap.add(value);
            }
        }else{
            if(this.maxHeap.peek() > value) {
                Integer max = this.maxHeap.poll();
                this.maxHeap.add(value);
                this.minHeap.add(max);
            }else{
                this.minHeap.add(value);
            }
        }
    }
}
