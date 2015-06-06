package com.ossginc;

import java.awt.Robot;

public class VolumeEventImp extends AbstractEventImp implements VolumeEvent {

	private static VolumeEvent instance=null;
	Robot r;

	@Override
	public void processEvent() {
		//int numObjects = pdu.getNumberOfObjects();
		int VolumeButtonEvent = (Integer) pdu.getRawPayload()[0];
		//System.out.println("number of objects " + numObjects);
	}

	public static VolumeEvent getInstance() {
		if (instance==null)	instance=new VolumeEventImp();
		return instance;
	}
}
