package DesignPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternMain {
    public static void main(String[] args) {

        Subject implSubject = new SubjectImpl();
        List<Observer> observers = new ArrayList<>();

        for (int i = 1; i <= 5; i++){
            observers.add(new ObserverImpl("Observer -"+i));
        }

        for (Observer observer: observers){
            implSubject.register(observer);
            observer.setSubject(implSubject);
        }

//        observers.get(4).update();

        implSubject.unregister(observers.remove(2));

        implSubject.postMessage("Hello $$ - Message posted by Pugal");

    }
}
