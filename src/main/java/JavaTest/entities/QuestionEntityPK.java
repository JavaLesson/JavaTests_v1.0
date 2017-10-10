package JavaTest.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class QuestionEntityPK implements Serializable {
    private int questionId;
    private int testId;
    private int topicId;

    @Column(name = "questionId")
    @Id
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Column(name = "testId")
    @Id
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Column(name = "topicId")
    @Id
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntityPK that = (QuestionEntityPK) o;

        if (questionId != that.questionId) return false;
        if (testId != that.testId) return false;
        if (topicId != that.topicId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + testId;
        result = 31 * result + topicId;
        return result;
    }
}
