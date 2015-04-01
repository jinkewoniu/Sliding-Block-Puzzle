import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: jinkewoniu
 * Date: 11-10-24
 * Time: 下午9:29
 * To change this template use File | Settings | File Templates.
 */
public class block implements Cloneable
{   @Override public boolean equals( Object ablock )
   {
    block blk=(block)ablock;
       if(this.getRangex()!=((block) ablock).getRangex())
           return false;
       if(this.getRangey()!=((block) ablock).getRangey())
           return false;
       if(this.getPointx()!=((block) ablock).getPointx())
           return false;
       if(this.getPointy()!=((block) ablock).getPointy())
           return false;
       else return true;
   }
    @Override public int hashCode()
    {
        return this.getBlockid();
    }
    private int blockid;
    private int pointx;
    private int pointy;
    private int rangex;
    private int rangey;
    public block()
    {}
    public Object clone()
    {
    block o = null;
    try {
   o = (block) super.clone();
         }
    catch (CloneNotSupportedException e)
    {
   e.printStackTrace();
     }
  return o;
     }


    public block(int id,int px,int py,int rx,int ry)
    {
        this.blockid=id;
        this.pointx=px;
        this.pointy=py;
        this.rangex=rx;
        this.rangey=ry;
    }
    public int getBlockid()
    {
        return blockid;
    }
    public int getPointx()
	{
		return pointx;
	}
    public void setPointx(int newpointx)
    {
        pointx=newpointx;
    }
    public void setPointy(int newpointy)
    {
        pointy=newpointy;
    }
    public int getPointy()
    {
        return pointy;
    }
    public int getRangex()
    {
        return rangex;
    }

    public int getRangey()
    {
        return rangey;
    }
    public String toString()
	{
		return "id"+blockid+"("+pointx+","+pointy+")" + rangex + rangey;
    }
    public int blockform()
    {
        if(rangex==1&&rangey==1)
            return 1;
        if(rangex==1&&rangey==2)
            return 2;
        if(rangex==2&&rangey==1)
            return 3;
        if(rangex==2&&rangey==2)
            return 4;
        else return 5;
    }
    public void ISok(block blk,tray tay)
    {

    }
    public void draw(block blk)
    {

            StdDraw.setPenColor(Color.white);
            StdDraw.setPenRadius(.005);
            StdDraw.rectangle((blk.rangex*0.5)+blk.pointx,(blk.rangey*0.5)+blk.pointy,blk.rangex*0.5,blk.rangey*0.5);
            if(blk.rangey==2&&blk.rangex==1)
            {StdDraw.setPenColor(Color.green);
           StdDraw.filledRectangle((blk.rangex*0.5)+blk.pointx,(blk.rangey*0.5)+blk.pointy,blk.rangex*0.5,blk.rangey*0.5); }
            if(blk.rangey==2&&blk.rangex==2)
            {
                StdDraw.setPenColor(Color.red);
               StdDraw.filledRectangle((blk.rangex*0.5)+blk.pointx,(blk.rangey*0.5)+blk.pointy,blk.rangex*0.5,blk.rangey*0.5);
            }
            if(blk.rangey==1&&blk.rangex==1)
            {
                StdDraw.setPenColor(Color.yellow);
               StdDraw.filledRectangle((blk.rangex*0.5)+blk.pointx,(blk.rangey*0.5)+blk.pointy,blk.rangex*0.5,blk.rangey*0.5);
            }
            if(blk.rangey==1&&blk.rangex==2)
            {
                StdDraw.setPenColor(Color.blue);
              StdDraw.filledRectangle((blk.rangex*0.5)+blk.pointx,(blk.rangey*0.5)+blk.pointy,blk.rangex*0.5,blk.rangey*0.5);
            }
    }

    }
