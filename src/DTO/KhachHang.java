/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author boixi
 */
public class KhachHang extends JFrame {

    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private InetAddress host;
    private int port;
    public static String sms;
    public static Socket socket;

    public KhachHang(InetAddress host, int port) throws IOException {
        this.socket = new Socket(host, port);
        Init();
        this.host = host;
        this.port = port;
    }

    public KhachHang() {

    }

    public KhachHang(String id, String name, String address, String phoneNumber, InetAddress host, int port) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.host = host;
        this.port = port;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InetAddress getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public KhachHang(String id, String phoneNumber){
        this.id = id;
        this.phoneNumber = phoneNumber;
    }
    public static void main(String[] args) throws UnknownHostException, IOException {
        KhachHang khachHang = new KhachHang(InetAddress.getLocalHost(), 15797);
        khachHang.execute();
    }
    public static javax.swing.JTextArea chatArea = new JTextArea();
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField jTextField1;
    private javax.swing.JLabel status;

    private void Init() {
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jTextField1.setToolTipText("text\tType your message here...");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(10, 370, 410, 40);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException ex) {
                }
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(420, 370, 80, 40);

        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 490, 280);

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Client");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 20, 180, 40);

        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setText("...");
        jPanel1.add(status);
        status.setBounds(10, 50, 300, 40);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(508, 441));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

        //sendMessage(jTextField1.getText());
//        jTextFSocket socketield1.setText("");
//        KhachHang.sms = KhachHang.jTextField1.getText();
//        ReadClient read = new ReadClient(socket);
//        read.start();
//        WriteClient write = new WriteClient(socket);
//        write.start();
//        jTextField1.setText("");
    }

    public void execute() throws IOException {
        KhachHang.sms = KhachHang.jTextField1.getText();
        ReadClient read = new ReadClient(socket);
        read.start();
        WriteClient write = new WriteClient(socket);
        write.start();

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        KhachHang.sms = KhachHang.jTextField1.getText();
        ReadClient read = new ReadClient(socket);
        read.start();
        WriteClient write = new WriteClient(socket);
        write.start();

        jTextField1.setText("");

    }
}

class ReadClient extends Thread {

    private Socket socket;

    public ReadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
//            while (true) {
            String sms = dis.readUTF();
            System.err.println("sms = " + sms);
            if (sms != null || !sms.equals("")) {
                KhachHang.chatArea.setText(KhachHang.chatArea.getText().trim() + "\n" + "Server:\t" + sms);
            }
//            }
        } catch (Exception e) {
            try {
                dis.close();
                socket.close();
            } catch (IOException ex) {
                System.out.println("Ngắt kết nối");
            }
        }
    }
}

class WriteClient extends Thread {

    private Socket socket;

    public WriteClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataOutputStream dos = null;
        Scanner sc = null;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            sc = new Scanner(System.in);
//            while (true) {
//                KhachHang.sms = sc.nextLine();
            if (!KhachHang.sms.trim().equals("")) {
                KhachHang.chatArea.setText(KhachHang.chatArea.getText().trim() + "\n" + "Client:\t" + KhachHang.sms);
                System.err.println(KhachHang.sms.trim().equals("") ? "rong" : "ko rong");

            }
            String sms = KhachHang.sms;// Dang doi server nhap du lieu
            dos.writeUTF(sms);

//            }
        } catch (Exception e) {
            try {
                dos.close();
                socket.close();
            } catch (IOException ex) {
                System.out.println("Ngắt kết nối");
            }
        }
    }

}
