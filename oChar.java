public class oChar extends oBase
{
	int health = 100;
	public oChar(String a, int x, int y, game z)
	{
		super(a,x,y,z);
	}
	int getType()
	{
		return 1;
	}
}
