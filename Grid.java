import java.lang.Math;
import java.util.ArrayList;
public class Grid
{
    enum direction{
        NORTH,
        SOUTH,
        EAST,
        WEST,
        NULL
    }
    
    private String[] characters = // This list will be replaced with discord emotes
    {
        "A ", //0
        "B ",
        "C ",
        "D ",
        "E ",
        "F ",
        "G ",
        "H ",
        "I ",
        "J ",
        "K ",
        "L ",
        "M ",
        "N ",
        "O ",
        "P ",
        "Q ",
        "R ",
        "S ",
        "T ",
        "U ",
        "V ",
        "W ",
        "X ",
        "Y ",
        "Z ", //25
        "{ ",
        "[ ",
        "  ",
        "# ",
        "==",//30
        "| "
    };

    private String[] numbers = // This list will be replaced with discord emotes
    {
        "0 ",
        "1 ",
        "2 ",
        "3 ",
        "4 ",
        "5 ",
        "6 ",
        "7 ",
        "8 ",
        "9 ",
        "10"
    };

    private int xSize;
    private int ySize;
    private String[][] grid;
    
    public Grid(int x, int y)
    {
        xSize = x;
        ySize = y;
        makeGrid();
    }

    public void makeGrid()
    {
       grid = new String[xSize][ySize];
       for(int i = 0; i < xSize; i++)
       {
            for(int k = 0; k < ySize; k++)
            {
                grid[i][k] = characters[29];
            }
       }
    }

    public void printGrid()
    {
        System.out.print("    ");
        for(int i = 0; i < xSize; i++)
        {
            System.out.print(numbers[i+1]);
        }
        System.out.println();
        System.out.print("    ");
        for(int i = 0; i < xSize; i++)
        {
            System.out.print(characters[30]);
        }
        System.out.println();
        for(int i = 0; i < xSize; i++)
        {
            
            System.out.print(numbers[i+1]);
            System.out.print(characters[31]);
            for(int f = 0; f < ySize; f++)
            {
                System.out.print(grid[i][f]);
            }
            System.out.println();
        }
    }

    /**
     * Gets the information of a tile relative to how the information is shown when printed
     * 
     * @param x The X integer
     * @param y The Y integer
     * @return The value at that tile 
    */
    public String getTile(int x, int y)
    {
        return(grid[y-1][x-1]);
    }

    public void setSpace(int[] position, int character)
    {
        grid[position[1]-1][position[0]-1] = characters[character];
    }
    
    public int[][] setSpaces(int[] start, int[] stop, int[] chars)
    {
        int distance = chars.length;
        int[][] spaces;
        spaces = new int[distance][2];
        //East
        if((start[0] < stop[0]) && (start[1] == stop[1]))
        {
            System.out.println("East");
            for(int i = 0; i < distance; i++)
            {
                int[] end = {start[0]+i, start[1]};
                spaces[i] = end;
                setSpace(end, chars[i]);
            }
        }
        //Northeast
        if((start[0] < stop[0]) && (start[1] > stop[1]))
        {
            System.out.println("Northeast");
            for(int i = 0; i < distance; i++)
            {
                int[] end = {start[0]+i, start[1]-i};
                spaces[i][0] = end[0];
                spaces[i][1] = end[1];
                setSpace(end, chars[i]);
            }
        }
        //North
        else if((start[1] > stop[1]) && (start[0] == stop[0]))
        {
            System.out.println("North");
            for(int i = 0; i < distance; i++)
            {
                int[] end = {start[0], start[1]-i};
                spaces[i][0] = end[0];
                spaces[i][1] = end[1];
                setSpace(end, chars[i]);
            }
        }
        //Northwest
        else if((start[1] > stop[1]) && (start[0] > stop[0]))
        {    
            System.out.println("Northwest");
            for(int i = 0; i < distance; i++)
            {
                int[] end = {start[0]-i, start[1]-i};
                spaces[i][0] = end[0];
                spaces[i][1] = end[1];
                setSpace(end, chars[i]);
            }
        }
        //West
        else if((start[0] > stop[0]) && (start[1] == stop[1]))
        {
            System.out.println("West");
            for(int i = 0; i < distance; i++)
            {
                int[] end = {start[0]-i, start[1]};
                spaces[i][0] = end[0];
                spaces[i][1] = end[1];
                setSpace(end, chars[i]);
            }
        }
        //Southwest
        else if((start[0] > stop[0]) && (start[1] < stop[1]))
        {
            System.out.println("Southwest");
            for(int i = 0; i < distance; i++)
            {
                int[] end = {start[0]-i, start[1]+i};
                spaces[i][0] = end[0];
                spaces[i][1] = end[1];
                setSpace(end, chars[i]);
            }
        }
        //South
        else if((start[1] < stop[1]) && (start[0] == stop[0]))
        {
            System.out.println("South");
            for(int i = 0; i < distance; i++)
            {
                int[] end = {start[0], start[1]+i};
                spaces[i][0] = end[0];
                spaces[i][1] = end[1];
                setSpace(end, chars[i]);
            }
        }
        //Southeast
        else if((start[0] < stop[0]) && (start[1] > stop[1]))
        {
            System.out.println("Southeast");
            for(int i = 0; i < distance; i++)
            {
                int[] end = {start[0]+i, start[1]+i};
                spaces[i][0] = end[0];
                spaces[i][1] = end[1];
                setSpace(end, chars[i]);
            }
        }
        return spaces;
    }

    public int random(int min, int max)
    {
        int num;
        num = (int)((Math.random()*(max - min)) + min);
        return num;
    }
}