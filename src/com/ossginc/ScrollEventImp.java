package com.ossginc;

import java.awt.AWTException;
import java.awt.Robot;

public class ScrollEventImp extends AbstractEventImp implements ScrollEvent {

	private static ScrollEvent instance=null;
	Robot r;
	
	ScrollEventImp() {
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void processEvent() {
		//int numObjects = pdu.getNumberOfObjects();
		//int scrollEvent = (Integer) pdu.getRawPayload()[0];
		//System.out.println("Number of sc.evt objects = "+numObjects+", scrllEventType = "+scrollEvent+" scroll2 = "+(int) pdu.getRawPayload()[1]);
		r.mouseWheel((Integer) pdu.getRawPayload()[1]);
	}
	
	public static ScrollEvent getInstance() {
		if (instance==null)	instance=new ScrollEventImp();
		return instance;
	}

}
