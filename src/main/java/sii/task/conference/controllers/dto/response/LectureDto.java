package sii.task.conference.controllers.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sii.task.conference.entities.Lecture;
import sii.task.conference.entities.TopicPath;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LectureDto {
    private LocalDateTime lectureStart;
    private LocalDateTime lectureEnd;
    private TopicPath topicPath;
    private Integer freeSpots;
    private Integer duration;

    public LectureDto(Lecture lecture) {
        this.lectureStart = lecture.getLectureDate();
        this.lectureEnd = lecture.getLectureDate().plusMinutes(lecture.getDurationTime());
        this.topicPath = lecture.getTopicPath();
        this.freeSpots = lecture.getLectureLimit() - lecture.getParticipants().size();
        this.duration = lecture.getDurationTime();
    }
}
