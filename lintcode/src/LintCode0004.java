/**
 * Created by imink on 25/10/2016.
 */
import java.util.*;

class  HashHeap {
    ArrayList<Integer> heap;
    String mode;
    int size_t;
    HashMap<Integer, Node> hash;

    class Node {
        public Integer id;
        public Integer num;

        Node(Node now) {
            id = now.id;
            num = now.num;
        }

        Node(Integer first, Integer second) {
            this.id = first;
            this.num = second;
        }
    }

    public HashHeap(String mod) {
        heap = new ArrayList<Integer>();
        mode = mod;
        hash = new HashMap<Integer, Node>();
        size_t = 0;
    }

    int peak() {
        return heap.get(0);
    }

    int size() {
        return size_t;
    }

    Boolean isEmpty() {
        return (heap.size() == 0);
    }

    int parent(int id) {
        if (id == 0) {
            return -1;
        }
        // TODO: 25/10/2016 why id - 1
        return (id - 1) / 2;
    }

    int lson(int id) {
        return id * 2 + 1;
    }

    int rson(int id) {
        return id * 2 + 2;
    }

    boolean compareSmall(int a, int b) {
        if (a <= b) {
            if (mode == "min") return true;
            else return false;
        } else {
            if (mode == "min") return false;
            else return true;
        }
    }

    void swap(int idA, int idB) {
        int valA = heap.get(idA);
        int valB = heap.get(idB);

        int numA = hash.get(valA).num;
        int numB = hash.get(valB).num;

        hash.put(valB, new Node(idA, numB));
        hash.put(valA, new Node(idB, numA));

        heap.set(idA, valB);
        heap.set(idB, valA);
    }

    Integer poll() {
        size_t --;
        Integer now = heap.get(0);
        Node hashNow = hash.get(now);

        if (hashNow.num == 1) {
            // swap the first and the last element
            swap(0, heap.size() - 1);
            // then remove the corresponding element
            hash.remove(now);
            heap.remove(heap.size() - 1);
            if (heap.size() > 0) {
                shiftDown(0);
            }
        } else {
            hash.put(now, new Node(0, hashNow.num - 1));
        }

        return now;
    }

    void add(int now) {
        size_t ++;
        if (hash.containsKey(now)) {
            Node hashNow = hash.get(now);
            hash.put(now, new Node(hashNow.id, hashNow.num + 1));
        } else {
            heap.add(now);
            hash.put(now, new Node(heap.size() - 1, 1));
        }

        shiftUp(heap.size() - 1);
    }

    void delete(int now) {
        size_t --;
        Node hashNow = hash.get(now);
        int id = hashNow.id;
        int num = hashNow.num;

        if (hashNow.num == 1) {
            swap(id, heap.size() - 1);
            hash.remove(now);
            heap.remove(heap.size() - 1);
            if (heap.size() > id) {
                shiftUp(id);
                shiftDown(id);
            }
        } else {
            hash.put(now, new Node(id, num - 1));
        }
    }

    void shiftUp(int id) {
        while (parent(id) > -1) {
            int parentId = parent(id);
            if (compareSmall(heap.get(parentId), heap.get(id)) == true) {
                break;
            } else {
                swap(id, parentId);
            }

            id = parentId;
        }
    }

    void shiftDown(int id) {
        while (lson(id) < heap.size()) {
            int leftId = lson(id);
            int rightId = rson(id);
            int son;

            if (rightId >= heap.size() || (compareSmall(heap.get(leftId), heap.get(rightId)) == true)) {
                son = leftId;
            } else {
                son = rightId;
            }
            if (compareSmall(heap.get(id), heap.get(son)) == true) {
                break;
            } else {
                swap(id, son);
            }
            id = son;
        }
    }

}



public class LintCode0004 {
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        if (nums.length == 0) return ans;

        int median = nums[0];
        HashHeap minHeap = new HashHeap("min");
        HashHeap maxHeap = new HashHeap("max");

        for (int i = 0; i < nums.length; i ++) {
            if (i != 0) {
                if (nums[i] > median) {
                    minHeap.add(nums[i]);
                } else {
                    maxHeap.add(nums[i]);
                }
            }

            if (i >= k) {
                if (median == nums[i - k]) {
                    if (maxHeap.size() > 0) {
                        median = maxHeap.poll();
                    } else if (minHeap.size() > 0) {
                        median = minHeap.poll();
                    }
                } else if (median < nums[i - k]) {
                    minHeap.delete(nums[i - k]);
                } else {
                    maxHeap.delete(nums[i - k]);
                }
            }

            while (maxHeap.size() > minHeap.size()) {
                minHeap.add(median);
                median = maxHeap.poll();
            }

            while (minHeap.size() > maxHeap.size()) {
                maxHeap.add(median);
                median = minHeap.poll();
            }
            // to make sure we add the correct 1st median
            if (i + 1 >= k) {
                ans.add(median);
            }
        }


        return ans;
    }


    public static void main(String[] args) {
        int[] array = {1,2,7,8,5};
        int k = 3;

        LintCode0004 obj = new LintCode0004();

        System.out.println(Arrays.asList(obj.medianSlidingWindow(array, k)));
    }
}
