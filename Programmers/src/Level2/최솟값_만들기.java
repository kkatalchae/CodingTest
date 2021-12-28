package Level2;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값_만들기 {
    /*
    문제 설명
    길이가 같은 배열 A, B 두 개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
    배열 A, B 에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며,
    두 수를 곱한 값을 누적하여 더합니다. 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다.
    단, 각 배열에서 k 번째 숫자를 뽑았다면 다음에 k 번째 숫자는 다시 뽑을 수 없습니다.

    제한 사항
    배열 A, B 의 크기 : 1,000 이하의 자연수
    배열 A, B 의 원소의 크기 : 1,000 이하의 자연수
     */

    private static int solution (int[] A, int[] B){

        int sum = 0;
        Integer[] arr = new Integer[B.length];
        for (int i = 0; i < B.length; i++){
            arr[i] = B[i];
        }

        Arrays.sort(A);
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < A.length; i++){
            sum += A[i] * arr[i];
        }

        return sum;
    }
    private static int solution2(int[] A, int[] B) {

        int sum = 0;
        int reverse = A.length - 1;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++){
            sum += A[i] * B[reverse--];
        }

        return sum;
    }



    public static void main(String[] args){
        int[] A = {1, 2};
        int[] B = {3, 4};

        System.out.println(solution(A,B));
    }
}
