import java.net.*;
import java.io.*;
import java.util.*;


public class Udpserver {

    private static DatagramSocket serverSocket;

    public static void main(String[] args) throws Exception {

        serverSocket = new DatagramSocket(4445);
       // byte[] receiveData = new byte[1024];
        //byte[] sendData = new byte[1024];
        
        Scanner in=new Scanner(System.in);
        while(true)
           {
               byte[] receiveData = new byte[1024];
               byte[] sendData = new byte[1024];
               String s=null;
              System.out.println("WAITING FOR MESSAGE FROM CLIENT");
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              serverSocket.receive(receivePacket);
              s="\0";
              s = new String( receivePacket.getData());
              
              System.out.println("MESSAGE OF CLIENT : " + s);
              if(s.equals("i quit")){
				Thread.sleep(1000);
				break;
			  }
              InetAddress inetaddress = receivePacket.getAddress();
              int port = receivePacket.getPort();
              System.out.println("ENTER MESSAGE TO SEND TO CLIENT:-");
              s=null;
              s=in.nextLine();
              sendData=null;
              sendData = s.getBytes();
              //System.out.println("MESSAGE SENt AS STRING IS :"+s);

              DatagramPacket sendpacket = new DatagramPacket(sendData, sendData.length,inetaddress, port);
              serverSocket.send(sendpacket);
              if(s.equals("i quit")){
                Thread.sleep(1000);
                break;
              }
           }
           serverSocket.close();
           System.exit(0);

    }

}