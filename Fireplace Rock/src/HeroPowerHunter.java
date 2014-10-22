
public class HeroPowerHunter extends CardHeroPower {
	public HeroPowerHunter (Hero cardHolder)
	{
		super(cardHolder);
		effectGiven = new EffectDamage(2);
		cardName = "Steady Shot";
		cardText = "Deal two damage to enemy hero.";
	}
	public void playCard()
	{
		cardHolder.enemyBoard.hero.giveBasicEffect(effectGiven);
	}
	
}
