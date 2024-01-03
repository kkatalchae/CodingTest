package src.Beakjoon.IO_Arithmetic;

import java.io.IOException;
import java.util.Scanner;

public class ADivideB {
    /**
     * 문제
     * 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
     *
     * 출력
     * 첫째 줄에 A/B를 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다.
     */

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();

        if (a < 0 ) throw new IOException("A 는 0 이상으로 입력해야 한다.");

        double b = scanner.nextDouble();

        if (b >= 10) throw new IOException("B 는 10 미만으로 입력해야 한다.");

        System.out.println(a / b);
    }
}
