package Level2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 피보나치_수 {

    /*
    문제 설명
    피보나치 수는 F(0) = 0, F(1) = 1 일 때, 1 이상의 n 에 대하여 F( n ) = F(n-1) + F(n-2)가 적용되는 수입니다.
    2 이상의 n 이 입력되었을 때, n 번쨰 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수를 완성하세요.

    제한 사항
    n 은 2 이상 100,000 이하인 자연수입니다.
     */

    private static int solution(int n) {

        // 피보나치 수를 담아줄 배열을 생성
        int[] arr = new int[n + 1];

        // 반복적으로 피보나치 수를 구하기 위한 초기 값들을 세팅해준다.
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        /*
         피보나치 수열의 규칙에 맞게 반복문을 돌려준다.
         이 때 피보나치 수를 구하는 식에서 1234567로 나눠주는 것이 중요하다.
         왜나햐면 그냥 피보나치 수를 구하게 되면 int 자료형으로는 담을 수 없기 때문에 오버 플로우가 발생한다.
         만약 7번 테스트부터 오류가 뜬다면 오버 플로우를 고려해봐야 한다.
         */
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
        }



        return arr[n];

    }

    // 다른 사람 풀이 배열을 사용하지 않고 변수 세 개를 이용해서 풀이
    private static int solution2(int n) {
        if (n == 2) return 1;

        int n1 = 1;
        int n2 = 1;
        int sum = 0;
        // n1 에 n-1 번쨰 피보나치 수를 n2 에 n-2 번째 피보나치를 넣고 n 번째 수를 구한 후 값들을 다음에 필요한 값들로 세팅
        for (int i = 3; i <= n; i++) {
            sum = n1 + n2;
            sum %= 1234567;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }

    /*
     재귀를 이용한 피보나치 수 구하기 - 7번 테스트부터 시간 초과가 나타남
     예를 들어 5번째 피보나치 수를 구하기 위해서 3번째 4번째 피보나치 수를 구해야하고
     다시 3번째를 구하기 위해 1, 2번을 구해서 더해야함
     때문에 불필요한 메모리가 많이 발생하고 시간 초과가 발생함
     */
    private static int solution3(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        return (solution3(n - 1) + solution3(n - 2)) % 1234567;


    }

    public static void main(String[] args) {
        int[] tests = {3, 5, 10, 50};

        for (int test : tests) {
            System.out.println("첫번쨰 풀이 결과 : " + solution(test));
            System.out.println("두번쨰 풀이 결과 : " + solution2(test));
            System.out.println("세번쨰 풀이 결과 : " + solution3(test));
        }


    }
}
