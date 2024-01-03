package Level2;

import java.util.*;

public class 주차_요금_계산 {

    /*
    문제 설명
    주차장의 요금표와 차량이 들어오고 나간 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다.
    아래는 하나의 예시를 나타냅니다.

    요금표
    ---------------------------------------------------------------------
    | 기본 시간 ( 분 ) | 기본 요금 ( 원 ) | 단위 시간 ( 분 ) | 단위 요금 ( 원 ) |
    _____________________________________________________________________
    |     180        |       5000     |      10         |     600        |
    _____________________________________________________________________

    입 / 출차 기록
    ___________________________________
    | 시각 ( 시 : 분 ) | 차량 번호 | 내역 |
    ___________________________________
    |     05 : 34     | 5961    | 입차 |
    ___________________________________
    |     06 : 00     | 0000    | 입차 |
    ___________________________________
    |     06 : 34     | 0000    | 출차 |
    ___________________________________
    |     07 : 59     | 5961    | 출차 |
    ___________________________________
    |     07 : 59     | 0148    | 입차 |
    ___________________________________
    |     18 : 59     | 0000    | 입차 |
    ___________________________________
    |     19 : 09     | 0148    | 출차 |
    ___________________________________
    |     22 : 59     | 5961    | 입차 |
    ___________________________________
    |     23 : 00     | 5961    | 출차 |
    ___________________________________

    - 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
    - 0000번 차량은 18:59에 입차된 이후, 출차된 내역이 없습니다. 따라서, 23:59에 출차된 것으로 간주합니다.
    - 00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.
    - 누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
    - 누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
    - 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
    - ⌈a⌉ : a보다 작지 않은 최소의 정수를 의미합니다. 즉, 올림을 의미합니다.
    - 주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records 가 매개변수로 주어집니다.
    - 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 함수를 완성해주세요.

    제한 사항
    - fees 의 길이 = 4
        - fees[0] = 기본 시간(분)
        - 1 ≤ fees[0] ≤ 1,439
        - fees[1] = 기본 요금(원)
        - 0 ≤ fees[1] ≤ 100,000
        - fees[2] = 단위 시간(분)
        - 1 ≤ fees[2] ≤ 1,439
        - fees[3] = 단위 요금(원)
        - 1 ≤ fees[3] ≤ 10,000
    - 1 ≤ records 의 길이 ≤ 1,000
        - records 의 각 원소는 "시각 차량번호 내역" 형식의 문자열입니다.
        - 시각, 차량번호, 내역은 하나의 공백으로 구분되어 있습니다.
        - 시각은 차량이 입차되거나 출차된 시각을 나타내며, HH:MM 형식의 길이 5인 문자열입니다.
            - HH:MM은 00:00부터 23:59까지 주어집니다.
            - 잘못된 시각("25:22", "09:65" 등)은 입력으로 주어지지 않습니다.
        - 차량번호는 자동차를 구분하기 위한, `0'~'9'로 구성된 길이 4인 문자열입니다.
        - 내역은 길이 2 또는 3인 문자열로, IN 또는 OUT 입니다. IN은 입차를, OUT 은 출차를 의미합니다.
        - records 의 원소들은 시각을 기준으로 오름차순으로 정렬되어 주어집니다.
        - records 는 하루 동안의 입/출차된 기록만 담고 있으며, 입차된 차량이 다음날 출차되는 경우는 입력으로 주어지지 않습니다.
        - 같은 시각에, 같은 차량번호의 내역이 2번 이상 나타내지 않습니다.
        - 마지막 시각(23:59)에 입차되는 경우는 입력으로 주어지지 않습니다.
        - 아래의 예를 포함하여, 잘못된 입력은 주어지지 않습니다.
            - 주차장에 없는 차량이 출차되는 경우
            - 주차장에 이미 있는 차량(차량번호가 같은 차량)이 다시 입차되는 경우
     */


