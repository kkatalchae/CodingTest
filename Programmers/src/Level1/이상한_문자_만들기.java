package Level1;

public class 이상한_문자_만들기 {

    /*
    문제 설명
    문자열 s 는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
    각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수를 완성하세요.

    제한 사항
    문자열 전체의 짝/홀수 인덱스가 아니라, 단어( 공백을 기준 ) 별로 짝/홀수 인덱스를 판단해야 합니다.
    첫 번째 글자는 0번쨰 인덱스로 보아 짝수번쨰 알파벳으로 처리해야 합니다.
     */

    // boolean 을 활용해서 풀어봤다. ( ~ 0.5 ms 7x mb 기존 풀이에 비해 속도는 크게 개선, 메모리는 더 사용 )
    private static String solution(String str) {

        StringBuilder builder = new StringBuilder();
        boolean flag = true;

        String[] arr = str.split("");

        for (int i = 0; i < arr.length; i++){
            if (arr[i].equals(" ")) {
                flag = true;
                builder.append(arr[i]);
                continue;
            }

            if (flag) {
                arr[i] = arr[i].toUpperCase();
                builder.append(arr[i]);
                flag = !flag;
            } else {
                arr[i] = arr[i].toLowerCase();
                builder.append(arr[i]);
                flag = !flag;
            }
        }

        return builder.toString();

    }

    // 기존 풀이 ( 1 ~ 2 ms, 50 ~ 60 mb )
    private static String solution2(String s) {
        String answer = "";
        String[] arr = s.split("");
        int idx = 0;
        for ( int i =0; i < arr.length; i++){
            if(arr[i].equals(" ")){
                idx = 0;
            } else if ( idx % 2 == 0){
                arr[i] = arr[i].toUpperCase();
                idx++;
            } else {
                arr[i] = arr[i].toLowerCase();
                idx++;
            }
            answer += arr[i];
        }
        return answer;
    }

    public static void main(String[] args){
        String[] tests = {
                "try hello world",
                "Try heLLo", // 단어의 홀수번쨰 문자가 대문자로 되어 있는 경우
                " try hello world", // 문자열 맨 앞에 공백이 있는 경우
                "hello world ", // 문자열 맨 마지막에 공백이 위치한 경우
                "hello  world", // 문자열에 공백이 두 개이상 있는 경우
                "i lOvE YOU"
        };

        for (String test: tests) System.out.println(solution(test));

    }
}
