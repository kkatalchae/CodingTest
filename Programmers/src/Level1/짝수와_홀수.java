package Level1;

public class 짝수와_홀수 {

    /*
    문제
    정수 num 이 짝수일 경우 "Even" 을 반환하고 홀수인 경우 "Odd" 를 반환하는 함수를 완성하세요.

    제한 조건
    num 은 int 범위의 정수입니다.
    0은 짝수입니다.
     */

    public static String solution(int num) {
        if(num % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    public static void main(String[] args){

        int[] tests = {0, 3, 4,765};

        for (int test : tests) System.out.println(solution(test));

    }
}
