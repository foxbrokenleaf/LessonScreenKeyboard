import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class MainFrame extends JFrame{
//    private JFrame jFrame;
    private JLabel outputTextField;
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton eButton;
    private JButton fButton;
    private JButton gButton;
    private JButton hButton;
    private JButton iButton;
    private JButton jButton;
    private JButton kButton;
    private JButton lButton;
    private JButton mButton;
    private JButton nButton;
    private JButton oButton;
    private JButton pButton;
    private JButton qButton;
    private JButton rButton;
    private JButton sButton;
    private JButton tButton;
    private JButton uButton;
    private JButton vButton;
    private JButton wButton;
    private JButton xButton;
    private JButton Button_7;
    private JButton Button_8;
    private JButton Button_9;
    private JButton Button_4;
    private JButton Button_5;
    private JButton Button_6;
    private JButton Button_1;
    private JButton Button_2;
    private JButton Button_3;
    private JButton yButton;
    private JButton Button_0;
    private JButton zButton;
    private JButton Button_0x60;
    private JButton Button_0x21;
    private JButton Button_0x40;
    private JButton Button_0x23;
    private JButton Button_0x24;
    private JButton Button_0x25;
    private JButton Button_0x5E;
    private JButton Button_0x26;
    private JButton Button_0x2A;
    private JButton Button_0x2C;
    private JButton Button_0x2E;
    private JButton Button_0x2F;
    private JButton Button_0x7E;
    private JButton Button_0x5F;
    private JButton Button_0x2B;
    private JButton Button_0x7B;
    private JButton Button_0x7D;
    private JButton Button_0x5C;
    private JButton Button_0x3A;
    private JButton Button_0x27;
    private JButton Button_0x3B;
    private JButton Button_0x5D;
    private JButton Button_0x5B;
    private JButton Button_0x3D;
    private JButton Button_0x2D;
    private JButton Button_0x29;
    private JButton Button_0x28;
    private JButton Button_0x22;
    private JButton Button_0x7C;
    private JButton Button_0x3C;
    private JButton Button_0x3E;
    private JButton Button_0x3F;
    private JButton Button_0x20;
    private JPanel jPanel;
    private JCheckBox UpperCheckBox;
    private JButton deleteButton;
    private JButton SearchButton;
    private JButton ClearnButton;
    private JButton PinYinButton;
    private JButton HistoryButton;
    private JButton TestButton;
    private JButton button2;
    private JCheckBox shiftCheckBox;
    private JComboBox SearchEnginecomboBox;
    private JPopupMenu MousePopupMenu;
    private MainFrame.GlobalKeyListener globalKeyListener;
    private String OutputStringBuffer;
    private boolean WindowFocus;

    private SQLiteJDBC sqLiteJDBC;

    private static MainFrame mainFrame;


    public static MainFrame getInstance() {
        if (mainFrame == null) {
            mainFrame = new MainFrame();
        }
        return mainFrame;
    }

    class CustomMouseListener extends MouseAdapter{

        @Override
        public void mouseReleased(MouseEvent event){
            MouseActionPerformedReleased(event);
        }
    }

    class CustomKeyboardListener extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent event){
            KeyboardActionPerformedDown(event);
        }
    }

    class GlobalKeyListener implements NativeKeyListener{

        @Override
        public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent){
            GlobalKeyboardPressedActionPerformed(nativeKeyEvent);
        }

        @Override
        public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent){
            GlobalKeyboardReleasedActionPerformed(nativeKeyEvent);
        }

        @Override
        public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent){

        }

    }

    public MainFrame(){

        mainFrame = this;
        this.OutputStringBuffer = new String();
        this.sqLiteJDBC = new SQLiteJDBC();
        this.sqLiteJDBC.CreateHistoryTabel();

        Logger MainLogger = Logger.getLogger("MainFrame");

        this.setIconImage(new ImageIcon("icon.png").getImage());
        this.setTitle("反伽卡他卡摸鱼神器 - " + new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                LostFocusActionPerformed(e);
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent event) {
                JFrameClick(event);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.add(this.jPanel);

        this.outputTextField.setBorder(BorderFactory.createLineBorder(new Color(0xe8, 0xe8, 0xe8)));

        this.MousePopupMenu = new JPopupMenu();
        this.MousePopupMenu.setBackground(new Color(0xff, 0xff, 0xff));

        JMenuItem MousePopupMenuItem_1 = new JMenuItem("复制");
        MousePopupMenuItem_1.setBackground(new Color(0xfc, 0xe4, 0xec));
        MousePopupMenuItem_1.setForeground(new Color(0x2d, 0x2d, 0x2d));
        MousePopupMenuItem_1.setBorder(BorderFactory.createLineBorder(new Color(0xe8, 0xe8, 0xe8)));
        MousePopupMenuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MousePopupMenuActionPerformed(e);
            }
        });
        JMenuItem MousePopupMenuItem_2 = new JMenuItem("粘贴");
        MousePopupMenuItem_2.setBackground(new Color(0xfc, 0xe4, 0xec));
        MousePopupMenuItem_2.setForeground(new Color(0x2d, 0x2d, 0x2d));
        MousePopupMenuItem_2.setBorder(BorderFactory.createLineBorder(new Color(0xe8, 0xe8, 0xe8)));
        MousePopupMenuItem_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MousePopupMenuActionPerformed(e);
            }
        });
        this.MousePopupMenu.add(MousePopupMenuItem_1);
        this.MousePopupMenu.add(MousePopupMenuItem_2);

        this.outputTextField.addMouseListener(new CustomMouseListener());


        try{
            GlobalScreen.registerNativeHook();
        }catch (NativeHookException err){
            err.printStackTrace();
        }
        this.globalKeyListener = new MainFrame.GlobalKeyListener();
        GlobalScreen.addNativeKeyListener(globalKeyListener);
        InitButton();
        this.UpperCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpperCheckBoxActionPerformed(e);
            }
        });

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameTitleTimeUpdate(e);
            }
        });
        timer.start();

        this.TestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestUnit(e);
            }
        });

        this.pack();
        this.setVisible(true);

    }

    private void TestUnit(ActionEvent event){

    }

    private void MainFrameTitleTimeUpdate(ActionEvent event){
        this.setTitle("反伽卡他卡摸鱼神器 - " + new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
    }

    private void LostFocusActionPerformed(WindowEvent event){
        this.WindowFocus = false;
    }

    private void JFrameClick(MouseEvent event){
        this.WindowFocus = true;
    }

    private void GlobalKeyboardPressedActionPerformed(NativeKeyEvent nativeKeyEvent){
        if (!this.WindowFocus) {
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK);
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CONTROL && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT) {
                if(this.getState() == JFrame.ICONIFIED) {
                    this.setState(JFrame.NORMAL);
                }
                this.setAlwaysOnTop(true);
            }
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_SHIFT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT);
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ALT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT);
            //Windows键
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_META && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT);
            //右
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CONTROL && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT);
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_SHIFT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT);
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ALT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT);
            //Windows键
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_META && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT);
        } else{
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) this.deleteButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ESCAPE) this.ClearnButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ENTER) this.SearchButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_A) this.aButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_B) this.bButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_C) this.cButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_D) this.dButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_E) this.eButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_F) this.fButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_G) this.gButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_H) this.hButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_I) this.iButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_J) this.jButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_K) this.kButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_L) this.lButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_M) this.mButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_N) this.nButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_O) this.oButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_P) this.pButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_Q) this.qButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_R) this.rButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_S) this.sButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_T) this.tButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_U) this.uButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_V) this.vButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_W) this.wButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_X) this.xButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_Y) this.yButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_Z) this.zButton.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_SPACE) this.Button_0x20.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_SHIFT) this.shiftCheckBox.setSelected(!this.shiftCheckBox.isSelected());
            if (this.shiftCheckBox.isSelected()) {
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CONTROL) this.PinYinButton.doClick();
                if (nativeKeyEvent.getKeyCode() == 41) this.Button_0x7E.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_1) this.Button_0x21.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_2) this.Button_0x40.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_3) this.Button_0x23.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_4) this.Button_0x24.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_5) this.Button_0x25.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_6) this.Button_0x5E.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_7) this.Button_0x26.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_8) this.Button_0x2A.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_9) this.Button_0x28.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_0) this.Button_0x29.doClick();
                if (nativeKeyEvent.getKeyCode() == 12) this.Button_0x5F.doClick();
                if (nativeKeyEvent.getKeyCode() == 13) this.Button_0x2B.doClick();
                if (nativeKeyEvent.getKeyCode() == 26) this.Button_0x7B.doClick();
                if (nativeKeyEvent.getKeyCode() == 27) this.Button_0x7D.doClick();
                if (nativeKeyEvent.getKeyCode() == 39) this.Button_0x3A.doClick();
                if (nativeKeyEvent.getKeyCode() == 40) this.Button_0x22.doClick();
                if (nativeKeyEvent.getKeyCode() == 43) this.Button_0x7C.doClick();
                if (nativeKeyEvent.getKeyCode() == 51) this.Button_0x3C.doClick();
                if (nativeKeyEvent.getKeyCode() == 52) this.Button_0x3E.doClick();
                if (nativeKeyEvent.getKeyCode() == 53) this.Button_0x3F.doClick();
            }
            else{
                if(nativeKeyEvent.getKeyCode() == 41) this.Button_0x60.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_0) this.Button_0.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_1) this.Button_1.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_2) this.Button_2.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_3) this.Button_3.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_4) this.Button_4.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_5) this.Button_5.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_6) this.Button_6.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_7) this.Button_7.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_8) this.Button_8.doClick();
                if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_9) this.Button_9.doClick();
                if (nativeKeyEvent.getKeyCode() == 12) this.Button_0x2D.doClick();
                if (nativeKeyEvent.getKeyCode() == 13) this.Button_0x3D.doClick();
                if (nativeKeyEvent.getKeyCode() == 26) this.Button_0x5B.doClick();
                if (nativeKeyEvent.getKeyCode() == 27) this.Button_0x5D.doClick();
                if (nativeKeyEvent.getKeyCode() == 39) this.Button_0x3B.doClick();
                if (nativeKeyEvent.getKeyCode() == 40) this.Button_0x27.doClick();
                if (nativeKeyEvent.getKeyCode() == 43) this.Button_0x5C.doClick();
                if (nativeKeyEvent.getKeyCode() == 51) this.Button_0x2C.doClick();
                if (nativeKeyEvent.getKeyCode() == 52) this.Button_0x2E.doClick();
                if (nativeKeyEvent.getKeyCode() == 53) this.Button_0x2F.doClick();
            }
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) UpperCheckBox.doClick();
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_F1){
                if(Desktop.isDesktopSupported()){
                    Desktop desktop = Desktop.getDesktop();
                    String SearchEngine = new String();
                    if(this.SearchEnginecomboBox.getSelectedItem().equals("必应")){
                        SearchEngine = "https://www.bing.com";
                    }
                    else if(this.SearchEnginecomboBox.getSelectedItem().equals("谷歌")){
                        SearchEngine = "https://www.google.com";
                    }
                    try{
                        desktop.browse(new URI(SearchEngine));
                    }catch (IOException | URISyntaxException err){
                        err.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "Desktop is not supported!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }

    private void GlobalKeyboardReleasedActionPerformed(NativeKeyEvent nativeKeyEvent){
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) ;
//            //左
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CONTROL && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT){
                this.setAlwaysOnTop(false);
            }
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_SHIFT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT);
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ALT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT);
            //Windows键
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_META && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT);
            //右
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CONTROL && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT);
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_SHIFT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT);
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ALT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT);
            //Windows键
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_META && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT);

    }

    private void KeyboardActionPerformedDown(KeyEvent event){
        System.out.println(event);
    }

    private void MouseActionPerformedReleased(MouseEvent event){
        this.WindowFocus = true;
        if(event.isPopupTrigger()) this.MousePopupMenu.show(event.getComponent(), event.getX(), event.getY());
    }

    private void MousePopupMenuActionPerformed(ActionEvent event){
        Logger MousePopupMenuItemLogger = Logger.getLogger("MousePopupMenuItem");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if(event.getActionCommand().equals("复制")) {
            StringSelection selection = new StringSelection(this.OutputStringBuffer);
            clipboard.setContents(selection, null);
            MousePopupMenuItemLogger.info("文本(" + this.OutputStringBuffer + ")已复制到剪切板！");
        }
        else if(event.getActionCommand().equals("粘贴")){
            Transferable transferable = clipboard.getContents(null);
            if(transferable != null && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)){
                try{
                    String text = (String) transferable.getTransferData(DataFlavor.stringFlavor);
                    this.OutputStringBuffer += text;
                    this.outputTextField.setText(this.OutputStringBuffer);
                    MousePopupMenuItemLogger.info("剪贴板中的文本:" + text);
                }catch (Exception err){
                    err.printStackTrace();
                }
            }
            else{
                MousePopupMenuItemLogger.info("剪贴板中无文本");
            }
        }
    }

    private void UpperCheckBoxActionPerformed(ActionEvent event){
        this.WindowFocus = true;
        if(this.UpperCheckBox.isSelected()){
            this.aButton.setText("A");
            this.bButton.setText("B");
            this.cButton.setText("C");
            this.dButton.setText("D");
            this.eButton.setText("E");
            this.fButton.setText("F");
            this.gButton.setText("G");
            this.hButton.setText("H");
            this.iButton.setText("I");
            this.jButton.setText("J");
            this.kButton.setText("K");
            this.lButton.setText("L");
            this.mButton.setText("M");
            this.nButton.setText("N");
            this.oButton.setText("O");
            this.pButton.setText("P");
            this.qButton.setText("Q");
            this.rButton.setText("R");
            this.sButton.setText("S");
            this.tButton.setText("T");
            this.uButton.setText("U");
            this.vButton.setText("V");
            this.wButton.setText("W");
            this.xButton.setText("X");
            this.yButton.setText("Y");
            this.zButton.setText("Z");
        }
        else {
            this.aButton.setText("a");
            this.bButton.setText("b");
            this.cButton.setText("c");
            this.dButton.setText("d");
            this.eButton.setText("e");
            this.fButton.setText("f");
            this.gButton.setText("g");
            this.hButton.setText("h");
            this.iButton.setText("i");
            this.jButton.setText("j");
            this.kButton.setText("k");
            this.lButton.setText("l");
            this.mButton.setText("m");
            this.nButton.setText("n");
            this.oButton.setText("o");
            this.pButton.setText("p");
            this.qButton.setText("q");
            this.rButton.setText("r");
            this.sButton.setText("s");
            this.tButton.setText("t");
            this.uButton.setText("u");
            this.vButton.setText("v");
            this.wButton.setText("w");
            this.xButton.setText("x");
            this.yButton.setText("y");
            this.zButton.setText("z");
        }
    }

    private void ButtonActionPerformed(ActionEvent event){
        Logger ButtonLogger = Logger.getLogger("Button");
        this.WindowFocus = true;
        String ClickButtonChar = event.getActionCommand();
        ButtonLogger.info("Click Button:" + ClickButtonChar);
        if(ClickButtonChar.equals(this.Button_0x20.getActionCommand())) ClickButtonChar = " ";
        if(ClickButtonChar.equals(this.deleteButton.getActionCommand())){
            if(!this.OutputStringBuffer.isEmpty())
                this.OutputStringBuffer = this.OutputStringBuffer.substring(0, this.OutputStringBuffer.length() - 1);
        }
        else if(ClickButtonChar.equals(this.SearchButton.getActionCommand())){
            this.sqLiteJDBC.Insert2History(this.OutputStringBuffer);
            if(Desktop.isDesktopSupported()){
                Desktop desktop = Desktop.getDesktop();
                String SearchEngine = new String();
                if(this.SearchEnginecomboBox.getSelectedItem().equals("必应")){
                    SearchEngine = "https://www.bing.com";
                }
                else if(this.SearchEnginecomboBox.getSelectedItem().equals("谷歌")){
                    SearchEngine = "https://www.google.com";
                }
                try{
                    this.OutputStringBuffer = this.OutputStringBuffer.replace(" ", "%20");
                    desktop.browse(new URI(SearchEngine + "/search?q=" + this.OutputStringBuffer));
                }catch (IOException | URISyntaxException err){
                    err.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(this, "Desktop is not supported!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        else if(ClickButtonChar.equals(this.ClearnButton.getActionCommand())){
            this.OutputStringBuffer = "";
            this.outputTextField.setText(this.OutputStringBuffer);
        }
        else if(ClickButtonChar.equals(this.PinYinButton.getActionCommand())){
            PinYinFrame pinYinFrame = new PinYinFrame(this);
        }
        else if(ClickButtonChar.equals(this.HistoryButton.getActionCommand())){
            HistoryFrame historyFrame = new HistoryFrame(this);
        }
        else{
            this.OutputStringBuffer += ClickButtonChar;
        }
        this.outputTextField.setText(this.OutputStringBuffer);

    }

    private void InitButton(){

        this.Button_0x26.setText("&");
        this.Button_0x7E.setText("~");

        this.aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.dButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.eButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.fButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.gButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.hButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.iButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.kButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.lButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.mButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.nButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.oButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.pButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.qButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.rButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.sButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.tButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.uButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.vButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.wButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.yButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.zButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x27.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x28.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x29.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x2A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x2B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x2C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x2D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x2E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x2F.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x3A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x3B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x3C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x3D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x3E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x3F.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x40.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x5B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x5C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x5D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x5E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x5F.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x60.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x7B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x7C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x7D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.Button_0x7E.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.ClearnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.PinYinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
        this.HistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
    }

    public void setOutputTextField(String string){
        this.OutputStringBuffer = string;
        this.outputTextField.setText(this.OutputStringBuffer);
    }

    public void addOutputTextField(String string){
        this.OutputStringBuffer += string;
        this.outputTextField.setText(this.OutputStringBuffer);
    }

    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
    }


}
