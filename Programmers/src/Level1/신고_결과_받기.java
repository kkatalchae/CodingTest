package Level1;

import java.util.*;

public class 신고_결과_받기 {

    /*

    문제 설명

    신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 발송하는 시스템을 개발하려 합니다.
    무지가 개발하려는 시스템은 다음과 같습니다.

    - 각 유저는 한 번에 한 명의 유저를 신고 할 수 있습니다
        - 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
        - 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
    - k 번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
        - 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.

    다음은 전체 유저 목록이 [ "muzi", "frodo", "appeach", "neo" ] 이고, k = 2 ( 즉, 2번 이상 신고를 당하면 이용 정지 ) 인 경우의 예시입니다.

    --------------------------------------------------------------------------
    |  유저 ID  |  유저가 신고한 ID  |     설명                                  |
    --------------------------------------------------------------------------
    |  "muzi"  | "frodo"          | "muzi" 가 "frodo"를 신고했습니다.           |
    --------------------------------------------------------------------------
    | "apeach" | "frodo"          | "apeach"가 "frodo"를 신고했습니다.          |
    --------------------------------------------------------------------------
    | "frodo"  | "neo"            | "frodo" 가 "neo" 를 신고했습니다.           |
    --------------------------------------------------------------------------
    | "muzi"   | "neo"            | "muzi" 가 "neo" 를 신고했습니다.            |
    --------------------------------------------------------------------------
    | "apeach" | "muzi"           | "apeach" 가 "muzi" 를 신고했습니다.         |
    --------------------------------------------------------------------------

    각 유저별로 신고당한 횟수는 다음과 같습니다.

    muzi : 1  |  frodo : 2  | apeach : 0  | neo  : 2

    ----------------------------------------------------
    |  유저 ID  |  유저가 신고한 ID  |  정지된 ID          |
    ----------------------------------------------------
    | "muzi"    | ["frodo", "neo"]| ["frodo", "neo"]   |
    ----------------------------------------------------
    | "frodo"   | 	["neo"]	      | ["neo"]            |
    ----------------------------------------------------
    | "apeach"  |["muzi", "frodo"]| ["frodo"]          |
    ----------------------------------------------------
    | "neo"     | 없음             |  없음               |
    ----------------------------------------------------

	따라서 "muzi"는 처리 결과 메일을 2회, "frodo"와 "apeach"는 각각 처리 결과 메일을 1회 받게 됩니다.

    이용자의 ID가 담긴 문자열 배열 id_list, 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report, 정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때,
    각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.

    제한 사항

    - 2 ≤ id_list 의 길이 ≤ 1,000
        - 1 ≤ id_list 의 원소 길이 ≤ 10
        - id_list 의 원소는 이용자의 id를 나타내는 문자열이며 알파벳 소문자로만 이루어져 있습니다.
        - id_list 에는 같은 아이디가 중복해서 들어있지 않습니다.
    - 1 ≤ report 의 길이 ≤ 200,000
        - 3 ≤ report 의 원소 길이 ≤ 21
        - report 의 원소는 "이용자 id 신고한 id"형태의 문자열입니다.
        - 예를 들어 "muzi frodo"의 경우 "muzi"가 "frodo"를 신고했다는 의미입니다.
        - id는 알파벳 소문자로만 이루어져 있습니다.
        - 이용자 id와 신고한 id는 공백(스페이스)하나로 구분되어 있습니다.
        - 자기 자신을 신고하는 경우는 없습니다.
    - 1 ≤ k ≤ 200, k는 자연수입니다.
    - return 하는 배열은 id_list 에 담긴 id 순서대로 각 유저가 받은 결과 메일 수를 담으면 됩니다.

     */

