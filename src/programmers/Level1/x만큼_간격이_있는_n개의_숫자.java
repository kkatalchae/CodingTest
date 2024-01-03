package Level1;

import java.util.Arrays;
import java.util.Scanner;

public class x만큼_간격이_있는_n개의_숫자 {

    /*
    정수 x 와 자연수 n 을 입력 받아, x 부터 시작해 x 씩 증가하는 숫자
    n 개 지니는 리스트를 리턴해야 합니다.
    제한 조건 : x 는 -10000000 이상, 10000000 이하인 정수입니다.
    n 은 1000 이하인 자연수입니다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // x 의 범위가 10000000 이기 때문에 늘려나가다 보면 넘칠 가능성이 있기 때문에 long 형으로 받아준다.
        long x = sc.nextLong();
        int n = sc.nextInt();

        System.out.println("x : " + x);
        System.out.println("n : " + n);

        // 같은 이유로 배열 속 요소들도 long 형으로 설정
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = x * (i + 1);
        }
        // 출력을 위한 코드
        System.out.println(Arrays.toString(answer));

    }
}
