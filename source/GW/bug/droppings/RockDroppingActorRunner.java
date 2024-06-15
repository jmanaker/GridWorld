package GW.bug.droppings;

import java.awt.Color;
import java.util.Random;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;

/**
 * This class tests the {@link RockDroppingActor} class.
 */
public class RockDroppingActorRunner
{
  /**
   * Creates a new green RockDroppingActor and places it in the grid.
   * @param args an unused parameter.
   */
 public static void main(String[] args)
 {
  ActorWorld world = new ActorWorld();
  Actor angus = new RockDroppingActor(Color.GREEN, new Random().nextInt(360));
  world.add(angus);
  world.show();
 }
}