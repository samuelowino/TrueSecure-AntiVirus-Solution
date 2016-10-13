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
import java.util.Arrays;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HACKER
 */
public class HistoryView extends JPanel {

    private static JLabel statementOneLabel;
    private static JLabel statementTwoLabel;
    private static JRadioButton quarantinedItemsRadioButton;
    private static JRadioButton allowedItemsradioButton;
    private static JRadioButton allDetectedItemsRadioButton;
    private static JLabel quarantinedItemsDescription;
    private static JLabel allowedItemsDescription;
    private static JLabel allDetectedItemsDewsscription;

    private static JLabel bottomPanelStatementOneLabel;
    private static JLabel bottomPanelClickViewLabel;
    private static JButton viewDetailsButton;
    private static ButtonGroup optionButtonGroup;

    private static JSplitPane mainSplitPane;
    private static JSplitPane bottomPanelSplitPane;
    private static JPanel topOptionsPanel;
    private static JPanel bottomSectionPanel;

    private static JPanel quarantinedItemsTablePanel;
    private static JPanel allDetectedItemsTablePanel;
    private static JPanel allowedItemsTablePanel;

    private static JTable quarantinedItemsTable;
    private static JTable allowedItemsTable;
    private static JTable allDetectedItemsTable;

    private static JButton removeAllQuarantinedItemsButton;
    private static JButton removerAllDetectedItemsButton;
    private static JButton removeAllAllowedItems;

    private static JButton allowItemButton;
    private static JButton restoreButton;
    private static JButton removeButtonQuarantinedItems;
    private static JButton removeAllowedItems;

    private static JScrollPane quarantineScrollPane;
    private static JScrollPane allowedItemsScrollPane;
    private static JScrollPane allDetectedItemsScrollPane;

    private static DefaultTableModel defaultTableModel;

