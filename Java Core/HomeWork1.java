/**
 * Java Core. Homework 1
 * 
 * @author Butakova A.O.
 * 02.12.2021
 */
 

public class HomeWork1 {
    public static void main(String[] args) {
        Team team = new Team("NoName", new Participant("Bismarck", 400), new Participant("Victory", 250), new Participant("Nadezhda", 300), new Participant("Dyojfken", 100));
        team.showAll();
        Course course = new Course(180, 210, 290);
        course.doIt(team);
        System.out.println();
        team.showWinners();
    }
}

class Course {
    int[] obstacles = new int[3]; 
	
    public Course(int obstacle1, int obstacle2, int obstacle3) {
        obstacles[0] = obstacle1;
        obstacles[1] = obstacle2;
        obstacles[2] = obstacle3;
    }

    public void doIt(Team team){
        for (Participant participant : team.participants) {
            for(int distance: obstacles){
                if (participant.distance >= distance){
                    participant.isWinner = true;
                }	
                else {
                    participant.isWinner = false;  
                    break;
                }
            }
        }
    }
}

class Participant {
    String name;
    int distance;
    boolean isWinner;

    Participant(String name, int distance) {
        this.name = name;
        this.distance = distance;
        isWinner = false;
    }

    @Override
    public String toString () {
        return "Participant " + name + " distance " + distance + "."; 
    }
}

class Team {
    String name;
    Participant participants[] ;   

    public Team(String name,Participant ... participants) {
        this.name = name;
        this.participants = participants;
    }
    
    void showAll() {
        System.out.println("Team: " + this.name );
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }
	
    void showWinners(){
        System.out.println("Winners:");
        for (Participant participant : participants) {
            if (participant.isWinner){
                System.out.println(participant);
            }
        }
    }
}
