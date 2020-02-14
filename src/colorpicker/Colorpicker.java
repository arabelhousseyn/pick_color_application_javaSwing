
package colorpicker;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Locale;

public class Colorpicker extends JFrame {
    JFrame win;
    JLabel red_title;
    JLabel green_title;
    JLabel blue_title;
    JScrollBar red_scroll;
    JScrollBar green_scroll;
    JScrollBar blue_scroll;
    JPanel pane;
    JLabel values;
    JMenuBar menu;
    JMenu m;
    JMenuItem item;
    public Colorpicker(){
        comp();
    }
    private void comp()
    {
        win = new JFrame();
        win.setTitle("color picker");
        win.setVisible(true);
        win.setLayout(null); 
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(600, 300);
        win.setResizable(false);
        win.setLocationRelativeTo(null);
        
        ////////////////////////////////////////
        red_title = new JLabel("RED");
        green_title = new JLabel("green");
        blue_title = new JLabel("blue");
        
        red_title.setBounds(40,40,120,20);
        green_title.setBounds(40, 80, 120, 20);
        blue_title.setBounds(40, 120, 120, 20);
        
        win.add(red_title);
        win.add(green_title);
        win.add(blue_title);
        ///////////////////////////////////////
        red_scroll = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);
        green_scroll = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);
        blue_scroll = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 256);

        red_scroll.setBounds(80, 40, 300, 20);
        red_scroll.setBackground(Color.red);
        green_scroll.setBounds(80, 80, 300, 20);
        green_scroll.setBackground(Color.GREEN);
        blue_scroll.setBounds(80, 120, 300, 20);
        blue_scroll.setBackground(Color.BLUE);
        win.add(red_scroll);
        win.add(green_scroll);
        win.add(blue_scroll);
        
        //////////////////////////////////////////////////
        
       pane = new JPanel();
       pane.setBackground(Color.BLACK);
       pane.setBounds(430, 50, 90, 90);
       
       win.add(pane);
       
       //////////////////////////////////////////////////////////
        
        values = new JLabel("Color value : 0,0,0");
        values.setBounds(400, 150, 300, 20);
        
        win.add(values);
        
        //////////////////////////////////////////////////////////
        menu = new JMenuBar();
        m = new JMenu("Edit");
        item = new JMenuItem("add new Color ");
        menu.add(m);
        m.add(item);
        win.setJMenuBar(menu);
        
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    JTextField rg1 = new JTextField();
                JTextField rg2 = new JTextField();
                JTextField rg3 = new JTextField();
               String in1 = JOptionPane.showInputDialog(rg1, "RGB color 1 ", "pick", JOptionPane.INFORMATION_MESSAGE);
               String in2 = JOptionPane.showInputDialog(rg2, "RGB color 2 ", "pick", JOptionPane.INFORMATION_MESSAGE);
               String in3 = JOptionPane.showInputDialog(rg3, "RGB color 3 ", "pick", JOptionPane.INFORMATION_MESSAGE);
               switch(JOptionPane.OK_CANCEL_OPTION)
               {
                   case JOptionPane.CANCEL_OPTION :System.exit(0);break;
               }
               int color1 = Integer.parseInt(in1);
               int color2 = Integer.parseInt(in2);
               int color3 = Integer.parseInt(in3);
                Color c = new Color(color1,color2,color3);
                pane.setBackground(c);
                red_scroll.setValue(color1);
                green_scroll.setValue(color2);
                blue_scroll.setValue(color3);
                values.setText("Color value :" +" "+color1+  " " + color2+" "+ color3 + " " +"RGB");
                }catch(Exception value){
                    JOptionPane.showMessageDialog(null, "you cannot enter a characters", "Error", JOptionPane.ERROR_MESSAGE);
                }
 
            }
        });
        //////////////// functions 
        AdjustmentListener al = new AdjustmentListener(){
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Color c = new Color(red_scroll.getValue(),green_scroll.getValue(),blue_scroll.getValue());
                pane.setBackground(c);
                values.setText("Color value :" +" "+red_scroll.getValue() +  " " + green_scroll.getValue() +" "+ blue_scroll.getValue() + " " +"RGB");
                
            }
        };
        
        red_scroll.addAdjustmentListener(al);
        green_scroll.addAdjustmentListener(al);
        blue_scroll.addAdjustmentListener(al);
        
        
        
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               new Colorpicker(); 
            }
        });
    }
    
}
