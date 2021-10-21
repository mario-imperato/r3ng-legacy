package org.r3.system.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Deque;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{
	public static void zip(File directory, File zipfile) throws IOException
	{
		String zipFileName = zipfile.getName();

		URI base = directory.toURI();
		Deque<File> queue = new LinkedList<File>();
		queue.push(directory);

		try (OutputStream out = new FileOutputStream(zipfile); ZipOutputStream zout = new ZipOutputStream(out);)
		{

			while (!queue.isEmpty())
			{
				directory = queue.pop();
				for (File kid : directory.listFiles())
				{
					String name = base.relativize(kid.toURI()).getPath();
					if (kid.isDirectory())
					{
						queue.push(kid);
						name = name.endsWith("/") ? name : name + "/";
						zout.putNextEntry(new ZipEntry(name));
					}
					else
					{
						if (!zipFileName.equalsIgnoreCase(name))
						{
							zout.putNextEntry(new ZipEntry(name));
							copy(kid, zout);
							zout.closeEntry();
						}
					}
				}
			}
		}

	}

	public static void unzip(File zipfile, File directory) throws IOException
	{
		try (ZipFile zfile = new ZipFile(zipfile);)
		{
			Enumeration<? extends ZipEntry> entries = zfile.entries();
			while (entries.hasMoreElements())
			{
				ZipEntry entry = entries.nextElement();
				File file = new File(directory, entry.getName());
				if (entry.isDirectory())
				{
					file.mkdirs();
				}
				else
				{
					file.getParentFile().mkdirs();
					try(InputStream in = zfile.getInputStream(entry);)
					{
						copy(in, file);
					}
				}
			}
		}
	}

	private static void copy(InputStream in, OutputStream out) throws IOException
	{
		byte[] buffer = new byte[1024];
		while (true)
		{
			int readCount = in.read(buffer);
			if (readCount < 0)
			{
				break;
			}
			out.write(buffer, 0, readCount);
		}
	}

	private static void copy(File file, OutputStream out) throws IOException
	{
		InputStream in = new FileInputStream(file);
		try
		{
			copy(in, out);
		}
		finally
		{
			in.close();
		}
	}

	private static void copy(InputStream in, File file) throws IOException
	{
		OutputStream out = new FileOutputStream(file);
		try
		{
			copy(in, out);
		}
		finally
		{
			out.close();
		}
	}

	public static void main(String[] args) throws IOException
	{
		File directory = new File("C:/tmp/UNEP/tmp/tmpd.20130105_000351_548_http-8080-5");
		File zipFile = new File("C:/tmp/UNEP/tmp/file.zip");
		ZipUtils.zip(directory, zipFile);
	}
}
