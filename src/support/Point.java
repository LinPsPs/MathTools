/**
 *
 * @author Haolin Yu
 */

package support;

public class Point implements Comparable<Point>{
    public Integer x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(y.compareTo(o.y) == 0){
            return x.compareTo(o.x);
        }
        return y.compareTo(o.y);
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
