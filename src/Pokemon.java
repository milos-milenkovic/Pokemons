public class Pokemon {
  private long id;
  private String name;
  private long height;
  private long weight;

  public Pokemon(long id, String name, long height, long weight) {
    this.id = id;
    this.name = name;
    this.height = height;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return this.name.substring(0, 1).toUpperCase() + this.name.substring(1) +
           " has an id of " + this.id + "\n" +
           "and is " + this.height + " decimeters tall" + "\n" +
           "and weighs " + this.weight + " hectograms.";
  }

}
