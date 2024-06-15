import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter
{
  public ArrayList<Actor> getActors()
  {
    Grid<Actor> manifold = this.getGrid();
    int dir = this.getDirection();
    Location home = this.getLocation(), target = home.getAdjacentLocation(dir);
    ArrayList<Actor> retVal = new ArrayList<Actor>(2);
    if(manifold.isValid(target))
    {
      Actor at = manifold.get(target);
      if(at != null)
      {
        retVal.add(at);
      }
    }
    target = home.getAdjacentLocation(dir + Location.HALF_CIRCLE);
    if(manifold.isValid(target))
    {
      Actor at = manifold.get(target);
      if(at != null)
      {
        retVal.add(at);
      }
    }
    return retVal;
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
    world.add(new Location(4, 4), new ChameleonKid());
    world.add(new Location(5, 8), new ChameleonKid());
    world.show();
  }
}