import java.lang.Math;
import java.util.Scanner;
public class TicTacToe 
{
    //TODO can i verify the word with just the start and end?
    //TODO add a return method to pointToPoint to return all the points a thing has
    int wordNum;
    int feildSize = 12;
    int gridSize = feildSize-1;
    String[] boardWords;
    String[][] field = new String[12][12];
    String[][] wordPoints;
    Scanner in = new Scanner(System.in);

    String[][] words = 
    {
        //Three Letter Words
        {"ink", "aid", "bad", "cat", "dog", "eat", "fig", "god", "hat", "jug", "kit", "let", "may", "net", "our", "pet", "rub", "sit", "tag", "urn", "van", "war", "yes", "zip"},
        //Four Letter Words
        {
        "Area", "Army", "Baby", "Back", "Ball", "Band", "Bank", "Base", "Bill", "Body", "Book", "Call","Card", "Care", "Case", "Cash", "City", "Club", "Cost", "Date", "Deal", "Door", "Duty", "East", "Edge","Face", "Fact", "Farm", "Fear", "File", "Film", "Fire", "Firm", "Fish", "Food", "Foot", "Form", "Fund", "Game", "Girl", "Goal","Gold", "Hair", "Half", "Hall", "Hand", "Head", "Help", "Hill",
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
        System.out.println("How many words(>5)?");
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

    public int random(int min, int max)
    {
        int num;
        num = (int)((Math.random()*(max - min)) + min);
        return num;
    }
    
    public void makeField()
    {
        for(int i = 0; i < feildSize; i++)
        {
            for(int f = 0; f < feildSize; f++)
            {
                field[i][f] = characters[random(0, 25)]+" ";
            }
        }
        field[0][0] = "---";
        for(int i = 1; i < 12; i++)
        {
            field[i][0] = "\u001B[45m" + numbers[i-1] + " " + "\u001B[0m";
        }
        for(int j = 1; j < 12; j++)
        {
            field[0][j] = "\u001B[45m" + numbers[j-1] + " " + "\u001B[0m";
        }
        for(int i = 0; i < wordNum; i++)
        {
            generateWord();
        }
    }
    
    public void generateWord()
    {
        //generates 1 or 0
        int wordLength = (random(0, 2));    
        //picks a word from words[][] using the wordlength int to pick from the 2D list then grabs a word based off a random number
        String word = words[wordLength][random(1, words[wordLength].length)];
        //makes a list the size of the word
        //makes list of letter ints to 
        int[] values = new int[word.length()];
        System.out.println(word);
        //turns the word into a list of nums to call from the letters list
        for(int i = 0; i < word.length(); i++)
        {
            char letter = word.toLowerCase().charAt(i);
            values[i] = ((int) letter)-97;
            
            // System.out.println(characters[((int) letter)-97]);
            // field[x][5] = "\u001B[41m" + characters[((int) letter)-97] + "\u001B[0m";
        }
        // System.out.println(values);
        int startX = random(1, gridSize);
        int startY = random(1, gridSize); 
        // pointToPoint(startX, startY, startX+word.length()-1, startY-word.length()+1, values);
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
        int[][] points;
        String direction = "";
        if(xa == xb)
        {
            //change in x = void
            direction = "v";
        }
        else if(xa > xb)
        {
            //change in x = west
            direction = "w";
        }
        else if(xa < xb)
        {
            //change in x = east
            direction = "e"; 
        }

        if(ya == yb)
        {
            //change in y = void
            direction += "v";
        }
        else if(ya < yb)
        {
            //change in y = south
            direction += "s";
        }
        else if(ya > yb)
        {
            //change in y = north
            direction += "n";
        }
        
        int j;
        int k = 0;
        switch(direction)
        {
            case "vv":
                //No movement
                // points = new int[1];
                System.out.println("That doesn't go anywhere!");
                break;
            case "vs":
                //only down
                for(int i = ya; i <= yb; i++)
                {
                    field[i][xa] = "\u001B[41m" + characters[values[k]] + "\u001B[0m";
                    k++;
                }
                break;
            case "vn":
                //only up
                for(int i = ya; i >= yb; i--)
                {
                    field[i][xa] = "\u001B[41m" + characters[values[k]] + "\u001B[0m";
                    k++;
                }
                break;
            case "wv":
                //only left
                for(int i = xa; i >= xb; i--)
                {
                    field[ya][i] = "\u001B[42m" + characters[values[k]] + "\u001B[0m";
                    k++;
                }
                break;
            case "ws":
                //left and down
                j = xa;
                for(int i = ya; i <= yb; i++)
                {
                    field[i][j] = "\u001B[43m" + characters[values[k]] + "\u001B[0m";
                    j--;
                    k++;
                }
                break;
            case "wn":
                //left and up
                j = xa;
                for(int i = ya; i >= yb; i--)
                {
                    field[i][j] = "\u001B[44m" + characters[values[k]] + "\u001B[0m";
                    j--;
                    k++;
                }
                break;
            case "ev":
                //only right
                for(int i = xa; i <= xb; i++)
                {
                    field[ya][i] = "\u001B[45m" + characters[values[k]] + "\u001B[0m";
                    k++;
                }
                break;
            case "es":
                //right and down
                j = xa;
                for(int i = ya; i <= yb; i++)
                {
                    field[i][j] = "\u001B[46m" + characters[values[k]] + "\u001B[0m";
                    j++;
                    k++;
                }
                break;
            case "en":
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
