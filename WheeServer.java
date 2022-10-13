
package wheechat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;  

/**
 *
 * @author rampa
 */
public class WheeServer extends JFrame implements ActionListener {
    
    JTextField text;
    JPanel TextBlank;
    Box vertical=Box.createVerticalBox();
    
    WheeServer(){
        
        setLayout(null);
        
        JPanel pl=new JPanel();
        pl.setBackground(new Color(7,94,84));
        pl.setBounds(0,0,465,75);
        pl.setLayout(null);
        add(pl);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2= i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel back=new JLabel(i3);
        back.setBounds(5,20,25,25);
        pl.add(back);
        
        back.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent ae){
            System.exit(0);
        }
        });
        
        ImageIcon j1=new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image j2=j1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon j3=new ImageIcon(j2);
        JLabel dp=new JLabel(j3);
        dp.setBounds(50, 10, 50,50);
        pl.add(dp);
        
        JLabel name=new JLabel("UserOne");
        name.setBounds(120, 12, 100,18);
        name.setForeground(Color.red);
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
        TextBlank.setBounds(0,76,457,598);
        TextBlank.setBackground(Color.LIGHT_GRAY);
        add(TextBlank);
        
        
        text=new JTextField();                      //task 1 :placeholder needed 
        text.setBounds(10,675,350,50);
        text.setFont(new Font("Monospace",Font.BOLD,18));
        add(text);
        
        JButton send=new JButton(">");
        send.setFont(new Font("SAN_SERIF",Font.BOLD,38));
        send.setForeground(Color.blue);
        send.setBounds(360,675,85,50);
        send.setBackground(Color.PINK);
        add(send);
        send.addActionListener(this);
        
        
        
                
        setSize(475,775);
        setLocation(300,100);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String out=text.getText();
       
        
        JPanel p2;
        p2 = formatLabel(out);
        p2.setBackground(Color.yellow);
        
        TextBlank.setLayout(new BorderLayout());
        JPanel right=new JPanel(new BorderLayout());
        right.add(p2,BorderLayout.LINE_END);
        vertical.add(right);
        
        vertical.add(Box.createVerticalStrut(15));
        TextBlank.add(vertical,BorderLayout.PAGE_START);
        text.setText("");
        repaint();
        invalidate();
        validate();
        
    }
    
  
    
   
    
    public static void main(String args[]){
        new WheeServer();
    }

    private JPanel formatLabel(String out) {
        
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel output=new JLabel("<html><p style=\"width:150px\">"+out+"</p></html>");
        output.setFont(new Font("Monospace",Font.BOLD,25));
        output.setForeground(Color.blue);
        output.setBorder(new EmptyBorder(15,15,15,50));
        panel.add(output);
        Calendar cal = Calendar.getInstance(); 
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        JLabel time =new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        
        return panel;
        
                 
    }
    
   

    
    
    
}
