package CommonWordsCount;

import java.io.*;
import java.util.*;

// Creates a list of common words to be removed from the text using a given text file of the most common words to
// be removed, and includes any other functions associated with this list
public class CommonWordList
{
    private ArrayList<String> commonWords = new ArrayList<>(); // List of all the common words

    // Constructor which takes a file and creates a CommonWordList object that has a list of all the words in the file
    // and a function that determines if a string is a member of that list
    CommonWordList(File commonWordFile) throws IOException
    {
        AddCommonWords(commonWordFile);
    }

    // Uses a buffered reader to take a file, split it line by line, then split each line down into a single word,
    // and then adds each of those words to the commonWords list
    private void AddCommonWords(File commonWordFile) throws IOException
    {
        FileReader fileRead = new FileReader(commonWordFile);
        BufferedReader buffRead = new BufferedReader(fileRead);
        String curLine;
        String[] tempList;


        while((curLine = buffRead.readLine()) != null)
        {
            tempList = curLine.split("\\s+");
            for(String word : tempList)
            {
                commonWords.add(word.toLowerCase());
            }
        }
    }

    // Checks if a given word is a common word
    public Boolean IsCommonWord(String word)
    {
        return commonWords.contains(word);
    }
}
