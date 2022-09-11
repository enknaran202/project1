import java.io.File;
import java.util.Scanner;

public class Parser {

    SkipList<String, Rectangle> list;
    KVPair<String, Rectangle> pair;

    public Parser() {

        list = new SkipList<String, Rectangle>();
        pair = new KVPair<String, Rectangle>(null, null);

    }


    // Open DSA
    // !QUESTION!
    // Do we assume the inputs will be perfect?
    @SuppressWarnings("unchecked")
    public void parseFile(String filename) {

        Rectangle rect = new Rectangle(0, 0, 0, 0);
        try {
            Scanner sc = new Scanner(new File(filename));
            String token = "";
            String name = "";
            int x = 0;
            int y = 0;
            int width = 0;
            int height = 0;

            while (sc.hasNext()) // While we have text to read
            {
                token = sc.next();
                // String[] line = sc.nextLine().strip().split("\\s"); (clean up
                // later)

                System.out.println(token);

                switch (token) {

                    case "insert":
                        name = sc.next();
                        x = sc.nextInt();
                        y = sc.nextInt();
                        width = sc.nextInt();
                        height = sc.nextInt();

                        rect.setX(x);
                        rect.setY(y);
                        rect.setWidth(width);
                        rect.setHeight(height);
                        if (width < 0 || height < 0 || x + width > 1024 || y
                            + height > 1024 || x < 0 || y < 0) // checks for
                                                               // validity
                        {
                            System.out.println("Rectangle rejected: (" + rect
                                .toString() + ")");
                        }

                        pair.theKey = name;
                        pair.theVal = rect;
                        list.insert(pair);
                        break;

                    case "remove":
                        name = sc.next(); // get name or first integer
                        // if removing by rectangle
                        if (Character.isDigit(name.charAt(0))) {

                            rect.setX(Integer.parseInt(token)); // read each
                                                                // dimensions
                            rect.setY(sc.nextInt());
                            rect.setWidth(sc.nextInt());
                            rect.setHeight(sc.nextInt());

                            pair = list.removeByValue(rect);

                            if (pair == null) {
                                System.out.println("Rectangle not removed: ("
                                    + rect.toString() + ")");
                                break;
                            }

                            System.out.println("Rectangle removed: (" + pair
                                .toString() + ")");
                            break;
                        }
                        // else remove by name
                        pair = list.removeByKey(name);

                        if (pair == null) {
                            System.out.println("Rectangle not removed: "
                                + token);
                            break;
                        }

                        System.out.println("Rectangle removed: (" + list
                            .removeByKey(name).toString() + ")");
                        break;

                    case "regionsearch":

                        rect.setX(sc.nextInt()); // read each dimensions
                        rect.setY(sc.nextInt());
                        rect.setWidth(sc.nextInt());
                        rect.setHeight(sc.nextInt());

                        if (rect.getWidth() <= 0 || rect.getHeight() <= 0) {
                            System.out.println("Rectangle rejected: " + rect
                                .toString());
                            break;
                        }

                        System.out.println(list.regionSearch(rect));
                        break;

                    case "intersections":

                        System.out.println();
                        System.out.println(list.intersections());

                        break;

                    case "dump":

                        System.out.println(list.dump());
                        break;

                    case "search":

                        name = sc.next();
                        String output = list.search(name);
                        if (output.equals(null)) {

                            System.out.println("Rectangle not found: (" + name
                                + ")");

                        }
                        else {

                            System.out.println("Rectangle found:" + list.search(
                                name));
                        }

                        break;

                    default:

                        break;
                }

            }

        }
        catch (

        Exception e) {
            e.printStackTrace();
        }
    }
}
