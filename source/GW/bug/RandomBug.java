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

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.lang.Math;

/**
 * A <code>RandomBug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class RandomBug extends Bug
{
  private int maxTurns;
  /**
   * Constructs a red bug.
   */
  public RandomBug(int maxTurns)
  {
    this(maxTurns, Color.RED);
  }
  /**
   * Constructs a bug of a given color.
   * @param bugColor the color for this bug
   */
  public RandomBug(int maxTurns, Color bugColor)
  {
    setColor(bugColor);
    this.maxTurns = maxTurns - 1;
  }
  public void act()
  {
    Actor buddy = this.GetBuddy();
    if(buddy == this)
    {
      this.move();
    }
    else
    {
      int length = (int)Math.round(1 + maxTurns * Math.random());
      for(int index = 0; index < length; index++)
      {
        this.turn();
      }
    }
  }
  public Actor GetBuddy()
  {
    Grid<Actor> gr = getGrid();
    if (gr == null)
    {
      return null;
    }
    Location loc = getLocation();
    Location next = loc.getAdjacentLocation(getDirection());
    if (!gr.isValid(next))
    {
      return null;
    }
    Actor neighbor = gr.get(next);
    if((neighbor == null) || (neighbor instanceof Flower))
    {
      return this;
    }
    else
    {
      return neighbor;
    }
  }
}
