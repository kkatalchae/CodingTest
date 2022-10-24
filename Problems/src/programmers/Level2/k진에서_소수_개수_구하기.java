package Level2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class k진에서_소수_개수_구하기 {

    /*
    문제 설명

    양의 정수 n 이 주어집니다. 이 숫자를 k 진수로 바꿨을 떄, 변환된 수 안에 아래 조건에 맞는 소수가 몇 개인지 알아보려 한다.

    - 0P0 처럼 소수 양쪽에 0 이 있는 경우
    - P0 처럼 소수 오른쪽에만 0 이 있고 왼쪽에는 아무것도 없는 경우
    - 0P 처럼 소수 왼쪽에만 0 이 있고 왼쪽에는 아무것도 없는 경우
    - P 처럼 소수 양쪽에 아무것도 없는 경우
    - 단, P 는 각 자릿수에 0을 포함하지 않는 소수입니다.
        - 예를 들어, 101 은 P 가 될 수 없습니다.

    정수 n 과 k 가 매개변수로 주어집니다. n 을 k 진수로 바꿨을 떄,
    변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 리턴하는 함수를 완성하세요.

    제한 사항

    - 1 <= n <= 1,000,000
    - 3 <= k <= 10

     */

    public int solution (int n, int k) {

        int answer = 0;

        String parsed = parseNotation(n, k);



        return answer;
    }

    private static void isP(String parsed) {

        Pattern pattern = Pattern.compile("(0[1-9]+0)([1-9]+0)(0[1-9]+)(^[1-9]+$)");

        Matcher matcher = pattern.matcher(parsed);

        System.out.println(matcher.group());
    }

    private static String parseNotation(int n, int k) {

        StringBuilder builder = new StringBuilder();

        int temp = n;

        while (temp != 0) {
            builder.append(temp % k);
            temp /= k;
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {

        int[] n = {437674, 110011};
        int[] k = {3, 10};

        for (int i = 0; i < n.length; i++) {
            isP(parseNotation(n[i], k[i]));
        }
    }
}
