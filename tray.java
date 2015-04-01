import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: jinkewoniu
 * Date: 11-10-25
 * Time: 下午6:09
 * To change this template use File | Settings | File Templates.
 */
public class tray implements Cloneable
{

    @Override public boolean equals( Object atay )
    {
        tray tay=(tray)atay;
         /*if(this.getRangex()!=tay.getRangex())
             return false;
         if(this.getRangey()!=getRangey())
            return false;*/
        int a=0;
        for(block blk1:this.getBlocks())
        {
           for(block blk2:tay.getBlocks())
           {
               if((blk2.getRangex()==blk1.getRangex()&&(blk2.getRangey())==blk1.getRangey()))
               {
                   if((blk2.getPointx()==blk1.getPointx())&&(blk2.getPointy()==blk1.getPointy()))
                       a++;
               }
           }
        }
        if(a==10)
            return true;
        else return false;

    }
    @Override public int hashCode() {
       int a=0;
        for(block blk:this.getBlocks())
        {
            if(blk.blockform()==1)
           a=a+20*30*30*20*(blk.getPointx()+blk.getPointy()*10);
            if(blk.blockform()==2)
           a=a+20*30*30*(blk.getPointx()+blk.getPointy()*10);
            if(blk.blockform()==3)
           a=a+20*30*(blk.getPointx()+blk.getPointy()*10);
            if(blk.blockform()==4)
           a=a+20*(blk.getPointx()+blk.getPointy()*10);
        }
        return a;
      }

    private ArrayList<block> blocks;
    private int rangex;
    private int rangey;
    boolean bl[][]=new boolean[4][5];
    public String tostring1()
    {
        for(int i=0;i<=3;i++)
        { for(int j=0;j<=4;j++)
        {
          if(bl[i][j])
              return "("+i+","+j+")";
        }
        }
        return null;

    }
    public void setRangex(int x)
    {
        this.rangex=x;
    }


    public static ArrayList<block> cloneList(ArrayList<block> list)
    {
    ArrayList<block> clone = new ArrayList<block>(list.size());
    for(block item: list)
        clone.add((block) item.clone());
    return clone;
    }
   public tray clone()
    {
        /*tray trayClone = new tray();
        ArrayList<block> blocksClone = new ArrayList<block>();

        for (block b : blocks) {
            blocksClone.add((block) b.clone());
        }

        return trayClone;  */
        tray o=null;
        try
        {
            o=(tray)super.clone();
        }
        catch (CloneNotSupportedException e)
        {
             e.printStackTrace();
        }
        o.bl=new boolean[4][5];
        for(int i=0;i<=3;i++)
        { for(int j=0;j<=4;j++) {
           o.bl[i][j]=bl[i][j];
        } }
        o.blocks=new ArrayList<block>();
        for(int i=0;i<blocks.size();i++)
        {
            block temp=(block)blocks.get(i).clone();
            o.blocks.add(temp);
        }

        return o;

    }
    public ArrayList<block> getBlocks()
    {
        return blocks;
    }
    public tray()
    {}
    public tray(tray t)
    {
        this.rangex=t.getRangex();
        this.rangey=t.getRangey();
        this.blocks=t.getBlocks();
        this.bl=t.bl;
    }

