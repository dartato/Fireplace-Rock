
public class MinionGurubashiBeserker extends Minion
{
    
    public MinionGurubashiBeserker()
    {
        baseHealth = 7;
        baseAttack = 2;
        maxHealth = 7;
        currentHealth = 7;
        currentAttack = 2;
        isDead = false;
        hasTaunt = false;
        minionName = "Gurubashi Beserker";
        activeEffects.add(new RecurringEffectGurubashi(this));
    }


}
