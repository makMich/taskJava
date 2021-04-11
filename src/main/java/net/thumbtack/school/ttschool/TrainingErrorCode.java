package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("TRAINEE_WRONG_FIRSTNAME"),
    TRAINEE_WRONG_LASTNAME("TRAINEE_WRONG_LASTNAME"),
    TRAINEE_WRONG_RATING("TRAINEE_WRONG_RATING"),
    GROUP_WRONG_NAME ("GROUP_WRONG_NAME"),
    GROUP_WRONG_ROOM ("GROUP_WRONG_ROOM"),
    TRAINEE_NOT_FOUND ("TRAINEE_NOT_FOUND"),
    SCHOOL_WRONG_NAME ("SCHOOL_WRONG_NAME"),
    DUPLICATE_GROUP_NAME ("DUPLICATE_GROUP_NAME"),
    GROUP_NOT_FOUND("GROUP_NOT_FOUND"),
    DUPLICATE_TRAINEE("DUPLICATE_TRAINEE"),
    EMPTY_TRAINEE_QUEUE("EMPTY_TRAINEE_QUEUE");

    private String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString(){
        return errorString;
    }
}
