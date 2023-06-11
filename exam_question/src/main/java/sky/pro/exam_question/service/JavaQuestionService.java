package sky.pro.exam_question.service;

import org.springframework.stereotype.Service;
import sky.pro.exam_question.exception.NotFindException;
import sky.pro.exam_question.localInterface.QuestionService;
import sky.pro.exam_question.models.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();
    private final Set<Question> javaQuestion = new HashSet<>();


    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        javaQuestion.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (javaQuestion.contains(question)) {
            javaQuestion.remove(question);
            return question;
        }
        throw new NotFindException("Такого вопроса нет !");
    }

    @Override
    public Collection<Question> getAll() {
        List<Question> list = new ArrayList<>(javaQuestion);
        return list;
    }

    @Override
    public Question getRandomQuestion() {
        if(javaQuestion.isEmpty()){
            throw new LayerInstantiationException();
        }
        List<Question> list = new ArrayList<>(javaQuestion);
        int numb = random.nextInt(getAll().size());
        return list.get(numb);
    }

}
