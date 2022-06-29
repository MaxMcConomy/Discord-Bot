import java.lang.Math;
import java.util.Scanner;
public class TicTacToe 
{
    //TODO can i verify the word with just the start and end?
    int wordNum;
    String[][] field = new String[12][12];
    String[][] wordPoints;
    Scanner in = new Scanner(System.in);

    String[][] words = 
    {
        //Three Letter Words
        {"ink", "aid", "bad", "cat", "dog", "eat", "fig", "god", "hat", "jug", "kit", "let", "may", "net", "our", "pet", "rub", "sit", "tag", "urn", "van", "war", "yes", "zip"},
        //Four Letter Words
        {"Area", "Army", "Baby", "Back", "Ball", "Band", "Bank", "Base", "Bill", "Body", "Book", "Call","Card", "Care", "Case", "Cash", "City", "Club", "Cost", "Date", "Deal", "Door", "Duty", "East", "Edge","Face", "Fact", "Farm", "Fear", "File", "Film", "Fire", "Firm", "Fish", "Food", "Foot", "Form", "Fund", "Game", "Girl", "Goal","Gold", "Hair", "Half", "Hall", "Hand", "Head", "Help", "Hill",
        "Home", "Hope", "Hour", "Idea", "Jack", "John", "Kind", "King", "Lack", "Lady", "Land", "Life", "Line", "List", "Look", "Lord", "Loss", "Love", "Mark", "Mary", "Mind", "Miss", "Move", "Name", "Need", "News", "Note", "Page", "Pain", "Pair", "Park", "Part", "Past", "Path", "Paul", "Plan", "Play", "Post", "Race", "Rain", "Rate", "Rest", "Rise", "Risk", "Road", "Rock", "Role", "Room", "Rule", "Sale", "Seat", "Shop", 
        "Show", "Side", "Sign", "Site", "Size", "Skin", "Sort", "Star", "Step", "Task", "Team", "Term", "Test", "Text", "Time", "Tour", "Town", "Tree", "Turn", "Type", "Unit", "User", "View", "Wall", "Week", "West", "Wife", "Will", "Wind", "Wine", "Wood", "Word", "Work", "Year"
        }
    };
    
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
        this.wordPoints = new String[wordNum][4];
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
    
    // int wordLength = (int) ((Math.random() * (2 - 1)) + 1);    
    public void generateWord()
    {
        int wordLength = (int) ((Math.random() * (2 - 0)) + 0);    
        String word = words[wordLength][(int) ((Math.random() * (words[wordLength].length - 1)) + 1)];
        int[] values = new int[word.length()];
        System.out.println(word);
        for(int i = 0; i < word.length(); i++)
        {
            char letter = word.toLowerCase().charAt(i);
            values[i] = ((int) letter)-97;
            // System.out.println(characters[((int) letter)-97]);
            // field[x][5] = "\u001B[41m" + characters[((int) letter)-97] + "\u001B[0m";
        }
        pointToPoint(2, 7, 2+word.length()-1, 7-word.length()+1, values);
        
        // System.out.println
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

    public void pointToPoint(int xa, int ya, int xb, int yb, int[] values)
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
        else if(ya < yb)
        {
            //change in y = down
            direction += "b";
        }
        else if(ya > yb)
        {
            //change in y = up
            direction += "c";
        }
        
        int j;
        int k = 0;
        switch(direction)
        {
            case "aa":
                //No movement
                System.out.println("That doesn't go anywhere!");
                break;
            case "ab":
                //only down
                for(int i = ya; i <= yb; i++)
                {
                    field[i][xa] = "\u001B[41m" + characters[values[k]] + "\u001B[0m";
                    k++;
                }
                break;
            case "ac":
                //only up
                for(int i = ya; i >= yb; i--)
                {
                    field[i][xa] = "\u001B[41m" + characters[values[k]] + "\u001B[0m";
                    k++;
                }
                break;
            case "ba":
                //only left
                for(int i = xa; i >= xb; i--)
                {
                    field[ya][i] = "\u001B[42m" + characters[values[k]] + "\u001B[0m";
                    k++;
                }
                break;
            case "bb":
                //left and down
                j = xa;
                for(int i = ya; i <= yb; i++)
                {
                    field[i][j] = "\u001B[43m" + characters[values[k]] + "\u001B[0m";
                    j--;
                    k++;
                }
                break;
            case "bc":
                //left and up
                j = xa;
                for(int i = ya; i >= yb; i--)
                {
                    field[i][j] = "\u001B[44m" + characters[values[k]] + "\u001B[0m";
                    j--;
                    k++;
                }
                break;
            case "ca":
                //only right
                for(int i = xa; i <= xb; i++)
                {
                    field[ya][i] = "\u001B[45m" + characters[values[k]] + "\u001B[0m";
                    k++;
                }
                break;
            case "cb":
                //right and down
                j = xa;
                for(int i = ya; i <= yb; i++)
                {
                    field[i][j] = "\u001B[46m" + characters[values[k]] + "\u001B[0m";
                    j++;
                    k++;
                }
                break;
            case "cc":
                //right and up
                j = xa;
                for(int i = ya; i >= yb; i--)
                {
                    field[i][j] = "\u001B[47m" + characters[values[k]] + "\u001B[0m";
                    j++;
                    k++;
                }
                break;
            default:
                //something went wrong
                break;

        }
    }

    public void getTile()
    {
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
