
public class RecurringEffectAsleep extends RecurringEffect {
	public RecurringEffectAsleep (Minion minionEffected)
	{
		super(minionEffected);
		this.minionEffected = minionEffected;
	}
	public boolean activatesAtBeginningOfTurn()
	{
		return true;
	}
	public BasicEffect effectGiven()
	{
		return new EffectWake();
	}
}
