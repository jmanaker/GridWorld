import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class acts as population check on Critters.  
 * It behaves like a dragon--it eats rock and breathes fire at critters.  If there are so many dragons that it can eat its fill, it explodes.  
 * The modifications necessary to Critter cause Critter to FAIL TO COMPILE APPROPRIATELY IN DRJAVA.  However, it does so in NetBeans, et al.  
 * I include a public final variable DRJAVA in Critter; to use an algorithm compatible with Dr. Java (that fails with Dragon), set {@code Critter.DRJAVA[0]} to {@code true}
 */
public class Dragon extends Critter
{
//  //DEBUG PURPOSES ONLY
//  @Override
//  public void removeSelfFromGrid()
//  {
//    //Yes
//  }
  /**
   * A class representing the blaze a Dragon can start.  
   */
  static class Flames extends Actor
  {
    /**
     * The amount of fuel the blaze has consumed.
     */
    private int flames;
    /**
     * Create a new, red blaze, that has not yet consumed any of its fuel.
     */
    public Flames()
    {
      this.flames = 0;
      this.setColor(Color.RED);
    }
    /**
     * Allows a fire to keep track of time's passage; a flame object burns for a while, then stops.  
     */
    public void act()
    {
      flames++;
      if(flames > 5)
      {
        new Flower().putSelfInGrid(this.getGrid(), this.getLocation());
      }
    }
  }
  /**
   * The amount of fire a Dragon can breathe.
   */
  int flames;
  /**
   * Create a new Dragon, unable to breathe fire.  
   */
  public Dragon()
  {
    flames = 0;
  }
  /**
   * Dragons sometimes accidentally step on flowers and fires.  
   * @return all adjacent Locations that are empty or occupied by Flowers or Fires.
   */
  public ArrayList<Location> getMoveLocations()
  {
    Grid<Actor> manifold = this.getGrid();
    ArrayList<Location> temp = manifold.getValidAdjacentLocations(this.getLocation());
    Iterator<Location> igor = temp.iterator();
    while(igor.hasNext())
    {
      Actor spock = manifold.get(igor.next());
      if(spock != null && !(spock instanceof Flower) && !(spock instanceof Flames))
      {
        igor.remove();
      }
    }
    return temp;
  }
  /**
   * Examines all surrounding Actors to see if they are Critters.  If an Actor is a Critter, the Dragon shoots fire at them, calling {@code Flame}.  
   * @param actors the Actors that ostensibly surround this Dragon.  
   */
  public void processActors(ArrayList<Actor> actors)
  {
    for(Actor buddy : actors)
    {
      if(buddy instanceof Rock)
      {
        buddy.removeSelfFromGrid();
        flames++;
        if(flames > 9)
        {
          this.flame(this);
        }
        break;
      }
      //instanceof accepts inheritance (sigh?)
      if((buddy instanceof Critter) && !(buddy instanceof Dragon))
      {
        this.flame((Critter)buddy);
      }
    }
  }
  /**
   * This method replaces a Critter with a new {@code Flames} object.  
   * @param flamed the Critter the Dragon will shoot fire at.
   */
  void flame(Critter flamed)
  {
    if(flames > 0)
    {
      this.flames--;
      new Flames().putSelfInGrid(flamed.getGrid(), flamed.getLocation());
    }
  }
}