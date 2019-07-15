import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

/**
 * @author Haolin Yu
 * ID: 111454745
 * Course AMS 345
 * Final Project
 * 
 * This program implements the Graham Scan Algorithm for computing convex hull for points in the plane.
 * 
 * @version 1.0
 */

public class GrahamScan {

    private List<Point> points = new ArrayList<>();
    private Stack<Point> pointStack = new Stack<>();
    private Point firstPoint;

    public static void main(String[] args) {
            GrahamScan grahamScan = new GrahamScan();
            grahamScan.readPointList();
            grahamScan.processScan();
    }

    public void readPointList(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Graham Scan program started.");
        
        boolean done = false;
        
        while(!done) {
            try{
                System.out.print("Please input the file path: ");
                String path = sc.nextLine();
                System.out.println();
                File f = new File(path);
                sc = new Scanner(f);
                done = true;
            }
            catch(FileNotFoundException e) {
                System.out.println("File not found. Please check file path.");
            }
        }
        
        int pointNum = Integer.parseInt(sc.nextLine());
        
        for(int i = 0; i < pointNum; i++) {
            String pointLocation = sc.nextLine();

            pointLocation = pointLocation.replace("[", " ");
            pointLocation = pointLocation.replace("]", " ");
            pointLocation = pointLocation.trim();

            int x = Integer.parseInt(pointLocation.substring(0, pointLocation.indexOf(",")));
            int y = Integer.parseInt(pointLocation.substring(pointLocation.indexOf(",") + 1, pointLocation.length()));
            Point point = new Point(x, y);
            points.add(point);
        }
        sc.close();
        System.out.println("Start scanning.....\n");  
    }
    
    public void processScan() {
        Collections.sort(points);
        firstPoint = points.get(0);
        pointStack.push(firstPoint);
        points.remove(0);

        Collections.sort(points, angleComparator);
        Collections.reverse(points);

        pointStack.push(points.get(0));
        points.remove(0);

        for(int i = 0; i < points.size(); i++){
            while(pointStack.size() >= 2 && orientationTest(pointStack, i)){
                pointStack.pop();
            }
            pointStack.push(points.get(i));
        }
        
        String points = pointStack.size()+"\n";
        
        for(int i = 0; i < pointStack.size();i++){
            points += pointStack.get(i)+"\n";
        }
        
        export(points);
    }
    
    public void export(String content) {
        System.out.print("Complete.\nPlease input export path: ");
        Scanner sc = new Scanner(System.in);
        String exportPath = sc.nextLine();
        Writer writer;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(exportPath+"\\GrahamScanResult.txt"), "utf-8"));
            writer.write(content);
            writer.close();
        }
        catch(Exception e) {
            
        }
    }

    public boolean orientationTest(Stack<Point> pointStack, int i) {
        Point p2 = pointStack.pop();
        Point p1 = pointStack.pop();
        Point p3 = points.get(i);
        Point vector1 = new Point(p2.x - p1.x, p2.y - p1.y);
        Point vector2 = new Point(p3.x - p1.x, p3.y - p1.y);
        pointStack.push(p1);
        pointStack.push(p2);
        int crossProduct = vector1.x * vector2.y - vector1.y * vector2.x;
        return crossProduct <= 0;
    }

    Comparator<Point> angleComparator = new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {

            Point p1Re = new Point(p1.x - firstPoint.x, p1.y - firstPoint.y);
            Point p2Re = new Point(p2.x - firstPoint.x, p2.y - firstPoint.y);

            Double r1 = Math.sqrt(Math.pow(p1Re.x, 2) + Math.pow(p1Re.y, 2));
            Double r2 = Math.sqrt(Math.pow(p2Re.x, 2) + Math.pow(p2Re.y, 2));
            Integer crossProduct = p1Re.x * p2Re.y - p1Re.y * p2Re.x;
            if(crossProduct.compareTo(0) == 0){
                    return r1.compareTo(r2) == 0 ? 1 : -r1.compareTo(r2);
            }
            return crossProduct.compareTo(0);
        }
    };
}