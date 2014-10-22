
public class Main
{
	//Lets get this started!
	public static void main(final String[] args)
	{
		//Starts a two-player game
		KeyboardReader reader = new KeyboardReader();
		Board p1Board = new Board();
		Board p2Board = new Board();

		String userInput;
		Hero p1Hero = null, p2Hero = null;
		Hero heroPlaying;
		do {
			userInput = reader.readString("What hero would player 1 like to play as?");
			if (userInput.equalsIgnoreCase("Hunter"))
				p1Hero = new HeroHunter(p1Board, p2Board);
			else if (userInput.equalsIgnoreCase("Mage"))
				p1Hero = new HeroMage(p1Board, p2Board);
			else if (userInput.equalsIgnoreCase("Warlock"))
				p1Hero = new HeroWarlock(p1Board, p2Board);
			else if (userInput.equalsIgnoreCase("Paladin"))
				p1Hero = new HeroPaladin(p1Board, p2Board);
			else if (userInput.equalsIgnoreCase("Priest"))
				p1Hero = new HeroPriest(p1Board, p2Board);
			else if (userInput.equalsIgnoreCase("Druid"))
				p1Hero = new HeroDruid(p1Board, p2Board);
			else
			{
				userInput = "";
				System.out.println("That is not an available hero, please try again!");
			}


		} while (userInput=="");
		do {
			userInput = reader.readString("What hero would player 2 like to play as?");
			if (userInput.equalsIgnoreCase("Hunter"))
				p2Hero = new HeroHunter(p2Board, p1Board);
			else if (userInput.equalsIgnoreCase("Mage"))
				p2Hero = new HeroMage(p2Board, p1Board);
			else if (userInput.equalsIgnoreCase("Warlock"))
				p2Hero = new HeroWarlock(p2Board, p1Board);
			else if (userInput.equalsIgnoreCase("Paladin"))
				p2Hero = new HeroPaladin(p2Board, p1Board);
			else if (userInput.equalsIgnoreCase("Priest"))
				p2Hero = new HeroPriest(p2Board, p1Board);
			else
			{
				userInput = "";
				System.out.println("That is not an available hero, please try again!");
			}
		} while (userInput=="");
		if (Math.random()<0.5)
		{
			heroPlaying = p1Hero;
			p1Hero = p2Hero;
			p2Hero = heroPlaying;
		}

		DeckContainer p1Deck = new DeckContainer(p1Hero);
		DeckContainer p2Deck = new DeckContainer(p2Hero);
		p1Board.assignHero(p1Hero);
		p2Board.assignHero(p2Hero);
		p1Hero.fillDeck(p1Deck);
		p2Hero.fillDeck(p2Deck);
		Game game = new Game(p1Hero, p2Hero);
		UserInterface io = new UserInterface(game);
		game.progressTurn();
		String input;
		boolean gameIsNotOver = true;
		int winner = 3;
		while (gameIsNotOver)
		{
			io.displayBoard();
			input = reader.readString(":> ");
			if (game.currentTurn)
				heroPlaying = p1Hero;
			else
				heroPlaying = p2Hero;
			if (input.equalsIgnoreCase("end turn"))
			{
				game.progressTurn();
				continue;
			} else if (input.equalsIgnoreCase("Play Card"))
			{
				int cardIndex = reader.readInt("Enter the index of the card in your hand: ");
				if (game.currentTurn)
				{
					if (p1Hero.heroHand[cardIndex].cardType == 0)
					{
						p1Hero.playCard(cardIndex);
					} else {
						if (p1Hero.heroHand[cardIndex].targeted)
						{
							Minion minionAffected;
							int minionIndex;
							minionIndex = reader.readInt("Enter the index for the target of the spell (-1 for hero)");
							if (minionIndex == -1)
								minionAffected = p2Hero;
							else
								minionAffected = p2Board.get(minionIndex);
							p1Hero.playCard(cardIndex, minionAffected);
						} else {
							p1Hero.playCard(cardIndex);
						}	
					}
					continue;
				} else {
					if (p2Hero.heroHand[cardIndex].cardType == 0)
					{
						p2Hero.playCard(cardIndex);
					} else {
						if (p2Hero.heroHand[cardIndex].targeted)
						{
							Minion minionAffected;
							int minionIndex;
							minionIndex = reader.readInt("Enter the index for the target of the spell (-1 for hero)");
							if (minionIndex == -1)
								minionAffected = p1Hero;
							else
								minionAffected = p1Board.get(minionIndex);
							p2Hero.playCard(cardIndex, minionAffected);
						} else {
							p2Hero.playCard(cardIndex);
						}
					}
				}
			} else if (input.equalsIgnoreCase("Attack"))
			{               
				int minion1 = reader.readInt("Enter the index of the top minion: ");
				int minion2 = reader.readInt("Enter the index of the bottom minion: ");
				if (minion1!=-1)
					minion1 = Math.abs(((7-p1Board.size())/2+1)-minion1);
				if (minion2!=-1)
					minion2 = Math.abs(((7-p2Board.size())/2+1)-minion2);

				game.attack(minion1, minion2);
				continue;
			} else if (input.equalsIgnoreCase("Hero Power"))
			{

				if (heroPlaying.heroPower.targeted)
				{
					int target, team;
					Hero damagedTeam;
					target = reader.readInt("Enter the index for the target of the hero power");
					team = reader.readInt("Of which team? (0 for allied, 1 for enemy)");
					if (team==1)
						damagedTeam = heroPlaying.enemyBoard.hero;
					else 
						damagedTeam = heroPlaying;

					if (target==-1)
						heroPlaying.playHeroPower(damagedTeam);
					else
						heroPlaying.playHeroPower(damagedTeam.alliedBoard.get(Math.abs(((7-damagedTeam.alliedBoard.size())/2+1)-target)));
				} else {
					heroPlaying.playHeroPower();
				}
			}
			else if (input.equals("exit")) {break;
			} else {
				System.out.println("Input not recognized!");
			}

			if (p2Hero.currentHealth<=0)
			{
				gameIsNotOver = false;
				winner = 1;
			} else if (p1Hero.currentHealth<=0)
			{
				gameIsNotOver = false;
				winner = 2;
			}
		}
		System.out.println("Congratulations to player "+winner+" for winning this game!");
			

	}
}