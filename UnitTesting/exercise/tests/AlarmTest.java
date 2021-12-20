package UnitTesting.exercise.tests;

import UnitTesting.exercise.p06_TirePressureMonitoringSystem.Alarm;
import UnitTesting.exercise.p06_TirePressureMonitoringSystem.Sensor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    private static final double LOW_PRESSURE_VALUE = 12;
    private static final double HIGH_PRESSURE_VALUE = 50;
    private static final double NORMAL_PRESSURE_VALUE = 18;

    @Test
    public void testAlarmTurnsOnForLowPressure() {
        Sensor fakeLowPressureSensor = Mockito.mock(Sensor.class);
        Mockito.when(fakeLowPressureSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);
        Alarm alarm = new Alarm(fakeLowPressureSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmTurnsOnForHighPressure() {
        Sensor fakeHighPressureSensor = Mockito.mock(Sensor.class);
        Mockito.when(fakeHighPressureSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);
        Alarm alarm = new Alarm(fakeHighPressureSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmForNormalPressure() {
        Sensor fakeNormalPressureSensor = Mockito.mock(Sensor.class);
        Mockito.when(fakeNormalPressureSensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE_VALUE);
        Alarm alarm = new Alarm(fakeNormalPressureSensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}
