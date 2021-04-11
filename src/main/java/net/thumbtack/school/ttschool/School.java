package net.thumbtack.school.ttschool;

import java.util.*;

public class School {
    private String name = "name";
    private int year;
    private Set<Group> groups;

    public School(String name, int year) throws TrainingException {
        setName(name);
        setYear(year);
        groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.length() == 0) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) throws TrainingException {
        for (Group g : getGroups()) {
            if (g.getName().equals(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }
        getGroups().add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        removeGroup(group.getName());
    }

    public void removeGroup(String name) throws TrainingException {
        for (Group g : getGroups()) {
            if (g.getName().equals(name)) {
                getGroups().remove(g);
                return;
            }
        }
        throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
    }

    public boolean containsGroup(Group group) {
        for (Group g : getGroups()) {
            if (g.getName().equals(group.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year &&
                Objects.equals(name, school.name) &&
                Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, groups);
    }
}
