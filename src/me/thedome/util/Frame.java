package me.thedome.util;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionListener;

/**
 * ComputerCraft Paster/me.thedome.util
 * Created on 10/2016.
 */
public class Frame extends JFrame {

	private final JFrame frame = this;
	Paster p;
	private ActionListener startListener;
	private ActionListener stopListener;
	private ActionListener clipboardPasteListener;


	public Frame() {
		this.setTitle("Computercraft Paster");
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				panel.setOpaque(true);

				JEditorPane textArea = new JEditorPane();
				textArea.setEditable(true);
				textArea.setFont(Font.getFont(Font.SANS_SERIF));
				textArea.setMinimumSize(new Dimension(300, 200));


				JScrollPane scroller = new JScrollPane(textArea);
				scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
				scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

				JPanel inputpanel = new JPanel();
				inputpanel.setLayout(new FlowLayout());
				inputpanel.setMaximumSize(new Dimension(500, inputpanel.getPreferredSize().height));

				JSpinner timeUntilCopySpinner = new JSpinner(new SpinnerNumberModel(3000, 500, 10000, 500));
				JSpinner msBetweenClickSpinner = new JSpinner((new SpinnerNumberModel(10, 10, 1000, 10)));


				JLabel msBetweenClick = new JLabel("ms between keypresses");
				JLabel label = new JLabel("ms until copy");
				JButton startButton = new JButton("Paste");
				JButton clipboardPaste = new JButton("Paste clipboard!");
				JButton stopButton = new JButton("Stop");

				stopButton.setEnabled(false);

				startListener = e -> {
					p = new Paster(textArea.getText(), Integer.parseInt(timeUntilCopySpinner.getValue().toString()), stopButton, Integer.parseInt(msBetweenClickSpinner.getValue().toString()));
					p.start();
				};

				stopListener = e -> p.stopKeys();

				clipboardPasteListener = e -> {

					// Get the text from the clipboard
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

					try {
						p = new Paster((String) clipboard.getData(DataFlavor.stringFlavor), Integer.parseInt(timeUntilCopySpinner.getValue().toString()), stopButton, Integer.parseInt(msBetweenClickSpinner.getValue().toString()));
						p.start();
					} catch (Exception e1) {
					}
				};

				startButton.addActionListener(startListener);
				stopButton.addActionListener(stopListener);

				clipboardPaste.addActionListener(clipboardPasteListener);

				DefaultCaret caret = (DefaultCaret) textArea.getCaret();
				caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);


				panel.add(scroller);
				inputpanel.add(stopButton);
				inputpanel.add(clipboardPaste);
				inputpanel.add(startButton);
				inputpanel.add(timeUntilCopySpinner);
				inputpanel.add(label);
				inputpanel.add(msBetweenClickSpinner);
				inputpanel.add(msBetweenClick);
				panel.add(inputpanel);


				setDefaultLookAndFeelDecorated(true);
				frame.getContentPane().add(BorderLayout.CENTER, panel);
				frame.pack();
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
				textArea.requestFocus();
			}
		});
	}
}
