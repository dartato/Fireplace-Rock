
public class RecurringEffect
{
    //This applies a regular effect, but it is persistent
    //NOTE: This can't affect minions directly, but it can apply a one time basic effect
    String effectDescription;
    Minion minionEffected;
    public RecurringEffect(Minion minionEffected)
    {
        // initialise instance variables
        effectDescription = "This is a modifier to a minion";
        this.minionEffected = minionEffected;
    }
        //Now, the fun part, testing when this actually does something.
    boolean activatesOnAttack()
    {
        return false;
    }
    boolean activatesOnDeath()
    {
        return false;
    }
    boolean activatesOnAlliedDeath()
    {
        return false;
    }
    boolean activatesOnDamageTaken()
    {
        return false;
    }
    boolean activatesOnAlliedDamage()
    {
        return false;
    }
    boolean activatesAtEndOfTurn()
    {
        return false;
    }
    boolean activatesAtBeginningOfTurn()
    {
        return false;
    }
    boolean activatesAlways()
    {
        return false;
    }
    boolean activatesOnAttacked()
    {
        return false;
    }
    boolean activatesOnHeal()
    {
        return false;
    }
    boolean activatesOnAlliedHeal()
    {
        return true;
    }
    BasicEffect effectGiven(BasicEffect activatorEffect)
    {
        return new EffectNothing();
    }
    BasicEffect effectGiven()
    {
        return new EffectNothing();
    }
}
