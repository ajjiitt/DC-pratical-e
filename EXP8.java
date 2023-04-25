import java.io.*;
import java.util.*;
import java.net.*;
public class EXP8 {
	public static void main(String[] args)
	{
		String host = "www.geeksforgeeks.org";
		try {
		InetAddress[] iaddress = InetAddress.getAllByName(host);

			for (InetAddress ipaddresses : iaddress) {
				System.out.println(ipaddresses.toString());
			}
		}
		catch (UnknownHostException e) {
			System.out.println(e);
		}
	}
}
