import org.example.DataLoader;
import org.example.Task;
import org.example.model.Citizen;
import org.example.model.City;

import java.util.List;


public class Main {
    public static void main(String[] args) {
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
