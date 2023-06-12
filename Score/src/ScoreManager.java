import java.util.List;
import java.util.Map;

public interface ScoreManager {
	// 학생정보 등록
	void addStudent(Student student) throws Exception;
	
	// 학번으로 학생 검색
	Student searchStudent(String stdno);
	
	// 학생정보 삭제
	void removeStudent(String stdno);
	
	// 전체 학생 및 점수정보
	List<Student> getAllStudents();
	
	// 과목별 평균
	public Map<String, Double> getAverage();
	
}
