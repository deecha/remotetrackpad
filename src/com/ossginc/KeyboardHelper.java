package com.ossginc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardHelper {

	private static KeyboardHelper instance = null;
	private static Robot robot;
	private static KeySequence ks;
	
	private KeyboardHelper() {
		try {
			robot = new Robot();
			ks = new KeySequence();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static KeyboardHelper getInstance() {
		if (instance == null) {
			instance = new KeyboardHelper();
		}
		return instance;
	}

	public class KeySequence {

		public void type(int keyCode, char keyChar) {
			robot.keyPress(keyCode);
			robot.keyRelease(keyCode);
		}

		public void press(int keyCode, char keyChar) {
			robot.keyPress(keyCode);
		}

		public void release(int keyCode, char keyChar) {
			robot.keyRelease(keyCode);
		}

	}

	public void dispatchKeyViaRobot(char asciiCode) {
		processCharacterPress(asciiCode);
	}

	private void processCharacterPress(char character) {
		switch (character) {
		case 'a':
			ks.type(KeyEvent.VK_A, character);
			break;
		case 'b':
			ks.type(KeyEvent.VK_B, character);
			break;
		case 'c':
			ks.type(KeyEvent.VK_C, character);
			break;
		case 'd':
			ks.type(KeyEvent.VK_D, character);
			break;
		case 'e':
			ks.type(KeyEvent.VK_E, character);
			break;
		case 'f':
			ks.type(KeyEvent.VK_F, character);
			break;
		case 'g':
			ks.type(KeyEvent.VK_G, character);
			break;
		case 'h':
			ks.type(KeyEvent.VK_H, character);
			break;
		case 'i':
			ks.type(KeyEvent.VK_I, character);
			break;
		case 'j':
			ks.type(KeyEvent.VK_J, character);
			break;
		case 'k':
			ks.type(KeyEvent.VK_K, character);
			break;
		case 'l':
			ks.type(KeyEvent.VK_L, character);
			break;
		case 'm':
			ks.type(KeyEvent.VK_M, character);
			break;
		case 'n':
			ks.type(KeyEvent.VK_N, character);
			break;
		case 'o':
			ks.type(KeyEvent.VK_O, character);
			break;
		case 'p':
			ks.type(KeyEvent.VK_P, character);
			break;
		case 'q':
			ks.type(KeyEvent.VK_Q, character);
			break;
		case 'r':
			ks.type(KeyEvent.VK_R, character);
			break;
		case 's':
			ks.type(KeyEvent.VK_S, character);
			break;
		case 't':
			ks.type(KeyEvent.VK_T, character);
			break;
		case 'u':
			ks.type(KeyEvent.VK_U, character);
			break;
		case 'v':
			ks.type(KeyEvent.VK_V, character);
			break;
		case 'w':
			ks.type(KeyEvent.VK_W, character);
			break;
		case 'x':
			ks.type(KeyEvent.VK_X, character);
			break;
		case 'y':
			ks.type(KeyEvent.VK_Y, character);
			break;
		case 'z':
			ks.type(KeyEvent.VK_Z, character);
			break;
		case 'A':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_A, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'B':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_B, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'C':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_C, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'D':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_D, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'E':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_E, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'F':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_F, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'G':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_G, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'H':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_H, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'I':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_I, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'J':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_J, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'K':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_K, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'L':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_L, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'M':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_M, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'N':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_N, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'O':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_O, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'P':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_P, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'Q':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_Q, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'R':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_R, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'S':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_S, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'T':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_T, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'U':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_U, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'V':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_V, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'W':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_W, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'X':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_X, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'Y':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_Y, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case 'Z':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_Z, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '`':
			ks.type(KeyEvent.VK_BACK_QUOTE, character);
			break;
		case '0':
			ks.type(KeyEvent.VK_0, character);
			break;
		case '1':
			ks.type(KeyEvent.VK_1, character);
			break;
		case '2':
			ks.type(KeyEvent.VK_2, character);
			break;
		case '3':
			ks.type(KeyEvent.VK_3, character);
			break;
		case '4':
			ks.type(KeyEvent.VK_4, character);
			break;
		case '5':
			ks.type(KeyEvent.VK_5, character);
			break;
		case '6':
			ks.type(KeyEvent.VK_6, character);
			break;
		case '7':
			ks.type(KeyEvent.VK_7, character);
			break;
		case '8':
			ks.type(KeyEvent.VK_8, character);
			break;
		case '9':
			ks.type(KeyEvent.VK_9, character);
			break;
		case '-':
			ks.type(KeyEvent.VK_MINUS, character);
			break;
		case '=':
			ks.type(KeyEvent.VK_EQUALS, character);
			break;
		case '~':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_BACK_QUOTE, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '!':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_1, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '@':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(50, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '#':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(51, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '$':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(52, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '%':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_5, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '^':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(54, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '&':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(55, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '*':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(56, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '(':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(57, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case ')':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_0, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '_':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_MINUS, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '+':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_EQUALS, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '\t':
			ks.type(KeyEvent.VK_TAB, character);
			break;
		case '\n':
			ks.type(KeyEvent.VK_ENTER, character);
			break;
		case '[':
			ks.type(KeyEvent.VK_OPEN_BRACKET, character);
			break;
		case ']':
			ks.type(KeyEvent.VK_CLOSE_BRACKET, character);
			break;
		case '\\':
			ks.type(KeyEvent.VK_BACK_SLASH, character);
			break;
		case '{':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_OPEN_BRACKET, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '}':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_CLOSE_BRACKET, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '|':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_BACK_SLASH, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case ';':
			ks.type(KeyEvent.VK_SEMICOLON, character);
			break;
		case ':':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_SEMICOLON, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case '\'':
			ks.type(222, character);
			break;
		case '"':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(222, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case ',':
			ks.type(KeyEvent.VK_COMMA, character);
			break;
		case '<':
			ks.type(KeyEvent.VK_LESS, character);
			break;
		case '.':
			ks.type(KeyEvent.VK_PERIOD, character);
			break;
		case '>':
			ks.type(KeyEvent.VK_GREATER, character);
			break;
		case '/':
			ks.type(KeyEvent.VK_SLASH, character);
			break;
		case '?':
			ks.press(KeyEvent.VK_SHIFT, '\0');
			ks.type(KeyEvent.VK_SLASH, character);
			ks.release(KeyEvent.VK_SHIFT, '\0');
			break;
		case ' ':
			ks.type(KeyEvent.VK_SPACE, character);
			break;
		case 8:
			ks.type(KeyEvent.VK_BACK_SPACE, character);
			break;
		default:
			throw new IllegalArgumentException("Cannot type character "
					+ character);
		}
	}
}
