package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 숫자_짝꿍 {

    /*
    문제 설명
        두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
        (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
        X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

        예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다.
        다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다
        (X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
        두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return 하는 solution 함수를 완성해주세요.

    제한사항
        3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
        X, Y는 0으로 시작하지 않습니다.
        X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.
     */

    public static String solution(String X, String Y) {

        String answer = "";

        List<String> xList = new ArrayList<>();
        xList.addAll( Arrays.asList(X.split("")));
        List<String> yList = new ArrayList<>();
        yList.addAll(Arrays.asList(Y.split("")));

        List<String> answerList = new ArrayList<>();

        for (String item : xList)
        {
            if (yList.contains(item))
            {
                answerList.add(item);
                yList.remove(item);
            }

        }

        answerList = answerList.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        if (answerList.isEmpty())
        {
            answer = "-1";
        } else {
            answer = String.join("", answerList);
        }

        if (answer.equals("00")) answer = "0";

        return answer;
    }

    public String solution2(String X, String Y) {

        String answer = "";

        

        return answer;
    }

    public static void main(String[] args) {
        String X = "12321";
        String Y = "42531";

        System.out.println(solution(X, Y));
    }

}
