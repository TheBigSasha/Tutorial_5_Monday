package TutorialV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageViewerGUI {
    private JPanel mainPanel;
    private JButton buttonEasy;
    private JButton buttonMedium;
    private JButton buttonHard;
    private static final int TIMER_DELAY = 1000;
    private Timer t;
    private boolean isReady = false;

    //====================================================== Sample "Images" ========================================================
    public static final Color[][] easyImage = new Color[][]{{Color.RED, Color.BLACK, Color.WHITE}};
    public static final Color[][] mediumImage = new Color[][]{{Color.RED, Color.GREEN, Color.BLUE, Color.WHITE}};
    public static final Color[][] hardImage = new Color[][]{{Color.YELLOW, Color.WHITE, Color.BLUE, Color.CYAN, Color.GRAY, Color.ORANGE}};
    //===============================================================================================================================

    public static void main(String[] args) { ImageViewerGUI program = new ImageViewerGUI();
    }

    public ImageViewerGUI() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Welcome to COMP250!");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUIComponents();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private void drawArray(Color[][] image) {
        t = new Timer(TIMER_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isReady = true;
            }
        });
        if (mainPanel.getComponents().length > 1) {
            mainPanel.remove(1);
        }
        ArrayDrawer graphics = new ArrayDrawer(image);
        mainPanel.add(graphics);
        mainPanel.validate();
        bubbleSort(image[0]);

    }


    //TODO: Write here!
    private void bubbleSort(Color arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].getRGB() > arr[j+1].getRGB())
                {
                    Color temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
    }
    //========================================

    private void refresh(Color[] arr) {
        ArrayDrawer graphics = new ArrayDrawer(new Color[][]{arr});
        mainPanel.remove(1);
        mainPanel.add(graphics);
        mainPanel.validate();
    }

    private void createUIComponents() {
        buttonHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawArray(hardImage);
            }
        });
        buttonMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             drawArray(mediumImage);
            }
        });
        buttonEasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawArray(easyImage);
            }
        });

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        mainPanel.add(panel1, BorderLayout.NORTH);
        buttonEasy = new JButton();
        buttonEasy.setText("Easy \uD83D\uDC9A");
        panel1.add(buttonEasy);
        buttonMedium = new JButton();
        buttonMedium.setText("Medium \uD83C\uDFAF");
        panel1.add(buttonMedium);
        buttonHard = new JButton();
        buttonHard.setText("Hard \uD83D\uDD25");
        panel1.add(buttonHard);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
