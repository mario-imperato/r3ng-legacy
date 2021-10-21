package org.r3.system.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5_Test
{

	public MD5_Test()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.err.println("Please specify a file.");
		}

		File f = new File("c:/tmp/md5.ser");
		f.delete();

		for (String element : args)
		{
			try
			{
				byte[] blockData = readFully(new File(element));
				System.out.println(MD5.getHashString(new File(element)) + " " + element + " " + Codecs.md5Digest(blockData));

				int blockSize = 1024;
				computeChunkedJDKMD5(blockData, blockSize);
				computeChunkedAltMD5Mode2(blockData, blockSize);
				computeChunkedAltMD5Mode3(blockData, blockSize);
			}
			catch (IOException x)
			{
				System.err.println(x.getMessage());
			}
		}
	}

	private static void computeChunkedAltMD5Mode2(byte[] blockData, int blockSize)
	{
		MD5 md5 = new MD5();

		int numberOfBlocks = blockData.length / blockSize;
		int leftOver = blockData.length % blockSize;
		int i = 0;
		while (i < numberOfBlocks)
		{

			md5.update(blockData, i * blockSize, blockSize);
			i++;
			// saveMD5Instance(md5);
		}

		if (leftOver > 0)
		{

			md5.update(blockData, i * blockSize, leftOver);
			// saveMD5Instance(md5);
		}

		System.out.println(md5.getHashString());
	}

	private static void computeChunkedAltMD5Mode1(byte[] blockData, int blockSize)
	{

		MD5 md5 = null;
		int numberOfBlocks = blockData.length / blockSize;
		int leftOver = blockData.length % blockSize;
		int i = 0;
		while (i < numberOfBlocks)
		{
			if (md5 == null)
				md5 = getMD5Instance();
			byte[] b = new byte[blockSize];
			System.arraycopy(blockData, i * blockSize, b, 0, blockSize);
			md5.update(b);
			i++;
			saveMD5Instance(md5);
		}

		if (leftOver > 0)
		{
			md5 = getMD5Instance();
			byte[] b = new byte[leftOver];
			System.arraycopy(blockData, i * blockSize, b, 0, leftOver);
			md5.update(b);

			// md5.update(blockData, i * blockSize, leftOver);
			saveMD5Instance(md5);
		}

		md5 = getMD5Instance();
		System.out.println(md5.getHashString());
	}

	private static void computeChunkedAltMD5Mode3(byte[] blockData, int blockSize)
	{

		MD5 md5 = new MD5();
		int numberOfBlocks = blockData.length / blockSize;
		int leftOver = blockData.length % blockSize;
		int i = 0;
		while (i < numberOfBlocks)
		{

			byte[] b = new byte[blockSize];
			System.arraycopy(blockData, i * blockSize, b, 0, blockSize);
			md5.update(b);
			i++;

		}

		if (leftOver > 0)
		{

			byte[] b = new byte[leftOver];
			System.arraycopy(blockData, i * blockSize, b, 0, leftOver);
			md5.update(b);

		}

		System.out.println(md5.getHashString());
	}

	private static void computeChunkedJDKMD5(byte[] blockData, int blockSize)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");

			int numberOfBlocks = blockData.length / blockSize;
			int leftOver = blockData.length % blockSize;
			int i = 0;
			while (i < numberOfBlocks)
			{

				md.update(blockData, i * blockSize, blockSize);
				i++;
				// saveMD5Instance(md5);
			}

			if (leftOver > 0)
			{

				md.update(blockData, i * blockSize, leftOver);
				// saveMD5Instance(md5);
			}

			byte[] dig = md.digest();
			System.out.println(Codecs.byteToHex(dig));
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}

	private static MD5 getMD5Instance()
	{
		File f = new File("c:/tmp/md5.ser");
		if (!f.exists())
			return new MD5();

		
		try (FileInputStream inputFileStream = new FileInputStream("c:/tmp/md5.ser");ObjectInputStream objectInputStream = new ObjectInputStream(inputFileStream);)
		{			
			MD5 md5 = (MD5) objectInputStream.readObject();
			return md5;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	private static void saveMD5Instance(MD5 anMD5)
	{
		File f = new File("c:/tmp/md5.ser");

		FileOutputStream outputFileStream = null;
		ObjectOutputStream objectInputStream = null;
		try
		{
			outputFileStream = new FileOutputStream("c:/tmp/md5.ser");
			objectInputStream = new ObjectOutputStream(outputFileStream);
			objectInputStream.writeObject(anMD5);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SystemUtils.close(objectInputStream);
			SystemUtils.close(outputFileStream);
		}
	}

	private static byte[] readFully(File aFile)
	{
		FileInputStream finp = null;

		try
		{
			finp = new FileInputStream(aFile);
			byte[] fileBuffer = new byte[(int) aFile.length()];
			finp.read(fileBuffer);

			return fileBuffer;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			SystemUtils.close(finp);
		}

		return null;
	}

}
