package sky.pro.kurs2_exam_questions.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.kurs2_exam_questions.Data.Question;
import sky.pro.kurs2_exam_questions.Repository.JavaQuestionRepository;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static sky.pro.kurs2_exam_questions.Constants.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    JavaQuestionService out;

    @Mock
    JavaQuestionRepository repMock;

    @BeforeEach
    public void init() {
        out = new JavaQuestionService(repMock);
    }

    @Test
    public void getRandomQuestionTest() {
        when(repMock.getAll()).thenReturn(DEFAULT_SET);
        Question q = out.getRandomQuestion();
        assertTrue(q.equals(question1) ||
                q.equals(question2) ||
                q.equals(question3));
    }

}