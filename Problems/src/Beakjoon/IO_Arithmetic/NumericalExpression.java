package src.Beakjoon.IO_Arithmetic;

/**
 * 문제
 * 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
 *
 * 출력
 * 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
 */


import java.io.IOException;
import java.util.Scanner;

public class NumericalExpression {

    public static void main( String[] args ) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        if ( A < 0 ) throw new IOException("A는 1보다 크거나 같은 수여야 합니다.");

        int B = scanner.nextInt();
        if ( B > 10000 ) throw new IOException("B는 10000 보다 작거나 같은 수여야 합니다.");

        System.out.println(A + B);
        System.out.println(A - B);
        System.out.println(A * B);
        System.out.println(A / (double) B);
        System.out.println(A % B);
    }
}
