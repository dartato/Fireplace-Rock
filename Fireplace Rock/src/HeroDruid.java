
public class HeroDruid extends Hero {
	public HeroDruid(Board alliedBoard, Board enemyBoard)
	{
		super(alliedBoard, enemyBoard);
		this.heroPower = new HeroPowerDruid(this);
		this.minionName = "  Druid   ";
	}

}
