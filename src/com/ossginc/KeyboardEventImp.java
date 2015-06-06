package com.ossginc;

public class KeyboardEventImp extends AbstractEventImp implements KeyboardEvent {

	private static KeyboardEvent instance = null;

	KeyboardEventImp() {
	}

	@Override
	public String getEventType() {
		return null;
	}

	@Override
	public void processEvent() {
		int keyCode = (Integer) pdu.getRawPayload()[0];
		int modifier = (Integer) pdu.getRawPayload()[1];
		// System.out.println("Object[0]="+keyCode+", Object[1]="+modifier);
		processKeyStrokeWithSpecialKeys(modifier, keyCode);
	}

	private void processKeyStrokeWithSpecialKeys(int modifier, int keyCode) {
		char processedAscii = ' ';
		try {
			switch (keyCode) {
			case -5: // bksp
				processedAscii = 8;
				break;
			case -7: // enter
				processedAscii = '\n';
				break;
			case 64: // @
				processedAscii = '@';
				break;
			case 35: // #
				processedAscii = '#';
				break;
			case 36: // $
				processedAscii = '$';
				break;
			case 38: // &
				processedAscii = '&';
				break;
			case 42: // *
				processedAscii = '*';
				break;
			case 40: // (
				processedAscii = '(';
				break;
			case 41: // )
				processedAscii = ')';
				break;
			case 33: // !
				processedAscii = '!';
				break;
			case 34: // "
				processedAscii = '"';
				break;
			case 58: // :
				processedAscii = ':';
				break;
			case 180:
				processedAscii = '\'';
				break;
			default:
				if (modifier == 1)
					processedAscii = Character.toUpperCase(Character
							.toChars(keyCode)[0]);
				else
					processedAscii = Character.toChars(keyCode)[0];
				break;
			}
			KeyboardHelper.getInstance().dispatchKeyViaRobot(processedAscii);
		} catch (Exception ex) {
			System.out.println("Modifier=" + modifier + " and for ascii="
					+ keyCode);
		}
	}

	public static KeyboardEvent getInstance() {
		if (instance == null)
			instance = new KeyboardEventImp();
		return instance;
	}

}
