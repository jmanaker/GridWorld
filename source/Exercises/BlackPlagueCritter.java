// A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

public class BlackPlagueCritter extends Critter
{
 //processActors will turn all Actors around this critter Black
 //unless the Actor is a Rock or another BlackPlagueCritter
 public void processActors(ArrayList<Actor> dudes)
 {
   for(Actor dude : dudes)
   {
     if(!(dude instanceof Rock) && !(dude instanceof BlackPlagueCritter))
     {
       dude.setColor(Color.BLACK);
     }
   }
 }
}