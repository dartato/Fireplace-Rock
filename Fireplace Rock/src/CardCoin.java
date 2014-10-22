
public class CardCoin extends CardSpell {
	
	public CardCoin(Hero cardHolder)
	{
		super(cardHolder);
		cardText = "(Spell) Gives one mana crystal this turn";
		manaCost = 0;
		effectGiven = new EffectGiveMana(1);
	}
	public void playCard()
	{
		this.cardHolder.giveBasicEffect(effectGiven);
	}
}
