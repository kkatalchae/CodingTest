package Level2;

public class 숫자의_표현 {

    /*
    문제 설명
    Finn 은 요즘 수학공부에 빠져 있습니다.
    수학 공부를 하던 Finn 은 자연수 n 을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
    예를 들어 15 는 다음과 같이 표시할 수 있습니다.
    1 + 2 + 3 + 4 + 5 = 15
    4 + 5 + 6 = 15
    7 + 8 = 15
    15 = 15

    자연수 n 이 매개변수로 주어질 때, 연속된 자연수들로 n 을 표현하는 방법의 수를 리턴하는 함수를 완성하세요.

    제한 사항
    n 은 10,000 이하의 자연수 입니다.

     */

    // ~ 0.17 ms , 70 ~ 80 mb
    private static int solution(int n) {

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return answer;
    }

    /*
     - , 황정우 , Jin Park , - , 즈스크 외 4 명
     ~ 0.04 ms 나의 풀이보다 빠른 성능을 보임 메모리는 비슷
     정수론 정리 - 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다
     */
    private static int solution2(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i += 2) {
            if (num % i == 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] tests = {15, 10000};

        for (int test : tests) System.out.println(solution(test));
        for (int test : tests) System.out.println(solution2(test));
    }
}
