package sky.pro.kurs2_exam_questions.Services;
import org.springframework.stereotype.Service;
import sky.pro.kurs2_exam_questions.Data.Question;
import sky.pro.kurs2_exam_questions.Repository.JavaQuestionRepository;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private List<QuestionService> services = new ArrayList<>();

    public ExaminerServiceImpl(JavaQuestionService jqs, MathQuestionService mqs) {
        services.add(jqs);
        services.add(mqs);
    }
    @Override
    public Set<Question> getQuestions(Integer amount) {
        if(amount == 0) throw new IllegalArgumentException("You can not answer for 0 questions");
        Set<Question> questionsSet = new HashSet<>();
        Integer javaAmount;
        if(services.get(0).getAll().size() >= amount) {
            javaAmount = getJavaAmount(amount);
        } else {
            javaAmount = getJavaAmount(services.get(0).getAll().size());
        }
        while(questionsSet.size()<javaAmount) {
            questionsSet.add(services.get(0).getRandomQuestion());
        }
        while(questionsSet.size()<amount) {
            questionsSet.add(services.get(1).getRandomQuestion());
        }
        return questionsSet;
    }

    private int getJavaAmount(Integer amount) {
        Random rnd = new Random();
        return rnd.nextInt(amount);
    }
}
