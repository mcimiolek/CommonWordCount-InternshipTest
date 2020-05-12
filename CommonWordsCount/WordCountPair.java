package CommonWordsCount;

// A class that creates an object which holds a word and how many times the word has appeared
public class WordCountPair
{
    String word;
    int count;

    // Constructor that creates the object with the word and the count
    WordCountPair(String word, int count)
    {
        this.word = word;
        this.count = count;
    }

    // Returns what the word of the pair is
    public String GetWord()
    {
        return word;
    }

    // Returns the count of the pair
    public int GetCount()
    {
        return count;
    }

    // Increments the count if the word is found again
    public void IncrementCount()
    {
        count++;
    }

    // Returns a string with both the count and the word
    public String toString()
    {
        return String.format("%-20s" + count, word + ":");
    }
}
