**
 *
 * @author gloria
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class invoice_system {
    JFrame frame= new JFrame("INVOICE SYSTEM");
    JPanel p1= new JPanel(new FlowLayout());
    JPanel p2= new JPanel(new GridLayout(4,2,15,60));
    JPanel p3= new JPanel(new GridLayout(1,2,15,60));
    JLabel lblhead= new JLabel("OOK SUPERMARKET");
    JLabel sub= new JLabel("SubTotal");
    JLabel discount= new JLabel("Discount Amount");
    JLabel total= new JLabel("Total Due");
    JTextField t1= new JTextField();
    JTextField t2= new JTextField();
    JTextField t3= new JTextField();
    JButton process= new JButton("Process");
    JButton clear= new JButton("Clear");
    JButton exit= new JButton("Exit");
    
    public void drawAndShowGUI() {
        p1.add(lblhead);
        p2.add(sub);
        p2.add(t1);
        p2.add(discount);
        p2.add(t2);
        p2.add(total);
        p2.add(t3);
    p3.add(process);
    process.addActionListener(new Process());
    p3.add(clear);
    clear.addActionListener(new Clear());
    p3.add(exit);
    exit.addActionListener(new Exit());
    
    frame.getContentPane().add(p1);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setSize(350,350);
    frame.setLocation(250,300);
    frame.setVisible(true);
    
    frame.add(p1,BorderLayout.NORTH);
    frame.add(p2,BorderLayout.CENTER);
    frame.add(p3,BorderLayout.SOUTH);
    
}
  
    private class Process implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            double sub, discount = 0, total;
            sub= Double.parseDouble(t1.getText());
            if(sub<100){
            discount= 0* sub;
            }
            else
            if(sub>100 &&sub<1000){
                    discount=0.3*sub;
                    
                    }
            else
                if(sub>1000){
                discount=0.5*sub;
                }
            String discounts= String.valueOf(discount);
            t2.setText(discounts);
            total=sub-discount;
            String totals= String.valueOf(total);
            t3.setText(totals);
            
        }
    }
        private class Clear implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                t1.setText("");
                t2.setText("");
                t3.setText("");
            }
        }
        private class Exit implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
                
            }
        
    }
    
}
