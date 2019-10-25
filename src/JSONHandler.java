import java.util.Dictionary;
import java.util.Hashtable;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;

public class JSONHandler {

  public Dictionary<String,Object> parsePokemonDetails(String response) {

    Dictionary<String,Object> pokemonDetails = new Hashtable<String,Object>();

    // parsing JSON response
    Object obj = null;
    try {
      obj = new JSONParser().parse(response);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    // typecasting obj to JSONObject
    JSONObject jo = (JSONObject) obj;

    // getting id, name, height and weight
    long id = (long) jo.get("id");
    String name = (String) jo.get("name");
    long height = (long) jo.get("height");
    long weight = (long) jo.get("weight");

    // add id, name, height and weight to dictionary
    pokemonDetails.put("id", id);
    pokemonDetails.put("name", name);
    pokemonDetails.put("height", height);
    pokemonDetails.put("weight", weight);

    return pokemonDetails;
  }
}
