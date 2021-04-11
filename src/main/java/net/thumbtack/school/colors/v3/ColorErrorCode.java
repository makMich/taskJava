package net.thumbtack.school.colors.v3;

public enum ColorErrorCode {
    WRONG_COLOR_STRING("wrong color string exception"),
    NULL_COLOR("null color exception");

    String errorString;

    ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }


    public String getErrorString() {
        return errorString;
    }


}
