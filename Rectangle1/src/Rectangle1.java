import java.io.File;
import java.util.Scanner;

public class Rectangle1
{
    public static void main(String[] args)
    {

    }


    // Open DSA
    // !QUESTION!
    // Do we assume the inputs will be perfect?
    @SuppressWarnings("unchecked")
    public void parse(String filename)
    {
        // !QUESTION!
        // "SkipList is a raw type. References to generic type SkipList<K,E>
        // should be parameterized"
        // What do I do with this?
        SkipList list = new SkipList();
        // !QUESTION!
        // I want to instantiate once and change as we go
        // Does this look correct?
        KVPair pair = new KVPair(null, null);
        Rectangle rect = new Rectangle(0, 0, 0, 0);
        try
        {
            Scanner sc = new Scanner(new File(filename));
            Scanner scancmd; // Declare two scanners one to read the file and
                             // one to read the text pulled from the file
            while (sc.hasNextLine()) // While we have text to read
            {
                String line = sc.nextLine(); // Get our next line
                scancmd = new Scanner(line); // Create a scanner from this line
                String cmd = scancmd.next(); // Get the first word (the
                                             // command)on each line

                String token = "";
                String name = "";
                int x = 0;
                int y = 0;
                int width = 0;
                int height = 0;

                switch (cmd)
                {
                    case "insert":
                        name = scancmd.next();
                        x = scancmd.nextInt();
                        y = scancmd.nextInt();
                        width = scancmd.nextInt();
                        height = scancmd.nextInt();

                        rect.setX(x);
                        rect.setY(y);
                        rect.setWidth(width);
                        rect.setHeight(height);
                        if (width < 0 || height < 0 || x + width > 1024 || y
                            + height > 1024) // checks for validity
                        {
                            System.out.println("Rectangle rejected: (" + rect
                                .toString() + ")");
                        }

                        pair.theKey = name;
                        pair.theVal = rect;
                        list.insert(pair);
                        break;

                    case "remove":
                        token = scancmd.next(); // get name or first integer
                        // if removing by rectangle
                        if (Character.isDigit(token.charAt(0)))
                        {
                            rect.setX(Integer.parseInt(token)); // read each
                                                                // dimensions
                            rect.setY(scancmd.nextInt());
                            rect.setWidth(scancmd.nextInt());
                            rect.setHeight(scancmd.nextInt());

                            pair = list.removeByValue(rect);

                            if (pair == null)
                            {
                                System.out.println("Rectangle not removed: "
                                    + rect.toString());
                                break;
                            }
                            System.out.println("Rectangle removed: " + pair
                                .toString());
                            break;
                        }
                        // else remove by name
                        pair = list.removeByKey(token);
                        if (pair == null)
                        {
                            System.out.println("Rectangle not removed: "
                                + token);
                            break;
                        }
                        System.out.println("Rectangle removed: " + list
                            .removeByKey(token));
                        break;

                    case "regionsearch":
                        rect.setX(scancmd.nextInt()); // read each dimensions
                        rect.setY(scancmd.nextInt());
                        rect.setWidth(scancmd.nextInt());
                        rect.setHeight(scancmd.nextInt());

                        if (rect.getWidth() <= 0 || rect.getHeight() <= 0)
                        {
                            System.out.println("Rectangle rejected: " + rect
                                .toString());
                            break;
                        }
                        list.regionSearch(rect);
                        break;

                    case "intersections":
                        // call intersections
                        break;

                    case "dump":
                        list.dump();
                        break;

                    case "search":
                        name = scancmd.next();

                        // call search by name
                        break;

                    default:
                        System.out.println("Unrecognized input");
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
