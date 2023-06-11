package sky.pro.exam_question.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.exam_question.exception.ListIsEmptyException;
import sky.pro.exam_question.exception.QuestionLimitException;
import sky.pro.exam_question.localInterface.QuestionService;
import sky.pro.exam_question.models.Question;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;


    private final Collection<Question> questionSet = Set.of(
            new Question("question1", "answer1"),
            new Question("question2", "answer2"),
            new Question("question3", "answer3"),
            new Question("question4", "answer4"),
            new Question("question5", "answer5")
    );

    @Test
    public void getQuestionsNegativeTest() {
        when(questionService.getAll()).thenReturn(questionSet);

        assertThatExceptionOfType(QuestionLimitException.class)
                .isThrownBy(() -> examinerService.getQuestion(-1));
        assertThatExceptionOfType(QuestionLimitException.class)
                .isThrownBy(() -> examinerService.getQuestion(questionSet.size() + 1));
    }

    @Test
    public void getQuestionTest() {
        when(questionService.getAll()).thenReturn(questionSet);
        when(questionService.getRandomQuestion()).thenReturn(
                new Question("question4", "answer4"),
                new Question("question4", "answer4"),
                new Question("question5", "answer5"),
                new Question("question2", "answer2")
        );
        Assertions.assertThat(examinerService.getQuestion(3)).hasSize(3).containsExactlyInAnyOrder(
                new Question("question4", "answer4"),
                new Question("question2", "answer2"),
                new Question("question5", "answer5")
        );
    }

}
