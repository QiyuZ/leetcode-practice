class Solution {
    public int carFleet(int target, int[] position, int[] speed) { //bucket
        int fleets = 0;
        double max = -1;
        double[] times = new double[target + 1];
        Arrays.fill(times, -1);
        for (int i = 0; i < position.length; i++) times[position[i]] = (double)(target - position[i]) / speed[i]; 
        //此处注意只能double分子否则就是计算完以后才double的
        for (int i = times.length - 1; i >= 0; i--) {
            if (times[i] > max) { //如果时间比这个长，说明不能追上，而且是按照距离从离target最近的开始的
                max = times[i];
                fleets++;
            }
        }
        return fleets;
    }
}
