import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EXP6NT {
    boolean hasOutstandingGrantMessage;
    long outstandingGrantMessageTimestamp;
    int outstandingGrantMessageId;
    int id;
    int clock = 0;
    InetAddress add = null;
    int port1 = 0;
    LinkedList<String> hostname;
    LinkedList<String> port;
    LinkedList<Integer> quorum;
    LinkedList<Boolean> quorumGranted;
    Socket clientSocket;

    public EXP6NT(int id) {
        this.id = id;
        hostname = new LinkedList<>();
        port = new LinkedList<>();
        quorum = new LinkedList<>();
        quorumGranted = new LinkedList<>();
    }

    class ServerThread extends Thread {
        EXP6NT server;
        int port;
        LinkedList<Request> request;

        public ServerThread(EXP6NT main) {
            this.server = main;
            request = new LinkedList<>();
        }

        int increaseClock(int clk1, int clk2)
        {
            if(clk1>clk2)
            {
                clock = clk1+1;
            }
            else
            {
                clock = clk2+1;
            }
            return clock;
        }

        void insertRequestByTimestamp(Request newRequest) {
            int indexToInsertInto = 0;
            for (int i = 0; i < request.size(); i++) {
                Request r = request.get(i);
                if (r.clk > newRequest.clk) {
                    indexToInsertInto = i;
                    break;
                }
            }
            request.add(indexToInsertInto, newRequest);
                 int realIndex = -1;
            for (int i = 0; i < this.server.quorum.size(); i++) {
                System.out.println(server.quorum.get(i)+","+messageId);
                if (server.quorum.get(i)-1 == messageId) realIndex = i;
            }
            this.server.quorumGranted.set(realIndex, true);
            boolean b = server.quorumAllGranted();
            if (b) {
               byte[] sendData = "capitalizedSentence".getBytes();
               DatagramPacket sendPacket =
               new DatagramPacket(sendData, sendData.length, add, port1);

        void processInquire(int messageId)
        {
            String hostName = server.hostname.get(messageId);
            String hostPort = server.port.get(messageId);
            System.out.println(hostPort);
            int realIndex = -1;
            for (int i = 0; i < this.server.quorum.size(); i++) {
                System.out.println(server.quorum.get(i)+","+messageId);
                if (server.quorum.get(i)-1 == messageId) realIndex = i;
            }
            this.server.quorumGranted.set(realIndex, false);
            try {
             DatagramSocket clientSocket = new DatagramSocket();
             InetAddress IPAddress = InetAddress.getByName(hostName);
             byte[] sendData = new byte[1024];
             byte[] receiveData = new byte[1024];
             String sentence = msg;
             sendData = sentence.getBytes();
             System.out.println("Sent Yeild response:"+sentence);
             DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, Integer.parseInt(hostPort));

void readFromSocket(DatagramPacket receivePacket, String inpmsg, DatagramSocket serverSocket) {
            String message = inpmsg;
            String[] field = message.split(",");
                  if (message.equals("start")) {
                add = receivePacket.getAddress();
               port1 = receivePacket.getPort();
               for (int i = 0; i < quorum.size(); i++) {
                   System.out.print(quorum.get(i)+" ");
                               {
                add = receivePacket.getAddress();
               port1 = receivePacket.getPort();
               for (int i = 0; i < quorum.size(); i++) {
                   System.out.print(quorum.get(i)+" ");
                for(int i1=0;i1<server.quorumGranted.size();i1++)
                        {
                            server.quorumGranted.set(i1,false);
                             }
        if (field.length == 2) {
                int messageType = Integer.parseInt(field[0]);
                int messageId = Integer.parseInt(field[1]);
                if(messageType == Message.FAILED.id)
                {
                    System.out.println("Recieved Failed Message From: "+messageId);
                    int realIndex = -1;
                    for (int i = 0; i < this.server.quorum.size(); i++) {
                        System.out.println(server.quorum.get(i)+","+messageId);
                        if (server.quorum.get(i)-1 == messageId) realIndex = i;
                    }
                    this.server.quorumGranted.set(realIndex, false);

                }
                else if(messageType == Message.INQUIRE.id)
                {

                    System.out.println("INQUIRE::"+messageId);
                    if(!checkInquire(messageId))
                    {
                        int in = -1;
                        for (int i = 0; i < this.server.quorum.size(); i++) {
                            System.out.println(server.quorum.get(i));
                String port2 = server.port.get(id)
DatagramSocket serverSocket = new DatagramSocket(Integer.parseInt(port2));
                byte[] receiveData = new byte[1024];
                byte[] sendData = new byte[1024];
                    serverSocket.receive(receivePacket);
                    String sentence = "";
                    sentence = "";
     sentence = new String( receivePacket.getData(),0, receivePacket.getLength());
                    System.out.println("RECEIVED: " + sentence);
                    readFromSocket(receivePacket, sentence, serverSock}
            } catch (IOException ex) {
                Logger.getLogger(EXP6NT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class Request {
        final int clk;
        final int messageId;
        public Request(int l, int i) {
            clk = l;
            messageId = i;
        }
    }

    enum Message {

        REQUEST(1), REPLY(2), RELEASE(3), GRANT(4), INQUIRE(5), FAILED(6), YIELD(7),
        MONITOR(8), END(9);

        public final int id;

        Message(int i) {
            this.id = i;
        }

        int getMessageId() {
            return id;
        }
    }

            main.startThread()
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EXP6NT.class.getName()).log(Level.SEVERE, null, ex);
        }    }
}
