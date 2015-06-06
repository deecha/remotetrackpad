package com.ossginc;

import java.util.Date;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;

public class Receiver implements OSCListener{

	private enum EventType {
		mouse_event, scroll_event, keyboard_event, volume_event;
	}
	
	@Override
	public void acceptMessage(Date arg0, OSCMessage arg1) {
		ProtocolDataUnit pdu = new ProtocolDataUnit(arg1);
		EventType eventType = EventType.valueOf(pdu.getMessageType());
		AbstractEvent action=null;
		switch(eventType) {
		case mouse_event:
			action = MouseEventImp.getInstance();
			break;
		case scroll_event:
			action = ScrollEventImp.getInstance();
			break;
		case keyboard_event:
			action = KeyboardEventImp.getInstance();
			break;
		case volume_event:
			action = VolumeEventImp.getInstance();
			break;
		default:
			System.out.println("Unknown handler !");
		}
		if (action != null) {
			action.setPdu(pdu);
			action.processEvent();
		}
	}
}
