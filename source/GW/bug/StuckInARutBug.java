/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

package GW.bug;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * A <code>RandomBug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class StuckInARutBug extends Bug
{
  public StuckInARutBug(Color color)
  {
    super(color);
  }
  public void turn()
  {
    this.setDirection(this.getDirection() + Location.RIGHT);
  }
}