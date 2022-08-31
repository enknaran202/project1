import java.io.File;
import java.util.Scanner;

public class Rectangle1
{

    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

// Remove switch case string and integer

// CLASS: RemoveName

// CLASS: RemoveCoord

// CLASS: RegionSearch

// CLASS: Intersect

// public class Main {
//
// /**
// * @param args
// */
// public static void main(String[] args) {
// int count = 0;//Set our counter
// if(args.length < 1) {
// //No parameters is this a problem?
// }
// while(count < args.length) {//While we have not reached the end of our
// arguments keep going.
// switch(args[count]) {
// case "-h"://Display help info
// System.out.println("This is the help message. Proper command syntax:");
// System.out.println("cmdline -v: Displays version information");
// System.out.println("cmdline -h: Displays this help message");
// System.out.println("cmdline -f [file]: Sets file to file provided");
// count++;
// break;
// case "-v"://Display version information
// System.out.println("Cmdline parse sample version 1.0.0");
// count++;
// break;
// case "-f"://This is an example to show you how to handle when you have a
// parameter that takes info
// String fileName = args[count+1];//We are getting the filename so set it to
// the string after -f
// System.out.println("Input file is "+fileName);//Print out info
// count = count+2;//Increment counter to next item (skipping filename).
// //Note this provides no bounds checking so if you pass the parameter without
// file info it may bomb if at the end
// //You may also surround it in a try/catch for safety.
// break;
// default://If none of your cases match then this is an unrecognized parameter
// and we will exit.
// System.out.println("Unrecognized parameter "+args[count]+"\nExiting.");
// System.exit(-1);
// break;
// }
// }
// }
//
// }


// This code will parse through a command file, read in each command and each of
// their parameters (if the command has one). It is important to note, however,
// that this code is not necessarily safe. It assumes that the command file
// given is properly formatted, and as such if a user decides to give the
// program a malformed file the program will behave in a possibly unknown way.
//
// Depending on the structure of your file you may not wish to simply do the
// token method. Another approach would be to read in an entire line and then
// work from there. Consider this input file. We now have 3 commands that we
// must support.
//
// 1. insert {artist-name}<SEP>{song-name} - inserts a song using the
// information provided in the fields
//
// remove {artist|song} {name} - removes a song given a song name or artist name
//
// 3. print {artist|song|blocks} - depending on the parameter value, you will
// print out either a complete listing of the artists contained in the database,
// or the songs, or else the free block list for the memory manager
//
// So this time we have less commands to support, but more options for each
// command , no worries! We simply need to change our code just a little bit. We
// see this time that the insert command has no spacing between artist/song
// tokens. Rather it uses the seperator <SEP>.
//
    public static void beginParsingByLine(String filename)
    {
        try
        {
            Scanner sc = new Scanner(new File(filename));
            Scanner scancmd;// Declare two scanners one to read the file and one
                            // to read the text pulled from the file
            while (sc.hasNextLine())
            {// While we have text to read
                String line = sc.nextLine();// Get our next line
                scancmd = new Scanner(line);// Create a scanner from this line
                String cmd = scancmd.next();// Get the first word (the command)
                                            // on each line
                String type;

                String name = "";

                String x = "";

                String y = "";

                String wid = "";

                String len = "";
                switch (cmd)
                {
                    case "insert":// In the case of insert change our delimiter
                                  // from white space to <SEP>

                        name = scancmd.next();

                        x = scancmd.next();

                        y = scancmd.next();

                        wid = scancmd.next();

                        len = scancmd.next();

                        // Create the rectangle and send to insert
                        if (true)
                        {
                            // send success message to output
                        }
                        // send failure message to output

                        break;
                    case "remove":
                        type = scancmd.next();// Get the mode of deletion
                                              // artist/song
                        String token = scancmd.next();
                        if (Character.isDigit(token.charAt(0))) // if removing
                                                                // dimensions
                        {
                            x = token;

                            y = scancmd.next();

                            wid = scancmd.next();

                            len = scancmd.next();
                            // call remove by character
                        }
                        name = token;
                        // call remove by name
                        
                        break;
                    case "print":// Print command
                        type = scancmd.next();// get the type of print command
                        switch (type)
                        {
                            case "artist":
                                System.out.println("Print artist mode");
                                break;
                            case "song":
                                System.out.println("Print song mode");
                                break;
                            case "blocks":
                                System.out.println("Print block mode");
                                break;
                            default:
                                System.out.println("Error bad print type"
                                    + type);
                                break;
                        }
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
