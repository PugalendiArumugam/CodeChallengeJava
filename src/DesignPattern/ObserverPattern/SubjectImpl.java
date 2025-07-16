package DesignPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject{

    private List<Observer> observerList = null;

    private String message;

    public SubjectImpl(){
        observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        observerList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        observerList.remove(observer);
        System.out.println("Observer removed "+observer.getObservername());

    }

    @Override
    public void notifyObservers() {
        if(observerList != null && !observerList.isEmpty()){
            for(Observer observer : observerList){
                observer.update(message);
            }
        } else {
            System.out.println("No Observers to notify");
        }
    }



    @Override
    public Object getUpdate() {
        return message;
    }

    @Override
    public void postMessage(String message) {
        System.out.println("Message posted from Subject :"+message);
        this.message=message;
        notifyObservers();
    }
}
