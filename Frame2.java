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






public class Frame2
  extends JFrame
{
  private JPanel contentPane;
  private JTextField textbox1;
  private JTextField textbox2;
  private JLabel lblEnterDirectory;
  private JLabel lblEnterOutputFile;
  private JButton btnSubmit;
  private JPanel panel;
  private JLabel label;
  
  public Frame2() {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 800, 600);
    this.contentPane = new JPanel();
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(null);
    
    this.textbox1 = new JTextField();
    this.textbox1.setFont(new Font("Verdana", 0, 16));
    this.textbox1.setBounds(342, 242, 167, 35);
    this.contentPane.add(this.textbox1);
    this.textbox1.setColumns(10);
    
    this.textbox2 = new JTextField();
    this.textbox2.setFont(new Font("Verdana", 0, 16));
    this.textbox2.setBounds(342, 310, 167, 35);
    this.contentPane.add(this.textbox2);
    this.textbox2.setColumns(10);
    
    this.lblEnterDirectory = new JLabel("Enter Directory:");
    this.lblEnterDirectory.setFont(new Font("Tahoma", 0, 18));
    this.lblEnterDirectory.setBounds(164, 242, 140, 45);
    this.contentPane.add(this.lblEnterDirectory);
    
    this.lblEnterOutputFile = new JLabel("Enter Output File :");
    this.lblEnterOutputFile.setFont(new Font("Tahoma", 0, 18));
    this.lblEnterOutputFile.setBounds(164, 313, 159, 45);
    this.contentPane.add(this.lblEnterOutputFile);
    
    this.btnSubmit = new JButton("Submit");
    this.btnSubmit.setFont(new Font("Verdana",1, 18));
    this.btnSubmit.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            Frame2.this.dispose();
            PackUnpack newobj = new PackUnpack();
            int i = newobj.Pack(Frame2.this.textbox1.getText(), Frame2.this.textbox2.getText());
            if (i == -2)
            {
              JOptionPane.showMessageDialog(null, "Directory not found.", "Alert", 2);
            }
            Frame1 obj = new Frame1();
            obj.setVisible(true);
          }
        });
    this.btnSubmit.setBounds(315, 392, 116, 45);
    this.contentPane.add(this.btnSubmit);
    
    this.panel = new JPanel();
    this.panel.setLayout(null);
    this.panel.setBackground(Color.LIGHT_GRAY);
    this.panel.setBounds(0, 0, 782, 169);
    this.contentPane.add(this.panel);
    
    this.label = new JLabel("Packer Unpacker Application");
    this.label.setFont(new Font("Verdana", 1, 26));
    this.label.setBounds(33, 13, 434, 73);
    this.panel.add(this.label);
  }
}
