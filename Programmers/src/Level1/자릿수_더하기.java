package Level1;

public class 자릿수_더하기 {

    /*
    문제 설명
    자연수 N 이 주어지면, N 의 각 자릿수의 합을 구해서 return 하는 함수를 만들어 주세요.

    제한 사항
    N 의 범위 : 100,000,000 이하의 자연수
     */

    // 무한 루프보다 조금 더 간결하게 풀어냄
    private static int solution(int N) {
        int answer = 0;

        while (N != 0){
            answer += N % 10;
            N /= 10;
        }

        return answer;
    }

    // 기존 풀이 - 무한 루프
    private static int solution2(int N) {
        int answer = 0;
        while(true){
            answer += (int)n%10;
            if(N < 10) break;
            N /= 10;

        }
        return answer;
    }


    public static void main(String[] args){
        int[] tests = {
                123,
                987,
                99999999 // 최대값
        };

        for (int test : tests) System.out.println(solution(test));
    }
}
