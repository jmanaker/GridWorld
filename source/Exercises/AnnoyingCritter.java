import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.*;

/**
 * A critter that chooses a friend, then chases him or her anywhere.  AnnoyingCritter is a subclass of {@link Critter} and displays as such.
 */
public class AnnoyingCritter extends Critter
{
 /* 
  * instance variables will be needed
  * one for the bFF and one to set whether this Critter has a bFF
  */
  private Actor bFF = null;
  private Random rand = new Random();
  
  public AnnoyingCritter()
  {
      super(Rock.class, Flower.class);
  }
  
 /**
  * processActors restricts this AnnoyingCritter's diet to Flower and Rock objects.  
  * Specifically, it asks each Flower and Rock object in {@code neighbors} to remove itself from a grid.
  * Furthermore, if bFF is null, it is set to a random non-{@link Rock}, non-{@link Flower}, non-{@link Actor} actor.  
  * @param neighbors the ostensibly neighboring Actors whom this AnnoyingCritter will examine for food.
  */
  public void processActors(ArrayList<Actor> neighbors)
  {
    if(bFF == null)
    {
      Grid<Actor> grid = this.getGrid();
      ArrayList<Location> guys = grid.getOccupiedLocations();
      guys.remove(this.getLocation());
      Iterator<Location> igor = guys.iterator();
      while(igor.hasNext())
      {
        Actor guy = grid.get(igor.next());
        if((guy instanceof Rock) || (guy instanceof Flower) || guy.getClass().equals(Actor.class))
        {
          igor.remove();
        }
      }
      bFF = grid.get(guys.get(rand.nextInt(guys.size())));
    }
    for(Actor neighbor : neighbors)
    {
//      if(types.contains(neighbor.getClass()))
//      {
//        neighbor.removeSelfFromGrid();
//      }
    }
  }
  
  /**
   * selectMoveLocation selects the place in {@code places} closest to its bFF.
   * @param places the places that are ostensibly empty and next to this AnnoyingCritter.
   */
  public Location selectMoveLocation(ArrayList<Location> places)
  {
    Location me = this.getLocation();
    Location target = bFF.getLocation();
    TreeMap<Double, Location> dists = new TreeMap<Double, Location>();
//    try
//    {
    places.add(me);
    for(Location place : places)
    {
      dists.put(distance(place, target), place);
    }
    return dists.firstEntry().getValue();
//    }
//    catch(Throwable e)
//    {
//      System.out.println("Here we go again...");
//      return null;
//    }
  }
  private static double distance(Location a, Location b)
  {
    return Math.sqrt(Math.pow((a.getCol() - b.getCol()), 2) + Math.pow((a.getRow() - b.getRow()), 2));
  }
}
