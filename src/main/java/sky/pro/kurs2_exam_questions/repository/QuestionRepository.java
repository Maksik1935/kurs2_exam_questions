package sky.pro.kurs2_exam_questions.repository;
import sky.pro.kurs2_exam_questions.Data.Question;
import java.util.Set;

public interface QuestionRepository {
    boolean add(String question, String answer);
    boolean remove(String question);
    Set<Question> getAll();
}
