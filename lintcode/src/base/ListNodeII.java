package base;

/**
 * Created by imink on 08/03/2017.
 */

public class ListNodeII {
    public int id;
    public String name;
    public ListNode before, after;
    public Boolean first, last;
    public ListNodeII (int id, String name) {
        this.id = id;
        this.name = name;
    }
}