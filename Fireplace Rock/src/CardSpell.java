
public class CardSpell extends Card {
	BasicEffect effectGiven;
	public CardSpell(Hero cardHolder)
	{
		super(cardHolder);
		cardText = "Spell";
		cardName = "Spell Card";
		displayCard = true;
		manaCost = 100;
		cardType = 0;
		effectGiven = new EffectNothing();
		
	}
    public void playCard(Minion[] minion)
    {
        for (int i=0;i<minion.length;i++)
        {
        	minion[i].giveBasicEffect(effectGiven);
        }
    }
}
