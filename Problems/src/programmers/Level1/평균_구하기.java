package Level1;

import java.util.Arrays;

public class 평균_구하기 {

    /*
    정수를 담고 있는 배열 arr 의 평균값을 구하는 함수를 완성하세요.
    제한사항 : arr 은 길이 1 이상, 100 이하인 배열입니다.
              arr 의 원소는 -10,000 이상 10,000 이하인 정수입니다.
     */

    public static double solution(int[] arr){
        double sum = 0;

        for(int num : arr) sum +=num;

        return sum / arr.length;
    }

    public static double solution2(int[] arr){
        // stream 을 이용해서 한 줄로 처리할 수 있지만 반복문을 통한 방법보다 현저히 성능이 떨어짐
        return Arrays.stream(arr).average().getAsDouble();
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4};

        System.out.println("솔루션 1 로 도출한 값 : " + solution(arr));
        System.out.println("솔루션 2 로 도출한 값 : " + solution2(arr));

    }
}
