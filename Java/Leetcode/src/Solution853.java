import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution853
 * @Author 11214
 * @Date 2020/6/5
 * @Description 车队
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 */
public class Solution853 {
    private class Car {
        private int position;
        private double time;

        Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cars.add(new Car(position[i], (double) (target - position[i]) / speed[i]));
        }
        cars.sort((o1, o2) -> o2.position - o1.position);
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            if (cars.get(i).time >= cars.get(i + 1).time) {
                cars.get(i + 1).time = cars.get(i).time;
            } else {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(new Solution853().carFleet(12, position, speed));
    }
}
