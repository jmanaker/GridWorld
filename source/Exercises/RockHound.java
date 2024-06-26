import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class RockHound extends Critter
{
  public void processActors(ArrayList<Actor> quarries)
  {
    for(Actor quarry : quarries)
    {
      if(quarry instanceof Rock)
      {
        quarry.removeSelfFromGrid();
      }
    }
  }
  public static void main(String[] args)
  {
    ActorWorld world = new ActorWorld();
    world.add(new Location(7, 8), new Rock());
    world.add(new Location(3, 3), new Rock());
    world.add(new Location(2, 8), new Rock(Color.BLUE));
    world.add(new Location(5, 5), new Rock(Color.PINK));
    world.add(new Location(1, 5), new Rock(Color.RED));
    world.add(new Location(7, 2), new Rock(Color.YELLOW));
    world.add(new Location(4, 4), new RockHound());
    world.add(new Location(5, 8), new RockHound());
    world.show();
  }
}