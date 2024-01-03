package Level1;

import java.util.Arrays;

public class 행렬의_덧셈 {

    /*
    행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을
    서로 더한 결과가 됩니다.
    2개의 행렬을 받아, 행렬 덧셈의 결과를 반환하는 함수를 완성하세요.

    제한 조건 : 입력받는 행렬의 길이는 500을 넘지 않습니다.
     */

    public int[][] solution(int[][] arr1, int[][] arr2) {
        // 문제에서 행과 열의 크기가 같다고 했으므로 길이를 변수에 담아 사용
        int len = arr1.length;

        // 입력 받은 두 행렬의 합을 요소로 가지는 정답 행렬 생성
        int[][] answer = new int[len][len];

        // 각 행과 열을 돌면서 더하고 할당하는 작업을 반복
        if(len < 500) {
            for (int row = 0; row < len; row++) {
                for (int col = 0; col < len; col++) {
                    answer[row][col] = arr1[row][col] + arr2[row][col];
                }
            }
        } else {
            System.out.println("길이가 500 이하인 행렬을 입력하세요.");
        }

        return answer;
    }
    // 결과를 출력해보기 위한 코드
    public static void main(String[] args){
        int[][] arr1 = {{1,2}, {2,3}};
        int[][] arr2 = {{3,4}, {5,6}};

        // solution 메소드는 static 이 아니기 때문에 객첼르 생성해서 사용
        행렬의_덧셈 check = new 행렬의_덧셈();

        // 이차원 배열을 출력해보려면 deepToString 메소드를 사용해야함
        System.out.println(Arrays.deepToString(check.solution(arr1,arr2)));


    }
}
