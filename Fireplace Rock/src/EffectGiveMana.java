
public class EffectGiveMana extends BasicEffect {
	private int manaAmount;	
	public EffectGiveMana(int manaAmount)
	{
			this.manaAmount = manaAmount;
	}
	public void runEffect(Hero hero)
	{
		hero.currentMana+=this.manaAmount;
	}
}
