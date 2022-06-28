public class Main
{
    public static void main(String[] args)
    {
        TicTacToe joe = new TicTacToe();
        joe.makeField();
        joe.printField();
        // joe.getTile();
        // joe.getTile();
        // System.out.println();
        // joe.pointToPoint(5, 1, 3, 1); //ba
        // joe.pointToPoint(4, 6, 7, 6); //ca
        joe.pointToPoint(6, 4, 6, 7); //ab
        joe.pointToPoint(1, 5, 1, 3); //ac
        joe.pointToPoint(5, 8, 9, 4); //cc
        joe.pointToPoint(9, 8, 5, 4); //bc
        joe.printField();
    }
}
