package CommonWordsCount;

import java.io.*;

public class Main
{

    // Runs the program, using two string arguments from args to name the file locations of the files used for
    // commonWordsFile and textFile
    public static void main(String[] args) throws IOException
    {
        File commonWordsFile = new File(args[0]);
        File textFile = new File(args[1]);

        WordCountList wordCounts = new WordCountList(textFile, commonWordsFile);
        wordCounts.OutputList();
    }
}
