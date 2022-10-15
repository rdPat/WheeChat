/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wheechat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;  
import java.net.*;
import java.io.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;




/**
 *
 * @author rampa
 */
public class WheeClient  implements ActionListener, KeyListener {
    
    JTextField text;
    static JPanel TextBlank;
    static  Box vertical=Box.createVerticalBox();
    static DataOutputStream dos;
    static JFrame fr=new JFrame();
    
    WheeClient(){
        
        fr.setLayout(null);
        
        JPanel pl=new JPanel();
        pl.setBackground(new Color(225, 48, 108));
        pl.setBounds(0,0,465,75);
        pl.setLayout(null);
        fr.add(pl);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2= i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel back=new JLabel(i3);
        back.setBounds(5,20,25,25);
        pl.add(back);

        back.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent ae){
            new LogOutSession();
            System.exit(0);
            
        }
        });
        
        ImageIcon j1=new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image j2=j1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon j3=new ImageIcon(j2);
        JLabel dp=new JLabel(j3);
        dp.setBounds(50, 10, 50,50);
        pl.add(dp);
        
        JLabel name=new JLabel("UserTwo");
        name.setBounds(120, 12, 100,18);
        name.setForeground(new Color(26, 255, 163));
        name.setFont(new Font("SAN_SERIF",Font.BOLD,22));
        pl.add(name);
        
        JLabel status=new JLabel("Online");
        status.setBounds(120, 37, 100,15);
        status.setForeground(Color.white);
        status.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        pl.add(status);
        
        ImageIcon k1=new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image k2= k1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon k3=new ImageIcon(k2);
        JLabel moreoption=new JLabel(k3);
        moreoption.setBounds(390,20,30,30);
        pl.add(moreoption);
        
        moreoption.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent ae){
            System.exit(0);
        }
        });
        
        TextBlank =new JPanel();
        TextBlank.setBounds(0,76,463,837);
        TextBlank.setBackground(new Color(203, 242, 242));
        fr.add(TextBlank);
        
        
        text=new JTextField();                      
        text.setBounds(7,915,357,55);
        text.setFont(new Font("SAN_SERIF",Font.ITALIC,18));
        fr.add(text);
        
        JButton send=new JButton(">");
        send.setFont(new Font("SAN_SERIF",Font.BOLD,38));
        send.setForeground(new Color(39, 227, 89));
        send.setBounds(365,915,85,55);
        send.setBackground(Color.white);
        fr.add(send); 
        
        text.addActionListener(this);          
        send.addActionListener(this);
        send.addKeyListener(this);
        
        fr.setSize(465,975);
        fr.setLocation(875,45);
        fr.getContentPane().setBackground(Color.LIGHT_GRAY);
        fr.setUndecorated(true);
        
        fr.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
        String out=text.getText();
       
        JPanel p2;
        p2 = formatLabel(out);
        p2.setBackground(new Color(132, 140, 207));
        
        TextBlank.setLayout(new BorderLayout());
        JPanel right=new JPanel(new BorderLayout());
        right.add(p2,BorderLayout.LINE_END);
        vertical.add(right);
        
        vertical.add(Box.createVerticalStrut(15));
        TextBlank.add(vertical,BorderLayout.PAGE_START);
        dos.writeUTF(out);
        
        text.setText("");
        fr.repaint();
        fr.invalidate();
        fr.validate();
        }
        catch(Exception e){
            System.out.println("ÄctionPerformedMethodException");
        }
        
    }
    
  
    public static void main(String args[]){
        new WheeClient();
        
        try{
            Socket s=new Socket("127.0.0.1",6001);
            DataInputStream  dis =new DataInputStream(s.getInputStream());
            dos=new DataOutputStream(s.getOutputStream());
            while(true){
                    TextBlank.setLayout(new BorderLayout());
                    String msg=dis.readUTF();
                    JPanel p;
                    p = formatLabel(msg);
                    JPanel lside=new JPanel(new BorderLayout());
                    lside.add(p,BorderLayout.LINE_START);
                    vertical.add(lside);
                    vertical.add(Box.createVerticalStrut(15));
                    TextBlank.add(vertical,BorderLayout.PAGE_START);
                
                    fr.validate();
                    
                }
        }
        catch(Exception e){
            System.out.println("InsideClientConstructorSocketException"+e);
        }
        
    }

    private static  JPanel formatLabel(String out) {
        
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel output=new JLabel("<html><p style=\"width:220px\">"+out+"</p></html>");
        output.setFont(new Font("SAN_SERIF",Font.ITALIC,22));
        output.setForeground(Color.black);
        output.setBorder(new EmptyBorder(10,10,10,45));
        panel.add(output);
        Calendar cal = Calendar.getInstance(); 
        SimpleDateFormat sdf=new SimpleDateFormat("hh.mm aa");
        JLabel time =new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try{
        String out=text.getText();
               
        JPanel p2;
        p2 = formatLabel(out);
        p2.setBackground(new Color(132, 140, 207));
        
        TextBlank.setLayout(new BorderLayout());
        JPanel right=new JPanel(new BorderLayout());
        right.add(p2,BorderLayout.LINE_END);
        vertical.add(right);
        
        vertical.add(Box.createVerticalStrut(15));
        TextBlank.add(vertical,BorderLayout.PAGE_START);
        dos.writeUTF(out);
        
        text.setText("");
        fr.repaint();
        fr.invalidate();
        fr.validate();
        }
        catch(Exception je){
            System.out.println("EnterKeyPressedException"+je);
        }
    }

    
    
    
}
