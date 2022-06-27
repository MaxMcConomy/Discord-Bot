import java.lang.Math;
import java.util.Scanner;
public class TicTacToe 
{
    int wordNum;
    String[] words;
    String[][] field = new String[12][12];
    Scanner in = new Scanner(System.in);

    String[] characters = // This list will be replaced with discord emotes
    {
        "A", //0
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
        "M",
        "N",
        "O",
        "P",
        "Q",
        "R",
        "S",
        "T",
        "U",
        "V",
        "W",
        "X",
        "Y",
        "Z", //25
        "{ ",
        "[ ",
        "  "
    };

    String[] numbers = // This list will be replaced with discord emotes
    {
        "0",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10"
    };

    TicTacToe()
    {
        System.out.println("How many words?");
        // int w = 1;
        int w = in.nextInt();
        while(w > 5)
        {
            System.out.println("Less than 5 words");
            w = in.nextInt();
        }
        this.wordNum = w;
    }

    public void makeField()
    {
        for(int i = 0; i < 12; i++)
        {
            for(int f = 0; f < 12; f++)
            {
                field[i][f] = characters[(int)((Math.random()*(25)))]+" ";
            }
        }
        field[0][0] = characters[28];
        for(int i = 1; i < 12; i++)
        {
            field[i][0] = "\u001B[45m" + numbers[i-1] + " " + "\u001B[0m";
        }
        for(int j = 1; j < 12; j++)
        {
            field[0][j] = "\u001B[45m" + numbers[j-1] + " " + "\u001B[0m";
        }
    }

    public void printField()
    {
        for(int i = 0; i < 12; i++)
        {
            for(int f = 0; f < 12; f++)
            {
                System.out.print(field[i][f]);
            }
            System.out.println();
        }
    }

    public void pointToPoint(int xa, int ya, int xb, int yb)
    {
        String direction = "";
        if(xa == xb)
        {
            //change in x = none
            direction = "a";
        }
        else if(xa > xb)
        {
            //change in x = left
            direction = "b";
        }
        else if(xa < xb)
        {
            //change in x = right
            direction = "c"; 
        }

        if(ya == yb)
        {
            //change in y = none
            direction += "a";
        }
        else if(ya > yb)
        {
            //change in y = left
            direction += "b";
        }
        else if(ya < yb)
        {
            //change in y = right
            direction += "c";
        }
        
        switch(direction)
        {
            case "aa":
                System.out.println("aa");
                break;
            case "ab":
                //
                break;
            case "ac":
                //
                break;
            case "ba":
                //
                break;
            case "bb":
                //
                break;
            // case ""
        }
    }

    public void getTile()
    {
        
        // System.out.println("Next tile? (x,y)");
        String next = "";
        while(next.indexOf(",") == -1)
        {
            System.out.println("Next tile? (x,y)");
            next = in.nextLine();
        }
        int y = Integer.parseInt(next.substring(0, next.indexOf(",")));
        int x = Integer.parseInt(next.substring(next.indexOf(",")+1));
        field[x+1][y+1] = "\u001B[41m" + characters[26]+ "\u001B[0m";
    }
}
