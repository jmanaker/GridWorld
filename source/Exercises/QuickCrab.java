import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter
{
  public ArrayList<Location> getLocationsInDirections(int[] directions)
  {
    ArrayList<Location> locs = new ArrayList<Location>();
    Grid<Actor> gr = getGrid();
    Location loc = getLocation();
    for (int d : directions)
    {
      int nD = this.getDirection() + d;
      Location nLoc = loc.getAdjacentLocation(nD).getAdjacentLocation(nD);
      if (gr.isValid(nLoc))
      {
        locs.add(nLoc);
      }
    }
    return locs;
  }
  public static void main(String[] args)
  {
    ActorWorld world = new ActorWorld();
    world.add(new Location(7, 5), new Rock());
    world.add(new Location(5, 4), new Rock());
    world.add(new Location(5, 7), new Rock());
    world.add(new Location(7, 3), new Rock());
    world.add(new Location(7, 8), new Flower());
    world.add(new Location(2, 2), new Flower());
    world.add(new Location(3, 5), new Flower());
    world.add(new Location(3, 8), new Flower());
    world.add(new Location(6, 5), new Bug());
    world.add(new Location(5, 3), new Bug());
    world.add(new Location(4, 5), new QuickCrab());
    world.add(new Location(6, 1), new QuickCrab());
    world.add(new Location(7, 4), new QuickCrab());
    world.show();
  }
}