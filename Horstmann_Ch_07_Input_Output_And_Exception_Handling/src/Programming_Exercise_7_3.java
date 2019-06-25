import javax.swing.JOptionPane;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

/**
 * "Repeat Exercise P7.2, but allow the user to specify the file name in the command-line.
 * If the user doesnt specify any file name, them prompt the user for the name."
 */

public class programmingExercise73
{
    public static void main(String[] args)
    {
        String inputFile = " ";
        String outputFile = " ";
        if (args.length < 2)
        {
            System.out.print("Please provide 2 files.");
        }
        else
        {
            inputFile = args[0];
            outputFile = args[1];
        }

        try
        {
            File inFile = new File(inputFile);
            Scanner lineReader = new Scanner(inFile);
            PrintWriter outFile = new PrintWriter(outputFile);
            try
            {
                int count = 1;
                while (lineReader.hasNextLine())
                {
                    String line = lineReader.nextLine();
                    outFile.printf("/* %s */ %s%n", count, line);
                    count ++;
                }
            }
            finally
            {
                lineReader.close();
                outFile.close();
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}