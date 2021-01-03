import java.io.*;

public class FindNlineThread
{
public static void main(String args[]) {
try {
    String folderpath = "D:\\Java\\";
    File f = new File(folderpath);
    String[] files = f.list();
    for (int i=0;i<files.length;i++)
    {
	new FindLine(new File(folderpath+files[i])).start();
    }
    }catch(Exception e)
    {
    e.printStackTrace();
    }
    }
}

class FindLine extends Thread {
	File searchfile;
	FindLine(File searchfile)
	{
	this.searchfile = searchfile;
	}
	public void run()
	{
	try
	{
	FileReader reader = new FileReader(searchfile);
	BufferedReader br = new BufferedReader(reader);
	String s;
	int i = 0;
	while ((s = br.readLine()) != null)
	i++;
	System.out.println("No. of Lines in file "+searchfile.getName()+" = "+i);
	} catch (Exception e)
	{
	e.printStackTrace();
	}
	}
}
