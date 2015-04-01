import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: jinkewoniu
 * Date: 11-10-25
 * Time: 下午6:39
 * To change this template use File | Settings | File Templates.
 */
public class controller
{
        public static void solve(HashSet<tray> st,HashSet<tray> stf) {

           System.out.println(stf.size());
           HashSet<tray> addList = new HashSet<tray>();
          for (Iterator its = st.iterator();its.hasNext();)
           {  tray tay = (tray)its.next();
        if(tay.issolutiontray())
                        {
                            tay.draw();
                            try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                            System.out.println("^_^");
                            System.exit(10);
                        }
       if(tay.issolutiontray()==false)
        {
            tray nexttay=(tray)tay.clone();
            //System.out.println(st.size());

        for(block blk:nexttay.getBlocks())
        {
            for(int dir=1;dir<=4;dir++)
            {
                if(nexttay.movepossilbe(blk,dir))
                {
                    tray copy=(tray)nexttay.clone();
                    for(block bk:copy.getBlocks())
                    {
                        if(bk.getBlockid()==blk.getBlockid())
                        {
                            copy.move(bk,dir);

                        }
                    }
                  if((!stf.contains(copy))&&(!addList.contains(copy)))
                    {
                        addList.add(copy);

                        System.out.println(addList.size());
                                               copy.draw();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                        StdDraw.clear();
                    }
                }
            }
        }
        }
            }

            st.addAll(addList);
            stf.addAll(addList);
            HashSet<tray> testList=new HashSet<tray>();
            testList.addAll(addList);
            //System.out.println(testList.size());
            System.out.println(testList.size());
            controller.solve(testList,stf);

}
    public static void main(String args[])
    {   HashSet<tray> seentrays=new HashSet<tray>();

       if(args.length==1)
        {
            File configurationfile=new File(args[0]);
            reader Reader=new reader(configurationfile);
        if (configurationfile.exists())
        {
            ArrayList<block> blocks=Reader.getlistofblocks();
            tray trays=Reader.gettray();
            seentrays.add(trays);
            tray Tay=(tray)trays.clone();
            controller.solve(seentrays,seentrays);
            tray currenttray=(tray)Tay.clone();
            a:for(block blk:currenttray.getBlocks())
            {
               b: for(int dir=1;dir<=4;dir++)
                {
                    if(currenttray.movepossilbe(blk,dir))
                    {
                      System.out.println(blk);
                      System.out.println(dir);
                      tray nexttray=new tray(currenttray,blk,dir);
                     if(!seentrays.contains(nexttray))
                      {
                           seentrays.add(nexttray);
                           nexttray.draw();


                          try {
                              Thread.sleep(1000);
                          } catch (InterruptedException e) {
                              e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                          }
                          break a;
                          //StdDraw.clear();
                      }
                    }
                }
            }
            currenttray.draw();
            //System.out.println(seentrays.size());

        }
    }
}
}