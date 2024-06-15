// A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import info.gridworld.grid.Grid;
import info.gridworld.actor.*;
import info.gridworld.grid.Location;

public class SpinnerCritter extends Critter
{
  //processActors will make each actor around this actor move to the left
  public void processActors(ArrayList<Actor> dudes)
  {
    for(Actor dude : dudes)
    {
      if(dude instanceof Flower)
      {
        dude.removeSelfFromGrid();
        continue;
      }
      if(dude instanceof Rock)
      {
        continue;
      }
      Location target = dude.getLocation().getAdjacentLocation(Location.WEST);
      Grid<Actor> found = dude.getGrid();
      if(!target.equals(this.getLocation()) && found.isValid(target) && found.get(target) == null)
      {
        dude.moveTo(target);
      }
    }
  }
}