    // 나의 풀이 - 1.43 ~ 433.43 ms 74 ~ 172 mb
    private static int[] solution(String[] id_list, String[] report, int k) {

        // 유저별 받은 결과 메일 수를 담을 배열
        int[] answer = new int[id_list.length];

        // 유저별 신고를 받은 숫자 배열
        int[] reportCnt = new int[id_list.length];

        // 한 유저가 동일한 유저를 신고하는 경우를 제외시키기 위해 report 배열의 중복을 제거
        report = Arrays.stream(report).distinct().toArray(String[]::new);

        // 유저별 신고한 ID 를 담아두기 위한 Map 객체 ( HashSet 객체를 이용하여 유저별로 동일한 ID 를 신고할 수 없도록 설정 )
        Map<String, HashSet<String>> reportID = new HashMap<>();

        HashSet<String> stopped = new HashSet<>();

        // report 배열을 순환
        for (String str : report) {
            // 신고 내용을 공백을 기준으로 분리하여 temp 배열에 임시 저장
            String[] temp = str.split(" ");

            String reporter = temp[0]; // 신고한 사람
            String reported = temp[1]; // 신고당한 사람

            if (reportID.containsKey(reporter)) { // 신고한 사람이 reportID 에 존재할 경우
                // reportID 에서 해당하는 키에 존재하는 HashSet 에 신고한 ID 를 더해준다.
                reportID.get(reporter).add(reported);
            } else { // 신고한 사람이 reportID 에 존재하지 않을 경우
                // key : 신고한 사람 value : 신고당한 사람을 요소로 가지는 HashSet 을 생성
                reportID.put(reporter, new HashSet<String>(Arrays.asList(reported)));
            }

            // 유저 리스트에서 신고받은 유저의 인덱스를 반환하여 유저별로 신고당한 횟수를 요소로 가진 배열의 값을
            int index = Arrays.asList(id_list).indexOf(reported);
            reportCnt[index]++;

            // 유저별로 신고당한 횟수를 늘려준 후, 정지를 당하게 되는 기준인 k 와 비교하여 정지당한 ID 로 분류
            if (reportCnt[index] == k) {
                stopped.add(id_list[index]);
            }
        }

        // 유저 목록을 순환
        for (int j = 0; j < id_list.length; j++) {

            // 정지당한 ID 목록을 순환
            for (String stoppedID : stopped) {
                // 유저가 신고하지 않은 경우, NullPointerException 이 발생하기 때문에 이 경우를 제외하는 조건식을 작성
                if (reportID.get(id_list[j]) != null) {
                    if (reportID.get(id_list[j]).contains(stoppedID)) { // 유저가 신고한 ID 중에 정지당한 ID 가 있을 시
                        answer[j]++;
                    }
                }
            }
        }

        return answer;
    }

    //  타인 풀이 - ImMino 0.36 ~ 197 ms 72 ~ 181 mb
    private int[] solution2(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String, Integer> suspendedList = new HashMap<>(); //<이름>
        HashMap<String, Integer> idIdx = new HashMap<String, Integer>(); // <이름, 해당 이름의 User 클래스 idx>
        int idx = 0;

        for (String name : id_list) {
            idIdx.put(name, idx++);
            users.add(new User(name));
        }

        for (String re : report) {
            String[] str = re.split(" ");
            //suspendedCount.put(str[0], suspendedCount.getOrDefault(str[0],0)+1);
            users.get(idIdx.get(str[0])).reportList.add(str[1]);
            users.get(idIdx.get(str[1])).reportedList.add(str[0]);
        }

        for (User user : users) {
            if (user.reportedList.size() >= k)
                suspendedList.put(user.name, 1);
        }

        for (User user : users) {
            for (String nameReport : user.reportList) {
                if (suspendedList.get(nameReport) != null) {
                    answer[idIdx.get(user.name)]++;
                }

            }
        }


        return answer;
    }


    class User {
        String name;
        HashSet<String> reportList;
        HashSet<String> reportedList;

        public User(String name) {
            this.name = name;
            reportList = new HashSet<>();
            reportedList = new HashSet<>();
        }
    }

    public static void main(String[] args) {

        String[][] id_lists = {{"muzi", "frodo", "apeach", "neo"}, {"con", "ryan"}};

        String[][] reports = {{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, {"ryan con", "ryan con", "ryan con", "ryan con"}};

        int[] k = {2, 3};

        for (int i = 0; i < id_lists.length; i++) {
            System.out.println(Arrays.toString(solution(id_lists[i], reports[i], k[i])));
        }
    }
}
