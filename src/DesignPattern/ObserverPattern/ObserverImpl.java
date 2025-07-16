package DesignPattern.ObserverPattern;

public class ObserverImpl implements Observer{

    String observerName;

    Subject subjectRegistered;

    public ObserverImpl(String observerName){
        this.observerName = observerName;
    }

    @Override
    public void update() {
        String newMessage = (String) subjectRegistered.getUpdate();
        if (newMessage != null) {
            System.out.println(observerName+" New message Received:"+ newMessage);
        } else {
            System.out.println(observerName+ " New message received");
        }
    }

    @Override
    public void update(String newMessage) {

        if (newMessage != null) {
            System.out.println(observerName+" New message Received:"+ newMessage);
        } else {
            System.out.println(observerName+ " New message received");
        }

    }

    @Override
    public void setSubject(Subject subject) {
        subjectRegistered = subject;
    }

    @Override
    public String getObservername(){
        return observerName;
    }


}
