package Level2;

public class N개의_최소공배수 {

    /*
    문제
    두 수의 최소공배수란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
    예을 들어 2 와 7 의 최소공배수는 14가 됩니다.
    정의를 확장해서 n 개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
    n 개의 숫자를 담은 배열 arr 이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수를 완성하세요.

    제한 사항
    arr 는 길이 1 이상, 15 이하인 배열입니다.
    arr 의 원소는 100 이하인 자연수입니다.
     */

    static int getGCD(int a, int b) {
        if(b == 0)
            return a;
        else
            return getGCD(b, a % b);
    }

    static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }

    static int solution(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            arr[index] = getLCM(arr[index-1],arr[index]);
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};

        System.out.println(solution(arr));

    }
}
