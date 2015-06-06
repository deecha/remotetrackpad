package com.ossginc;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseEventImp extends AbstractEventImp implements MouseEvent {

	private String subEventType;
	private static MouseEvent instance=null;
	
	MouseEventImp() {
		instance = this;
	}

	@Override
	public String getSubEventType() {
		return subEventType;
	}

	@Override
	public void processEvent() {
		int mouseEvent = (Integer) pdu.getRawPayload()[0];
		switch(mouseEvent) {
		case 0:
			int x = (Integer) pdu.getRawPayload()[1];
			int y = (Integer) pdu.getRawPayload()[2];
			moveMouse(x,y);
			break;
		case 1:
			mouseClick("left");
			break;
		case 2:
			mouseClick("right");
			break;
		default:
			System.out.println("Default event");
			break;
		}
	}
	
	void moveMouse(int x, int y){
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int currX =  (int) b.getX();
		int currY =  (int) b.getY();
		currX += x;
		currY += y;
		Robot r=null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		if (r != null) r.mouseMove(currX, currY);
		x=0;
		y=0;
		r = null;
	}
	
	void mouseClick(String buttonOrientation) {
		Robot robot=null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		if (robot != null) {
			if (buttonOrientation.equalsIgnoreCase("left")){
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
			}
			if (buttonOrientation.equalsIgnoreCase("right")){
				robot.mousePress(InputEvent.BUTTON3_MASK);
				robot.mouseRelease(InputEvent.BUTTON3_MASK);
			}
		}
		robot = null;
	}


	public static MouseEvent getInstance() {
		if (instance==null) instance=new MouseEventImp();
		return instance;
	}

}
