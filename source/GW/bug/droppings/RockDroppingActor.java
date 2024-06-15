//? A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

package GW.bug.droppings;

import java.awt.Color;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class RockDroppingActor extends Bug
{
  public RockDroppingActor()
  {
  }
  public RockDroppingActor(Color newColor)
  {
    this.setColor(newColor);
  }
  public RockDroppingActor(int direction)
  {
    this.setDirection(direction);
  }
  public RockDroppingActor(Color newColor, int direction)
  {
    this.setColor(newColor);
    this.setDirection(direction);
  }
  public void act()
  {
    Location old = this.getLocation();
    super.act();
    if(this.getLocation() != old)
    {
      new Rock().putSelfInGrid(this.getGrid(), old);
    }
  }
}