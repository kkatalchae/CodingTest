package Level1;

public class 하샤드_수 {
    /*
    양의 정수 x 가 하샤드 수이려면 x 의 자릿수의 합으로 x 가 나누어져야 합니다.
    예를 들어 18의 자릿수 합은 1+8 = 9이고, 18은 9로 나누어 떨어지므로
    18은 하샤드 수입니다. 자연수 x 가 하샤드 수인지 아닌지 검사하는 함수를 완성하세요.
    제한 조건 : x 는 1 이상, 10000 이하인 정수입니다.
     */

    public static boolean solution(int x) {
        // 사용할 변수들 생성
        boolean answer = false;
        int sum = 0;
        int num = x;

        /*
        각 자리 합을 구하기 위한 코드
        10으로 나눈 나머지는 1의 자리를 의미함
        그 다음 10으로 나눠주면 일의 자리는 없어지고 십의 자리부터 남는다.
        이 과정을 반복하면 각 자리의 합을 구할 수 있다.
         */
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }

        // 입력받은 값이 하샤드 수이면 false 를 true 로 바꿔준다.
        if(x % sum == 0)
            answer = true;

        return answer;
    }
    // 결과값을 출력해보기 위한 코드
    public static void main(String[] args){
        int[] xs = {5, 12, 112, 1234, 10000, 10, 11, 13};

        for (int x : xs) System.out.println(solution(x));
    }
}
