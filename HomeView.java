/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truesecurebetaView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author HACKER
 */
public class HomeView extends JPanel {

    private static JPanel rightSidePanel;
    private static JPanel leftSidePanel;
    private static JLabel imageLabel;
    private static JLabel statementOneLabel;
    private static JLabel statementTwoLabel;
    private static JRadioButton realTimeProtectionRadioButton;
    private static JRadioButton malwareDetectionRadioButton;
    private static JRadioButton spywareDefinitionRadioButton;
    private static JLabel scanOptionLabel;
    private static JRadioButton quickScanRadioButton;
    private static JRadioButton fullScanRadioButton;
    private static JRadioButton customeScanRadioButton;
    private static JButton scanNowButton;
    private static JButton aboutButton;
    private static JLabel copyrightDeclarationLabel;
    
    private static BufferedImage bgImage;

    public HomeView() {

        setSize(730, 480);
        setLocation(40, 40);
        setLayout(null);
        setBackground(Color.WHITE);

        bgImage = getBufferedImage("secureIcon.png");
        rightSidePanel = new JPanel(null);
        leftSidePanel = new JPanel(null);
        imageLabel = new JLabel(new ImageIcon(bgImage));
        scanOptionLabel = new JLabel("Scan Options");
        statementOneLabel = new JLabel("Virus and Spyware ultimate");
        statementTwoLabel = new JLabel("Security");
        realTimeProtectionRadioButton = new JRadioButton("Realtime protection ");
        malwareDetectionRadioButton = new JRadioButton("Malware detection and Cleaning ");
        spywareDefinitionRadioButton = new JRadioButton("Spyware definition ");
        quickScanRadioButton = new JRadioButton("Quick Scan");
        fullScanRadioButton = new JRadioButton("Full Scan");
        customeScanRadioButton = new JRadioButton("Custom Scan");

        aboutButton = new JButton("About");
        copyrightDeclarationLabel = new JLabel("(c)Copyright Samuel Owino Omondi,2016");
        scanNowButton = new JButton("Scan now");

        rightSidePanel.setBounds(500, 10, 215, 390);
        leftSidePanel.setBounds(10, 10, 500, 390);
        aboutButton.setBounds(10, 410, 100, 25);
        copyrightDeclarationLabel.setBounds(150,410,300,25);
        imageLabel.setBounds(5, 5, 150, 130);
        realTimeProtectionRadioButton.setBounds(5, 150, 300, 25);
        malwareDetectionRadioButton.setBounds(5, 190, 300, 25);
        spywareDefinitionRadioButton.setBounds(5, 230, 300, 25);
        statementOneLabel.setBounds(170, 5, 300, 25);
        statementTwoLabel.setBounds(170, 30, 300, 25);
        scanOptionLabel.setBounds(10, 10, 300, 25);
        quickScanRadioButton.setBounds(30, 50, 150, 25);
        fullScanRadioButton.setBounds(30, 90, 150, 25);
        customeScanRadioButton.setBounds(30, 130, 150, 25);
        scanNowButton.setBounds(30,200,150,30);

        rightSidePanel.setBorder(new LineBorder(Color.black));
        leftSidePanel.setBorder(new LineBorder(Color.black));
        aboutButton.setBorder(new LineBorder(Color.decode("#1e90ff")));
        imageLabel.setBorder(new LineBorder(Color.black));
        rightSidePanel.setBackground(Color.WHITE);
        leftSidePanel.setBackground(Color.WHITE);

        aboutButton.setBackground(Color.decode("#1e90ff"));
        aboutButton.setForeground(Color.WHITE);
        statementOneLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        statementTwoLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        statementOneLabel.setForeground(Color.decode("#008000"));
        statementTwoLabel.setForeground(Color.decode("#008000"));
        scanOptionLabel.setForeground(Color.decode("#008000"));
        scanOptionLabel.setFont( new Font("Calibri",Font.BOLD,16));
        scanNowButton.setBackground(Color.decode("#1e90ff"));
        scanNowButton.setForeground(Color.white);
        copyrightDeclarationLabel.setForeground(Color.decode("#008000"));

        List<JRadioButton> radioButtons = Arrays.asList(
                malwareDetectionRadioButton, realTimeProtectionRadioButton, spywareDefinitionRadioButton,
                quickScanRadioButton, fullScanRadioButton, customeScanRadioButton
        );

        List<JRadioButton> rightSidePanelRadioButton = Arrays.asList(
                quickScanRadioButton, fullScanRadioButton, customeScanRadioButton
        );

        setradioButtonsProperties(radioButtons);
        setRightSideRadioButtonsProperties(rightSidePanelRadioButton);

        rightSidePanel.add(scanOptionLabel);
        rightSidePanel.add(scanNowButton);

        leftSidePanel.add(imageLabel);
        leftSidePanel.add(statementOneLabel);
        leftSidePanel.add(statementTwoLabel);

        add(rightSidePanel);
        add(leftSidePanel);
        add(aboutButton);
        add(copyrightDeclarationLabel);
    }

    /**
     *Obtains bufferdImage from fileName
     * @param fileName
     * @return
     */
    public final BufferedImage getBufferedImage(String fileName) {
        try {
            BufferedImage bufferedImage = null;
            bufferedImage = ImageIO.read(getClass().getResource("/appimages/"+fileName));
            return bufferedImage;
        } catch (IOException e) {
            return new BufferedImage(0,0,0);
        }
    }

    public final void setRightSideRadioButtonsProperties(List<JRadioButton> radioButtons) {
        radioButtons.stream()
                .forEach(e -> {
                    e.setSelected(true);
                    rightSidePanel.add(e);
                    e.setBackground(Color.WHITE);
                    e.setForeground(Color.decode("#1e90ff"));
                    e.setFont(new Font("Calibri", Font.BOLD, 18));
                    e.addActionListener(event -> {
                        if (e.isSelected()) {
                            e.setForeground(Color.decode("#1e90ff"));
                        } else if (!(e.isSelected())) {
                            e.setForeground(Color.decode("#8c8c8c"));
                        }
                    });
                    e.addMouseListener(
                            new MouseAdapter(){
                                @Override
                                public void mouseEntered(MouseEvent event){
                                    e.setBackground(Color.decode("#e6faff"));
                                }
                                @Override
                                public void mouseExited(MouseEvent event){
                                    e.setBackground(Color.WHITE);
                                }
                            }
                    );
                });
    }

    public final void setradioButtonsProperties(List<JRadioButton> radioButtons) {
        radioButtons.stream()
                .forEach(e -> {
                    e.setSelected(true);
                    leftSidePanel.add(e);
                    e.setBackground(Color.WHITE);
                    e.setForeground(Color.decode("#1e90ff"));
                    e.setFont(new Font("Calibri", Font.BOLD, 18));
                    e.addActionListener(event -> {
                        if (e.isSelected()) {
                            e.setForeground(Color.decode("#1e90ff"));
                        } else if (!(e.isSelected())) {
                            e.setForeground(Color.decode("#8c8c8c"));
                        }
                    });
                    e.addMouseListener(
                            new MouseAdapter(){
                                @Override
                                public void mouseEntered(MouseEvent event){
                                    e.setBackground(Color.decode("#e6faff"));
                                }
                                @Override
                                public void mouseExited(MouseEvent event){
                                    e.setBackground(Color.WHITE);
                                }
                            }
                    );
                });
    }
}
