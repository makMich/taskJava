package net.thumbtack.school.ttschool;


import java.util.*;

public class TraineeQueue {
    Queue<Trainee> traineeQueue;

    public TraineeQueue() {
        traineeQueue = new ArrayDeque<Trainee>();
    }

    public void addTrainee(Trainee trainee) {
        traineeQueue.add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        if (traineeQueue.peek() == null) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        return traineeQueue.poll();
    }

    public boolean isEmpty() {
        return traineeQueue.peek() == null ? true : false;
    }


}
