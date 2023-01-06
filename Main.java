public class Main
{
    public static void main(String[] args)
    {
        System.out.println(5 > 5);
        Grid field = new Grid(10, 10);
        field.printGrid();
        int[] start = {5, 5};
        int[] word = {1, 0, 11, 11, 18};
        int[] stop = {6, 4};
        int[] test = {10,10};
        field.setSpace(test, 22);
        field.setSpaces(start, stop, word);
        // int[] stop1 = {0, 5};
        // field.setSpaces(start, stop1, word);
        // int[] stop2 = {5, 10};
        // field.setSpaces(start, stop2, word);
        // int[] stop3 = {10, 5};
        // field.setSpaces(start, stop3, word);
        field.printGrid();
    }
}
