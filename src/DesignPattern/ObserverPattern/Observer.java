package DesignPattern.ObserverPattern;

public interface Observer {

    void update();

    void update(String message);

    void setSubject(Subject subject);

    String getObservername();
}

