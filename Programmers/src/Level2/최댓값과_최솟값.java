package Level2;


import java.util.Arrays;


public class 최댓값과_최솟값 {

    /*
    문제 설명
    문자열 s 에는 공백으로 구분된 숫자들이 저장되어 있습니다.
    str 에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수를 완성하세요.

    제한 조건
    s 에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
     */

    private static String solution(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        // 문자열의 양쪽 끝에 공백이 있을 경우 공백을 없애둔다.
        s = s.trim();

        // 공백이 하나 이상이 있을 경우를 대비해 정규식을 이용해 문자열을 잘라준다.
        String[] arr = s.split("\\s+");

        // 자른 문자열 배열의 값들을 int 형 배열에 옮겨 담아준다.
        int[] nums = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }

        // 정렬
        Arrays.sort(nums);

        stringBuilder.append(nums[0]);
        stringBuilder.append(" ");
        stringBuilder.append(nums[arr.length - 1]);

        return stringBuilder.toString();
    }

    //  - , - , - , - , - 외 49 명
    private static String solution2(String str) {
        String[] tmp = str.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
            n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;

    }

    //
    public static void main(String[] args) {

        String[] tests = {"1 2 3 4",
                // 음수값이 포함된 경우
                "-1 -2 -3 -4",
                // 중복값이 존재하는 경우
                "-1 -1",
                // 문자열 맨 앞에 공백이 존재하는 경우
                " 5 1 3 6 -1",
                // 문자열 맨 뒤에 공백이 존재하는 경우
                "1 2 3 4 ",
                // 공백이 두개 이상
                " 3  4 5  -1"
        };

        for (String test : tests) System.out.println(solution(test));
        for (String test : tests) System.out.println(solution2(test));
    }
}
