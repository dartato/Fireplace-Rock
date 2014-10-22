
public class RecurringEffectArmor extends RecurringEffect {
	int armorAmount;
	public RecurringEffectArmor(Hero protectedHero)
	{
		super(protectedHero);
	}
	public boolean activatesOnDamageTaken()
	{
		return true;
	}
	public int getAmount()
	{
		return armorAmount;
	}
	public void addArmor(int amount)
	{
		armorAmount += amount;
	}
	public void removeArmor()
	{
		armorAmount = 0;
	}
	
	public BasicEffect effectGiven(BasicEffect activatorEffect)
	{
		if (activatorEffect.doesDamage)
		{
			int armorRemoved = Math.min(activatorEffect.damageAmount(), armorAmount);
			armorAmount -= armorRemoved;
			return new EffectHeal(armorRemoved);
		} else
		{
			return new EffectNothing();
		}
	}
}
