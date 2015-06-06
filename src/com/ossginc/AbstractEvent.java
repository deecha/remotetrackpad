package com.ossginc;

public interface AbstractEvent {
	
	public String getEventType();
	public void processEvent();
	public void setPdu(ProtocolDataUnit pdu);
}
