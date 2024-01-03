package Level1;

public class 콜라츠_추측 {

    /*
    1937년 콜라츠란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될 때까지 다음 작업을 반복하면,
    모든 수를 1로 만들 수 있다는 추측입니다.
    1-1. 입력된 수가 짝수라면 2로 나눕니다.
    1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
    2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.

    예를 들어, 입력된 수가 6이라면 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1 총 8번 만에 1이 됩니다.
    위 작업을 몇 번이나 반복해야하는지 반환하는 함수를 완성해 주세요.
    단, 작업을 500번을 반복해도 1이 되지 않는다면 -1을 반환해 주세요.
    제한사항 : 입력된 수, num 은 1 이상 8000000 미만인 정수입니다.
     */

    // 값을 int 로 받으면 overflow 가 발생하기 때문에 long 형으로 값을 입력받는다.
    public static int solution (long num) {
        // 횟수를 받기 위한 변수 생성
        int cnt = 0;

        // 입력받은 값이 1이 될 때가지 반복
        while(num != 1) {
            cnt++;
            if ( num % 2 == 0 ) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }

            // 500번이 넘어도 1이 되지 않는다면 -1을 리턴하도록 설정
            if( cnt > 500) {
                cnt = -1;
                break;
            }
        }

        return cnt;
    }

    public static void main (String[] args) {
        int[] nums = {6, 16, 626331};

        for(int num : nums) System.out.println(solution(num));
    }
}
