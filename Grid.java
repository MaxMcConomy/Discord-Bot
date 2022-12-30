import java.util.stream.IntStream;

public class Grid 
{
    enum direction{
        NORTH,
        SOUTH,
        EAST,
        WEST
    }
    
    private String[] characters = // This list will be replaced with discord emotes
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
        "  ",
        "# "
    };

    private String[] numbers = // This list will be replaced with discord emotes
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

    private int xSize;
    private int ySize;
    private String[][] grid;
    
    public Grid(int x, int y)
    {
        xSize = x;
        ySize = y;
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
        System.out.print("  ");
        for(int i = 0; i < xSize; i++)
        {
            System.out.print((i+1) + " ");
        }
        System.out.println();
        for(int i = 0; i < xSize; i++)
        {
            if(i < 9){
                System.out.print((i+1) + " ");
            } else {
                System.out.print((i+1));    
            }
            for(int f = 0; f < ySize; f++)
            {
                System.out.print(grid[i][f]);
            }
            System.out.println();
        }
    }

    public void setSpace(int[] start, int[] character, direction dir)
    {
        switch(dir)
        {
            case NORTH: System.out.println("North");
                        break;
            case EAST:  System.out.println("East");
                        break;
            case SOUTH: System.out.println("South");
                        break;
            case WEST:  System.out.println("West");
                        break;
        }

    }
}