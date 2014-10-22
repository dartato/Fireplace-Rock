public class CardGoldshireFootman extends CardMinion
{
    //Card class - this represents a card, the only way things can happen in the game
    /* Card types:
     * 0 = Spell
     * 1 = Minion
     */
    public CardGoldshireFootman(Hero cardHolder)
    {
    	super(cardHolder);
        manaCost = 1;
        cardText = "Taunt";
        cardName = "Goldshire Footman";
    }
    public void playCard(Board board)
    {
        board.add(new MinionGoldshireFootman());
    }
}
