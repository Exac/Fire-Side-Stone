class oBase
{
	Image img;
	String imageName;
	int posx,posy;
	int vspeed=0, hspeed=0;
	void oBase(String a, int x, int y)
	{
		posx=x;
		posy=y;
		imageName = a;
		img = getImage(getDocumentBase(),a);
	}
	void setvspeed(int x)
	{
		vspeed = x;
	}
	void sethspeed(int x)
	{
		hspeed = x;
	}
	void setposx(int x)
	{
		posx = x;
	}
	void setposy(int x)
	{
		posy = y;
	}
	void draw.inRelation(Graphics g, int relx, int rely, int drawx, int drawy)
	{
		g.drawImage(img,drawx,drawy);
	}
}
class oChar extends oBase
{
	int health = 100;
	String filename;
}

