
package Respiratory.Topic;

import java.io.Serializable;
import java.util.Objects;

public class TopicDTO implements Serializable  {
    private String topic;
    private String picture;

    public TopicDTO(String topic, String picture) {
        this.topic = topic;
        this.picture = picture;
    }

    public TopicDTO() {
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "TopicDTO{" + "topic=" + topic + ", picture=" + picture + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.topic);
        hash = 97 * hash + Objects.hashCode(this.picture);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TopicDTO other = (TopicDTO) obj;
        if (!Objects.equals(this.topic, other.topic)) {
            return false;
        }
        return Objects.equals(this.picture, other.picture);
    }
    
}
