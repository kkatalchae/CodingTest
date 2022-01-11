package Level1;

public class 두_정수_사이의_합 {

    /*
    문제 설명
    두 정수 a, b 가 주어졌을 때 a 와 b 사이에 속한 모든 정수의 합을 리턴하는 함수를 완성하세요.

    제한 조건
    a 와 b 가 같은 경우는 둘 중 아무 수나 리턴하세요.
    a 와 b 는 -10,000,000 이상 10,000,000 이하인 정수입니다.
    a 와 b 의 대소관계는 정해져있지 않습니다.

     */

    // 0.03 ~ 12.91 ms 72 ~ 80 mb
    private static long solution(int a, int b) {
        long sum = 0;

        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) sum += i;

        return sum;
    }

    // 두 정수 사이의 합은 두 정수의 차이 + 1 과 두 정수의 합의 곱 나누기 2한 값과 같다는 원리를 이용한 풀이
    // 0.02 ~ 0.08 ms 71 ~ 90 mb
    private static long solution2(int a, int b){
        long min = Math.min(a, b);
        long max = Math.max(a, b);

        return (max - min + 1) * (min + max) / 2;
    }

    public static void main(String[] args){
        int[][] tests = {
                {3, 5},
                {3, 3},
                {5, 3}
        };

        for (int[] test : tests) System.out.println("첫번째 풀이 결과 : " + solution(test[0], test[1]));
        for (int[] test : tests) System.out.println("두번째 풀이 결과 : " + solution2(test[0], test[1]));
    }
}
