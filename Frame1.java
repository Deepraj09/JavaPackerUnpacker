package Pack;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;




public class Frame1
  extends JFrame
{
  private JPanel contentPane;
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            try {
              Frame1 frame = new Frame1();
              frame.setVisible(true);
            } catch (Exception e) {
              e.printStackTrace();
            } 
          }
        });
  }




  
  public Frame1() {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 800, 600);
    this.contentPane = new JPanel();
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);
    
    JButton button1 = new JButton("Pack");
    button1.setFont(new Font("Verdana", 1, 18));
    button1.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            Frame1.this.dispose();
            Frame2 obj = new Frame2();
            obj.setVisible(true);
          }
        });

    
    button1.setBounds(193, 325, 135, 46);
    this.contentPane.add(button1);
    
    JButton button2 = new JButton("Unpack");
    button2.setFont(new Font("Verdana", 1, 18));
    button2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Frame1.this.setVisible(false);
            Frame3 obj = new Frame3();
            obj.setVisible(true);
          }
        });
    
    button2.setBounds(454, 325, 122, 46);
    this.contentPane.add(button2);
    
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setBounds(0, 0, 782, 169);
    this.contentPane.add(panel);
    
    JLabel label = new JLabel("Packer Unpacker Application");
    label.setFont(new Font("Verdana", 1, 26));
    label.setBounds(33, 13, 434, 73);
    panel.add(label);
  }
}
