import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinYinFrame extends JFrame{
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton gButton;
    private JButton hButton;
    private JButton iButton;
    private JButton jButton;
    private JButton mButton;
    private JButton nButton;
    private JButton oButton;
    private JButton pButton;
    private JButton sButton;
    private JButton tButton;
    private JButton uButton;
    private JButton vButton;
    private JButton eButton;
    private JButton kButton;
    private JButton qButton;
    private JButton wButton;
    private JButton fButton;
    private JButton lButton;
    private JButton rButton;
    private JButton xButton;
    private JButton yButton;
    private JButton zButton;
    private JPanel SelectPinYinPanel;
    private JPanel pane1;
    private JScrollPane jScrollPane;
    private JPanel scrollPanel;
    private JLabel ShowInput;
    private JButton deleteButton;
    private String InputStringBuffer;
    private int InputStringBufferOldL;

    private MainFrame mainFrame;

    private String PinYinJason;

    private GlobalKeyListener globalKeyListener;

    class GlobalKeyListener implements NativeKeyListener {

        @Override
        public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent){
            GlobalKeyboardPressedActionPerformed(nativeKeyEvent);
        }

        @Override
        public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent){

        }

        @Override
        public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent){

        }

    }

    public PinYinFrame(MainFrame frame){
        this.mainFrame = frame;

        this.setTitle("拼音输入");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setSize(350, 260);

        this.jScrollPane = new JScrollPane();
        this.jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        this.jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.scrollPanel.setLayout(new BoxLayout(this.scrollPanel, BoxLayout.X_AXIS));

        this.InputStringBuffer = new String();
        InitButton();

        this.globalKeyListener = new PinYinFrame.GlobalKeyListener();
        GlobalScreen.addNativeKeyListener(globalKeyListener);

        this.add(pane1);
        this.setVisible(true);
    }

    private void GlobalKeyboardPressedActionPerformed(NativeKeyEvent nativeKeyEvent){
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
        if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_BACKSPACE) this.deleteButton.doClick();
    }

    private void ButtonActionPerformed(ActionEvent event){
        String ClickButtonChar = event.getActionCommand();
        if(ClickButtonChar.equals(this.deleteButton.getActionCommand())){
            if(!this.InputStringBuffer.isEmpty())
                this.InputStringBuffer = this.InputStringBuffer.substring(0, this.InputStringBuffer.length() - 1);
                this.scrollPanel.removeAll();
                LoadingPinYin();
        } else {
            this.InputStringBuffer += event.getActionCommand().toLowerCase();
            this.scrollPanel.removeAll();
            LoadingPinYin();
        }
        this.ShowInput.setText(this.InputStringBuffer);
    }

    private void InitButton() {

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
        this.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButtonActionPerformed(e);
            }
        });
    }

    private void LoadingPinYin(){
        if(this.InputStringBuffer.length() == 1)
            PinyinData.PINYIN_MAP.keySet().stream().forEach(key -> {
                if(this.InputStringBuffer.substring(0, 1).toUpperCase().equals(key.substring(0, 1)))
                    PinyinData.PINYIN_MAP.get(key).keySet().stream().forEach(key_2 -> {
                        String hanzis = new String(PinyinData.PINYIN_MAP.get(key).get(key_2)[0]);
                        for(int i = 0; i < hanzis.length(); i++){
                            UpdateHanziButton(hanzis.split("")[i]);
                        }
                    });
            });
        else if(this.InputStringBuffer.length() > 1)
            PinyinData.PINYIN_MAP.keySet().stream().forEach(FirstChar -> {
                PinyinData.PINYIN_MAP.get(FirstChar).keySet().stream().forEach(SecondChar -> {
                    if(SecondChar.length() > 1) {
                        if (this.InputStringBuffer.equals(SecondChar)) {
                            String hanzis = new String(PinyinData.PINYIN_MAP.get(FirstChar).get(SecondChar)[0]);
                            for (int i = 0; i < hanzis.length(); i++) UpdateHanziButton(hanzis.split("")[i]);
                        }
                        else if(this.InputStringBuffer.equals(SecondChar.substring(0, 2))) {
                            String hanzis = new String(PinyinData.PINYIN_MAP.get(FirstChar).get(SecondChar)[0]);
                            for (int i = 0; i < hanzis.length(); i++) UpdateHanziButton(hanzis.split("")[i]);
                        }
                    }
                    else if(SecondChar.length() > 2) {
                        if (this.InputStringBuffer.equals(SecondChar)) {
                            String hanzis = new String(PinyinData.PINYIN_MAP.get(FirstChar).get(SecondChar)[0]);
                            for (int i = 0; i < hanzis.length(); i++) UpdateHanziButton(hanzis.split("")[i]);
                        }
                        else if(this.InputStringBuffer.equals(SecondChar.substring(0, 3))) {
                            String hanzis = new String(PinyinData.PINYIN_MAP.get(FirstChar).get(SecondChar)[0]);
                            for (int i = 0; i < hanzis.length(); i++) UpdateHanziButton(hanzis.split("")[i]);
                        }
                    }
                    else if(SecondChar.length() > 3) {
                        if (this.InputStringBuffer.equals(SecondChar)) {
                            String hanzis = new String(PinyinData.PINYIN_MAP.get(FirstChar).get(SecondChar)[0]);
                            for (int i = 0; i < hanzis.length(); i++) UpdateHanziButton(hanzis.split("")[i]);
                        }
                        else if(this.InputStringBuffer.equals(SecondChar.substring(0, 4))) {
                            String hanzis = new String(PinyinData.PINYIN_MAP.get(FirstChar).get(SecondChar)[0]);
                            for (int i = 0; i < hanzis.length(); i++) UpdateHanziButton(hanzis.split("")[i]);
                        }
                    }
                    else if(SecondChar.length() > 4) {
                        if (this.InputStringBuffer.equals(SecondChar)) {
                            String hanzis = new String(PinyinData.PINYIN_MAP.get(FirstChar).get(SecondChar)[0]);
                            for (int i = 0; i < hanzis.length(); i++) UpdateHanziButton(hanzis.split("")[i]);
                        }
                        else if(this.InputStringBuffer.equals(SecondChar.substring(0, 5))) {
                            String hanzis = new String(PinyinData.PINYIN_MAP.get(FirstChar).get(SecondChar)[0]);
                            for (int i = 0; i < hanzis.length(); i++) UpdateHanziButton(hanzis.split("")[i]);
                        }
                    }
                    else if(SecondChar.length() > 5) {
                        if (this.InputStringBuffer.equals(SecondChar)) {
                            String hanzis = new String(PinyinData.PINYIN_MAP.get(FirstChar).get(SecondChar)[0]);
                            for (int i = 0; i < hanzis.length(); i++) UpdateHanziButton(hanzis.split("")[i]);
                        }
                        else if(this.InputStringBuffer.equals(SecondChar.substring(0, 6))) {
                            String hanzis = new String(PinyinData.PINYIN_MAP.get(FirstChar).get(SecondChar)[0]);
                            for (int i = 0; i < hanzis.length(); i++) UpdateHanziButton(hanzis.split("")[i]);
                        }
                    }
                });
            });
    }

    private void UpdateHanziButton(String string){
        int DynamicButtonInterval = 5;
        JButton jButton1 = new JButton(string);
        jButton.setMaximumSize(new Dimension(jButton.getPreferredSize().width, Integer.MAX_VALUE));
        jButton1.setBackground(new Color(0xf8, 0xc8, 0xdc));
        jButton1.setForeground(new Color(0x2d, 0x2d, 0x2d));
        jButton1.setBorder(BorderFactory.createLineBorder(new Color(0xE8E8E8)));
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hanziButtonActionPerformd(e);
            }
        });
        this.scrollPanel.add(jButton1);
        this.scrollPanel.add(Box.createHorizontalStrut(DynamicButtonInterval));
    }

    private void hanziButtonActionPerformd(ActionEvent event){
        this.mainFrame.addOutputTextField(event.getActionCommand());
        this.InputStringBuffer = "";
        this.ShowInput.setText(this.InputStringBuffer);
        this.scrollPanel.removeAll();
//        this.dispose();
    }

}
