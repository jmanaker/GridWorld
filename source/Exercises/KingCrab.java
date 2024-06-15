import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class KingCrab extends CrabCritter
{
  public void processActors(ArrayList<Actor> actors)
  {
    Location home = this.getLocation();
    Grid<Actor> manifold = this.getGrid();
    for(Actor actor : actors)
    {
      Location vacation = actor.getLocation();
      vacation = vacation.getAdjacentLocation(vacation.getDirectionToward(home));
      if(manifold.isValid(vacation) && manifold.get(vacation) == null)
      {
        actor.moveTo(vacation);
      }
      else
      {
        actor.removeSelfFromGrid();
      }
    }
  }
}