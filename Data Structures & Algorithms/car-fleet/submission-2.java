class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[][] cars = new Integer[position.length][2];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Integer[] {position[i], speed[i]};
        }
        Arrays.sort(cars, (row1, row2) -> Integer.compare(row1[0], row2[0]));

        Deque<Double> stack = new ArrayDeque<>();

        for (int i = cars.length - 1; i >= 0; i--) {
            Double time = (double) (target - cars[i][0]) / (cars[i][1]);
            if (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
