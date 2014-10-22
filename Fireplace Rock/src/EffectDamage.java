
public class EffectDamage extends BasicEffect
{
    /**
     * Damages a minion for an amount
     */
    private int damageAmount;
    public EffectDamage(int damageAmount)
    {
        // remember how much damage to deal
        this.damageAmount = damageAmount;
        doesDamage = true;
        effectDescription = "Does damage.";
    }

    /**
     * Damages a minion
     */
    public void runEffect(Minion minion)
    {
        // Hurt it!
        minion.currentHealth -= this.damageAmount;
        if (minion.currentHealth < 1)
        {
            minion.isDead = true;
        }
    }
}
