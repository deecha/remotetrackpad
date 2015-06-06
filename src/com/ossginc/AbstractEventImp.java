package com.ossginc;

public abstract class AbstractEventImp implements AbstractEvent {
	
	protected ProtocolDataUnit pdu;
	
	AbstractEventImp() {
		
	}
	
	public void setPdu(ProtocolDataUnit pdu) {
		this.pdu = pdu;
	}
	
	@Override
	public String getEventType() {
		return pdu.getMessageType();
	}
}
