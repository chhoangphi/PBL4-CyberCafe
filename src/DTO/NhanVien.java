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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author TRI
 */
public class NhanVien extends JFrame {

    private String id;
    private String username;
    private String password;
    public static String name;
    private String date;
    private String position;
    private String email;
    private String address;
    private String phoneNumber;
    private double luongCoDinh = 5000000;
    private int port;
    public static ArrayList<Socket> listSocket;
    public static String sms;

    public NhanVien() {
    }

    public NhanVien(int port) throws IOException {
        Init();
        this.port = port;
    }

    public NhanVien(String id, String username, String password, String name, String date, String position, String email, String address, String phoneNumber, int port) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.date = date;
        this.position = position;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.port = port;
    }

    public static void main(String[] args) throws IOException {
        NhanVien.listSocket = new ArrayList<>();
        NhanVien nhanVien = new NhanVien(15797);
        nhanVien.execute();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLuongCoDinh() {
        return luongCoDinh;
    }

    public void setLuongCoDinh(double luongCoDinh) {
        this.luongCoDinh = luongCoDinh;
    }

    public int getPort() {
        return port;
    }

    public static ArrayList<Socket> getListSocket() {
        return listSocket;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(102, 255, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 480, 250);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(10, 350, 400, 40);

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButton1.setText("Send");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(410, 350, 80, 40);

        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setText("...");
        jPanel1.add(status);
        status.setBounds(10, 60, 300, 40);

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("Server");
        jLabel2.setToolTipText("");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 10, 190, 60);

        jLabel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 35, 460, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(500, 427));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

//        NhanVien.sms = NhanVien.jTextField1.getText();
////        NhanVien.jTextField1.setText("");
//        WriteServer write = new WriteServer();
//        write.start();
//        for (Socket item : NhanVien.listSocket) {
//            ReadServer read = new ReadServer(item);
//            read.start();
//        }
    }

    public void execute() throws IOException {
        ServerSocket server = new ServerSocket(port);
//        WriteServer write = new WriteServer();
//        write.start();
        System.out.println("Server is listening");
        while (true) {
            Socket socket = server.accept();
            System.out.println("Đã kết nối với " + socket);
            NhanVien.listSocket.add(socket);
            //Read client thì nhiều client nhắn tới server nhưng
            //server sẽ ko phân phát đi tất cả client
            // ReadClient read = new ReadClient(socket);
            //Read server thì nhiều client nhắn tới server và
            //server sẽ  phân phát đi tất cả client
//            ReadServer read = new ReadServer(socket);
//            read.start();
            WriteServer write = new WriteServer();
            write.start();
            for (Socket item : NhanVien.listSocket) {
                ReadServer read = new ReadServer(item);
                read.start();
            }
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        //String sms = NhanVien.jTextField1.getText().trim();
        NhanVien.sms = NhanVien.jTextField1.getText();
        WriteServer write = new WriteServer();
        write.start();
//        write.stop();
        for (Socket item : NhanVien.listSocket) {
            ReadServer read = new ReadServer(item);
            read.start();
//            read.stop();
        }
        NhanVien.jTextField1.setText("");

    }

}

class ReadServer extends Thread {

    private Socket socket;

    public ReadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
//            while (true) {
            String sms = dis.readUTF();
            if (sms.contains("exit")) {
                NhanVien.listSocket.remove(socket);
                System.out.println("Da ngat ket noi voi " + socket);
                dis.close();
                socket.close();
//                    continue;
            }
            for (Socket item : NhanVien.listSocket) {
                if (item.getPort() != socket.getPort()) {
                    DataOutputStream dos = new DataOutputStream(item.getOutputStream());
                    dos.writeUTF(sms);
                }
            }
            System.err.println("sms = " + sms);
            if (!sms.trim().equals("")) {
                NhanVien.chatArea.setText(NhanVien.chatArea.getText().trim() + "\n" + "Client:\t" + sms);
                System.err.println(sms.trim().equals("") ? "rong" : "ko rong");
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

class WriteServer extends Thread {

    @Override
    public void run() throws NullPointerException {
        DataOutputStream dos = null;
        Scanner sc = new Scanner(System.in);
//        while (true) {
//            NhanVien.sms = sc.nextLine();
//            NhanVien.sms = NhanVien.jTextField1.getText();
        if (NhanVien.sms != null || !NhanVien.sms.equals("")) {
            NhanVien.chatArea.setText(NhanVien.chatArea.getText().trim() + "\n" + "Server:\t" + NhanVien.sms);
        }
        String sms = NhanVien.sms;// Dang doi server nhap du lieu
        try {
            for (Socket item : NhanVien.listSocket) {
                dos = new DataOutputStream(item.getOutputStream());
                dos.writeUTF(sms);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.err.println("sms = " + sms);
//        }
    }

}
