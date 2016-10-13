/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truesecurebetaView;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author HACKER
 */
public class TrueSecureBeta extends JFrame {

    private static JPanel topSectionThinPanel;
    private static JLabel systemStatusLabel;
    private static String systemStatusValue = "Secure";
    private static JTabbedPane tabbedPane;
    

    public TrueSecureBeta() {
        setSize(800, 570);
        setLocation(10, 10);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#8080ff"));
        setTitle("True Secure");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        systemStatusLabel = new JLabel("System Status:"+systemStatusValue);
        topSectionThinPanel = new JPanel(null);
        tabbedPane = new JTabbedPane();
        
        tabbedPane.setBackground(Color.WHITE);
        tabbedPane.setForeground(Color.BLACK);
        tabbedPane.add("Home", new HomeView());
        tabbedPane.add("System Scan", new ScanView());
        tabbedPane.add("Update", new UpdateView());
        tabbedPane.add("History", new HistoryView());
        tabbedPane.add("Software Update", new IDSUpdateView());
        tabbedPane.add("Help", new JPanel());
        
        
        systemStatusLabel.setForeground(Color.WHITE);
        topSectionThinPanel.setBackground(Color.decode("#008000"));
        topSectionThinPanel.setBorder(new LineBorder(Color.decode("#008000")));
        systemStatusLabel.setFont( new Font("Calibri Light",Font.BOLD,18));
        tabbedPane.setBorder( new LineBorder(Color.decode("#8080ff")));
        
        systemStatusLabel.setBounds(10,2,300,25);
        topSectionThinPanel.setBounds(0, 0, 900, 30);
        tabbedPane.setBounds(40,40,730,480);
        
        topSectionThinPanel.add(systemStatusLabel);
        
        add(topSectionThinPanel);
        add(tabbedPane);
     

        repaint();
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
            @Override
            public void run() {
                new TrueSecureBeta();
            }
        }
        );

    }
}
