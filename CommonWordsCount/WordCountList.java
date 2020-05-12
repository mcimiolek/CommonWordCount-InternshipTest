package CommonWordsCount;

import java.util.*;
import java.io.*;

public class WordCountList
{
    private static CommonWordList commWords;
    private ArrayList<WordCountPair> wordCounts = new ArrayList<>();
    public int counter;

    WordCountList(File textFile, File commonWordsFile) throws IOException
    {
        commWords = new CommonWordList(commonWordsFile);
        CountWords(textFile);
    }

    private void CountWords(File textFile) throws IOException
    {
        FileReader fileRead = new FileReader(textFile);
        BufferedReader buffRead = new BufferedReader(fileRead);
        String curLine;
        String[] tempList;

        while((curLine = buffRead.readLine()) != null)
        {

            // apostrophes are included for words such as wasn't

            tempList = curLine.split("[^a-zA-Z']+");
            for(String word : tempList)
            {

                // removes single apostraphes and empty strings which are can be returned by this regex

                if(!(word.equals("'") || word.equals("")))
                {
                    counter++;
                    if (!(commWords.IsCommonWord(word.toLowerCase())))
                    {
                        // If a pair has not been incremented because it doesn't exist in wordCounts, add it to word counts
                        // with a base count of 1

                        if (!(PairIncremented(word.toLowerCase())))
                        {
                            wordCounts.add(new WordCountPair(word.toLowerCase(), 1));
                        }
                    }
                }
            }
        }
    }

    // Returns a boolean which is true if a word exists in a word-count pair in wordCounts, while also incrementing
    // that pair
    private boolean PairIncremented(String word)
    {
        for(WordCountPair pair : wordCounts)
        {
            if(pair.GetWord().equals(word))
            {
                pair.IncrementCount();
                return true;
            }
        }
        return false;
    }

    // Returns the count of all the words in the list
    public void OutputList()
    {
        System.out.println("Words and their counts:");
        for(WordCountPair pair : wordCounts)
        {
            System.out.println(pair.toString());
        }
    }
}
