package Level1;

public class 시저암호 {

    /*
    문제 설명
    어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
    예를 들어 AB 는 1 만큼 밀면 BC가 되고 3 만큼 밀면 DE가 됩니다.
    문자열 s 와 거리 n 을 입력받아 s 를 n 만큼 민 암호문을 만드는 함수를 완성하세요.

    제한 조건
    공백은 아무리 밀어도 공백입니다.
    s 는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
    s 의 길이는 8000 이하입니다.
    n 은 1 이상, 25 이하인 자연수입니다.
     */

    // ~ 0.8 ms, 평균 70 mb
    private static String solution(String s, int n) {

        StringBuilder builder = new StringBuilder();

        // 아스키 코드를 이용하기 위해 문자열을 char형 배열로 변환
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++){
            // 소문자 a 부터 z 까지
            if (arr[i] >= 97 && arr[i] <= 122) {
                arr[i] += n;
                // n 만큼 밀었을 때 z를 넘어가는 경우 발생
                if (arr[i] > 122) {
                    // 넘친 정도를 알기 위해 123을 빼준다.
                    arr[i] = (char)(97 + (arr[i] - 123));
                }
                // 대문자도 소문자와 마찬가지로 똑같이 처리
            } else if (arr[i] >= 65 && arr[i] <= 90){
                arr[i] += n;
                if (arr[i] > 90){
                    // 알파벳의 범위를 벗어난 정도가 알파벳의 개수보다 크다면 26으로 나머지를 구해줘야 겠지만
                    // 제한 조건에서 n 의 범위를 25 이하로 정하고 있기 때문에 본 문제에서는 필요하지 않다.
                    arr[i] = (char)(65 + (arr[i] - 91));
                }
            }

            builder.append(arr[i]);
        }

        return builder.toString();

    }

    // 기존 풀이 ( 1 ~ 2 ms, 50 ~ 80 mb )
    private static String solution2(String s, int n) {
        String answer = "";
        int code = 0;
        for( int i =0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                code = (int)s.charAt(i);
                if ( code >= 65 && code <=90){
                    code += n;
                    if( code > 90)
                        code = 65 + ((code-91)%26);
                } else if(code >= 97 && code <= 122) {
                    code += n;
                    if( code >122) code = 97 +((code-123)%26);
                }
                answer = answer + Character.toString((char)code); } else{
                answer = answer + Character.toString(s.charAt(i));
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String[] tests = {"AB", "z", "a B z"};
        int[] nums = {1, 1, 4};

        for (int i = 0; i < tests.length; i++){
            System.out.println(solution(tests[i], nums[i]));
        }

    }
}
