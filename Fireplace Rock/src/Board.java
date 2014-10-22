import java.util.*;
public class Board
{
    // It can contain minions!
    ArrayList<Minion> minionsContained;
    Hero hero;
    public Board()
    {
        // Initialize instance variables
        minionsContained = new ArrayList<Minion>();
        this.hero = new Hero();
    }
    public void assignHero(Hero hero)
    {
    	this.hero = hero;
    }
    public void add(int index, Minion minion)
    {
        minionsContained.add(index, minion);
    }
    public void add(Minion minion)
    {
        minionsContained.add(minion);
    }
    public void remove(int index)
    {
    	minionsContained.remove(index);
    }
    public Minion get(int index)
    {
    	if (index==-1)
    	{return this.hero;} else {
        return minionsContained.get(index);
    	}
    }
    public int size()
    {
        //how many minions are on the board
        return minionsContained.size();
    }
    public void sendEventToAll(Event event)
    {

        if (event.type == Event.CHECK_FOR_MINION_DEATH)
        {
            for (int i=0; i<minionsContained.size();i++)
            {
                if (minionsContained.get(i).isDead)
                	{
                		minionsContained.remove(i);
                	}
            }
        }
        for (int i=0; i<minionsContained.size();i++)
        {
            minionsContained.get(i).sendEvent(event);
        }
    }
}
