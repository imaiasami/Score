import java.util.*;

public class ScoreManagerImp implements ScoreManager {
	
	private List<Student> students = new ArrayList<>();  

	@Override
	public void addStudent(Student student) throws Exception {
		// 동일한 학번의 학생이 있는지 체크
		Student searchStudent = searchStudent(student.getStdno());
		// 1. 동일한 학번의 학생이 등록되지 않게 처리
//		if (searchStudent != null) {
//			// 동일한 학번의 학생이 존재 함
//			return;
//		}
		// 2. 동일한 학번의 학생이 등록되지 않게 처리
		if (searchStudent != null) {
			throw new IllegalArgumentException();
		}
		
		// 학생 등록
		students.add(student);
	}

	@Override
	public Student searchStudent(String stdno) {
		for (Student student : students) {
			if (student.getStdno().equals(stdno)) {
				return student;
			}
		}
		return null;
	}

	@Override
	public void removeStudent(String stdno) {
		Student searchStudent = searchStudent(stdno);
		// 학번에 해당하는 학생이 있을 경우 삭제
		if (searchStudent != null) {
			students.remove(searchStudent);
			return;
		}
		// 학번에 해당하는 학생이 없을 경우 예외 강제 발생
		try {
			throw new NullPointerException();			
		} catch (NullPointerException e) {
			System.out.println("삭제 대상 없음");
			return;
		}
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getStdno().equals(stdno)) {
//				students.remove(i);
//			}
//		}
	}

	@Override
	public List<Student> getAllStudents() {
		return students;
	}
	
	public Map<String, Double> getAverage() {
		Map<String, Double> average = new HashMap<>();
		int kor_sum = 0;
		int eng_sum = 0;
		int math_sum = 0;
		for (Student student : students) {
			kor_sum += student.getScore().getKor_score();
			eng_sum += student.getScore().getEng_score();
			math_sum += student.getScore().getMath_score();
		}
		average.put("국어", (double)kor_sum / students.size());
		average.put("영어", (double)eng_sum / students.size());
		average.put("수학", (double)math_sum / students.size());
		
		return average;
	}
	
}
