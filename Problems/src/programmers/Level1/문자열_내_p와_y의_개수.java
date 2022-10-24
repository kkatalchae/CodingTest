package Level1;

public class 문자열_내_p와_y의_개수 {

    /*
    문제 설명
    대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
    s 에  'p' 의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False 를 리턴하는 함수를 완성하세요.
    'p', 'y'  모두 하나도 없는 경우는 항상 True 를 리턴합니다.
    단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

    제한 사항
    문자열 s 의 길이 : 50 이하의 자연수
    문자열 s 는 알파벳으로만 이루어져 있습니다.

     */

    // 나의 풀이 두 개의 변수 배열까지 만드는 풀이 ( 0.11 ~ 0.33 ms 65 ~ 85 mb )
    private static boolean solution(String s){
        int cntP = 0;
        int cntY = 0;

        String[] arr = s.split("");

        for (String str : arr) {
            if (str.equals("P") || str.equals("p")) cntP++;
            if (str.equals("Y") || str.equals("y")) cntY++;
        }

        if (cntP == cntY)
            return true;
        else if (cntP == 0 && cntY == 0)
            return true;
        else
            return false;
    }

    // 김민지 , - , 박종수 , 이승우 , - 외 6 명  - 하나의 변수만을 이용해서 풀이 ( 0.02 ~ 0.06 ms 70 ~ 86 mb )
    private static boolean solution2(String s) {

        s = s.toLowerCase();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'p')
                count++;
            else if (s.charAt(i) == 'y')
                count--;
        }

        return count == 0;
    }

    //  aispark , gimhyunzin , 신영환 , - , 깅 외 13 명 람다식을 이용한 풀이 ( 0.94 ~ 1.56 ms 71 ~ 80 mb )
    private static boolean solution3(String s) {
        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }

    public static void main(String[] args){
        String[] tests = {
                "pPoooyY", // p 와 y 의 개수가 같은 경우
                "Pyy", // p 와 y 의 개수가 다른 경우
                "none" // p나 y 가 없는 경우
        };

        for (String test : tests) System.out.println("첫번째 풀이 결과 : " + solution(test));
        for (String test : tests) System.out.println("두번째 풀이 결과 : " + solution2(test));
        for (String test : tests) System.out.println("세번째 풀이 결과 : " + solution3(test));

    }
}
