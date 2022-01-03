package Level1;

public class 문자열을_정수로_바꾸기 {

    /*
    문제 설명
    문자열 s 를 숫자로 변환한 결과를 반환하는 함수를 완성하세요.

    제한 조건
    s 의 길이는 1 이상 5 이하입니다.
    s 의 맨앞에는 부호 ( + , - ) 가 올 수 있습니다.
    s 는 부호와 숫자로만 이루어져 있습니다.
    s 는 "0" 으로 시작하지 않습니다.

     */

    private static int solution(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args){
        String[] tests = {
                "1234",
                "+1234", // + 기호가 앞에 위치한 경우
                "-1234", // - 기호가 앞에 위치한 경우
                "99999" // 최대값
        };

        for (String test : tests) System.out.println(solution(test));
    }
}
