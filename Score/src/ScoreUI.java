import java.util.List;
import java.util.Map;

public class ScoreUI {
	
	private ScoreManager manager;
	
	public ScoreUI() {
		manager = new ScoreManagerImp();
	}
	
	// 학생등록
	public void addStudent(String stdno, String name) {
		Student student = new Student(stdno, name);
//		System.out.println(student);
		try {
			manager.addStudent(student);
		} catch (Exception e) {
			System.out.println("학번 중복으로 등록 실패");
			return;
		}
		System.out.println("학생 등록 성공");
	}
	
	// 점수입력
	public void saveScore(String stdno, Score score) {
		// 1. 점수를 등록할 학생을 찾기
		Student searchStudent = manager.searchStudent(stdno);
		
		// 2. 국영수 점수를 입력받아서 등록
		if (searchStudent != null) {
			searchStudent.setScore(score);
		}
	}
	
	// 점수수정
	public void updateScore(String stdno) {
		// 1. 학생 찾기
		Student searchStudent = manager.searchStudent(stdno);
		
		// 2. 점수 수정
		if (searchStudent != null) {
			int math_score = 100;
			searchStudent.getScore().setMath_score(math_score);
		}
	}
	
	// 학생삭제
	public void removeStudent(String stdno) {
		manager.removeStudent(stdno);
		System.out.println("학생 삭제 성공");
	}
	
	// 전체 학생정보 출력
	public void printAllStudents() {
		List<Student> students = manager.getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	// 과목별 성적 평균 구하기
	public void printAverage() {
		Map<String, Double> average = manager.getAverage();
		for (Map.Entry<String, Double> entry : average.entrySet()) {
			String key = entry.getKey();
			Double val = entry.getValue();
			System.out.println(key + " : " + val);
		}
	}
	
	public static void main(String[] args) {
		ScoreUI main = new ScoreUI();
		// 학생 등록하기
		main.addStudent("100", "홍길동");
		main.addStudent("200", "김개똥");
		main.addStudent("300", "이말똥");
		
		// 과목별 성적 입력하기
		Score score1 = new Score();
		score1.setKor_score(100);
		score1.setEng_score(100);
		score1.setMath_score(100);
		main.saveScore("100", score1);
		
		Score score2 = new Score();
		score2.setKor_score(80);
		score2.setEng_score(80);
		score2.setMath_score(80);
		main.saveScore("200", score2);
		
		Score score3 = new Score();
		score3.setKor_score(80);
		score3.setEng_score(80);
		score3.setMath_score(80);
		main.saveScore("300", score3);
		
		
		main.printAllStudents();
//		main.updateScore();
//		main.removeStudent();
//		main.printAllStudents();
//		main.printAverage();

	}

}
