package sky.pro.exam_question.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.exam_question.exception.NotFindException;
import sky.pro.exam_question.models.Question;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        javaQuestionService.add("question1", "answer1");
        javaQuestionService.add("question2", "answer2");
        javaQuestionService.add("question3", "answer3");
    }

    @AfterEach
    public void afterEach() {
        javaQuestionService.getAll().forEach(question -> javaQuestionService.remove(question));
    }

    @Test
    public void QuestionAddTest() {
        Question expected = new Question("question4", "answer4");
        Assertions.assertThat(javaQuestionService.add("question4", "answer4"))
                .isEqualTo(expected).isIn(javaQuestionService.getAll());
    }

    @Test
    public void QuestionRemoveTest() {
        Question actual = new Question("question3", "answer3");
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> javaQuestionService.remove(actual));
    }

    @Test
    public void QuestionNegativeRemoveTest() {
        Question actual = new Question("question5", "answer5");
        assertThrows(NotFindException.class, () -> javaQuestionService.remove(actual));
    }

    @Test
    public void QuestionGetAll() {
        Assertions.assertThat(javaQuestionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(new Question("question1", "answer1"),
                        new Question("question2", "answer2"),
                        new Question("question3", "answer3")
                );
    }


}
