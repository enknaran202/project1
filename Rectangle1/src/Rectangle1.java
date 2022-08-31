import java.io.File;
import java.util.Scanner;

public class Rectangle1
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }


// Open DSA
    public static void parse(String filename)
    {
        try
        {
            Scanner sc = new Scanner(new File(filename));
            Scanner scancmd; // Declare two scanners one to read the file and
                             // one
                             // to read the text pulled from the file
            while (sc.hasNextLine()) // While we have text to read
            {
                String line = sc.nextLine();// Get our next line
                scancmd = new Scanner(line);// Create a scanner from this line
                String cmd = scancmd.next();// Get the first word (the command)
                                            // on each line

                String type = "";
                String token = "";
                String name = "";
                int x = 0;
                int y = 0;
                int wid = 0;
                int len = 0;

                switch (cmd)
                {
                    case "insert":

                        name = scancmd.next();

                        x = scancmd.nextInt();

                        y = scancmd.nextInt();

                        wid = scancmd.nextInt();

                        len = scancmd.nextInt();

                        // Create the rectangle and send to insert
                        break;

                    case "remove":
                        type = scancmd.next();// get name or first integer
                        token = scancmd.next();
                        if (Character.isDigit(token.charAt(0))) // if removing
                                                                // by rectangle
                        { // read each dimensions
                            x = Integer.parseInt(token);

                            y = scancmd.nextInt();

                            wid = scancmd.nextInt();

                            len = scancmd.nextInt();
                            // call remove by rectange
                            break;
                        }
                        name = token; // else remove by name
                        // call remove by name
                        break;

                    case "regionsearch":
                        x = scancmd.nextInt();

                        y = scancmd.nextInt();

                        wid = scancmd.nextInt();

                        len = scancmd.nextInt();

                        // call regionsearch
                        break;

                    case "intersections":
                        // call intersections
                        break;

                    case "dump":
                        // call dump
                        break;

                    case "search":
                        type = scancmd.next();// get name or first integer
                        token = scancmd.next();
                        if (Character.isDigit(token.charAt(0))) // if removing
                                                                // by rectangle
                        { // read each dimensions
                            x = Integer.parseInt(token);

                            y = scancmd.nextInt();

                            wid = scancmd.nextInt();

                            len = scancmd.nextInt();
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