    // solution ( 나의 풀이, 0.47 ~ 28.11 ms 66 ~ 86 mb )
    private static int[] solution(int[] fees, String[] records) {

        // 차량번호별 기록을 저장하기 위한 Map < 차량번호, ArrayList< String 시간 >
        Map<String, ArrayList<String>> parkingTime = new HashMap<>();

        // records 는 시간, 차량 번호, 입차 / 출차 가 합쳐진 String 으로 되어있기 때문에 나눠서 사용하기 위한 배열
        String[] recordInfos;

        // records 배열을 돌면서 각각의 기록에 대해 로직 수행
        for (String record : records) {

            recordInfos = record.split(" ");
            String time = recordInfos[0];
            String carNum = recordInfos[1];
            String recordType = recordInfos[2];

            // Map 객체에 차량번호에 대한 기록이 아무것도 없을 시 ( 처음 입차했을 경우 )
            if (!parkingTime.containsKey(carNum)) {
                // 기본적으로 입차하면 출차 시간을 23:59분으로 세팅한다.
                parkingTime.put(carNum, new ArrayList<String>(Arrays.asList(time, "23:59")));
            }
            // 출차하는 경우
            else if (parkingTime.containsKey(carNum) && recordType.equals("OUT")) {
                // 출차할 경우, 기본적으로 세팅되어 있는 출차 시간을 수정해준다.
                // 두번째 출차인데 첫번째 출차 기록이 바뀌면 안되기 때문에 size() -1 에 해당하는 시간을 변경
                parkingTime.get(carNum).set(parkingTime.get(carNum).size() - 1, time);
            }
            // 동일한 차량 번호의 차량이 두 차례 이상 입차하는 경우
            else if (parkingTime.containsKey(carNum) && recordType.equals("IN")) {
                parkingTime.get(carNum).add(time);
                parkingTime.get(carNum).add("23:59");
            }
        }

        // ArrayList 에 기록이 있는 차량 번호를 담아둔 후, 정렬
        List<String> cars = new ArrayList<>();

        for (String car : parkingTime.keySet()) {
            cars.add(car);
        }

        Collections.sort(cars);

        // 차량별 요금을 담을 배열
        int[] answer = new int[cars.size()];

        int index = 0;

        // Map 에서 차량번호에 해당하는 기록 ( ArrayList ) 를 가져와서 주차한 시간을 구하고, 요금을 구한다.
        for (String car : cars) {
            answer[index++] = getFee(fees, getTime(parkingTime.get(car)));
        }

        return answer;
    }

    // 기록을 저장해둔 리스트를 이용해서 주차한 시간을 구해주는 getTime 메소드
    public static int getTime(ArrayList<String> parkingTimes) {

        // 출차 시간 - 입차 시간
        int time = 0;

        // 기록은 String 형으로 되어 있기 때문에 ":" 를 기준으로 분리한 후, 분으로 치환해준 뒤 차이를 구해준다.
        String[] times;

        for (int i = 0; i < parkingTimes.size(); i++) {

            times = parkingTimes.get(i).split(":");

            // ArrayList < 0, 2, 4 ... ( 짝수 ) : 입차 기록 , 1, 3, 5, 7 ... ( 홀수 ) : 출차 기록
            if (i % 2 == 0) {
                time -= Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            }

            if (i % 2 == 1) {
                time += Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            }
        }

        return time;

    }

    public static int getFee(int[] fees, int time) {

        // Math.ceil 메소드를 사용할 때 필요한 인자는 double 형이기 때문에 요금표의 요소들을 double 변수에 담아준다.
        double baseTime = fees[0];
        double baseFee = fees[1];
        double perTime = fees[2];
        double perFee = fees[3];

        if (time < baseTime) {
            return (int) baseFee;
        } else {
            // 기준 시간을 초과한
            return (int) (baseFee + Math.ceil(((time - baseTime) / perTime)) * perFee);
        }

    }



    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
