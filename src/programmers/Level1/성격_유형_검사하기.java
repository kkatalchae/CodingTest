package programmers.Level1;

import org.junit.Test;

public class 성격_유형_검사하기 {

  /*
    https://school.programmers.co.kr/learn/courses/30/lessons/118666?language=java
   */

  enum Indicator {

    R(0), T(0), C(0), F(0), J(0), M(0), A(0), N(0);
    private int score;

    Indicator(int score) {
      this.score = score;
    }

    public int getScore() {
      return this.score;
    }

    public void addScore(int score) {
      this.score += score;
    }
  }

  public String solution(String[] survey, int[] choices) {
    String answer = "";

    for (int index = 0; index < survey.length; index++) {
      String nonAgreeIndicator = survey[index].substring(0, 1);
      String agreeIndicator = survey[index].substring(1);

      int score = choices[index];

      if (score < 4) {
        Indicator.valueOf(nonAgreeIndicator).addScore(4 - score);
      } else if (score > 4) {
        Indicator.valueOf(agreeIndicator).addScore(score % 4);
      }
    }

    if (Indicator.R.score > Indicator.T.score) {
      answer += "R";
    } else if ( Indicator.T.score > Indicator.R.score ) {
      answer += "T";
    } else if ( Indicator.R.score == Indicator.T.score ) {
      answer += (Indicator.R.name().compareToIgnoreCase(Indicator.T.name()) < 0) ? "R" : "T"; // 사전 순으로 비교
    }

    if (Indicator.F.score > Indicator.C.score) {
      answer += "F";
    } else if ( Indicator.C.score > Indicator.F.score ) {
      answer += "C";
    } else if ( Indicator.F.score == Indicator.C.score ) {
      answer += (Indicator.F.name().compareToIgnoreCase(Indicator.C.name()) < 0) ? "F" : "C"; // 사전 순으로 비교
    }

    if (Indicator.M.score > Indicator.J.score) {
      answer += "M";
    } else if ( Indicator.J.score > Indicator.M.score ) {
      answer += "J";
    } else if ( Indicator.M.score == Indicator.J.score ) {
      answer += (Indicator.M.name().compareToIgnoreCase(Indicator.J.name()) < 0) ? "M" : "J"; // 사전 순으로 비교
    }

    if (Indicator.A.score > Indicator.N.score) {
      answer += "A";
    } else if ( Indicator.N.score > Indicator.A.score ) {
      answer += "N";
    } else if ( Indicator.A.score == Indicator.N.score ) {
      answer += (Indicator.A.name().compareToIgnoreCase(Indicator.N.name()) < 0) ? "A" : "N"; // 사전 순으로 비교
    }

    return answer;
  }

  @Test
  public void test() {

    // given
    String[] survey1 = new String[]{"AN", "CF", "MJ", "RT", "NA"};
    int[] choices1 = new int[]{ 5, 3, 2, 7, 5 };

    // when
    String answer1 = solution(survey1, choices1);

    // then
    assert answer1.equals("TCMA");

  }



}
