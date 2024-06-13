package Pack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;












public class Frame3
  extends JFrame
{
  private JPanel contentPane;
  private JTextField textbox3;
  
  public Frame3() {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 800, 600);
    this.contentPane = new JPanel();
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);
    
    this.textbox3 = new JTextField();
    this.textbox3.setFont(new Font("Verdana", 0, 16));
    this.textbox3.setText("");
    this.textbox3.setBounds(295, 352, 328, 37);
    this.contentPane.add(this.textbox3);
    this.textbox3.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("Enter File Name:");
    lblNewLabel.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel.setBounds(92, 359, 180, 30);
    this.contentPane.add(lblNewLabel);
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.LIGHT_GRAY);
    panel.setBounds(0, 0, 782, 169);
    this.contentPane.add(panel);
    panel.setLayout(null);
    
    JLabel lblNewLabel_1 = new JLabel("Packer Unpacker Application");
    lblNewLabel_1.setFont(new Font("Verdana", 0, 26));
    lblNewLabel_1.setBounds(33, 13, 434, 73);
    panel.add(lblNewLabel_1);
    
    JButton button = new JButton("Submit");
    button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Frame3.this.dispose();
            PackUnpack obj = new PackUnpack();
            int ret = obj.Unpack(Frame3.this.textbox3.getText());
            if (ret == -1) {
              
              JOptionPane.showMessageDialog(null, "Incorrect file for unpacking.", "Alert", 2);
            
            }
            else {
              
              JOptionPane.showMessageDialog(null, "File successfully unpacked.", "Alert", 2);
            } 
            
            Frame1 newobj = new Frame1();
            newobj.setVisible(true);
          }
        });
    button.setFont(new Font("Verdana", 1, 18));
    button.setBounds(295, 449, 116, 45);
    this.contentPane.add(button);
  }
}
