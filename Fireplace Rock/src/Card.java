public class Card implements Comparable
{
    //Card class - this represents a card, the only way things can happen in the game
    int manaCost;
	boolean targeted;
	//Can this card target a minion?
    /* Card types:
     * 0 = Spell
     * 1 = Minion
     */
    int cardType;
    boolean displayCard;
    String cardText, cardName;
    Hero cardHolder;
    public Card(Hero cardHolder)
    {
        cardText = "Hacker Card";
        cardName = "Dev Card";
        displayCard = false;
        manaCost = 100;
        this.cardHolder = cardHolder;
    }
    public int compareTo(Object o1)
    {
        if (this.manaCost == ((Card) o1).manaCost)
        {
            return 0;
        } else if ((this.manaCost) > ((Card) o1).manaCost)
        {
            return 1;
        } else {
            return -1;
        }
    }
    //Be careful! these are only here so both spells and minions can be in hand,
    // make sure that a spell can never be summoned as a minion and vice versa

    public void playCard(Board board)
    {
        //board.add(new Minion());
    }
    public void playCard(Minion minion)
    {
    	//minion.giveBasicEffect(new EffectNothing());
    }
    public void playCard()
    {
    	//cardHolder.dostufftoit();
    }
}
