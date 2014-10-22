
public class CardMinion extends Card{
	public CardMinion(Hero cardHolder)
	{
		super(cardHolder);
		cardText = "Minion";
		cardName = "Minion Card";
		displayCard = false;
		manaCost = 100;
		cardType = 1;
		
	}
    public void playCard(Board board)
    {
        board.add(new Minion());
    }
}
