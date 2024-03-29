import java.util.Arrays;
import java.util.List;

public class BattleShip
{
    int GRIDSIZE = 7;
    Grid shipsA = new Grid(GRIDSIZE, GRIDSIZE);    
    Grid shipsB = new Grid(GRIDSIZE, GRIDSIZE);
    int[][] shipPosA;
    int[][] shipPosB;

    public BattleShip()
    {
        shipPosA = new int[5][];
    }

    //TODO TEST THIS
    public void makeBotShips()
    {
        int[] ships = {2, 3, 3, 4, 5};
        for(int i = 0; i < 5; i++)
        {
            Boolean inUse = true;
            while(inUse == true)
            {
                //just testing one direction w/random
                Grid faker = new Grid(7, 7);
                int shipLength = ships[i];
                int[] chars;
                chars = new int[shipLength];
                for(int j = 0; j < shipLength; j++)
                {
                    chars[j] = 1;
                }
                int[] start = {faker.random(1, 8), faker.random(1, 8)};
                int[] stop = {start[0]+shipLength, start[1]+shipLength};
                int[][] test = faker.setSpaces(start, stop, chars);
                inUse = false;
                
                for(int k = 0; k < test.length; k++)
                {
                    List<int[]> posList = Arrays.asList(shipPosB);
                    if(posList.contains(test[i]))
                    {
                        inUse = true;
                    }
                }
            }
        }
    }

    public void makePlayerShips()
    {

    }

    public void printShips()
    {
        shipsA.printGrid(true);
        shipsB.printGrid(false);
    }   
}