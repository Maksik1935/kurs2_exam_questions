package sky.pro.kurs2_exam_questions.repository;

import org.springframework.stereotype.Repository;
import sky.pro.kurs2_exam_questions.Data.Question;
import sky.pro.kurs2_exam_questions.Exceptions.EmptyQuestionListException;
import sky.pro.kurs2_exam_questions.Exceptions.QuestionAlreadyAddedException;

import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private Set<Question> javaQuestions = new HashSet<>();

    @Override
    public boolean add(String question, String answer) {
        if(question == null || question.isEmpty()) throw new IllegalArgumentException("Question is Empty!");
        if(answer==null || answer.isEmpty()) answer = "Unknown answer";
        Question newQuestion = new Question(question, answer);
        if(javaQuestions.contains(newQuestion)) throw new QuestionAlreadyAddedException("Question already added!");
        javaQuestions.add(newQuestion);
        return true;
    }

    @Override
    public boolean remove(String question) {
        if(question == null || question.isEmpty()) throw new IllegalArgumentException("Question is Empty!");
        Question q = new Question(question, null);
        if(javaQuestions.contains(q)) {
            javaQuestions.remove(q);
        } else {
            throw new IllegalArgumentException("Question is not listed");
        }
        return true;
    }

    @Override
    public Set<Question> getAll() {
        if(javaQuestions.size() == 0) throw new EmptyQuestionListException();
        return new HashSet<>(javaQuestions);
    }
}
