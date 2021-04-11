package net.thumbtack.school.ttschool;

import java.io.Serializable;
import java.util.Objects;

public class Trainee implements Serializable {
    private static final long serialVersionUID = 803745049486954915L;
    private String firstName;
    private String lastName;
    private int rating;

    public Trainee(String firstName, String lastName, int rating) throws TrainingException {
        setFirstName(firstName);
        setLastName(lastName);
        setRating(rating);
    }
    public Trainee(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws TrainingException {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws TrainingException {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws TrainingException {
        validateRating(rating);
        this.rating = rating;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    private void validateFirstName (String firstName) throws TrainingException {
        if (firstName == null || firstName.length() == 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_FIRSTNAME);
        }
    }

    private void validateLastName (String lastName) throws TrainingException {
        if (lastName == null || lastName.length() == 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_LASTNAME);
        }
    }

    private void validateRating(int rating) throws TrainingException {
        if (rating < 1 || rating > 5) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_RATING);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return rating == trainee.rating &&
                firstName.equals(trainee.firstName) &&
                lastName.equals(trainee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, rating);
    }
}
