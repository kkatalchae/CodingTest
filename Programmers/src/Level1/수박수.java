package Level1;

public class 수박수 {

    /*
    문제 설명
    길이가 n 이고, "수박수박수박수...." 와 같은 패턴을 유지하는 문자열을 리턴하는 함수를 완성하세요.

    제한 조건
    n 은 길이 10,000 이하인 자연수입니다.

     */

    // 0.05 ~ 0.99 ms 70 ~ 80 mb
    private static String solution(int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= n; i++){
            if (i % 2 != 0)
                builder.append("수");
            else
                builder.append("박");
        }
        return builder.toString();
    }

    // 기존 풀이 0.08 ~ 1.25 ms  60 ~ 70 mb
    private static String solution2(int n) {
        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
    }

    public static void main(String[] args){
        int[] tests = { 3, 4, 10000 };

        for (int test : tests) System.out.println(solution(test));
    }
}