    public HistoryView() {

        setSize(730, 480);
        setLocation(40, 40);
        setLayout(null);
        setBackground(Color.WHITE);

        mainSplitPane = new JSplitPane();
        bottomPanelSplitPane = new JSplitPane();
        topOptionsPanel = new JPanel(null);
        bottomSectionPanel = new JPanel(null);
        quarantineScrollPane = new JScrollPane();
        allDetectedItemsScrollPane = new JScrollPane();
        allowedItemsScrollPane = new JScrollPane();
        removeButtonQuarantinedItems = new JButton("Remove");
        removeAllQuarantinedItemsButton = new JButton("Remove all");
        restoreButton = new JButton("Restore");
        removeAllAllowedItems = new JButton("Remove all");
        removeAllowedItems = new JButton("Remove");
        removerAllDetectedItemsButton = new JButton("Remove all");
        restoreButton = new JButton("Restore");
        allowItemButton = new JButton("Allow item");

        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Detected Items");
        defaultTableModel.addColumn("Allert Level");
        defaultTableModel.addColumn("Date");
        defaultTableModel.addColumn("Action taken");
        defaultTableModel.addColumn("Recommended Action");

        quarantinedItemsTable = new JTable(defaultTableModel);
        allDetectedItemsTable = new JTable(defaultTableModel);
        allowedItemsTable = new JTable(defaultTableModel);
        
        quarantineScrollPane.getViewport().add(quarantinedItemsTable);
        allDetectedItemsScrollPane.getViewport().add(allDetectedItemsTable);
        allowedItemsScrollPane.getViewport().add(allowedItemsTable);

        quarantinedItemsTablePanel = new JPanel(null);
        allowedItemsTablePanel = new JPanel(null);
        allDetectedItemsTablePanel = new JPanel(null);

        optionButtonGroup = new ButtonGroup();
        optionButtonGroup.add(quarantinedItemsRadioButton);
        optionButtonGroup.add(allowedItemsradioButton);
        optionButtonGroup.add(allDetectedItemsRadioButton);

        statementOneLabel = new JLabel("View the items that were detected as "
                + "potentially harmfull and action that you took on them.");
        quarantinedItemsRadioButton = new JRadioButton("Quarantined items.");
        allowedItemsradioButton = new JRadioButton("Allowed items.");
        allDetectedItemsRadioButton = new JRadioButton("All Detected items.");
        quarantinedItemsDescription = new JLabel("Items that were prevented from "
                + "running but not removed from your System.");
        allowedItemsDescription = new JLabel("Items that you've allowed to run on your system.");
        allDetectedItemsDewsscription = new JLabel("Items that were detected on your system.");

        bottomPanelStatementOneLabel = new JLabel("To help protect user privac, these items are hiddent.");
        bottomPanelClickViewLabel = new JLabel("Click view details to see the items.");
        viewDetailsButton = new JButton("View Details");

        mainSplitPane.setBounds(0, 0, 730, 480);
        bottomPanelSplitPane.setBounds(0, 0, 730, 150);
        mainSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        mainSplitPane.setDividerLocation(220);

        statementOneLabel.setBounds(10, 5, 800, 25);
        quarantinedItemsRadioButton.setBounds(10, 40, 300, 25);
        quarantinedItemsDescription.setBounds(10, 70, 600, 25);
        allowedItemsradioButton.setBounds(10, 100, 300, 25);
        allowedItemsDescription.setBounds(10, 140, 300, 25);
        allDetectedItemsRadioButton.setBounds(10, 170, 300, 25);
        allDetectedItemsDewsscription.setBounds(10, 200, 600, 25);
        
        removeAllQuarantinedItemsButton.setBounds(360,160,100,25);
        removeButtonQuarantinedItems.setBounds(480,160,100,25);
        restoreButton.setBounds(600,160,100,25);
        removeAllAllowedItems.setBounds(480,160,100,25);
        removeAllowedItems.setBounds(600,160,100,25);
        removerAllDetectedItemsButton.setBounds(480,160,100,25);
        allowItemButton.setBounds(600,160,100,25);
        
        removeAllQuarantinedItemsButton.setBackground(Color.decode("#f5f5f5"));
        removeButtonQuarantinedItems.setBackground(Color.decode("#f5f5f5"));
        restoreButton.setBackground(Color.decode("#f5f5f5"));
        removeAllAllowedItems.setBackground(Color.decode("#f5f5f5"));
        removeAllowedItems.setBackground(Color.decode("#f5f5f5"));
        removerAllDetectedItemsButton.setBackground(Color.decode("#f5f5f5"));
        allowItemButton.setBackground(Color.decode("#f5f5f5"));
        
        quarantinedItemsTablePanel.add(removeAllQuarantinedItemsButton);
        quarantinedItemsTablePanel.add(removeButtonQuarantinedItems);
        quarantinedItemsTablePanel.add(restoreButton);
        
        allowedItemsTablePanel.add(removeAllAllowedItems);
        allowedItemsTablePanel.add(removeAllowedItems);
        
        allDetectedItemsTablePanel.add(removerAllDetectedItemsButton);
        allDetectedItemsTablePanel.add(allowItemButton);

        bottomPanelStatementOneLabel.setBounds(150, 50, 500, 25);
        bottomPanelClickViewLabel.setBounds(200, 100, 500, 25);
        viewDetailsButton.setBounds(220, 140, 150, 30);

        statementOneLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        viewDetailsButton.setBackground(Color.decode("#1e90ff"));
        viewDetailsButton.setBorder(new LineBorder(Color.decode("#1e90ff")));
        viewDetailsButton.setForeground(Color.WHITE);

        quarantinedItemsTablePanel.setBackground(Color.WHITE);
        allDetectedItemsTablePanel.setBackground(Color.WHITE);
        allowedItemsTablePanel.setBackground(Color.WHITE);
        quarantinedItemsTablePanel.add(quarantineScrollPane);
        allDetectedItemsTablePanel.add(allDetectedItemsScrollPane);
        allowedItemsTablePanel.add(allowedItemsScrollPane);

        topOptionsPanel.add(statementOneLabel);

        List<JComponent> components = Arrays.asList(
                quarantinedItemsDescription, quarantinedItemsRadioButton,
                allDetectedItemsDewsscription, allDetectedItemsRadioButton,
                allowedItemsDescription, allowedItemsradioButton
        );

        List<JComponent> bottomPanelComponents = Arrays.asList(
                bottomPanelStatementOneLabel, bottomPanelClickViewLabel, viewDetailsButton
        );

        addCompnentsToPanels(bottomSectionPanel, bottomPanelComponents);
        addCompnentsToPanels(topOptionsPanel, components);

        mainSplitPane.setTopComponent(topOptionsPanel);
        mainSplitPane.setBottomComponent(bottomSectionPanel);

        List<JSplitPane> splitPanes = Arrays.asList(
                mainSplitPane, bottomPanelSplitPane
        );
        
        List<JScrollPane> scrollPanes = Arrays.asList(
                quarantineScrollPane,allDetectedItemsScrollPane,allowedItemsScrollPane
        );
        setSplitPaneProperties(splitPanes);
        setScrollPanesProperties(scrollPanes);

        quarantinedItemsRadioButton.addActionListener(e -> {
            allowedItemsradioButton.setSelected(false);
            allDetectedItemsRadioButton.setSelected(false);
            replaceBottomPanel(bottomSectionPanel);
        });

        allowedItemsradioButton.addActionListener(e -> {
            quarantinedItemsRadioButton.setSelected(false);
            allDetectedItemsRadioButton.setSelected(false);
            replaceBottomPanel(bottomSectionPanel);
        });

        allDetectedItemsRadioButton.addActionListener(e -> {
            allowedItemsradioButton.setSelected(false);
            quarantinedItemsRadioButton.setSelected(false);
            replaceBottomPanel(bottomSectionPanel);
        });

        viewDetailsButton.addActionListener(e -> {
            if (quarantinedItemsRadioButton.isSelected()) {
                replaceBottomPanel(quarantinedItemsTablePanel);
            } else if (allowedItemsradioButton.isSelected()) {
                replaceBottomPanel(allowedItemsTablePanel);
            } else if (allDetectedItemsRadioButton.isSelected()) {
                replaceBottomPanel(allDetectedItemsTablePanel);
            }
        });

        add(mainSplitPane);
    }

