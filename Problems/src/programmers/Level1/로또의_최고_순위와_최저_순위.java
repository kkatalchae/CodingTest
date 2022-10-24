package Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 로또의_최고_순위와_최저_순위 {

    /*
    순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
    알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
    알아볼 수 없는 두 개의 번호를 각각 11, 7 이라고 가정하면 5등에 당첨될 수 있습니다.
    민우가 구매한 로또 번호를 담은 배열 lottos 당첨 번호를 담은 배열 win_nums 가 매개 변수로 주어집니다.
    이 때 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 리턴하는 함수를 완성하세요.
     제한 사항 : lottos, win_nums 는 길이 6인 정수 배열입니다.
                lottos 의 모든 원소는 0 이상 45 이하인 정수입니다.
                0 은 알아볼 수 없는 숫자를 의미합니다. 0을 제외한 다른 숫자들은 lottos 에 2개 이상 담겨있지 않습니다.
                lottos 의 원소들은 정렬되어 있지 않을 수도 있습니다.
                win_nums 의 모든 원소는 1 이상 45 이하인 정수입니다.
                win_nums 에는 같은 숫자가 2개 이상 담겨있지 않습니다. win_nums 의 원소들은 정렬되어 있지 않을 수도 있습니다.
     */

    public static int[] solution(int[] lottos, int[] win_nums) {
        // 변수 생성
        Map<Integer, Boolean> answer = new HashMap<>();

        int zerocnt = 0;
        int correct = 0;

        // 배열을 돌면서 0이 아닌 수를 Map 객체에 삽입
        for (int lotto : lottos) {
            if (lotto == 0)
                zerocnt++;
            else
                answer.put(lotto, true);
        }

        // Map 객체에 있는 수라면 맞춘 숫자( correct ) 를 하나씩 늘려줌
        for(int win_num : win_nums) {
            if(answer.containsKey(win_num)) correct++;
        }

        /*
        최대 등수는 모르는 숫자 ( 0일 경우 ) 가 모두 맞았을 경우, 최소 등수는 모르는 숫자가 모두 틀렸을 경우를 의미한다.
        등수는 7 - 맞힌 개수이며, 맞힌 경우가 0일 경우를 대비하여 min 메소드를 사용해 등수의 최대값을 6으로 만들어준다. 
         */
        return new int[] {Math.min(6, 7 - (zerocnt + correct)), Math.min(6, 7 - correct)};
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        System.out.println(Arrays.toString(solution(lottos, win_nums)));

    }
}
