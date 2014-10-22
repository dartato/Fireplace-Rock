
public class RecurringEffectRemoveAttackAtEndOfTurn extends RecurringEffect{
	boolean triggeredYet;
	int amount;
	public RecurringEffectRemoveAttackAtEndOfTurn(Minion minionEffected, int amount) {
		super(minionEffected);
		this.amount = amount;
	}
	boolean activatesAtEndOfTurn()
	{
		return true;
	}
	BasicEffect effectGiven(BasicEffect activatorEffect)
	{
		if (!triggeredYet)
		{
			triggeredYet = true;
			return new EffectGiveAttack(-amount);
		} else {
			return new EffectNothing();
		}
		
	}
}
