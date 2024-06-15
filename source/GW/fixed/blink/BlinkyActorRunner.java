package GW.fixed.blink;

import java.awt.Color;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;

/**
 * This class tests the {@link BlinkyActor} class.  
 */
public class BlinkyActorRunner
{
  /**
   * Creates two new BlinkyActors using the default constructor, two orange BlinkyActors, and places them all in the grid.
   * @param args an unused parameter
   */
  public static void main(String[] args)
  {
    ActorWorld world = new ActorWorld();
    world.add(new Location(1, 1), new BlinkyActor());
    world.add(new Location(4, 2), new BlinkyActor(Color.ORANGE));
    world.add(new Location(6, 4), new BlinkyActor());
    world.add(new Location(2, 9), new BlinkyActor(Color.ORANGE));
    world.show(); 
  }
}