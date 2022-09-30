import java.io.File;
import java.util.Scanner;

/**
 * Parser for text
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * @version 9/11/2022
 */
public class Parser
{

    private SkipList<String, Rectangle> list;
    private KVPair<String, Rectangle> pair;

    /**
     * parser
     * 
     */
    public Parser()
    {

        list = new SkipList<String, Rectangle>();
        pair = new KVPair<String, Rectangle>(null, null);

    }


    // Open DSA
    // !QUESTION!
    // Do we assume the inputs will be perfect?
    /**
     * Where the file is parsed
     * 
     */
    public void parseFile(String filename)
    {

        Rectangle rect = new Rectangle(0, 0, 0, 0);
        try
        {
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

                switch (token)
                {

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
                        if (width <= 0 || height <= 0 || x + width > 1024 || y
                            + height > 1024 || x < 0 || y < 0) // checks for
                                                               // validity
                        {
                            System.out.println("Rectangle rejected: (" + name
                                + ", " + rect.toString() + ")");
                        }
                        else
                        {

                            list.insert(new KVPair<String, Rectangle>(name,
                                new Rectangle(x, y, width, height)));
                            System.out.println("Rectangle inserted: (" + name
                                + ", " + rect.toString() + ")");

                        }
                        break;

                    case "remove":
                        name = sc.next(); // get name or first integer
                        // if removing by rectangle
                        if (Character.isDigit(name.charAt(0)))
                        {

                            rect.setX(Integer.parseInt(name)); // read each
                                                               // dimensions
                            rect.setY(sc.nextInt());
                            rect.setWidth(sc.nextInt());
                            rect.setHeight(sc.nextInt());
                            if (rect.getWidth() > 0 && rect.getHeight() > 0
                                && rect.getX() + rect.getWidth() <= 1024 && rect
                                    .getY() + rect.getHeight() <= 1024 && rect
                                        .getX() >= 0 && rect.getY() >= 0)
                            {

                                pair = list.removeByValue(rect);

                            }
                            else
                            {

                                System.out.println("Rectangle rejected: ("
                                    + rect.toString() + ")");
                                break;

                            }

                            if (pair == null)
                            {
                                System.out.println("Rectangle not removed: ("
                                    + rect.toString() + ")");
                                break;
                            }

                            System.out.println("Rectangle removed: (" + pair
                                .toString() + ")");
                            break;
                        }

                        pair = list.removeByKey(name);

                        if (pair == null)
                        {
                            System.out.println("Rectangle not removed: (" + name
                                + ")");
                            break;
                        }

                        System.out.println("Rectangle removed: (" + pair
                            .toString() + ")");
                        break;

                    case "regionsearch":

                        rect.setX(sc.nextInt()); // read each dimensions
                        rect.setY(sc.nextInt());
                        rect.setWidth(sc.nextInt());
                        rect.setHeight(sc.nextInt());

                        if (rect.getWidth() <= 0 || rect.getHeight() <= 0)
                        {
                            System.out.println("Rectangle rejected: (" + rect
                                .toString() + ")");
                            break;
                        }
                        else
                        {
                            System.out.println(
                                "Rectangles intersecting region (" + rect
                                    .toString() + list.regionSearch(rect)
                                    + "): ");
                        }
                        break;

                    case "intersections":

                        System.out.println(list.intersections());

                        break;

                    case "dump":

                        System.out.println(list.dump());
                        break;

                    case "search":

                        name = sc.next();
                        String output = list.search(name);
                        if (output == null)
                        {

                            System.out.println("Rectangle not found: (" + name
                                + ")");

                        }
                        else
                        {

                            System.out.println("Rectangles found:" + list
                                .search(name));
                        }

                        break;

                    default:

                        break;
                }

            }

        }
        catch (

        Exception e)
        {
            e.printStackTrace();
        }
    }
}
