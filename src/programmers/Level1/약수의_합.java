package Level1;

public class 약수의_합 {

    /*
    문제 설명
    정수 n 을 입력받아 n 의 약수를 모두 더한 값을 리턴하는 함수를 완성해주세요.

    제한 사항
    n 은 0 이상 3000 이하인 정수입니다.
     */

    // 기존 풀이와 크게 다르지 않음 호
    private static int solution(int n) {
        int sum = 0;

        // 나누었을 떄 나머지가 0이라는 것은 약수라는 의미
        for (int i = 1; i <= n; i++){
            if (n % i == 0) sum += i;
        }

        return sum;
    }

    public static void main(String[] args){
        int[] tests = {12, 5, 3000, 0, 100};

        for (int test : tests) System.out.println(solution(test));
    }
}
