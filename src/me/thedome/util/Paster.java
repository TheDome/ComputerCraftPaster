package me.thedome.util;

import javax.swing.*;
import java.awt.*;

import static java.awt.event.KeyEvent.*;

/**
 * ComputerCraft Paster/me.thedome.util
 * Created on 10/2016.
 */
class Paster extends Thread {

	private boolean stop = false;
	private String paste;
	private int delay;
	private JButton stopButton;
	private int millisBetweenClick;
	private Robot robot = null;
	private JEditorPane textArea;

	Paster(String s, int milis, JButton stop, JEditorPane text, int milisBetweenClick) {
		paste = s;
		delay = milis;
		stopButton = stop;
		millisBetweenClick = milisBetweenClick;
		textArea = text;
	}

	@Override
	public void run() {
		super.run();
		stopButton.setEnabled(true);
		textArea.setEnabled(false);
		printOnScreen(paste, delay);
		stopButton.setEnabled(false);
		textArea.setEnabled(true);
	}

	private void printOnScreen(String s, int millis) {

		stop = false;

		try {
			sleep(millis);

			robot = new Robot();
			String[] splitString = s.split("\n");


			for (int i = 0; i < s.length(); i++) {
				if (stop) return;
				if (s.charAt(i) == '\r') {
					returnKeyValue(s.charAt(++i));
					returnKeyValue(s.charAt(i - 1));
				} else {
					returnKeyValue(s.charAt(i));
				}
			}


		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	void stopKeys() {
		stop = true;
	}

	private void returnKeyValue(char s) throws Exception {
		System.out.print(s);
		switch (s) {
			case 'a':
				doType(VK_A);
				break;
			case 'b':
				doType(VK_B);
				break;
			case 'c':
				doType(VK_C);
				break;
			case 'd':
				doType(VK_D);
				break;
			case 'e':
				doType(VK_E);
				break;
			case 'f':
				doType(VK_F);
				break;
			case 'g':
				doType(VK_G);
				break;
			case 'h':
				doType(VK_H);
				break;
			case 'i':
				doType(VK_I);
				break;
			case 'j':
				doType(VK_J);
				break;
			case 'k':
				doType(VK_K);
				break;
			case 'l':
				doType(VK_L);
				break;
			case 'm':
				doType(VK_M);
				break;
			case 'n':
				doType(VK_N);
				break;
			case 'o':
				doType(VK_O);
				break;
			case 'p':
				doType(VK_P);
				break;
			case 'q':
				doType(VK_Q);
				break;
			case 'r':
				doType(VK_R);
				break;
			case 's':
				doType(VK_S);
				break;
			case 't':
				doType(VK_T);
				break;
			case 'u':
				doType(VK_U);
				break;
			case 'v':
				doType(VK_V);
				break;
			case 'w':
				doType(VK_W);
				break;
			case 'x':
				doType(VK_X);
				break;
			case 'y':
				doType(VK_Y);
				break;
			case 'z':
				doType(VK_Z);
				break;
			case 'A':
				doType(VK_SHIFT, VK_A);
				break;
			case 'B':
				doType(VK_SHIFT, VK_B);
				break;
			case 'C':
				doType(VK_SHIFT, VK_C);
				break;
			case 'D':
				doType(VK_SHIFT, VK_D);
				break;
			case 'E':
				doType(VK_SHIFT, VK_E);
				break;
			case 'F':
				doType(VK_SHIFT, VK_F);
				break;
			case 'G':
				doType(VK_SHIFT, VK_G);
				break;
			case 'H':
				doType(VK_SHIFT, VK_H);
				break;
			case 'I':
				doType(VK_SHIFT, VK_I);
				break;
			case 'J':
				doType(VK_SHIFT, VK_J);
				break;
			case 'K':
				doType(VK_SHIFT, VK_K);
				break;
			case 'L':
				doType(VK_SHIFT, VK_L);
				break;
			case 'M':
				doType(VK_SHIFT, VK_M);
				break;
			case 'N':
				doType(VK_SHIFT, VK_N);
				break;
			case 'O':
				doType(VK_SHIFT, VK_O);
				break;
			case 'P':
				doType(VK_SHIFT, VK_P);
				break;
			case 'Q':
				doType(VK_SHIFT, VK_Q);
				break;
			case 'R':
				doType(VK_SHIFT, VK_R);
				break;
			case 'S':
				doType(VK_SHIFT, VK_S);
				break;
			case 'T':
				doType(VK_SHIFT, VK_T);
				break;
			case 'U':
				doType(VK_SHIFT, VK_U);
				break;
			case 'V':
				doType(VK_SHIFT, VK_V);
				break;
			case 'W':
				doType(VK_SHIFT, VK_W);
				break;
			case 'X':
				doType(VK_SHIFT, VK_X);
				break;
			case 'Y':
				doType(VK_SHIFT, VK_Y);
				break;
			case 'Z':
				doType(VK_SHIFT, VK_Z);
				break;
			case '`':
				doType(VK_BACK_QUOTE);
				break;
			case '0':
				doType(VK_0);
				break;
			case '1':
				doType(VK_1);
				break;
			case '2':
				doType(VK_2);
				break;
			case '3':
				doType(VK_3);
				break;
			case '4':
				doType(VK_4);
				break;
			case '5':
				doType(VK_5);
				break;
			case '6':
				doType(VK_6);
				break;
			case '7':
				doType(VK_7);
				break;
			case '8':
				doType(VK_8);
				break;
			case '9':
				doType(VK_9);
				break;

			// Special
			case '-':
				doType(VK_MINUS);
				break;
			case '=':
				doType(VK_SHIFT, VK_0);
				break;
			case '~':
				doType(VK_SHIFT, VK_BACK_QUOTE);
				break;
			case '!':
				doType(VK_EXCLAMATION_MARK);
				break;
			case '@':
				doType(VK_ALT, VK_6, VK_4);
				break;
			case '#':
				doType(VK_NUMBER_SIGN);
				break;
			case '$':
				doType(VK_DOLLAR);
				break;
			case '%':
				doType(VK_SHIFT, VK_5);
				break;
			case '^':
				doType(VK_CIRCUMFLEX);
				break;
			case '&':
				doType(VK_AMPERSAND);
				break;
			case '*':
				doType(VK_SHIFT, VK_PLUS);
				break;
			case '(':
				doType(VK_SHIFT, VK_8);
				break;
			case ')':
				doType(VK_SHIFT, VK_9);
				break;
			case '_':
				doType(VK_SHIFT, VK_MINUS);
				break;
			case '+':
				doType(VK_PLUS);
				break;
			case '\t':
				doType(VK_SPACE);
				break;
			case '\n':
				doType(VK_ENTER);
				break;
			case '[':
				Thread.sleep(10);
				doType(VK_CONTROL, VK_ALT, VK_8);
				break;
			case ']':
				Thread.sleep(10);
				doType(VK_CONTROL, VK_ALT, VK_9);
				break;
			case '\\':
				doType(VK_BACK_SLASH);
				break;
			case '{':
				Thread.sleep(10);
				doType(VK_CONTROL, VK_ALT, VK_7);
				break;
			case '}':
				Thread.sleep(10);
				doType(VK_CONTROL, VK_ALT, VK_0);
				break;
			case '|':
				doType(VK_SHIFT, VK_BACK_SLASH);
				break;
			case ';':
				doType(VK_SHIFT, VK_COMMA);
				break;
			case ':':
				doType(VK_SHIFT, VK_PERIOD);
				break;
			case '\'':
				doType(VK_QUOTE);
				break;
			case '"':
				doType(VK_SHIFT, VK_2);
				break;
			case ',':
				doType(VK_COMMA);
				break;
			case '<':
				doType(VK_LESS);
				break;
			case '.':
				doType(VK_PERIOD);
				break;
			case '>':
				doType(VK_SHIFT, VK_LESS);
				break;
			case '/':
				doType(VK_SHIFT, VK_7);
				break;
			case '?':
				doType(VK_SHIFT, VK_SLASH);
				break;
			case ' ':
				doType(VK_SPACE);
				break;
			case '\r':
				doType(VK_HOME);
				break;
			default:
				throw new IllegalArgumentException("Cannot type character " + s);
		}
	}

	private void doType(int... keyCodes) {
		doType(keyCodes, 0, keyCodes.length);
	}

	private void doType(int[] keyCodes, int offset, int length) {


		if (length == 0) {
			return;
		}

		if (keyCodes[offset] == VK_CONTROL) {
			robot.keyPress(keyCodes[offset]);
			robot.keyRelease(keyCodes[offset]);
		}

		try {
			Thread.sleep(millisBetweenClick);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		robot.keyPress(keyCodes[offset]);
		doType(keyCodes, offset + 1, length - 1);
		robot.keyRelease(keyCodes[offset]);
	}


}
