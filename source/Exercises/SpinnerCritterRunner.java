// A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.actor.ActorWorld;

public class SpinnerCritterRunner
{
  public static void main(String[] args)
  {
    ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(8,8));
    world.add(new Location(6, 6), new SpinnerCritter());
    Actor dude = new Actor();
    dude.setColor(Color.RED);
    world.add(new Location(7,6), dude);
    dude = new Actor();
    dude.setColor(Color.GREEN);
    world.add(new Location(6,5), dude);
    dude = new Actor();
    dude.setColor(Color.YELLOW);  
    world.add(new Location(5,6), dude);
    dude = new Actor();
    dude.setColor(Color.BLACK);
    world.add(new Location(6,7), dude);   
    world.add(new Location(4, 6), new Rock());  
    world.show(); 
  }
}