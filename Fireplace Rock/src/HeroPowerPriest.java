
public class HeroPowerPriest extends CardHeroPower {
	public HeroPowerPriest(Hero cardHolder)
	{
		super(cardHolder);
		effectGiven = new EffectHeal(2);
		cardName = "Lesser Heal";
		cardText = "Restore two health.";
		targeted = true;
	}
}