    public tray(int rx,int ry,ArrayList<block> bs)
    {
        this.rangex=rx;
        this.rangey=ry;
        this.blocks=bs;
        for(int i=0;i<=3;i++)
        {
            for(int j=0;j<=4;j++)
            {
                this.bl[i][j]=true;
            }
        }
              for(block blk:blocks)
              {
                  this.bl[blk.getPointx()][blk.getPointy()]=false;
                  if(blk.blockform()==2)
                      this.bl[blk.getPointx()][blk.getPointy()+1]=false;
                  if(blk.blockform()==3)
                      this.bl[blk.getPointx()+1][blk.getPointy()]=false;
                  if(blk.blockform()==4)
                  { this.bl[blk.getPointx()][blk.getPointy()+1]=false;
                      this.bl[blk.getPointx()+1][blk.getPointy()]=false;
                      this.bl[blk.getPointx()+1][blk.getPointy()+1]=false;}
              }
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
        return "x:"+rangex +"y:"+ rangey;
    }
    public void draw()
    {
        StdDraw.setXscale(0,rangex);
        StdDraw.setYscale(rangey,0);
            for(block blk:blocks) {
            StdDraw.setPenColor(Color.white);
            StdDraw.setPenRadius(.005);
            StdDraw.rectangle((blk.getRangex()*0.5)+blk.getPointx(),(blk.getRangey()*0.5)+blk.getPointy(),blk.getRangex()*0.5,blk.getRangey()*0.5);
            if(blk.getRangey()==2&&blk.getRangex()==1)
            {StdDraw.setPenColor(Color.green);
           StdDraw.filledRectangle((blk.getRangex()*0.5)+blk.getPointx(),(blk.getRangey()*0.5)+blk.getPointy(),blk.getRangex()*0.5,blk.getRangey()*0.5); }
            if(blk.getRangey()==2&&blk.getRangex()==2)
            {
                StdDraw.setPenColor(Color.red);
              StdDraw.filledRectangle((blk.getRangex()*0.5)+blk.getPointx(),(blk.getRangey()*0.5)+blk.getPointy(),blk.getRangex()*0.5,blk.getRangey()*0.5);
            }
            if(blk.getRangey()==1&&blk.getRangex()==1)
            {
                StdDraw.setPenColor(Color.yellow);
              StdDraw.filledRectangle((blk.getRangex()*0.5)+blk.getPointx(),(blk.getRangey()*0.5)+blk.getPointy(),blk.getRangex()*0.5,blk.getRangey()*0.5);
            }
            if(blk.getRangey()==1&&blk.getRangex()==2)
            {
                StdDraw.setPenColor(Color.blue);
            StdDraw.filledRectangle((blk.getRangex()*0.5)+blk.getPointx(),(blk.getRangey()*0.5)+blk.getPointy(),blk.getRangex()*0.5,blk.getRangey()*0.5);
            }   }
    }
    public void move(block bk,int dir)
    {

        if(dir==1)
        {
            bk.setPointy(bk.getPointy() - 1);
        }
        if(dir==2)
        {
            bk.setPointy((bk.getPointy()+1));
        }
        if(dir==3)
        {
            bk.setPointx(bk.getPointx()-1);
        }
        if(dir==4)
        {
            bk.setPointx(bk.getPointx()+1);
        }
           for(int i=0;i<=3;i++)
        {
            for(int j=0;j<=4;j++)
            {
                this.bl[i][j]=true;
            }
        }

              for(block blk:this.blocks)
              {
                  this.bl[blk.getPointx()][blk.getPointy()]=false;
                  if(blk.blockform()==2)
                      this.bl[blk.getPointx()][blk.getPointy()+1]=false;
                  if(blk.blockform()==3)
                      this.bl[blk.getPointx()+1][blk.getPointy()]=false;
                  if(blk.blockform()==4)
                  { this.bl[blk.getPointx()][blk.getPointy()+1]=false;
                      this.bl[blk.getPointx()+1][blk.getPointy()]=false;
                      this.bl[blk.getPointx()+1][blk.getPointy()+1]=false;}
              }
    }
    public tray(tray tay,block blk,int dir) {

        this.rangex=tay.getRangex();
        this.rangey=tay.getRangey();
        this.blocks=tay.getBlocks();
        //tray Tay=new tray(tay.getRangex(),tay.getRangey(),tay.getBlocks());
        for(block bk:this.getBlocks())
        {
            if(bk.getBlockid()==blk.getBlockid())
            {

        if(dir==1)
        {

            bk.setPointy(bk.getPointy() - 1);
        }
        if(dir==2)
        {
            bk.setPointy((bk.getPointy()+1));
        }
        if(dir==3)
        {
            bk.setPointx(bk.getPointx()-1);
        }
        if(dir==4)
        {
            bk.setPointy(bk.getPointx()+1);
        }
            }





    } }
    public boolean movepossilbe(block blk,int dir)
    {
        boolean a;
        a=true;
        if(dir==1)
        {
            if(blk.getPointy()>0)
            {
                for(int i=0;i<=blk.getRangex()-1;i++)
                {
                    if(!this.bl[blk.getPointx()+i][blk.getPointy()-1])
                        a=false;
                }

            }
            else a=false;
        }
        if(dir==2)
        {
            if((blk.getPointy()+blk.getRangey())<(this.rangey))
            {
               for(int i=0;i<=(blk.getRangex()-1);i++)
                {
                    if(this.bl[(blk.getPointx()+i)][blk.getPointy()+blk.getRangey()]==false)
                       a=false;
                }

            }
            else a=false;
        }
        if(dir==3)
        {
            if(blk.getPointx()>0)
            {
                for(int i=0;i<=(blk.getRangey()-1);i++)
                {
                    if(this.bl[(blk.getPointx()-1)][(blk.getPointy()+i)]==false)
                     a=false;
                }

            }
            else a=false;
        }
        if(dir==4)
        {
            if(blk.getPointx()+blk.getRangex()<this.rangex)
            {
                for(int i=0;i<=blk.getRangey()-1;i++)
                {
                    if(this.bl[blk.getPointx()+blk.getRangex()][blk.getPointy()+i]==false)
                      a=false;
                }

            }
            else a=false;
        }
        return a;
    }
    public boolean issolutiontray()
    {   int a=0;
        for(block blk:this.blocks)
        {
            if(blk.getRangex()==2&&blk.getRangey()==2)
            {
                if(blk.getPointx()==1&&blk.getPointy()==3)
                {
                  a++;
                }
            }
        }
       if(a!=0)
           return true;
        else
           return false;
    }
}
