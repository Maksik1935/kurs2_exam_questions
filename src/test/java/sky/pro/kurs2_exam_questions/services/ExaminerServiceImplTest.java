package sky.pro.kurs2_exam_questions.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import sky.pro.kurs2_exam_questions.Data.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static sky.pro.kurs2_exam_questions.Constants.TestConstants.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ExaminerServiceImplTest {
    ExaminerService out;
    @Mock
    JavaQuestionService javaMock;

    @Mock
    MathQuestionService mathMock;

    @BeforeEach
    public void init() {
        out = new ExaminerServiceImpl(javaMock, mathMock);
    }

    @Test
    public void getQuestionsTest() {
        when(javaMock.getAll()).thenReturn(DEFAULT_SET);
        when(mathMock.getRandomQuestion()).thenReturn(new Question("5+5", null), new Question("6+6", null));
        when(javaMock.getRandomQuestion()).thenReturn(question1, question2);
        Set<Question> tempSet = new HashSet<>(out.getQuestions(2));
        assertTrue(tempSet.equals(RND_SET_1) || tempSet.equals(RND_SET_2) || tempSet.equals(RND_SET_3));
    }
}