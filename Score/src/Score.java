
public class Score {
	private int kor_score;		// 국어점수
	private int eng_score;		// 영어점수
	private int math_score;		// 수학점수
	
	public int getKor_score() {
		return kor_score;
	}
	public void setKor_score(int kor_score) {
		this.kor_score = kor_score;
	}
	public int getEng_score() {
		return eng_score;
	}
	public void setEng_score(int eng_score) {
		this.eng_score = eng_score;
	}
	public int getMath_score() {
		return math_score;
	}
	public void setMath_score(int math_score) {
		this.math_score = math_score;
	}
	
	@Override
	public String toString() {
		return "Score [kor_score=" + kor_score + ", eng_score=" + eng_score + ", math_score=" + math_score + "]";
	}
	
}
