package DesignPatterns.Observer;

public class CarEnthusiast implements Observer {
    @Override
    public void update(String magazineName) {
        System.out.println("YES, my magazine is out" + magazineName);
    }
}
