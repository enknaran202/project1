import java.io.File;
import java.util.Scanner;

public class Rectangle1
{
    public static void main(String[] args)
    {

    }
    // Open DSA
    public void parse(String filename)
    {
        // !QUESTION!
        // "SkipList is a raw type. References to generic type SkipList<K,E>
        // should be parameterized"
        // What do I do with this?
        SkipList list = new SkipList();
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

                        if (width < 0 || height < 0 || x + width > 1024 || y
                            + height > 1024) // checks for validity
                        {
                            System.out.println("Rectangle rejected: (" + name
                                + ", " + x + ", " + y + ", " + width + ", "
                                + height + ")");
                        }

                        Rectangle newRect = new Rectangle(x, y, width, height);
                        // Create new rectangle, put it in KVPair, and insert in
                        // a list
                        // !QUESTION!
                        // How fix yellow line?
                        KVPair newPair = new KVPair(name, newRect);
                        list.insert(newPair);
                        break;

                    case "remove":
                        // EDIT
                        // Remove functions now return BOOLEAN
                        token = scancmd.next(); // get name or first integer
                        if (Character.isDigit(token.charAt(0))) // if removing
                                                                // by rectangle
                        {
                            x = Integer.parseInt(token); // read each dimensions

                            y = scancmd.nextInt();

                            width = scancmd.nextInt();

                            height = scancmd.nextInt();
                            // !QUESTION!
                            // How to represent remove failure?
                            System.out.println(list.removeByRectangle(x, y, width, height));
                            break;
                        }
                        name = token; // else remove by name
                        // !QUESTION!
                        // How fix yellow line?
                        // How to represent failure?
                        System.out.println(list.removeByName(name));
                        break;

                    case "regionsearch":
                        x = scancmd.nextInt();

                        y = scancmd.nextInt();

                        width = scancmd.nextInt();

                        height = scancmd.nextInt();

                        // call regionsearch
                        break;

                    case "intersections":
                        // call intersections
                        break;

                    case "dump":
                        // call dump
                        break;

                    case "search":
                        token = scancmd.next();
                        if (Character.isDigit(token.charAt(0))) // if removing
                                                                // by rectangle
                        { // read each dimensions
                            x = Integer.parseInt(token);

                            y = scancmd.nextInt();

                            width = scancmd.nextInt();

                            height = scancmd.nextInt();
                            // call search by rectangle
                            break;
                        }
                        name = token;
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
