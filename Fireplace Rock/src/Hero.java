import java.util.*;
public class Hero extends Minion
{
    //Standard minion class, base is essentially a nifty li'l wisp!
    boolean turnIsActive, playedHeroPowerYet;
    int currentMana, totalMana;
    CardHeroPower heroPower;
    RecurringEffectArmor heroArmor;
    Card[] heroDeck;
    Card[] heroHand = new Card[10];
    int cardsLeftInHand, deckIndex;
    Board alliedBoard;
    Board enemyBoard;
    
    public Hero()
    {
    	//Reserver memory space for a hero to fill
    }
    public Hero(Board alliedBoard, Board enemyBoard)
    {
        baseHealth = 30;
        baseAttack = 0;
        currentHealth = 30;
        currentAttack = 0;
        maxHealth = 30;
        minionName = "Basic Hero";
        minionClass = -1;
        this.heroPower = new CardHeroPower(this);
        this.heroHand = new Card[10];
        this.alliedBoard = alliedBoard;
        this.enemyBoard = enemyBoard;
        
        //Give the hero the option to gain armor
        heroArmor = new RecurringEffectArmor(this);
        activeEffects.add(heroArmor);
        //Give the hand one card so the array can sort
        for (int i=0;i<10;i++)
        {
            this.heroHand[i] = new Card(this);
        }
        hasAwoken = true;
        canAttack = true;
    }
    public void fillDeck(DeckContainer deck)
    {
    	this.heroDeck = deck.getDeck();
    }
    
    public void drawCard()
    {        
        Arrays.sort(this.heroHand);
        if (deckIndex>=30)
        {
            //"fatigue" mechanic
            this.giveBasicEffect(new EffectDamage(deckIndex-29));
        } else if (cardsLeftInHand<10)
        {
            this.heroHand[cardsLeftInHand] = heroDeck[deckIndex];
            cardsLeftInHand++;
        }
        deckIndex++;
        Arrays.sort(this.heroHand);
    }
    public Card[] getHand()
    {
        Arrays.sort(this.heroHand);
        return this.heroHand;
    }
    public void startTurn()
    {
        turnIsActive = true;
        playedHeroPowerYet = false;
        if (totalMana<10)
        {
            totalMana++;
        }
        currentMana = totalMana;
        drawCard();
    }
    public void endTurn()
    {
        turnIsActive = false;
    }
    public void giveBasicEffect(BasicEffect effectGiven)
    {
        ArrayList<BasicEffect> finalEffects = new ArrayList<BasicEffect>();
        finalEffects.add(effectGiven);
        for (int i=0; i<activeEffects.size(); i++) {
            finalEffects.add(activeEffects.get(i).effectGiven(effectGiven));
        }
        for (int i=0; i<finalEffects.size(); i++) {
            finalEffects.get(i).runEffect(this);
        }
    }
    public void playCard(int index)
    {
        //check to make sure that it is a minion
        if ((this.heroHand[index].cardType == 1 && alliedBoard.size() < 8) && this.currentMana >= this.heroHand[index].manaCost)
        {
            this.currentMana -= this.heroHand[index].manaCost;
            this.heroHand[index].playCard(this.alliedBoard);
            this.alliedBoard.sendEventToAll(new Event(Event.CARD_PLAYED));
            this.heroHand[index] = new Card(this);
            cardsLeftInHand--;
            getHand();
        } else if (this.heroHand[index].manaCost<=currentMana)
        	
        {
        	this.heroHand[index].playCard();
            this.currentMana -= this.heroHand[index].manaCost;
            this.alliedBoard.sendEventToAll(new Event(Event.CARD_PLAYED));
            this.heroHand[index] = new Card(this);
            cardsLeftInHand--;
            getHand();
        }
    }
    public void playHeroPower()
    {
    	if (!playedHeroPowerYet && currentMana>=2)
    	{
    		this.heroPower.playCard();
    		this.currentMana -= this.heroPower.manaCost;
    		this.playedHeroPowerYet = true;
    	}
    }
    public void playHeroPower(Minion target)
    {
    	if (!playedHeroPowerYet && currentMana>=2)
    	{
    		this.heroPower.playCard(target);
    		this.currentMana -= this.heroPower.manaCost;
    		this.playedHeroPowerYet = true;
    	}
    }
    public void playCard(int index, Minion targetMinion)
    {
    	
    }
}
