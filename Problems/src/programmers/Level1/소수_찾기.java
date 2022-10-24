package Level1;

public class 소수_찾기 {

    /*
    문제 설명
    1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수를 완성하세요.

    제한 조건
    n 은 2 이상 10000000 이하의 자연수입니다.

     */

    private static int solution(int n) {
        int answer = 0;

        if (n <= 1) return answer;
        if (n == 2) return ++answer;

        for (int i = 2; i <= n; i++) {
            if (isPrime2(i)) answer++;
        }

        return answer;
    }

    // 에라토스테네스의 체 ( 최소 0.02 ms 73.4 mb 최대 12.75 ms 79.9 mb 효율성 테스트 통과 )
    private static int solution2(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n + 1];

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) prime[j] = true;
            }
        }

        for (int i = 1; i <= n; i++) if (!prime[i]) answer++;

        return answer;

    }

    // 2부터 n 까지 나누면서 소수인지 확인 제한의 최대값을 대입하면 굉장히 오랜 시간이 소요됨
    private static boolean isPrime(int n) {

        if (n <= 1) return false;
        if (n == 2) return true;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    // 2 부터 n 의 제곱근까지 나누면서 소수인지 확인 최대값을 대입하면 조금 시간이 걸리긴 하지만 금방 나옴
    private static boolean isPrime2(int n) {

        if (n <= 1) return false;
        if (n == 2) return true;

        for (int i = 2; i <= Math.sqrt(n); i ++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] tests = {10, 5, 1, 2, 10000000};

        for (int test : tests) System.out.println("첫번째 풀이 결과 : " + solution(test));
        for (int test : tests) System.out.println("두번째 풀이 결과 : " + solution2(test));

    }
}
