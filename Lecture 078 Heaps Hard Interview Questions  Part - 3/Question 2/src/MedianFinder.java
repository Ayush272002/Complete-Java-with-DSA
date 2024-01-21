import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    double median;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        median = -1.0;
    }

    private int signum(int a, int b)
    {
        return Integer.compare(a, b);
    }

    public void addNum(int num) {
        int diff = signum(maxHeap.size() , minHeap.size());

        switch (diff)
        {
            case 0 :
                if(num > median)
                {
                    minHeap.add(num);
                    if(!minHeap.isEmpty()) median = minHeap.peek();
                }
                else
                {
                    maxHeap.add(num);
                    if(!maxHeap.isEmpty()) median = maxHeap.peek();
                }
                break;

            case 1 : //max heap is greater than right part
                if(num > median)
                {
                    minHeap.add(num);
                    if(!minHeap.isEmpty() && !maxHeap.isEmpty())
                        median = (minHeap.peek() + maxHeap.peek())/2.0;
                }
                else
                {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                    if(!minHeap.isEmpty() && !maxHeap.isEmpty())
                        median = (minHeap.peek() + maxHeap.peek())/2.0;
                }
                break;

            case -1 : //min heap is greater than max heap
                if(num > median)
                {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                    if(!minHeap.isEmpty() && !maxHeap.isEmpty())
                        median = (minHeap.peek() + maxHeap.peek())/2.0;

                }
                else
                {
                    maxHeap.add(num);
                    if(!minHeap.isEmpty() && !maxHeap.isEmpty())
                        median = (minHeap.peek() + maxHeap.peek())/2.0;

                }
                break;
        }
    }

    public double findMedian() {
        return median;
    }
}

/*
The time complexity of each addNum operation is O(log N).
The overall time complexity for a sequence of N addNum operations is O(N log N),
where N is the total number of elements added.
Space complexity - O(n)
 */

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */