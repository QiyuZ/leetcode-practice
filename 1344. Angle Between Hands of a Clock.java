class Solution {
    public double angleClock(int hour, int minutes) {
        double delta = 30 * (double)(minutes) / 60;
        double hourAngle = (hour == 12 ? 0 : hour * 30) + delta;
        double minAngle = minutes * 6;
        double angle = Math.abs(hourAngle - minAngle);
        return angle > 180 ? 360 - angle : angle;
    }
}
