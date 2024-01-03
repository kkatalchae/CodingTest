package Level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 문자열_내_마음대로_정렬하기 {

    /*
    문제 설명
    문자열로 구성된 리스트 strings 와 정수 n  이 주어졌을 때, 각 문자열의 인덱스 n 번째 글자를 기준으로 오름차순 정렬하려 합니다.

    제한 조건
    strings 는 길이 1 이상, 50 이하인 배열입니다.
    strings 의 원소는 소문자 알파벳으로 이루어져 있습니다.
    strings 의 원소는 길이 1 이상, 100 이하인 문자열입니다.
    모든 strings 의 원소의 길이는 n 보다 큽니다.
    인덱스 1 의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.

     */

    // 0.30 ~ 0.50 ms 59 ~ 73 mb Comparator 인터페이스의 compare 메소드 재정의하여 풀이
    private static String[] solution(String[] strings, int n){

        // 비교하는 방식을 재정의하여 정렬
        Arrays.sort(strings, new Comparator<String>() {
            // Comparator 인터페이스의 compare 메소드를 재정의하여 사용
            @Override
            public int compare(String o1, String o2) { // 인자에는 비교할 두 객체를 대입
                /*
                 메소드 본문에는 정렬할 기준을 작성
                 0 또는 음수 결과값이 나오면 두 객체의 자리가 유지되고
                 양수 값이 나오면 인자로 받은 두 객체의 자리를 바꾼다.
                 */
                char c1 = o1.charAt(n);
                char c2 = o2.charAt(n);

                if (c1 == c2) { // 비교할 알파벳이 같은 경우 사전 순으로 정렬
                    return o1.compareTo(o2);
                } else { // char 형은 아스키 코드로 자동 변환됨, a = 65 b = 66 이기 때문에 c1 - c2 가 사전 순이다.
                    return c1 - c2;
                }

            }
        });

        return strings;
    }

    // 람다식을 이용한 풀이
    private static String[] solution2(String[] strings, int n) {
        List<String> list = Arrays.asList(strings);
        list.sort((a, b) -> { // 람다식을 이용해서 리스트의 각 원소에 대해 다음 코드들을 적용
            int result = (a.split(""))[n].compareTo((b.split(""))[n]); // 리스트의 원소를 split으로 나눠 n 번째 자리를 비교
            if (result == 0)
                return a.compareTo(b);
            return result;
        });
        return list.toArray(new String[0]); // 다시 list 에서 배열로 형변환해 리턴
    }

        public static void main(String[] args){
        String[][] tests = {
                {"sun", "bed", "car"},
                {"abce", "abcd", "cdx"}
        };

        int[] nums = { 1, 2 };

        for (int i = 0; i < tests.length; i++){
            System.out.println("첫번째 풀이 결과 : " + Arrays.toString(solution(tests[i], nums[i])));
        }
        for (int i = 0; i < tests.length; i++){
            System.out.println("두번째 풀이 결과 : " + Arrays.toString(solution2(tests[i], nums[i])));
        }


    }

}
