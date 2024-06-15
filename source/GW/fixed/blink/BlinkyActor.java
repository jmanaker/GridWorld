package GW.fixed.blink;

import java.awt.Color;
import info.gridworld.actor.Actor;
import java.util.Random;

/**
 * An actor that changes color randomly.  BlinkyActor is a subclass of Actor and displays as such.
 */
public class BlinkyActor extends Actor
{
  /**
   * Creates a new, blue BlinkyActor.  
   */
  public BlinkyActor()
  {
  }
  /**
   * Creates a new BlinkyActor and sets it to a given color.
   * @param color the color to set the BlinkyActor to
   */
  public BlinkyActor(Color color)
  {
    this.setColor(color);
  }
  private Random rand = new Random();
  /**
   * Changes this BlinkyActor's color to a new, random color.
   */
  public void act()
  {
    this.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
  }
}