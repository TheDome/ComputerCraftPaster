package me.thedome.util;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * ComputerCraft Paster/me.thedome.util
 * Created on 10/2016.
 */
public class Frame extends JFrame {

	private final JFrame frame = this;
	private ActionListener startListener;
	private ActionListener stopListener;
	Paster p;


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

				JSpinner spinner = new JSpinner(new SpinnerNumberModel(3000, 500, 10000, 500));

				JLabel label = new JLabel("ms until copy");
				JButton startButton = new JButton("Paste");
				JButton stopButton = new JButton("Stop");

				stopButton.setEnabled(false);

				startListener = e -> {
					p = new Paster(textArea.getText(), Integer.parseInt(spinner.getValue().toString()), stopButton);
					p.start();
				};

				stopListener = e -> p.stopKeys();

				startButton.addActionListener(startListener);
				stopButton.addActionListener(stopListener);

				DefaultCaret caret = (DefaultCaret) textArea.getCaret();
				caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);


				panel.add(scroller);
				inputpanel.add(stopButton);
				inputpanel.add(startButton);
				inputpanel.add(spinner);
				inputpanel.add(label);
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
