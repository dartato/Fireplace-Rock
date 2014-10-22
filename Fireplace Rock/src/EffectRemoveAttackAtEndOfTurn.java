
public class EffectRemoveAttackAtEndOfTurn extends BasicEffect {
	int amount;
    public EffectRemoveAttackAtEndOfTurn(int amount)
    {
        effectDescription = "This will lose "+amount+" attack at the end of the turn";
        this.amount = amount;
    }
    public void runEffect(Minion minion)
    {
    	minion.activeEffects.add(new RecurringEffectRemoveAttackAtEndOfTurn(minion, amount));
    }

}
