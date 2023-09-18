/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChatSoloTCP;

import java.io.DataInputStream;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class TienTrinhDoc extends Thread {
    private Socket  socket;

    public TienTrinhDoc(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try{
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while(true){
                String sms = dis.readUTF();
                Client.chatArea.setText(Client.chatArea.getText()+"\n"+sms);
                System.err.println("sms = "+ sms);
               
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
