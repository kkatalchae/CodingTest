package Level1;

public class 핸드폰_번호_가리기 {

    /*
    프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
    전화번호가 문자열 phone_number 로 주어졌을때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *
    으로 가린 문자열을 리턴하는 함수를 완성하세요.
    제한 조건 : s 는 길이 4 이상, 20 이하인 문자열입니다.
     */

    public String solution(String phone_number){
        // 변환한 값을 다시 String 으로 만들기 위한 변수 생성
        StringBuilder answer = new StringBuilder();

        // 인자로 받은 String 을 바꾸기 위해 char 형 배열로 변환
        char[] array = phone_number.toCharArray();

        // 배열의 각 요소에 접근해서 마지막 4자리가 아니면 * 로 치환하고 StringBuilder 에 추가, 아니면 그냥 추가
        for( int index = 0; index < array.length; index++){
            if(index < array.length - 4) {
                array[index] = '*';
                answer.append(array[index]);
            } else {
                answer.append(array[index]);
            }
        }


        return answer.toString();
    }

    public String solution2(String phone_number) {

        StringBuilder answer = new StringBuilder();

        /*
        substring 메소드를 통해서 마지막 4자리를 기준으로 분리
        substring 은 endindex 논 포함하지 않기 때문에 끝에서 4번째에 해당하는 인덱스를 입력해주어야 한다.
         */
        String changed = phone_number.substring(0, phone_number.length() - 4);
        String unchanged = phone_number.substring(phone_number.length() - 4);

        // replaceAll 메소드를 통해서 숫자에 해당하는 전화번호를 모두 * 로 바꿔준다.
        changed = changed.replaceAll("[0-9]", "*");
        answer.append(changed);
        answer.append(unchanged);

        return answer.toString();
    }

    public static void main(String[] args){

        String phone_number = "13275981793850129358";

        핸드폰_번호_가리기 Solution = new 핸드폰_번호_가리기();

        System.out.println(Solution.solution(phone_number));
        System.out.println(Solution.solution2(phone_number));

    }
}
