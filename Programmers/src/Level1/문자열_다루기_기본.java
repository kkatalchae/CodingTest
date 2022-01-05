package Level1;

import java.util.regex.Pattern;

public class 문자열_다루기_기본 {

    /*
    문제 설명
    문자열 s 의 길이가 4 혹은 6 이고, 숫자로만 구성돼있는지 확인해주는 함수를 완성하세요.
    예를 들어 s 가 "a234" 이면 False 를 리턴하고 "1234" 를 리턴하면 됩니다.

    제한 사항
    s 는 1 이상, 길이 8 이하인 문자열입니다.

     */

    // 0.02 ~ 0.15 ms 69 ~ 90 mb
    private static boolean solution(String s){

        boolean answer = false;
        String pattern = "^[0-9]*$";

        if (s.length() == 4 || s.length() == 6) {
            answer = Pattern.matches(pattern, s);
        }

        return answer;
    }

    // - , JegalJisu , - , - , - 외 86 명 0.01 ~ 0.08 ms 71 ~ 83 mb
    private static boolean solution2(String s){
        if(s.length() == 4 || s.length() == 6){
            try{
                int x = Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
        else return false;

    }

    public static void main(String[] args){
        String[] tests = { "a234", "1234" };

        for (String test : tests) System.out.println("첫번째 풀이 결과 : " + solution(test));
        for (String test : tests) System.out.println("두번째 풀이 결과 : " + solution2(test));
    }
}
