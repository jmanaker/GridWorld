package GW.fixed.spin;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

/**
 * An actor that spins.  
 */
public class SpinningActor extends Actor
{
  /**
   * Spins this actor once.
   */
  public void act()
  {
    this.turn();
  }
  /**
   * Rotates this actor &pi;/4 radians clockwise.
   */
  public void turn()
  {
      setDirection(getDirection() + Location.HALF_RIGHT);
  }
}