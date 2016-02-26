package Hangman_Package;


import java.util.Random;

/**
 * Created by gage heinrich on 4/15/14.
 */
public class set_up {



    private String  tempArray;
    private char [] blankArray = {'_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_',};
    private char [] letters;
    private char [] guessedletters = {'_','_','_','_','_','_','_','_','_','_','_','_','_','_','_','_',};
    private char [] arrayChar;
    private char [] arrayCharCheck;
    Random rand;


    public void chooseWord(String [] array){

        rand = new Random();

        // lets choose a word from our list

        //use the temp array to put string in from our wordsarray of string type
        tempArray = array[rand.nextInt(array.length)];
        arrayCharCheck = tempArray.toCharArray();
        letters = tempArray.toCharArray();
        arrayChar = tempArray.toCharArray();

        // this will set the arrays we will use to blank for initialization
        for (int i = 0; i <arrayChar.length; i++)
        {
            arrayCharCheck[i]=blankArray[i];
            letters[i] = blankArray[i];
        }

    }

    // this function compares arrayChar with the word we have put into it with the letters passed through
    // the perameter of the function.
    public void checkWord(char c){

        char letter = '-';
        int temp = 0;
        for (int i =0; i < arrayChar.length;i++){

            if(arrayChar[i] == c)
               letters[i] = c;

           System.out.print("" + "yes it went in to the function");
        }

    }


}
