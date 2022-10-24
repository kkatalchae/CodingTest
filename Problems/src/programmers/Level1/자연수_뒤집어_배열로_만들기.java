package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 자연수_뒤집어_배열로_만들기 {

    /*
    문제 설명
    자연수 n 을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.

    제한 조건
    n 은 10,000,000,000 이하인 자연수입니다.
     */

    // 나머지 연산자와 나누기 연산자를 이용해 각 자리수 추출 ( 평균 0.03초의 속도 메모리는 기존과 비슷 )
    private static int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();


        while (n != 0) {
            list.add((int)(n % 10));
            n /= 10;
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    // 기존 풀이 - 문자열로 바꿔서 split 메소드로 각 자리수를 추출 ( 0.1x ms 대 성능 70mb )
    private static int[] solution2(long n) {

            String[] arr = String.valueOf(n).split("");
            int cnt = arr.length;
            int[] answer = new int[arr.length];
            for( int i = 0; i < arr.length; i++){
                answer[i] = Integer.parseInt(arr[--cnt]);
            }
            return answer;
    }

    public static void main(String[] args){
        long[] tests = {12345,
                1234567890,
                5833271// 중복값이 존재할 경우

        };

        for (long test : tests ){
            System.out.println(Arrays.toString(solution(test)));
        }
    }
}
