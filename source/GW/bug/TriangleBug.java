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

import java.awt.Color;

/**
 * A <code>RandomBug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class TriangleBug extends Bug
{
  private int sideLength;
  private static int[] turns = 
  {
    1, 2, 1
  };
  private int index = 0;
  /**
   * Constructs a red bug.
   */
  public TriangleBug(int sideLength)
  {
    this(sideLength, Color.RED);
  }
  /**
   * Constructs a bug of a given color.
   * @param color the color for this bug
   */
  public TriangleBug(int sideLength, Color color)
  {
    super(color);
    this.sideLength = sideLength;
  }
  public void act()
  {
    if(canMove())
    {
      move();
    }
    else
    {
      for(int jndex = 0; jndex < TriangleBug.turns[index]; jndex++)
      {
        turn();
      }
      index++;
      index %= 3;
    }
  }
 }