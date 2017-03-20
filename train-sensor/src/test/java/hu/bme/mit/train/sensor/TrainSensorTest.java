package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.mockito.Mockito.*;

public class TrainSensorTest {
	TrainController controller;
	TrainSensor sensor;
	TrainUser user;

    @Before
    public void before() {
    	controller = mock(TrainController.class);
    	user = mock(TrainUser.class);
    	sensor = new TrainSensorImpl(controller, user);
    }

	@Test
	public void OverridingSpeedLimitUpTo500_SetsAlarmStateTrue() {
		sensor.overrideSpeedLimit(501);
		verify(user, times(1)).setAlarmState(true);
	}

	@Test
	public void OverridingReferenceSpeedUpTo50Percent_SetsAlarmStateTrue() {
		when(controller.getReferenceSpeed()).thenReturn(50);
		sensor.overrideSpeedLimit(1);
		
		verify(user, times(1)).setAlarmState(true);
	}
	
	@Test
	public void OverridingSpeedLimitWithValidValue_SetAlarmStateFalse() {
		sensor.overrideSpeedLimit(300);
		verify(user, times(1)).setAlarmState(false);
	}
}
