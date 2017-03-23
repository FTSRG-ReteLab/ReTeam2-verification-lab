package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();
	
	boolean setReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

}
