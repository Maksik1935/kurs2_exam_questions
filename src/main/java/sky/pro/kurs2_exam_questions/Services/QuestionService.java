package sky.pro.kurs2_exam_questions.Services;

import sky.pro.kurs2_exam_questions.Data.Question;

import java.util.HashSet;
import java.util.Set;

public interface QuestionService {

    boolean add(String question, String answer);
    boolean remove(String question);
    Set<Question> getAll();
    Question getRandomQuestion();
}