    /**
     * Replaces bottom panel of the main splitPane
     *
     * @param tablePanel
     */
    public final void replaceBottomPanel(JPanel tablePanel) {
        mainSplitPane.remove(mainSplitPane.getBottomComponent());
        mainSplitPane.setRightComponent(tablePanel);
        mainSplitPane.setDividerLocation(220);
        mainSplitPane.setEnabled(false);
    }

    /**
     *
     * @param scrollPanes
     */
    public final void setScrollPanesProperties(List<JScrollPane> scrollPanes) {
        scrollPanes.stream()
                .forEach(e -> {
                    e.getViewport().setBackground(Color.white);
                    e.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    e.setBounds(10, 5, 700, 150);
                });
    }

    /**
     *
     * @param panel
     * @param components
     */
    public final void addCompnentsToPanels(JPanel panel, List<JComponent> components) {
        components.stream()
                .forEach(e -> {
                    panel.add(e);
                    if (e instanceof JRadioButton) {
                        e.setBackground(Color.WHITE);
                        e.addMouseListener(
                                new MouseAdapter() {
                            @Override
                            public void mouseEntered(MouseEvent event) {
                                e.setBackground(Color.decode("#e6faff"));
                            }

                            @Override
                            public void mouseExited(MouseEvent event) {
                                e.setBackground(Color.WHITE);
                            }
                        }
                        );
                    } else if (e instanceof JLabel) {
                        e.setFont(new Font("Calibri", Font.PLAIN, 14));
                    } else {

                    }
                });
    }

    /**
     *
     * @param splitPanes
     */
    public final void setSplitPaneProperties(List<JSplitPane> splitPanes) {
        splitPanes.stream()
                .forEach(e -> {
                    e.setDividerSize(1);
                    e.setBackground(Color.WHITE);
                    e.setBorder(new LineBorder(Color.WHITE));
                    e.getRightComponent().setBackground(Color.WHITE);
                    e.getLeftComponent().setBackground(Color.WHITE);

                });

    }
}
