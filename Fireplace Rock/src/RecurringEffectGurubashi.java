
public class RecurringEffectGurubashi extends RecurringEffect
{
    /**
     * Recurring effect describing a gurubashi's passive (+3 Attack every time it takes damage)
     */
    
    public RecurringEffectGurubashi(Minion minionEffected)
    {
        // Card text
		super(minionEffected);
        effectDescription = "Every time this minion takes damage, give it +3 attack";
    }
    
    public boolean activatesOnDamageTaken()
    {
        return true;
    }
    /**
     * Gives a minion the effect to grant it +3 Attack
     */
    public BasicEffect effectGiven(BasicEffect activatorEffect)
    {
        if (activatorEffect.doesDamage)
        {
            return new EffectGiveAttack(3);
        } else {
            return new EffectNothing();
        }
    }
}
