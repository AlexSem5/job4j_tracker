package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScores = 0;
        double number = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                double subjectScore = subject.score();
                totalScores += subjectScore;
                number++;
            }
        }
        return totalScores / number;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScores = 0;
            double number = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                double subjectScore = subject.score();
                totalScores += subjectScore;
                number++;
            }
            labels.add(new Label(pupil.name(), totalScores / number));
        }
        return List.copyOf(labels);
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        double pupilNumber = 0;
        for (Pupil pupil : pupils) {
            pupilNumber++;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                int subjectScore = subject.score() + map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), subjectScore);
            }
        }
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            labels.add(new Label(key, value / pupilNumber));
        }
        return List.copyOf(labels);
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScores = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                double subjectScore = subject.score();
                totalScores += subjectScore;
            }
            labels.add(new Label(pupil.name(), totalScores));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                int subjectScore = subject.score() + map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), subjectScore);
            }
        }
        for (String subjectName : map.keySet()) {
            Integer subjectScore = map.get(subjectName);
            labels.add(new Label(subjectName, subjectScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
