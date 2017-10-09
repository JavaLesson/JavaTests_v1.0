package JavaTest.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "statistic", schema = "javatests")
public class StatisticEntity {
    private int statisticId;
    private byte correct;
    private Date date;
    private int userId;
    private int questionId;
    private int testId;
    private int topicId;

    @Id
    @Column(name = "statisticId")
    public int getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(int statisticId) {
        this.statisticId = statisticId;
    }

    @Basic
    @Column(name = "correct")
    public byte getCorrect() {
        return correct;
    }

    public void setCorrect(byte correct) {
        this.correct = correct;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "questionId")
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "testId")
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Basic
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

        StatisticEntity that = (StatisticEntity) o;

        if (statisticId != that.statisticId) return false;
        if (correct != that.correct) return false;
        if (userId != that.userId) return false;
        if (questionId != that.questionId) return false;
        if (testId != that.testId) return false;
        if (topicId != that.topicId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statisticId;
        result = 31 * result + (int) correct;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + questionId;
        result = 31 * result + testId;
        result = 31 * result + topicId;
        return result;
    }
}
