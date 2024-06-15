package GW.fixed.spin;

import info.gridworld.actor.ActorWorld;

/**
 * This class tests the {@link SpinningActor} class.
 */
public class SpinningActorRunner
{
  /**
   * Creates four new SpinningActors and places them in the grid.
   */
  public static void main(String[] args)
  {
    ActorWorld world = new ActorWorld();
    SpinningActor Alice = new SpinningActor(), Bingo = new SpinningActor(), Carly = new SpinningActor(), Dizzy = new SpinningActor();
    world.add(Alice);
    world.add(Bingo);
    world.add(Carly);
    world.add(Dizzy);
    world.show();
  }
}