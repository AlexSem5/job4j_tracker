package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Mix bug", 4),
                new Job("Drink coffee", 2)
        );
        jobs.sort(new JobAscByName());
        Iterator<Job> iterator = jobs.iterator();
        assertThat(iterator.next()).isEqualTo(new Job("Drink coffee", 2));
        assertThat(iterator.next()).isEqualTo(new Job("Fix bug", 1));
        assertThat(iterator.next()).isEqualTo(new Job("Mix bug", 4));
    }

    @Test
    public void whenJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Mix bug", 4),
                new Job("Drink coffee", 2)
        );
        jobs.sort(new JobDescByName());
        Iterator<Job> iterator = jobs.iterator();
        assertThat(iterator.next()).isEqualTo(new Job("Mix bug", 4));
        assertThat(iterator.next()).isEqualTo(new Job("Fix bug", 1));
        assertThat(iterator.next()).isEqualTo(new Job("Drink coffee", 2));
    }

    @Test
    public void whenJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Mix bug", 4),
                new Job("Drink coffee", 2)
        );
        jobs.sort(new JobAscByPriority());
        Iterator<Job> iterator = jobs.iterator();
        assertThat(iterator.next()).isEqualTo(new Job("Fix bug", 1));
        assertThat(iterator.next()).isEqualTo(new Job("Drink coffee", 2));
        assertThat(iterator.next()).isEqualTo(new Job("Mix bug", 4));
    }

    @Test
    public void whenJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Mix bug", 4),
                new Job("Drink coffee", 2)
        );
        jobs.sort(new JobDescByPriority());
        Iterator<Job> iterator = jobs.iterator();
        assertThat(iterator.next()).isEqualTo(new Job("Mix bug", 4));
        assertThat(iterator.next()).isEqualTo(new Job("Drink coffee", 2));
        assertThat(iterator.next()).isEqualTo(new Job("Fix bug", 1));
    }

    @Test
    public void whenJobDescByNameAndJobDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenJobAscByNameAndJobAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenJobAscByNameAndJobDscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 2),
                new Job("Fix bug", 2)
        );
        assertThat(rsl).isEqualTo(0);
    }

}