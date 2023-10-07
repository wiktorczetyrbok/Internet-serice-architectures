import org.example.City;
import org.example.DataLoader;
import org.example.Citizen;
import org.example.Task;

import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Citizen> listOfCitizens = DataLoader.loadCitizens();
        List<City> listOfCities = DataLoader.loadCities();

        DataLoader.loadCompaniesToHardware(listOfCitizens, listOfCities);
        Task lab = new Task();

        lab.taskTwo(listOfCities);
        lab.taskThree(listOfCities);
        lab.taskFour(listOfCities);
        lab.taskFive(listOfCitizens);
        lab.taskSix(listOfCitizens);
        lab.taskSeven(listOfCities);
    }
}
