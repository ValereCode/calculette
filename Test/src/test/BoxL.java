/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author setod
 */
public class BoxL extends JFrame {
    
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();
    
    public BoxL() {
        this.setTitle("Le BoxLayout");
        this.setSize(1600, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
        
        p1.add(new JButton("a"));
         
       p2.setLayout(new BoxLayout(p2, BoxLayout.LINE_AXIS));
       p2.add(new JButton("b"));
       p2.add(new JButton("c"));
       
       p3.setLayout(new BoxLayout(p3, BoxLayout.LINE_AXIS));
       p3.add(new JButton("d"));
       p3.add(new JButton("e"));
       p3.add(new JButton("f"));
        
       p4.setLayout(new BoxLayout(p4, BoxLayout.PAGE_AXIS));
       p4.add(p1);
       p4.add(p2);
       p4.add(p3);
       
       this.setContentPane(p4);
       this.setVisible(true);
                     
    }
}
