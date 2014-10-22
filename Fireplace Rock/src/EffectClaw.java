
public class EffectClaw extends BasicEffect {
	int attackAmount, armorAmount;
	public EffectClaw(int attackAmount, int armorAmount)
	{
		this.attackAmount = attackAmount;
		this.armorAmount = armorAmount;
	}
	public void runEffect(Hero hero)
	{
		hero.giveBasicEffect(new EffectGiveAttack(attackAmount));
		hero.heroArmor.addArmor(armorAmount);
		hero.giveBasicEffect(new EffectRemoveAttackAtEndOfTurn(attackAmount));
	}
}
