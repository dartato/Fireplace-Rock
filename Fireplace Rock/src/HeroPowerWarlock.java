
public class HeroPowerWarlock extends CardHeroPower {
	public HeroPowerWarlock (Hero cardHolder)
	{
		super(cardHolder);
		effectGiven = new EffectDamage(2);
		cardName = "Life tap";
		cardText = "Draw a card and take two damage.";
	}
	public void playCard()
	{
		cardHolder.giveBasicEffect(effectGiven);
		cardHolder.drawCard();
	}
}
