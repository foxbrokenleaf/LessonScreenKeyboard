import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HistoryFrame extends JFrame{
    private JScrollPane jScrollPane;
    private MainFrame mainFrame;

    public HistoryFrame(MainFrame frame){

        this.mainFrame = frame;

        this.setTitle("历史输入");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(600, 400);

        this.jScrollPane = new JScrollPane();
        this.jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();
        ArrayList<String> strings = sqLiteJDBC.SelectHistory();
        for(int i = strings.toArray().length - 1; i >= 0;i--){
            JButton jButton = new JButton(strings.get(i));
            jButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, jButton.getPreferredSize().height));
            jButton.setBackground(new Color(0xf8, 0xc8, 0xdc));
            jButton.setForeground(new Color(0x2d, 0x2d, 0x2d));
            jButton.setBorder(BorderFactory.createLineBorder(new Color(0xE8E8E8)));
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    HistoryButtonActionPerformed(e);
                }
            });
            jPanel.add(jButton);
            jPanel.add(Box.createVerticalStrut(1));
        }
        this.jScrollPane.setViewportView(jPanel);
        this.add(this.jScrollPane);

        this.setVisible(true);
    }

    private void HistoryButtonActionPerformed(ActionEvent event){
        this.mainFrame.setOutputTextField(event.getActionCommand());
        this.dispose();
    }
}
