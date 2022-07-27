package sky.pro.kurs2_exam_questions.Services;

import sky.pro.kurs2_exam_questions.Data.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(Integer amount);
}
