package Level2;

import java.util.Stack;

public class 땅따먹기 {

    /*
    문제 설명
    땅따먹기 게임의 땅은 총 N 행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다.
    1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
    단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
    마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 리턴하는 함수를 완성하세요.

    제한 사항
    행의 개수 N : 100,000 이하의 자연수
    열의 개수는 4개이고, 땅은 2차원 배열로 주어집니다.
    점수 : 100 이하의 자연수

     */

    // 그리디 알고리즘의 느낌으로 풀이, 아마 그리디 알고리즘을 적용하면 안되는 듯하다. 시간 초과가 발생했을 가능성도 존재
    private static int solution(int[][] land) {

        int sum = 0;
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(4);
        // 2차원 배열의 행을 도는 반복문
        for (int i = 0; i < land.length; i++) {
            int max = 0;
            // 2차원 배열의 각 행의 열을 도는 반복문
            for (int j = 0; j < 4; j++) {
                // 이전에 선택했던 열은 선택하지 못하도록 스택을 이용해서 패스하도록 구현
                if (j == integerStack.peek()) {
                    continue;
                } else {
                    // 이전에 선택한 열을 제외하고 행에서 최대값의 인덱스값을 스택에 푸쉬
                    if (land[i][max] < land[i][j]) max = j;
                }
            }
            integerStack.push(max);
            sum += land[i][max];

        }

        return sum;
    }

    // 동적 계획법을 이용한 풀이 - 하나의 큰 문제를 여러 개의 작은 문제로 나누어서 그 결과를 저장하여 풀이에 사용하는 것
    private static int solution2(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        int answer = land[land.length - 1][0];
        for (int j = 1; j < 4; j++) {
            if (answer < land[land.length - 1][j]) answer = land[land.length - 1][j];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] test = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };

        System.out.println(solution(test));
        System.out.println(solution2(test));

    }
}
