
public class EffectHeal extends BasicEffect
{
    /**
     * Heals a minion for an amount
     */
    private int healAmount;
    public EffectHeal(int healAmount)
    {
        // remember how much damage to deal
        this.healAmount = healAmount;
        effectDescription = "Heals.";
    }

    /**
     * Heals a minion
     */
    public void runEffect(Minion minion)
    {
        // Heal it!
        minion.currentHealth += this.healAmount;
        if (minion.currentHealth > minion.maxHealth)
        {
            minion.currentHealth = minion.maxHealth;
        }
    }
}
