package JavaTest.entities;

import javax.persistence.*;

@Entity
@Table(name = "question", schema = "javatests", catalog = "")
@IdClass(QuestionEntityPK.class)
public class QuestionEntity {
    private int questionId;
    private String description;
    private int testId;
    private int topicId;

    @Id
    @Column(name = "questionId")
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "testId")
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Id
    @Column(name = "topicId")
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

        QuestionEntity that = (QuestionEntity) o;

        if (questionId != that.questionId) return false;
        if (testId != that.testId) return false;
        if (topicId != that.topicId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + testId;
        result = 31 * result + topicId;
        return result;
    }
}
