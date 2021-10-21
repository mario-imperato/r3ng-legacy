package org.r3.system.util;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class UserPasswordGenerate
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
        if (args.length != 1)
        {
        	System.out.println("Indicare a parametro il riferimento al file contenente la lista di prefissi per le parole chiave!");
        	return ;
        }
        	
        File f = new File(args[0]);
        if (!f.exists())
        {
        	System.out.println("Il file indicato a parametro non esiste");
        	return ;        	
        }
        
        File outFile = new File(f.getParent(), "codedPasswords.txt");
        
        BufferedReader br = null;
        PrintWriter prt = null;
        try
        {
        	br = new BufferedReader(new FileReader(f));
        	prt = new PrintWriter(new FileWriter(outFile));
        	
        	Random rand = new Random();
        	
        	String l = br.readLine();
        	while (l != null)
        	{
        		StringBuilder stb = new StringBuilder().append(l).append(rand.nextInt(100));
        		
        		String clearPassword = stb.toString();
        		String encodedPasswd = Codecs.digestAsString(clearPassword);
        		
        		prt.format("%20s --> %20s = '%s'\n", l, clearPassword, encodedPasswd);
        		l = br.readLine();
        	}
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	SystemUtils.close(br);
        	SystemUtils.close(prt);
        }
	}

}
