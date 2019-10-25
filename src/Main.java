import java.util.Dictionary;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // create a scanner so we can read the command-line input
    Scanner sc = new Scanner(System.in);
    String choice;
    // accept the choice and call the appropriate methods until the user types 3 to quit
    do {
      System.out.println();
      printMenu();
      choice = sc.nextLine();
      switch(choice){
        case "1":
          System.out.print("Enter pokémon's name: ");
          String name = sc.nextLine();
          Pokemon p = createPokemon(name);
          System.out.println(p);
          break;
        case "2":
          System.out.print("Enter location: ");
          String location = sc.nextLine();
          //l.printLocationDetails(String location)
          System.out.println();
          break;
        case "3":
          System.out.println("Bye bye!");
          break;
        default:
          System.out.println("Please enter a valid option!");
          System.out.println();
      }
    }
    while(!choice.equals("3"));
  }

  private static void printMenu() {
    System.out.println("Pick an option:");
    System.out.println("1 - Enter a name of a pokémon and get the id, name, height and weight");
    System.out.println("2 - Enter a name of a location and get all the names of the location in different languages and the name of the region it is in");
    System.out.println("3 - Quit");
    System.out.println("Your choice: ");
  }

  private static Pokemon createPokemon(String name) {
    APIHandler api = new APIHandler();
    String response = api.makeHTTPRequestPokemonDetails(name);
    JSONHandler jh = new JSONHandler();
    Dictionary<String, Object> pokemonDetails = jh.parsePokemonDetails(response);
    Pokemon p = new Pokemon((long) pokemonDetails.get("id"), (String) pokemonDetails.get("name"),
        (long) pokemonDetails.get("height"), (long) pokemonDetails.get("weight"));
    return p;
  }


}
