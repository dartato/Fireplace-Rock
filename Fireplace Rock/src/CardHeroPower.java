
public class CardHeroPower extends CardSpell {
	public CardHeroPower(Hero cardHolder)
	{
		super(cardHolder);
		manaCost = 2;
	}
    public void playCard(Minion minion)
    {
        	minion.giveBasicEffect(effectGiven);
    }
}
