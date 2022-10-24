package Level2;

import java.util.Arrays;

public class 행렬의_곱셈 {
    /*
    2차원 행렬 arr1 과 arr2 를 입력받아, arr1 에 arr2 를 곱한 결과를 반환하는 함수를 완성하세요.
    제한 조건
    행렬 arr1, arr2 의 행과 열의 길이는 2 이상 100 이하입니다.
    행렬 arr1, arr2 의 원소는 -10 이상 20 이하인 자연수입니다.
    곱할 수 있는 배열만 주어집니다.
     */
    static int[][] solution(int[][] arr1, int[][] arr2){
        int row = arr1.length;
        int col = arr2[0].length;
        int[][] result = new int[row][col];


        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
               for(int k = 0; k < arr2.length; k++){
                   result[i][j] += arr1[i][k] * arr2[k][j];
               }
            }
        }
        return result;
    }



    public static void main(String[] args){
        int[][] arr1 = {{1,4}, {3,2}, {4,1}};
        int[][] arr2 = {{3,3}, {3,3}};

        System.out.println(Arrays.deepToString(solution(arr1,arr2)));
    }
}
