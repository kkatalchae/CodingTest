package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 정수_내림차순으로_배치하기 {
    /*
    정수 n 을 매개변수로 입력받습니다. n 의 각 자릿수를 큰 것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
    제한조건
    n 은 1 이상 80000000000 이하인 자연수입니다.
     */

    // 기존 풀이 코드
    public long solution(long n) {
        String[] array = String.valueOf(n).split("");
        StringBuilder builder = new StringBuilder();

        Arrays.sort(array);
        for ( int i = array.length-1; i >= 0; i--){
            builder.append(array[i]);
        }
        return Long.parseLong(builder.toString());

    }

    // 복습 시 새로 작성한 풀이
    static long solution2(long n) {

        // 각 자릿수를 List에 담아준다.
        List<Long> list = new ArrayList<>();
        long result = 0;
        while(n != 0) {
            list.add(n % 10);
            n = n / 10;
        }

        // sort 메소드를 이용해서 역순으로 정렬
        Collections.sort(list, Collections.reverseOrder());

        // 다시 자릿수에 맞게 10의 제곱을 해줘서 원상태로 복구하기 위한 코드
        int index = 0;
        for(int pow = list.size() - 1; pow >= 0; pow--){
            result += list.get(index) * Math.pow(10, pow);
            index++;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(solution2(118372));
    }
}
