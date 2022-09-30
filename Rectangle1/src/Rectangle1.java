
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// Enk Narantsatsralt {enk}
// Deep Datta {ddeep21}

/**
 * MAIN CLASS
 * 
 * @author Deep Datta (PID: ddeep21), Enk Naran (PID: enk)
 * @version 9/11/2022
 */
public class Rectangle1
{
    public static void main(String[] args)
    {

        String filename = args[0];// Pass the function a full filepath
        Parser par = new Parser();
        par.parseFile(filename);// call the parsing function

    }

}
