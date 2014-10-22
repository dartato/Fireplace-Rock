
public class HeroPaladin extends Hero {
public HeroPaladin(Board alliedBoard, Board enemyBoard)
{
	super(alliedBoard, enemyBoard);
	this.heroPower = new HeroPowerPaladin(this);
	this.minionName = " Paladin  ";
}
}
