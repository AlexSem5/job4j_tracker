package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball smallBall = new Ball();
        Wolf smallWolf = new Wolf();
        Hare smallHare = new Hare();
        Fox smallFox = new Fox();
        smallFox.tryEat(smallBall);
        smallWolf.tryEat(smallBall);
        smallHare.tryEat(smallBall);

    }
}
