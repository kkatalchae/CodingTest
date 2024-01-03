package Level1;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {

    static int[] solution(int[] arr){
        // 제일 작은 수를 제거한 배열이 비어있을 경우
        if (arr.length <= 1) return new int[]{ -1 };

        // 최소값
        int min = Arrays.stream(arr).min().getAsInt();

        // 최소값과 일치하지 않는 값만 다시 배열에 담아준다.
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        System.out.println(Arrays.toString(solution(arr)));

    }
}
