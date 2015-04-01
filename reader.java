import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: jinkewoniu
 * Date: 11-10-25
 * Time: 下午6:22
 * To change this template use File | Settings | File Templates.
 */
public class reader
{
    private File configurationfile;
    public reader(File cf)
    {
        this.configurationfile=cf;
    }
    public tray gettray()
    {
         ArrayList<block> blocks = new ArrayList<block>();
            int tx=0;
            int ty=0;
            try{
			Scanner scanner = new Scanner(configurationfile);
			String firstline=scanner.nextLine();
            String[] firstlineSplit=firstline.split(" ");
            ty=Integer.parseInt(firstlineSplit[0]);
            tx=Integer.parseInt(firstlineSplit[1]);
                int a=1;
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();


                String[] lineSplit = line.split(" ");


				int ry = Integer.parseInt(lineSplit[0]);
				int rx= Integer.parseInt(lineSplit[1]);
                int py=Integer.parseInt(lineSplit[2]);
                int px=Integer.parseInt(lineSplit[3]);
				block blk=new block(a,px,py,rx,ry);
                a++;
				blocks.add(blk);
            }                   }
              catch (Exception e)
		{
			//throw new IOException("There was an error while parsing the configuration file, quitting");
		}

             tray tay=new tray(tx,ty,blocks);
             return tay;





    }
    public ArrayList<block> getlistofblocks()  {
        ArrayList<block> blocks = new ArrayList<block>();
        try
		{
			Scanner scanner = new Scanner(configurationfile);
			String firstline=scanner.nextLine();

            int a=1;
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();


                String[] lineSplit = line.split(" ");


				int ry = Integer.parseInt(lineSplit[0]);
				int rx= Integer.parseInt(lineSplit[1]);
                int py=Integer.parseInt(lineSplit[2]);
                int px=Integer.parseInt(lineSplit[3]);
				block blk=new block(a,px,py,rx,ry);
                a++;
				blocks.add(blk);
                



			}
		}
        catch (Exception e)
		{
			//throw new IOException("There was an error while parsing the configuration file, quitting");
		}
		return blocks;
    }
}
