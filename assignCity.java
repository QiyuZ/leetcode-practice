/*
给你每个人去la或者ny的两个地点需要的费用然后从中选取一个地点，比如给一个pair<int,int>(100,200)。
现在如果有n个人，要求一半人数去la一半人数去ny，求最少花费是多少。 */


public int getSum(List<int[]> people) {
	if (people == null || people.size() == 0) return 0;
	int res = 0;
	PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			return (o1[0] - o1[1]) - (o2[0] - o2[1]);
		}
	});
	for (int[] p : people) queue.offer(p);
	int city1 = people.size() / 2;
	for (int i = 0; i < city1; i++) sum += queue.poll()[0];
	if (people.size() % 2 == 1) {
		int[] mid = queue.poll();
		sum += Math.min(mid[0], mid[1]);
	}
	while (!queue.isEmpty()) sum += queue.poll()[1];
	return sum;
}
