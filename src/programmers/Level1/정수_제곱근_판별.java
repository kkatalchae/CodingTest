package Level1;



public class 정수_제곱근_판별 {
    /*
    임의의 양의 정수 n 에 대해, n 이 어떤 양의 정수 x 의 제곱인지 아닌지 판단하려 합니다.
    n 이 양의 정수 x 의 제곱이라면 x + 1 의 제곱을 리턴하고, n 이 양의 정수 x 의 제곱이 아니라면 -1 을 리턴하는 함수를 완성하세요

    제한사항
    n 은 1 이상, 500000000000000 이하인 양의 정수입니다.
     */

    static long solution (long n) {
        long x;
        long result;
        double temp = Math.sqrt(n);

        if(temp == Math.ceil(temp)) {
            x = (long) temp;
            result = (long) Math.pow(x + 1, 2);
            return result;
        } else {
            result = -1;
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(121));
        System.out.println(solution(3));
    }
}
