public class HeroPowerMage extends CardHeroPower {
	public HeroPowerMage(Hero cardHolder)
	{
		super(cardHolder);
		effectGiven = new EffectDamage(1);
		cardName = "Fireball";
		cardText = "Deal one damage.";
		targeted = true;
	}
}
