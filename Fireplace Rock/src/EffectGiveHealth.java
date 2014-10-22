
public class EffectGiveHealth extends BasicEffect
{
    /**
     * Heals a minion for an amount
     */
    private int healthAmount;
    public EffectGiveHealth(int healthAmount)
    {
        // remember how much health to grant
        this.healthAmount = healthAmount;
        effectDescription = "Grants health to a minion.";
    }

    /**
     * Heals a minion
     */
    public void runEffect(Minion minion)
    {
        // Health it!
        minion.currentHealth += this.healthAmount;
        minion.maxHealth += this.healthAmount;
    }
}
