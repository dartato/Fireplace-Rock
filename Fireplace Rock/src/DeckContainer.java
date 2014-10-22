public class DeckContainer
{
    //Deck class, returns an array containing the deck
    Card[] deck;
    public DeckContainer(Hero cardHolder)
    {
        this.deck = new Card[30];
        for (int i=0; i<15;i++)
        {
        deck[i] = new CardGoldshireFootman(cardHolder);
        deck[i+1] = new CardGurubashiBeserker(cardHolder);
        }
    }
    public Card[] getDeck() 
    {
        return this.deck;
    }
}
