package JavaTest.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test", schema = "javatests")
public class TestEntity implements Serializable {
    private int testId;
    private String description;
    private int topicId;

    @Id
    @Column(name = "testId")
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
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

        TestEntity that = (TestEntity) o;

        if (testId != that.testId) return false;
        if (topicId != that.topicId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + topicId;
        return result;
    }
}
