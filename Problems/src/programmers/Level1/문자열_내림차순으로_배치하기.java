package Level1;

import java.util.Arrays;
import java.util.Collections;

public class 문자열_내림차순으로_배치하기 {

    /*
    문제 설명
    문자열 s 에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수를 완성해주세요.
    s 는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

    제한 사항
    s 은 길이 1 이상인 문자열입니다.

     */

    private static String solution(String s){

        StringBuilder builder = new StringBuilder();
        String[] arr = s.split("");

        Arrays.sort(arr, Collections.reverseOrder());

        for (String str : arr) builder.append(str);

        return builder.toString();

    }

    public static void main(String[] args){
        String test = "Zbcdefg";

        System.out.println(solution(test));
    }
}
