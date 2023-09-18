/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChatSoloTCP;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TienTrinhGhi implements Runnable {

    private Socket socket;

    public TienTrinhGhi(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String sms = sc.nextLine();
                if (sms.equalsIgnoreCase("exit")) {
                    socket.close();
                }
                Client.chatArea.setText(sms);
                dos.writeUTF(sms);
                dos.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }

}
