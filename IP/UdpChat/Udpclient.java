import java.net.*;
import java.io.*;
import java.util.*;

public class Udpclient {

	
	public static void main(String[] args) throws SocketException,UnknownHostException,IOException,InterruptedException{
	    int port;
		InetAddress address;
		DatagramSocket socket = null;
		DatagramPacket packet;
		byte[] sendBuf = new byte[256];
   		
   		Scanner in=new Scanner(System.in);
		if (args.length != 1) {
		    System.out.println("Usage: java UdpClient <hostname>");
		    return;
		}

		socket = new DatagramSocket();
		byte[] buf = new byte[256];
		while(true){
			String s;
			System.out.println("\nENTER MESSAGE TO SEND TO SERVER:");
			s=null;
			//s=in.nextLine()+"\n"+"\0";
			s=in.nextLine();
			//System.out.println("\nMESSAGE SENT AS STRING IS :"+s);

			buf=null;
			buf = s.getBytes();
			//System.out.println("\nPRINTING VALUES IN BUF:-\n"+Arrays.toString(buf)+"\n");
			address = InetAddress.getByName(args[0]);
	        packet = new DatagramPacket(buf, buf.length, 
			                                address, 4445);
			socket.send(packet);
			if(s.equals("i quit")){
				Thread.sleep(1000);
				break;
			}
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			String received = new String(packet.getData(), 0, packet.getLength());
			System.out.println("\nMESSAGE FROM SERVER:- ");
			System.out.println(received);
			if(received.equals("i quit"))
				break;
   		}
   		socket.close();
   		System.exit(0);

   	}

}
