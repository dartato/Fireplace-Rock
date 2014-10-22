public class CardGurubashiBeserker extends Card
{
    //Card class - this represents a card, the only way things can happen in the game
    /* Card types:
     * 0 = Spell
     * 1 = Minion
     */
    public CardGurubashiBeserker(Hero cardHolder)
    {
    	super(cardHolder);
        manaCost = 5;
        cardText = "Gains +3 attack every time it takes damage.";
        cardName = "Gurubashi Beserker";
    }
    public void playCard(Board board)
    {
        board.add(new MinionGurubashiBeserker());
    }
}
