package sky.pro.exam_question.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sky.pro.exam_question.exception.QuestionLimitException;
import sky.pro.exam_question.localInterface.QuestionService;
import sky.pro.exam_question.models.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@Component
public class ExaminerServiceImpl implements sky.pro.exam_question.localInterface.ExaminerService {

    private final QuestionService javaQuestionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        int size = javaQuestionService.getAll().size();
        if (amount > size || amount <= 0) {
            throw new QuestionLimitException("Привышает лимит вопросов");
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionSet.add(javaQuestionService.getRandomQuestion());
        }
        return questionSet;
    }
}
