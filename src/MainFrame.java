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
import java.util.logging.Logger;

public class MainFrame extends JFrame{
//    private JFrame jFrame;
    private JTextField outputTextField;
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
    private JPopupMenu MousePopupMenu;
    private GlobalKeyListener globalKeyListener;
    private String OutputStringBuffer;
    private boolean WindowFocus;

    class CustomMouseListener extends MouseAdapter{

        @Override
        public void mouseReleased(MouseEvent event){
            if(event.isPopupTrigger()) MouseActionPerformedReleased(event);
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

        this.OutputStringBuffer = new String();

        Logger MainLogger = Logger.getLogger("MainFrame");

        this.setTitle("LessonScreenKeyboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        this.MousePopupMenu = new JPopupMenu();
        JMenuItem MousePopupMenuItem_1 = new JMenuItem("复制");
        MousePopupMenuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MousePopupMenuActionPerformed(e);
            }
        });
        JMenuItem MousePopupMenuItem_2 = new JMenuItem("粘贴");
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
        this.globalKeyListener = new GlobalKeyListener();
        GlobalScreen.addNativeKeyListener(globalKeyListener);
        InitButton();
        this.UpperCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpperCheckBoxActionPerformed(e);
            }
        });

        this.pack();
        this.setVisible(true);

    }

    private void LostFocusActionPerformed(WindowEvent event){
        System.out.println("失焦！");
        this.WindowFocus = false;
    }

    private void JFrameClick(MouseEvent event){
        System.out.println("聚焦！");
        this.WindowFocus = true;
    }

    private void GlobalKeyboardPressedActionPerformed(NativeKeyEvent nativeKeyEvent){
        if (!this.WindowFocus) {
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) ;
//            //左
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CONTROL && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT) {
                this.setAlwaysOnTop(true);
            }
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_SHIFT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT)
//                ;
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ALT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT)
//                ;
//            //Windows键
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_META && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT)
//                ;
//            //右
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CONTROL && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT)
//                System.out.println("L Click!");
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_SHIFT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT)
//                ;
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ALT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT)
//                ;
//            //Windows键
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_META && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT)
//                ;
        }

    }

    private void GlobalKeyboardReleasedActionPerformed(NativeKeyEvent nativeKeyEvent){
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CAPS_LOCK) ;
//            //左
            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CONTROL && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT){
                this.setAlwaysOnTop(false);
            }
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_SHIFT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT)
//                ;
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ALT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT)
//                ;
//            //Windows键
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_META && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_LEFT)
//                ;
//            //右
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_CONTROL && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT)
//                System.out.println("L Click!");
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_SHIFT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT)
//                ;
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ALT && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT)
//                ;
//            //Windows键
//            if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_META && nativeKeyEvent.getKeyLocation() == NativeKeyEvent.KEY_LOCATION_RIGHT)
//                ;

    }

    private void KeyboardActionPerformedDown(KeyEvent event){
        System.out.println(event);
    }

    private void MouseActionPerformedReleased(MouseEvent event){
        this.MousePopupMenu.show(event.getComponent(), event.getX(), event.getY());
        Logger MouseLogger = Logger.getLogger("Mouse");
        MouseLogger.info("Mouse released in X:" + event.getX() + " Y:" + event.getY());
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
        String ClickButtonChar = event.getActionCommand();
        ButtonLogger.info("Click Button:" + ClickButtonChar);
        if(ClickButtonChar.equals(this.Button_0x20.getActionCommand())) ClickButtonChar = " ";
        if(ClickButtonChar.equals(this.deleteButton.getActionCommand())){
            if(!this.OutputStringBuffer.isEmpty())
                this.OutputStringBuffer = this.OutputStringBuffer.substring(0, this.OutputStringBuffer.length() - 1);
        }
        else {
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
    }

    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
    }


}
