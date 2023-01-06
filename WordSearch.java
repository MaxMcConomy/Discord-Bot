import java.util.Scanner;
public class WordSearch 
{
    int wordNum;
    String[] boardWords;
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

    WordSearch()
    {
        System.out.println("How many words(>5)?");
        // int w = 1;
        int w = in.nextInt();
        while(w > 5)
        {
            System.out.println("Less than 5 words");
            w = in.nextInt();
        }
        wordNum = w;
    }
}
