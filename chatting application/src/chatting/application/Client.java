package chatting.application;

import javax.swing.*;
import javax.swing.border.*;               //child of swing
import java.awt.*;
import java.awt.event.*;
import java.util.*;                       //to import calendar class
import java.text.*;                           // to import calendar in text like simple date
import java.net.*;
import java.io.*;


public class Client implements ActionListener {    // JFrame comes under swing  //actionlistener interface is in awt event
    
    
    JTextField text;       // gloabally represnt so can access on other function
    static JPanel a1;                 // gloabally represnt so can access on other function
    static Box vertical = Box.createVerticalBox();    // gloabally represnt so can access on other function
   
    static JFrame f = new JFrame();
    
    static DataOutputStream dout;
    
    
    Client() {
        
        f.setLayout(null);
        
        JPanel p1 = new JPanel();    // used to work on frame
        p1.setBackground(new Color(7, 94, 84));   // bg of pane i,e, green
        p1.setBounds(0, 0, 450, 70);     //size of pane used bcz layout is null we put
        p1.setLayout(null);  
        f.add(p1);  // add used to put on something
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));  // image iscon class used to put some image
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT); // image class is in awt
        ImageIcon i3 = new ImageIcon(i2);    // used bcs actual img is i2 we cannnot ditectly pass it in jlabel
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);  //size of image
        p1.add(back);  // used to put image on panel
        
        back.addMouseListener(new MouseAdapter () {        //addmouselistener used to get mouse clicked function to get exit from  frame
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));  // image iscon class used to put some image
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); // image class is in awt
        ImageIcon i6 = new ImageIcon(i5);    // used bcs actual img is i2 we cannnot ditectly pass it in jlabel
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 10, 50, 50);  // image from top & bottom distancr and size of image
        p1.add(profile);  // used to put image on panel
        
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));  // image iscon class used to put some image
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); // image class is in awt
        ImageIcon i9 = new ImageIcon(i8);    // used bcs actual img is i2 we cannnot ditectly pass it in jlabel
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 30, 30);  // image from top & bottom distancr and size of image
        p1.add(video);  // used to put image on panel
        
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));  // image iscon class used to put some image
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT); // image class is in awt
        ImageIcon i12 = new ImageIcon(i11);    // used bcs actual img is i2 we cannnot ditectly pass it in jlabel
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 20, 35, 30);  // image from top & bottom distancr and size of image
        p1.add(phone);  // used to put image on panel
        
        
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));  // image iscon class used to put some image
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT); // image class is in awt
        ImageIcon i15 = new ImageIcon(i14);    // used bcs actual img is i2 we cannnot ditectly pass it in jlabel
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(420, 20, 10, 25);  // image from top & bottom distancr and size of image
        p1.add(morevert); // used to put image on panel
        
        JLabel name = new JLabel("Neetu");              // jlabel used to write anything on frame
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);
       
        
        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(status);
        
        
        a1 = new JPanel();                        //this panel is for messages
        a1.setBounds(5, 75, 440, 420);
        f.add(a1);
        
        text = new JTextField();            //used to write smessage fiel area
        text.setBounds(5, 500, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text);
        
        JButton send = new JButton("Send");   //used for send button
        send.setBounds(320, 500, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(send);
      
        
        f.setSize(450, 550);      // size of frame
        f.setLocation(700, 30);          // location of frame
        f.setUndecorated(true);     // to remove header of frame cross , minimise and all
        f.getContentPane().setBackground(Color.WHITE);   //bg of frame
        f.setVisible(true);                // visibility of frame
    }
        
    
    public void actionPerformed(ActionEvent ae){
        try{
            
        
        String out = text.getText();           //used to send messgae that is written
       
        
        JPanel p2 = formatLabel(out);
       
        a1.setLayout(new BorderLayout());
        
        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);          //line end to display mssg at end of line
        vertical.add(right);                                  //means it comes verticallu one after the other
        vertical.add(Box.createVerticalStrut(15));      //15 space b/w mssgs one other
        
        a1.add(vertical, BorderLayout.PAGE_START);
        
        dout.writeUTF(out);
        
        text.setText("");
        
        f.repaint();
        f.invalidate();
        f.validate();
        
        
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");    //styling in mssgs with width
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));   //mssg font style
        output.setBackground(new Color(37, 211, 102));        //mssg background
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        
        
        panel.add(output);
        
        Calendar cal =  Calendar.getInstance();           //present in calender
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));         //to set current time settext is used
        
        
        panel.add(time);
        
        return panel;
    }
    public static void main(String[] args) {
        new Client();
        
        
        try{
            
            Socket s = new Socket("127.0.0.1", 6001);  //127 is local host bcz running on llocal host and 6001 is server
            DataInputStream din = new DataInputStream(s.getInputStream()); //to receive mssgs used
            dout = new DataOutputStream(s.getOutputStream());   //used to send mssgs
            
            
             while(true){
                 a1.setLayout(new BorderLayout());
                    String msg = din.readUTF();    //to read mssg from clent
                    JPanel panel = formatLabel(msg);
                    
                    
                    JPanel left = new JPanel(new BorderLayout());                //to show received mssgs
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    
                    
                    vertical.add(Box.createVerticalStrut(15));
                    a1.add(vertical, BorderLayout.PAGE_START);   // to display rescived mssgs
                    
                    f.validate();
                }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
