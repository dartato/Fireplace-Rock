
public class HeroPowerPaladin extends CardHeroPower{
	public HeroPowerPaladin(Hero cardHolder)
	{
		super(cardHolder);
		cardName = "Reinforce";
		cardText = "Summon a 1/1 Silver Hand Recruit";
		targeted = false;
		cardType = 1;		
	}
	public void playCard()
	{
		cardHolder.alliedBoard.add(new MinionSilverHandRecruit());
	}
}
