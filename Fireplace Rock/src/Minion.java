import java.util.*;
public class Minion
{
    //Standard minion class, base is essentially a nifty li'l wisp!
    static int baseHealth = 1;
    static int baseAttack = 1;
    int currentHealth = 1;
    int currentAttack = 1;
    int maxHealth = 1;
    boolean hasTaunt, isDead, canAttack, hasAwoken;
    String minionName;
    ArrayList<RecurringEffect> activeEffects = new ArrayList<RecurringEffect>();
    // IMPORTANT! Define class of minion here
    static final int MINION = 0;
    static final int MURLOC = 1;
    static final int PIRATE = 2;
    static final int DRAGON = 3;
    static final int BEAST = 4;
    static final int TOTEM = 5;
    static final int GIANT = 6;
    static final int DEMON = 7;
    static final int HERO = -1;
    static int minionClass;
    
    
    public Minion()
    {
        minionName = "I'm a Cheater!";
        // Now put the minion to sleep this turn
        activeEffects.add(new RecurringEffectAsleep(this));
        canAttack = true;
    }

    //Stuff to find out what exactly this minion is
    /**
     * Method used to find out how much attack a minion has.
     * @return Integer for current attack value
     */
    public int getAttackDamage() 
    {
        return this.currentAttack;
    }
    
    /**
     * Method used to find out how much health a minion has.
     *
     * @return Integer for current health
     */
    public int getHealth()
    //Returns total current healht of this minion
    {
        return this.currentHealth;
    }
    
    public void giveBasicEffect(BasicEffect effectGiven)
    {
        ArrayList<BasicEffect> finalEffects = new ArrayList<BasicEffect>();
        finalEffects.add(effectGiven);
        for (int i=0; i<activeEffects.size(); i++) {
            finalEffects.add(activeEffects.get(i).effectGiven(effectGiven));
        }
        for (int i=0; i<finalEffects.size(); i++) {
            finalEffects.get(i).runEffect(this);
        }
    }
    public void sendEvent(Event event)
    {
        for (int i=0; i<activeEffects.size();i++)
        {
            if (event.type == Event.ALLIED_MINION_DEATH && activeEffects.get(i).activatesOnAlliedDeath())
            {
                giveBasicEffect(activeEffects.get(i).effectGiven());
            }
            if (event.type == Event.ALLIED_DAMAGE_TAKEN && activeEffects.get(i).activatesOnAlliedDamage())
            {
                giveBasicEffect(activeEffects.get(i).effectGiven());
            }
            if (event.type == Event.TURN_END && activeEffects.get(i).activatesAtEndOfTurn())
            {
                giveBasicEffect(activeEffects.get(i).effectGiven());
            }
            if (event.type == Event.TURN_START && activeEffects.get(i).activatesAtBeginningOfTurn())
            {
                giveBasicEffect(activeEffects.get(i).effectGiven());
            }
            if (event.type == Event.ALLIED_MINION_HEALED && activeEffects.get(i).activatesOnAlliedHeal())
            {
                giveBasicEffect(activeEffects.get(i).effectGiven());
            }
        }
    }
}