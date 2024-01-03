package Level2;

import java.util.Arrays;
import java.util.regex.Pattern;

public class JadenCase_문자열_만들기 {

    // 첫 번쨰 풀이 공백을 기준으로 단어를 구분 - 런타임 에러 발생
    static String solution(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = s.split(" ");

        for (String str : arr) {
            stringBuilder.append(" ");
            str = str.toLowerCase();
            str = str.replace(str.substring(0, 1), str.substring(0, 1).toUpperCase());
            stringBuilder.append(str);
        }
        return stringBuilder.toString().trim();
    }

    // 모든 자리를 나눠서 처리, 앞 문자가 공백이면 대문자로 변환, 마지막에 공백에 있을 경우는 변환하지 않음
    static String solution2(String s) {
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = s.split("");

        for(int index = 0; index < arr.length; index++) {
            if (index == 0) arr[index] = arr[index].toUpperCase();
            if(arr[index].equals(" ") && index < arr.length -1) {
                arr[index+1] = arr[index+1].toUpperCase();
            }
            stringBuilder.append(arr[index]);
        }
        return stringBuilder.toString();
    }

    // Sunhee Shin , 조희준 , LimHanGyeol , wonsangki , - 외 20 명
    String solution3(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }

    // 결과값을 출력해보기 위한 코드
    public static void main(String[] args) {

        String test1 = "3people unFollowed me";
        String test2 = "for the last week";
        String test3 = "  long  time  no  see  ";

        System.out.println(solution2(test1));
        System.out.println(solution2(test2));
        System.out.println(solution2(test3));

    }
}
