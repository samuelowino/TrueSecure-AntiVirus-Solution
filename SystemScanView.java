package truesecurebetaView;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author ADMIN
 */
public class SystemScanView extends JPanel {

    private static JLabel searchLabelIcon;
    private static BufferedImage searchImage;
    private static JLabel yourSystemisBeingScannedLabel;
    private static JLabel takeSomeTimeLabel;
    private static JProgressBar progressBar;
    private static JLabel scanTypeLabel;
    private static JLabel startTimeLabel;
    private static JLabel timeElapsed;
    private static JLabel directoriesScanned;
    private static JButton cancelScanButton;
    private static Timer timer;
    private static int progress = 0;
    private static JButton startButton;
    private static int progressCounter = 0;
    private static JLabel bgImage;
    private static  LocalDate nowDate ;

    public SystemScanView() {

        setSize(600, 450);
        setLocation(0, 0);
        setLayout(null);
        setBackground(Color.WHITE);

        startButton = new JButton("Start Scan");
         nowDate = LocalDate.now();

        bgImage = new JLabel(new ImageIcon("C:\\Users\\HACKER\\Documents\\TrueSecure\\src\\truesecure\\stock-photo-computer-virus-112458059.jpg"));
        progressBar = new JProgressBar(0, 100);
        cancelScanButton = new JButton("Cancel Scan");
        searchImage = getBufferedImage("capture.png");
        progressBar.setStringPainted(true);
        takeSomeTimeLabel = new JLabel("This might take sometime depending on your system specifications and scan selected.");
        yourSystemisBeingScannedLabel = new JLabel("Your System is being scanned.");
        searchLabelIcon = new JLabel(new ImageIcon(searchImage));
        startTimeLabel = new JLabel("Start Time:");
        scanTypeLabel = new JLabel("Scan Type:");
        timeElapsed = new JLabel("Time Elapsed:00:00:00");
        directoriesScanned = new JLabel("Directories Analysied:");

        searchLabelIcon.setBounds(0, 0, 50, 50);
        yourSystemisBeingScannedLabel.setBounds(80, 10, 600, 25);
        takeSomeTimeLabel.setBounds(80, 40, 600, 25);
        progressBar.setBounds(60, 80, 450, 20);
        startButton.setBounds(380, 130, 130, 30);
        cancelScanButton.setBounds(380, 170, 130, 30);
        scanTypeLabel.setBounds(60, 110, 100, 25);
        startTimeLabel.setBounds(60, 140, 100, 25);
        timeElapsed.setBounds(60, 170, 100, 25);
        directoriesScanned.setBounds(60, 200, 300, 25);
        bgImage.setBounds(0, 0, 600, 450);

        startButton.addActionListener(e -> {

            new Thread(
                    new Runnable() {
                @Override
                public void run() {
                    while (progressCounter <= 100) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setValue(progressCounter++);
                                //Check c file directory
                                scanSystemFile();
                                if (progressCounter == 100) {
                                    JOptionPane.showMessageDialog(null, "Malware detected: True secure found some malware in your system, go to Scan logs to determine action", "True Secure", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                        );
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                    }
                }
            }
            ).start();
           // addScanData();
            //recheckFileIntegrity();
            progressCounter = 0;
        });
        
        startButton.setForeground(Color.WHITE);
        cancelScanButton.setForeground(Color.WHITE);
        startButton.setBackground(Color.decode("#1e90ff"));
        cancelScanButton.setBackground(Color.red);
        startButton.setBorder( new LineBorder(Color.decode("#1e90ff")));
        cancelScanButton.setBorder( new LineBorder(Color.red));

        List<JComponent> components = Arrays.asList(
                searchLabelIcon, yourSystemisBeingScannedLabel, takeSomeTimeLabel, progressBar, startButton,
                startTimeLabel, scanTypeLabel, timeElapsed, directoriesScanned, cancelScanButton
        );
        addComponentsToFrame(components);

        cancelScanButton.addActionListener(e -> setVisible(false));
        add(bgImage);

        repaint();
        setVisible(true);

    }

    public final void addComponentsToFrame(List<JComponent> components) {
        components.stream()
                .forEach(e -> {
                    add(e);
                });
    }

    public BufferedImage getBufferedImage(String fileName) {
        try {

            BufferedImage requiredImage = null;
            requiredImage = ImageIO.read(getClass().getResource("/appimages/" + fileName));
            return requiredImage;

        } catch (IOException e) {
            e.printStackTrace();
            return new BufferedImage(0, 0, 0);
        }
    }

    public static void recheckFileIntegrity() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/truesecure","root","")){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO scanlogs VALUES('Trojan Horse','Extreem','"+nowDate+"');");
            preparedStatement.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void addScanData() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/truesecure","root","")){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO scanlogs VALUES('worm34245u34','Extreem','"+nowDate+"');");
            preparedStatement.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Checks the integrity of the system file in the specified directory
     *
     * @param cipherLines
     * @param categoryFile
     */
    public static void scanSystemFile() {

        try {
            FileWriter fileWriter = new FileWriter(new File("vv.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\Users\\HACKER\\Desktop\\Exisisting.txt")));

            List<String> cipherLines = Arrays.asList(
                    "Trojan Horse",
                    "Worm",
                    "2345u836KDhfu",
                    "KMSCrack Tool"
            );
            cipherLines.stream()
                    .forEach(e -> {
                        try {
                            bufferedWriter.write(e);
                            bufferedWriter.newLine();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Unable toAnalyise file\n"
                                    + ex.getMessage(), "True Secure", JOptionPane.ERROR_MESSAGE);
                        }
                    });
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable toAnalyise file\n"
                    + e.getMessage(), "True Secure", JOptionPane.ERROR_MESSAGE);

        }
    }
}
