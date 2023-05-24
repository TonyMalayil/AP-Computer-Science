import java.util.*;
import java.io.*;
import java.awt.*;

public class HashMapProbs
{
    public static void main( String[] args)
    {
        //#2

        HashMap<String, String> animalSound = new HashMap<>();
        animalSound.put("Dog", "Woof");
        animalSound.put("Cat", "Meow");
        animalSound.put("Cow", "Moo");
        animalSound.put("Pig", "Oink");
        System.out.println(animalSound);

        //#3
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scan.next();
        System.out.println(animalSound.get(str));

        //#4
        System.out.println(animalSound.size());

        //#5
        System.out.print("Enter an animal: ");
        String newAnimal = scan.next();
        System.out.print("Enter the animal's sound: ");
        String newSound = scan.next();
        animalSound.put( newAnimal, newSound);

        //#7
        System.out.println(takeBefore("str", "bye"));

        //#8
        System.out.println(multiple("hello"));



        //#9
        System.out.println(charWord(new String[] {"tea", "salt", "soda", "taco"}));


        //#10
        frequency();


    }

    public static HashMap<String, String> takeBefore( String a, String b)
    {
        HashMap<String, String>  map = new HashMap<>();
        for( int i = 0; i < a.length(); i++)
        {
            char key = ' ';
            char value = ' ';
            char letter = a.charAt(i);
            char other = b.charAt(i);
            if( letter < other) {
                key = letter;
                value = other;
            }
            if( letter > other) {
                key = other;
                value = letter;
            }
            String theKey = key + "";
            String theValue = value + "";
            map.put( theKey, theValue);
        }

        return map;
    }

    public static HashMap<String, Boolean> multiple(String s)
    {
        HashMap<String, Boolean>  map = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {

            char letter = s.charAt(i);

            Boolean repeats = false;

            for( int g = 0; g < s.length(); g++)
            {
                if( g != i)
                {
                    if( letter == s.charAt(g))
                        repeats = true;
                }
            }
            String Letter = letter + "";
            map.put(Letter, repeats);
        }
        return map;
    }

    public static HashMap< String, String> charWord( String[] words)
    {
        HashMap<String, String>  map = new HashMap<>();

        for( int i = 0; i < words.length; i++)
        {
            String word = words[i];

            char letter = words[i].charAt(0);

            String Letter = letter + "";

            if( map.containsKey(Letter))
                break;

            for( int g = 0; g < words.length; g++)
            {

                if( g != i)
                {
                    if( letter == words[g].charAt(0)) {

                        word = word + words[g] ;
                    }
                }

            }

            map.put(Letter, word);
        }

        return map;
    }

    public static void frequency()
    {
        HashMap<String, Integer> map = new HashMap<>();

        try {
            Scanner input = new Scanner(new File("C:\\Users\\georg\\OneDrive\\Desktop\\AP CompSci\\Lab10-MorseCode\\" +"dream.txt"));

            while( input.hasNextLine())
            {
                String word = input.next();
                word = word.toLowerCase(Locale.ROOT);
                word = word.replaceAll("\\p{P}", "");
                if( ! map.containsKey(word))
                {
                    map.put( word, 1);
                }
                else if( map.containsKey(word))
                {
                    map.put(word, map.get(word) +1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int max = Collections.max(map.values());

        for( String key: map.keySet())
        {
            if( map.get(key) == max)
                System.out.println("Highest frequency word: " + key + ", " + max);
        }
    }

}
