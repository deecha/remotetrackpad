package com.ossginc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import com.illposed.osc.OSCMessage;

public class ProtocolDataUnit {
	
	private String messageType;
	private Object[] payload;
	private byte[] payloadBytes;
	private int numberOfObjects;
	
	ProtocolDataUnit(OSCMessage pdu) {
		messageType = pdu.getAddress().substring(1).trim();
		payload = pdu.getArguments();
		numberOfObjects = payload.length;
		convertToBytes();
	}
	
	void convertToBytes() {
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(ba);
			out.writeObject(payload);
			payloadBytes = ba.toByteArray();
			out.close();
			ba.close();
		} catch (IOException iox) { iox.printStackTrace(); }
	}
	
	public String getMessageType() {
		return messageType;
	}
	
	public Object[] getRawPayload() {
		return payload;
	}
	
	public byte[] getPayloadBytes() {
		return payloadBytes;
	}

	public int getNumberOfObjects() {
		return numberOfObjects;
	}
}
