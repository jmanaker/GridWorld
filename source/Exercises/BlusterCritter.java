import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class BlusterCritter extends Critter
{
  private int c;
  public BlusterCritter(int c)
  {
    this.c = c;
  }
  private static final int[] OFFSETS = 
  {
    -2, -1, 0, 1, 2
  };
  public ArrayList<Actor> getActors()
  {
    ArrayList<Actor> retVal = new ArrayList<Actor>(24);
    Grid<Actor> manifold = this.getGrid();
    Location home = this.getLocation();
    int r = home.getRow(), c = home.getCol();
    for(int R : OFFSETS)
    {
      for(int C : OFFSETS)
      {
        Location glance = new Location(r + R, c + C);
        if(manifold.isValid(glance))
        {
          Actor recent = manifold.get(glance);
          if(recent != null)
          {
            retVal.add(recent);
          }
        }
      }
    }
    retVal.remove(this);
    return retVal;
  }
  public void processActors(ArrayList<Actor> actors)
  {
    this.setColor(actors.size() < c ? this.getColor().brighter() : this.getColor().darker());
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
    world.add(new Location(4, 4), new BlusterCritter(5));
    world.add(new Location(5, 8), new BlusterCritter(10));
    world.show();
  }
}