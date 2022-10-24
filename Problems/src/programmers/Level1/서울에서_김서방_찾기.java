package Level1;

public class 서울에서_김서방_찾기 {

    /*
    문제 설명
    String 형 배열 seoul 의 element 중 "Kim" 의 위치 x 를 찾아, "김서방은 x 에 있다" 는 String 을 반환하는 함수를 완성하세요.
    seoul 에 "Kim" 은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

    제한 사항
    seoul 은 길이 1 이상, 1000 이하인 배열입니다.
    seoul 의 원소는 길이 1 이상, 20 이하인 문자열입니다.
    "Kim" 은 반드시 seoul 안에 포함되어 있습니다.

     */

    private static String solution(String[] seoul){

        StringBuilder builder = new StringBuilder();
        builder.append("김서방은 ");
        for (int i = 0; i < seoul.length; i++){
            if (seoul[i].equals("Kim")) builder.append(i);
        }
        builder.append("에 있다");

        return builder.toString();
    }

    public static void main(String[] args){

        String[] seoul = {"Jane", "Kim"};

        System.out.println(solution(seoul));

    }
}
