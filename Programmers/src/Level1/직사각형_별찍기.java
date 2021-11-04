package Level1;

import java.util.Scanner;

public class 직사각형_별찍기 {

    /*
    표준 입력으로 두 개의 정수 n, m 이 주어집니다.
    별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m 인 직사각형 형태를 출력하세요
    제한 조건 : n 과 m 은 각각 1000 이하인 자연수입니다.
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n; row++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
