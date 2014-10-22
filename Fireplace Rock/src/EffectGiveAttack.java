
public class EffectGiveAttack extends BasicEffect
{
    /**
     * Grants a minion an amount of attack
     */
    private int attackAmount;
    public EffectGiveAttack(int attackAmount)
    {
        // remember how much health to grant
        this.attackAmount = attackAmount;
        effectDescription = "Grants attack to a minion.";
    }

    /**
     * Grants a minion attackAmount attack damage
     */
    public void runEffect(Minion minion)
    {
        // Buff it!
        minion.currentAttack += this.attackAmount;
    }
}
