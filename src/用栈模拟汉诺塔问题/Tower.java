package 用栈模拟汉诺塔问题;

import java.util.Stack;

public class Tower {
    private Stack<Integer> disks;

    /*
    * @param i: An integer from 0 to 2
    */
    public Tower(int i) {
        // create three towers
        this.disks = new Stack<>();
//        int index = i;
//        while (index >= 0) {
//            this.disks.push(index--);
//        }
    }

    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(Tower t) {
        // Move the top disk of this tower to the top of t.
        t.getDisks().push(this.disks.pop());
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    public void moveDisks(int n, Tower destination, Tower buffer) {
        // Move n Disks from this tower to destination by buffer tower
        if (n == 1) {
            this.moveTopTo(destination);
        } else if (n == 2) {
            this.moveTopTo(buffer);
            this.moveTopTo(destination);
            buffer.moveTopTo(destination);
        } else {
            moveDisks(n - 1, buffer, destination);
            this.moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }

    /*
     * @return: Disks
     */
    public Stack<Integer> getDisks() {
        // write your code here
        return disks;
    }

    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
        for (int i = n - 1; i >= 0; i--) towers[0].add(i);
        towers[0].moveDisks(n, towers[2], towers[1]);
        System.out.println("finish");
    }
}
