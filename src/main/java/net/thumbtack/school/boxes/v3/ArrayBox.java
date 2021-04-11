package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.ClosedFigure;

public class ArrayBox<T extends ClosedFigure>  {

    private T[] array;

    public ArrayBox(T[] obj) {
        this.array = obj;
    }

    public T[] getContent() {
        return array;
    }

    public void setContent(T[] obj) {
        this.array = obj;
    }

    public T getElement(int index){
        return array[index];
    }

    public void setElement(T element, int index) {
        this.array[index] = element;
    }


    public boolean isSameSize (ArrayBox<? extends ClosedFigure> arrayBox) {
        return this.array.length == arrayBox.array.length;
    }
}
