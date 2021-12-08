package Level1;

import java.util.Arrays;

public class 최대공약수_최소공배수 {

    /*
    문제
    두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수를 완성하세요.
    배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
    예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 [3, 12]를 반환해야 합니다.

    제한사항
    두 수는 1 이상 1000000 이하의 자연수입니다.
     */


    static int getGCD(int num1, int num2) {
        if(num2 == 0)
            return num1;
        else
            return getGCD(num1, num1 % num2);
    }

    static int getLCM(int num1, int num2){
        return (num1 * num2) / getGCD(num1, num2);
    }

    public static void main(String[] args) {
        int[] answer = new int[2];

        answer[0] = getGCD(1, 10);
        answer[1] = getLCM(1, 10);

        System.out.println(Arrays.toString(answer));



    }
}
