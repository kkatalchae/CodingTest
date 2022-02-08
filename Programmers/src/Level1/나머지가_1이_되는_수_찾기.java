package Level1;

public class 나머지가_1이_되는_수_찾기 {

    /*
    문제 설명
    자연수 n 이 매개변수로 주어집니다.
    n 을 x 로 나눈 나머지가 1 이 되도록 하는 가장 작은 자연수 x 를 리턴하도록 함수를 완성하세요

    제한 사항
    3 <= n <= 1,000,000

     */

    public static int solution(int n) {

        int minVal;
        for (minVal = 2; minVal < n; minVal++) {
            if (n % minVal == 1) {
                break;
            }
        }

        return minVal;
    }

    public static void main(String[] args) {

        int[] tests = {10, 12};

        for (int test : tests) System.out.println(solution(test));

    }
}
