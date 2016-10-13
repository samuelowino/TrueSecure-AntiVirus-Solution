/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truesecurebetaView;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author HACKER
 */
public class UpdateView extends JPanel {

    private static IDSUpdateView iDSUpdateView;
    private static JPanel topSectionPanel;
    private static JPanel bottomSectionPane;

    private static JLabel enableCheckLabel;
    private static JLabel statementOneLabel;
    private static JLabel statementTwoLabel;
    private static JLabel definationInstallationLabel;
    private static JLabel definationInstallationDate;
    private static JLabel definitionLastUpdateLabel;
    private static JLabel definitionLastUpdateDateLabel;
    private static JLabel virusDefinitionversionLabel;
    private static JLabel virusDefinitionVersionValue;
    private static JLabel spywareDefintionVersion;
    private static JLabel spywareDefinitionVersionValueLabel;

    private static JButton updateDefinitionButton;

    private static JLabel rememberLabel;
    private static JLabel tipStatementOneLabel;
    private static JLabel tipStatementTwoLabel;
    private static JLabel tipStatmentThreeLabel;

    private static LocalDate localDate;

    public UpdateView() {

        setSize(730, 480);
        setLocation(40, 40);
        setLayout(null);
        setBackground(Color.WHITE);

        localDate = LocalDate.now();
        topSectionPanel = new JPanel();
        bottomSectionPane = new JPanel(null);
        iDSUpdateView = new IDSUpdateView();
        updateDefinitionButton = new JButton("Update Definition");
        statementOneLabel = new JLabel("Virus and malware protection is enabled");
        statementTwoLabel = new JLabel("Your system is using our latest definition so you are safe.");
        definationInstallationLabel = new JLabel("Definition installation on:");
        definationInstallationDate = new JLabel(localDate.toString());
        definitionLastUpdateLabel = new JLabel("Definition last updated on:");
        definitionLastUpdateDateLabel = new JLabel(localDate.toString());
        virusDefinitionVersionValue = new JLabel("1.3.0");
        virusDefinitionversionLabel = new JLabel("Virus definition version");
        spywareDefinitionVersionValueLabel = new JLabel("1.3.0");
        spywareDefintionVersion = new JLabel("Spyware definiton version:");
        rememberLabel = new JLabel("Did you know !");
        tipStatementOneLabel = new JLabel("Virus,spyware and other malware "
                + "definitions are files that are used to identify"
                + " maliciouse or potentially unwanted .");
        tipStatementTwoLabel = new JLabel("software on your system. These definitions are"
                + " updated whenever you click update button ");
        tipStatmentThreeLabel = new JLabel("to get"
                + " the latest version whenever you want.");
        
        /**
         * 
         */


        statementOneLabel.setBounds(20,10,600,25);
        statementTwoLabel.setBounds(20,50,600,25);
        definationInstallationLabel.setBounds(20,100,600,25);
        definationInstallationDate.setBounds(200,100,600,25);
        definitionLastUpdateLabel.setBounds(20,130,600,25);
        definitionLastUpdateDateLabel.setBounds(200,130,600,25);
        virusDefinitionversionLabel.setBounds(20,160,600,25);
        virusDefinitionVersionValue.setBounds(200,160,600,25);
        updateDefinitionButton.setBounds(400,160,200,50);
        spywareDefintionVersion.setBounds(20,190,600,25);
        spywareDefinitionVersionValueLabel.setBounds(200,190,600,25);
        
        topSectionPanel.setBounds(0, 0, 730, 160);
        bottomSectionPane.setBounds(0, 160, 730, 300);
        iDSUpdateView.setBounds(30, 10, 670, 280);
        
        rememberLabel.setBounds(30,150,600,25);
        tipStatementOneLabel.setBounds(30,180,700,25);
        tipStatementTwoLabel.setBounds(30,210,700,25);
        tipStatmentThreeLabel.setBounds(30,240,600,25);

        topSectionPanel.setBackground(Color.WHITE);
        iDSUpdateView.setBackground(Color.WHITE);
        bottomSectionPane.setBackground(Color.decode("#ccccff"));
        iDSUpdateView.setBorder( new LineBorder(Color.black));
        statementOneLabel.setFont( new Font("Calibri",Font.BOLD,18));
        updateDefinitionButton.setBackground(Color.decode("#1e90ff"));
        updateDefinitionButton.setForeground(Color.WHITE);
        updateDefinitionButton.setBorder( new LineBorder(Color.decode("#1e90ff")));
        updateDefinitionButton.setFont( new Font("Calibri",Font.PLAIN,18));
        statementOneLabel.setForeground(Color.decode("#008000"));

        bottomSectionPane.add(rememberLabel);
        bottomSectionPane.add(tipStatementOneLabel);
        bottomSectionPane.add(tipStatementTwoLabel);
        bottomSectionPane.add(tipStatmentThreeLabel);
       
        
        add(iDSUpdateView);
        add(topSectionPanel);
        add(bottomSectionPane);

        repaint();
        setVisible(true);
    }

    private final void setFloatPanelLabelProperties(List<JLabel> labels) {
        labels.stream()
                .forEach(e -> {
                    //e.setForeground(Color.decode(""));
                    iDSUpdateView.add(e);
                });
    }

}
