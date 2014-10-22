
public class HeroPowerDruid extends CardHeroPower {
	public HeroPowerDruid(Hero cardHolder)
	{
		super(cardHolder);
		effectGiven = new EffectClaw(1,1);
		cardName = "Claw";
		cardText = "Give your hero one attack this turn and gain one armor.";
		targeted = false;
	}
	public void playCard()
	{
		cardHolder.giveBasicEffect(effectGiven);
	}

}
