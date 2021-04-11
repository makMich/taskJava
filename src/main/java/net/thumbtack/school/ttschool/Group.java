package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    private String groupName = "group";
    private String roomName = "audience";
    private List<Trainee> traineeList;

    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
        traineeList = new ArrayList<>();
    }

    public String getName() {
        return groupName;
    }

    public void setName(String groupName) throws TrainingException {
        if (groupName == null || groupName.length() == 0) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.groupName = groupName;
    }

    public String getRoom() {
        return roomName;
    }

    public void setRoom(String roomName) throws TrainingException {
        if (roomName == null || roomName.length() == 0) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.roomName = roomName;
    }

    public List<Trainee> getTrainees() {
        return traineeList;
    }

    public void addTrainee(Trainee trainee) {
        traineeList.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!traineeList.contains(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        traineeList.remove(trainee);
    }

    public void removeTrainee(int index) throws TrainingException {
        if (traineeList.size() <= index || index < 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        traineeList.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        Trainee trainee = new Trainee();
        for (Trainee t : traineeList) {
            if (t.getFirstName().equals(firstName)) {
                trainee = t;
                break;
            }
        }
        if (trainee.getFirstName() == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return trainee;
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        Trainee trainee = new Trainee();
        for (Trainee t : traineeList) {
            if (t.getFullName().equals(fullName)) {
                trainee = t;
                break;
            }
        }
        if (trainee.getFirstName() == null || trainee.getLastName() == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return trainee;
    }

    public void sortTraineeListByFirstNameAscendant() {
        traineeList.sort((t, t1) -> t.getFirstName().compareTo(t1.getFirstName()));
    }

    public void sortTraineeListByRatingDescendant() {
        traineeList.sort((t, t1) -> t.getRating() > t1.getRating() ? -1 : t.getRating() < t1.getRating() ? 1 : 0);
    }

    public void reverseTraineeList() {
        Collections.reverse(traineeList);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(traineeList, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        if (traineeList.size() == 0 || traineeList == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        List<Trainee> trainees = new ArrayList<>();
        Trainee max = Collections.max(traineeList,
                (t, t1) -> t.getRating() > t1.getRating() ? 1 : t.getRating() < t1.getRating() ? -1 : 0);
        for (Trainee t : traineeList) {
            if (t.getRating() == max.getRating()) {
                trainees.add(t);
            }
        }
        return trainees;
    }

    public boolean hasDuplicates() {
        Set<Trainee> set = new HashSet<>();
        for (Trainee t : traineeList) {
            if (!set.add(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupName.equals(group.groupName) &&
                roomName.equals(group.roomName) &&
                traineeList.equals(group.traineeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, roomName, traineeList);
    }
}
