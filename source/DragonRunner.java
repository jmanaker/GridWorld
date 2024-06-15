import GW.bug.droppings.RockDroppingActor;
import info.gridworld.actor.*;
import info.gridworld.grid.BoundedGrid;

//See Dragon class for more info
public class DragonRunner
{
  public static void main(String[] args)
  {
    Critter.DRJAVA[0] = true;
    
    ActorWorld tickles = new ActorWorld(new BoundedGrid<Actor>(25, 25));
    tickles.add(new Bug());
    tickles.add(new Bug());
    tickles.add(new Bug());
    tickles.add(new Bug());
    tickles.add(new Bug());
    tickles.add(new RockDroppingActor());
    tickles.add(new RockDroppingActor());
    tickles.add(new RockDroppingActor());
    tickles.add(new RockDroppingActor());
    tickles.add(new RockDroppingActor());
    tickles.add(new Dragon());
    tickles.add(new Dragon());
    tickles.add(new Critter(Rock.class, Dragon.class));
    tickles.add(new Critter(Rock.class, Dragon.class));
    tickles.show();
  }
}