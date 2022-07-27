package sky.pro.kurs2_exam_questions.Services;

import org.springframework.stereotype.Service;
import sky.pro.kurs2_exam_questions.Data.Question;
import sky.pro.kurs2_exam_questions.Exceptions.EmptyQuestionListException;
import sky.pro.kurs2_exam_questions.Repository.JavaQuestionRepository;

import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{
    private JavaQuestionRepository jcr;

    public JavaQuestionService(JavaQuestionRepository jcr) {
        this.jcr = jcr;
    }


    @Override
    public boolean add(String question, String answer) {
        return jcr.add(question,answer);
    }

    @Override
    public boolean remove(String question) {
        return jcr.remove(question);
    }

    @Override
    public Set<Question> getAll() {
        return jcr.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Set<Question> questSet = jcr.getAll();
        if(questSet.size() == 0) throw new EmptyQuestionListException();
        int item = new Random().nextInt(questSet.size());
        int i=0;
        for(Question q : questSet) {
            if(i == item) return q;
            i++;
        }
        throw new RuntimeException();
    }
}
